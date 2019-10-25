package br.ufma.ecp.estante_livros;

import java.util.Arrays;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class LivroTableModel extends AbstractTableModel {
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
		colunas = Arrays.asList("Id", "Nome", "Autor");
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

	public Object getValueAt(int rowIndex, int columnIndex) {
		Livro livro = livros.get(rowIndex);
		switch(columnIndex) {
			case 0: return livro.getCodigo();
			case 1: return livro.getNome();
			case 2: return livro.getAutor();
		}
		return null;
	}

}
