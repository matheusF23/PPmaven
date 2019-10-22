package br.ufma.ecp.estante_livros;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	public FrameLivro() {
		// Config Jframe
		setTitle("Cadastro de Livros"); // Titulo
		setSize(400, 250); // Tamanho
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Fecha a aplicacao
		setLocationRelativeTo(null); // Centraliza o Jframe
		
		// Instanciando
		lblCodigo = new JLabel("Código: ");
		lblNome = new JLabel("Nome do livro: ");
		lblAutor = new JLabel("Nome do autor: ");
		txtCodigo = new JTextField(5);
		txtNome = new JTextField(20);
		txtAutor = new JTextField(20);
		btnCadastrar = new JButton("Cadastrar");
		btnLimpar = new JButton("Limpar");
		btnSair = new JButton("Sair");
		btnMostraLivro = new JButton("Visualisar livros");

		jpnCodigo = new JPanel();
		jpnNome = new JPanel();
		jpnAutor = new JPanel();
		jpnButton = new JPanel();
		jpnButton1 = new JPanel();
		
		// Acoes aos botoes
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Livro livro = new Livro(Integer.parseInt(txtCodigo.getText()), txtNome.getText(), txtAutor.getText());
				LivroDAO dao = new LivroDAO(); // Cria uma conexao com o banco de dados permitindo operacoes no
													// banco
				dao.salvaNoBanco(livro); // salva os dados no banco
				dao.desconectaBanco(); // Fecha conexao com o banco
				btnCadastrarActionPerformed();
			}
		});
		
		
		
		// Adicao de componentes ao JFrame
		jpnCodigo.add(lblCodigo);
		jpnCodigo.add(txtCodigo);
		
		jpnNome.add(lblNome);
		jpnNome.add(txtNome);
		
		jpnAutor.add(lblAutor);
		jpnAutor.add(txtAutor);
		
		jpnButton.add(btnCadastrar);
		jpnButton.add(btnLimpar);
		jpnButton.add(btnMostraLivro);
		jpnButton1.add(btnSair);
		
		add(jpnCodigo);
		add(jpnNome);
		add(jpnAutor);
		add(jpnButton);
		add(jpnButton1);
		
	}
	
	private void btnCadastrarActionPerformed() {
		JOptionPane.showMessageDialog(null, "Cadastro salvo com sucesso",
				"Cadastro de livros", JOptionPane.PLAIN_MESSAGE);
	}

}
