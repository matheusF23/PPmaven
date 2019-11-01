package br.ufma.ecp.estante_livros_prog_reflexiva;

import java.lang.reflect.Field;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class GenericTableModel<T> extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private AbstractDAO<T> dao;
	private List<T> values;

	public GenericTableModel(AbstractDAO<T> dao) {
		this.dao = dao;
		values = dao.read();
	}
	
	public int getRowCount() {
		return values.size();
	}
	
	public int getColumnCount() {
		Object obj = values.get(0);
		Class c = obj.getClass();
		int count = 0;
		for (Field f : c.getDeclaredFields()) {
			if (f.isAnnotationPresent(CollumnAnnotation.class)) {
				count++;
			}
		}
		return count;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
