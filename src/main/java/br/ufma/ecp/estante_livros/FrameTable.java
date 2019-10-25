package br.ufma.ecp.estante_livros;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameTable extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FrameTable(LivroDAO dao) {
		super("Livros");
		LivroTableModel tm = new LivroTableModel(dao);
		JTable t = new JTable(tm);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(t);
		add(scroll);
		setSize(800, 250);
		setLocationRelativeTo(null); // Centraliza o Jframe
	}
}
