package br.ufma.ecp.agenda_contatos;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FrameContato extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JLabel lblNome;
	private JLabel lblEmail;
	private JLabel lblTelefone;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtTelefone;
	private JButton btnCadastrar;
	private JButton btnLimpar;
	private JButton btnSair;

	private JPanel jpnNome;
	private JPanel jpnEmail;
	private JPanel jpnTelefone;
	private JPanel jpnButton;

	public FrameContato() {
		// Config Jframe
		setTitle("Cadastro de Contatos"); // Titulo
		setSize(400, 200); // Tamanho
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE); // Fecha a aplicacao
		setLocationRelativeTo(null); // Centraliza o Jframe

		// Instanciando
		lblNome = new JLabel("Nome: ");
		lblEmail = new JLabel("Email: ");
		lblTelefone = new JLabel("Telefone: ");
		txtNome = new JTextField(15);
		txtEmail = new JTextField(15);
		txtTelefone = new JTextField(15);
		btnCadastrar = new JButton("Calcular");
		btnLimpar = new JButton("Limpar");
		btnSair = new JButton("Sair");
		jpnNome = new JPanel();
		jpnEmail = new JPanel();
		jpnTelefone = new JPanel();
		jpnButton = new JPanel();

		// Adicionando acoes aos botoes
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ev) {
				Contato contato = new Contato(txtNome.getText(), txtEmail.getText(), txtTelefone.getText());
				ContatoDAO dao = new ContatoDAO(); // Cria uma conexao com o banco de dados permitindo operacoes no
													// banco
				dao.salvaNoBanco(contato); // salva os dados no banco
				dao.desconectaBanco(); // Fecha conexao com o banco
			}
		});

		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtNome.setText("");
				txtEmail.setText("");
				txtTelefone.setText("");
			}
		});

		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		// Adicionando componentes ao JFrame
		jpnNome.add(lblNome);
		jpnNome.add(txtNome);

		jpnEmail.add(lblEmail);
		jpnEmail.add(txtEmail);

		jpnTelefone.add(lblTelefone);
		jpnTelefone.add(txtTelefone);
		
		jpnButton.add(btnCadastrar);
		jpnButton.add(btnLimpar);
		jpnButton.add(btnSair);

		add(jpnNome);
		add(jpnEmail);
		add(jpnTelefone);
		add(jpnButton);
		

	}

}
