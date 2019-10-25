package br.ufma.ecp.estante_livros;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameLivro extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private LivroDAO dao = new LivroDAO(); // Cria uma conexao com o banco de dados permitindo operacoes no banco

	private JLabel lblCodigo;
	private JLabel lblNome;
	private JLabel lblAutor;
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtAutor;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JButton btnSair;
	private JButton btnMostraLivro;

	private JPanel jpnCodigo;
	private JPanel jpnNome;
	private JPanel jpnAutor;
	private JPanel jpnButton;
	private JPanel jpnButton1;
	private JPanel jpnCN; // JPanel auxiliar para codigo e nome
	private JPanel jpnCNA; // JPanel auxiliar para codigo e nome e autor
	private JPanel jpnCNAB; // JPanel auxiliar para codigo e nome e autor e botoes
	private JPanel jpnCNABB; // JPanel auxiliar para codigo e nome e autor e botoes 2

	public FrameLivro() {
		// Config Jframe
		setTitle("Cadastro de Livros"); // Titulo
		setSize(350, 180); // Tamanho
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Fecha a aplicacao
		setLocationRelativeTo(null); // Centraliza o Jframe

		// Instanciando
		lblCodigo = new JLabel("Código: ");
		lblNome = new JLabel("Nome do livro: ");
		lblAutor = new JLabel("Nome do autor: ");
		txtCodigo = new JTextField(20);
		txtNome = new JTextField(20);
		txtAutor = new JTextField(20);
		btnCadastrar = new JButton("Cadastrar");
		btnLimpar = new JButton("Limpar");
		btnSair = new JButton("Sair");
		btnMostraLivro = new JButton("Visualisar livros");

		jpnCodigo = new JPanel(new BorderLayout());
		jpnNome = new JPanel(new BorderLayout());
		jpnAutor = new JPanel(new BorderLayout());
		jpnButton = new JPanel(new FlowLayout());
		jpnButton1 = new JPanel(new BorderLayout());
		jpnCN = new JPanel(new BorderLayout());
		jpnCNA = new JPanel(new BorderLayout());
		jpnCNAB = new JPanel(new BorderLayout());
		jpnCNABB = new JPanel(new BorderLayout());
		

		// Acoes aos botoes
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Livro livro = new Livro(Integer.parseInt(txtCodigo.getText()), txtNome.getText(), txtAutor.getText());

				dao.salvaNoBanco(livro); // salva os dados no banco
				btnCadastrarActionPerformed();
			}
		});

		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCodigo.setText("");
				txtNome.setText("");
				txtAutor.setText("");
			}
		});

		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSairActionPerformed();
			}
		});

		btnMostraLivro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnMostraLivroActionPerformed();
			}
		});

		// Adicao de componentes ao JFrame
		jpnCodigo.add(lblCodigo, BorderLayout.WEST);
		jpnCodigo.add(txtCodigo, BorderLayout.EAST);
		jpnCN.add(jpnCodigo, BorderLayout.NORTH);

		jpnNome.add(lblNome, BorderLayout.WEST);
		jpnNome.add(txtNome, BorderLayout.EAST);
		jpnCN.add(jpnNome, BorderLayout.SOUTH);

		jpnAutor.add(lblAutor, BorderLayout.WEST);
		jpnAutor.add(txtAutor, BorderLayout.EAST);
		jpnCNA.add(jpnCN, BorderLayout.NORTH);
		jpnCNA.add(jpnAutor, BorderLayout.SOUTH);

		jpnButton.add(btnCadastrar, BorderLayout.WEST);
		jpnButton.add(btnLimpar, BorderLayout.CENTER);
		jpnButton.add(btnMostraLivro, BorderLayout.EAST);
		jpnCNAB.add(jpnCNA, BorderLayout.NORTH);
		jpnCNAB.add(jpnButton, BorderLayout.SOUTH);

		jpnButton1.add(btnSair, BorderLayout.CENTER);
		jpnCNABB.add(jpnCNAB, BorderLayout.NORTH);
		jpnCNABB.add(jpnButton1, BorderLayout.SOUTH);

		
		add(jpnCNABB);
	}

	private void btnCadastrarActionPerformed() {
		JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso", "Cadastro de livros",
				JOptionPane.PLAIN_MESSAGE);
	}

	private void btnSairActionPerformed() {
		int confirm = JOptionPane.showConfirmDialog(this, "Deseja realemente fechar a aplicação?", "Sair - Contirmação",
				JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
		if (confirm == JOptionPane.YES_OPTION) {
			dao.desconectaBanco(); // Fecha conexao com o banco
			System.exit(1);
		}
	}

	private String listLivros() {
		List<Livro> livros = dao.readLivros();
		String listLivros = "";
		for (Livro l : livros) {
			String temp = "Codigo: " + Integer.toString(l.getCodigo()) + ". Nome: " + l.getNome() + ". Autor: "
					+ l.getAutor() + ".\n";
			listLivros = listLivros + temp;
		}
		return listLivros;
	}

	private void btnMostraLivroActionPerformed() {
		String livros = listLivros();

		JOptionPane.showMessageDialog(null, livros, "Lista de livros", JOptionPane.PLAIN_MESSAGE);
	}
}
