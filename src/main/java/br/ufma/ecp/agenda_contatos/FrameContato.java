package br.ufma.ecp.agenda_contatos;

import java.awt.FlowLayout;

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

		// Adicionando acoes aos botoes

		// Adicionando componentes ao JFrame
		jpnNome.add(lblNome);
		jpnNome.add(txtNome);
		
		jpnEmail.add(lblEmail);
		jpnEmail.add(txtEmail);
		
		jpnTelefone.add(lblTelefone);
		jpnTelefone.add(txtTelefone);
		
		add(jpnNome);
		add(jpnEmail);
		add(jpnTelefone);

	}

}
