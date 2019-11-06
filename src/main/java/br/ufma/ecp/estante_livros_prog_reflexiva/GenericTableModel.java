package br.ufma.ecp.estante_livros_prog_reflexiva;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class GenericTableModel<T> extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<T> values;

	public GenericTableModel(AbstractDAO<T> dao) {
		values = dao.read();
	}

	public int getRowCount() {
		return values.size();
	}

	public int getColumnCount() {
		T obj = values.get(0);
		Class<? extends Object> c = obj.getClass();
		int count = 0;
		for (Field f : c.getDeclaredFields()) {
			if (f.isAnnotationPresent(ColumnAnnotation.class)) {
				count++;
			}
		}
		return count;
	}

	public Object getValueAt(int row, int column) {
		T obj = values.get(row);
		Class<? extends Object> c = obj.getClass();
		Field fields[] = c.getDeclaredFields();
		for (Field f : fields) {
			if (f.isAnnotationPresent(ColumnAnnotation.class)) {
				ColumnAnnotation annotation = f.getDeclaredAnnotation(ColumnAnnotation.class);
				if (annotation.posicao() == column) {
					String fieldName = f.getName();
					String methodName = "get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1);
					Method m;
					try {
						m = c.getMethod(methodName);
						Object value = m.invoke(obj);
						return value;
					} catch (NoSuchMethodException | SecurityException | IllegalAccessException
							| IllegalArgumentException | InvocationTargetException e) {
						e.printStackTrace();
					}
				}
			}

		}
		return null;
	}

	public String getColumnName(int column) {
		Object obj = values.get(0);
		Class<? extends Object> c = obj.getClass();
		for (Field f : c.getDeclaredFields()) {
			if (f.isAnnotationPresent(ColumnAnnotation.class)) {
				ColumnAnnotation a = f.getDeclaredAnnotation(ColumnAnnotation.class);
				if (a.posicao() == column) {
					return a.nome();
				}
			}
		}
		return null;
	}

}
