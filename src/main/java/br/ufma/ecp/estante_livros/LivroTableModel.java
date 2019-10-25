package br.ufma.ecp.estante_livros;

import java.util.Arrays;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class LivroTableModel extends AbstractTableModel implements TableModelListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Livro> livros;
	private List<String> colunas;
	private LivroDAO dao;

	public LivroTableModel(LivroDAO dao) {
		this.dao = dao;
		this.livros = dao.readLivros();
		colunas = Arrays.asList("Codigo", "Nome", "Autor");
		this.addTableModelListener(this);
	}

	public int getRowCount() {
		return livros.size();
	}

	public int getColumnCount() {
		return colunas.size();
	}

	public String getColumnName(int i) {
		return colunas.get(i);
	}
	
	// pega os valores na tabela
	public Object getValueAt(int rowIndex, int columnIndex) {
		Livro livro = livros.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return livro.getCodigo();
		case 1:
			return livro.getNome();
		case 2:
			return livro.getAutor();
		}
		return null;
	}

	//Permite fazer alteracoes na table
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}
	
	// altera o valor na tabela apos o enter
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		// Pega o livro referente a linha especificada
		Livro livro = livros.get(rowIndex);

		switch (columnIndex) {
		case 1:
			livro.setNome((String) aValue);
			break;
		case 2:
			livro.setAutor((String) aValue);
			break;
		default:
			throw new IndexOutOfBoundsException("columnIndex out of bounds");
		}
		fireTableCellUpdated(rowIndex, columnIndex); // Notifica a atualização da célula
	}

	public void tableChanged(TableModelEvent event) {
		int i = event.getFirstRow();
		Livro livro = livros.get(i);
		dao.update(livro);
	}
}
