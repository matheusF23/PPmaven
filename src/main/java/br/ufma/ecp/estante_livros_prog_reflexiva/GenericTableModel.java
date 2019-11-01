package br.ufma.ecp.estante_livros_prog_reflexiva;

import java.util.ArrayList;
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
		// TODO Auto-generated method stub
		return 0;
	}

	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
