package br.ufma.ecp.estante_livros;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.ufma.ecp.estante_livros_prog_reflexiva.GenericTableModel;
import br.ufma.ecp.estante_livros_prog_reflexiva.ReflectLivroDAO;

public class FrameTable extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public FrameTable() {
		super("Livros");
		//LivroTableModel tm = new LivroTableModel(dao);
		//JTable t = new JTable(tm);
		JTable tm = new JTable(new GenericTableModel<Livro>(new ReflectLivroDAO()));
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(tm);
		add(scroll);
		setSize(800, 250);
		setLocationRelativeTo(null); // Centraliza o Jframe
	}
}
