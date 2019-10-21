package br.ufma.ecp.agenda_contatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ContatoDAO {
	private Connection conn;
	private PreparedStatement stmt;
	
	public ContatoDAO() {
		String url = "jdbc:mysql://localhost/agenda?user=root&password=1234&useTimezone=true&serverTimezone=UTC";
		try {
			// Conectando com o banco
			conn = DriverManager.getConnection(url);
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void desconectaBanco() {
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // fecha conexao com o banco
	}

	public void salvaNoBanco(Contato contato) {
		try {
			String sql = "insert into contato (nome, email, telefone) values (?, ?, ?)";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getPhone());
			stmt.execute();
			System.out.println("Adicionado com sucesso!");
			stmt.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buscaDados() {
		try {
			String sql = "select * from contato";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("Nome: " + rs.getString("nome"));
				System.out.println("Email: " + rs.getString("email"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
