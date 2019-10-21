package br.ufma.ecp.agenda_contatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private String url = "jdbc:mysql://localhost/agenda?user=root&password=1234&useTimezone=true&serverTimezone=UTC";
	
	public ContatoDAO() {
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
	
	public List<Contato> recuperarContato() {
		try {
			List<Contato> result = new ArrayList<Contato>();
			String sql = "select * from contato";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				result.add(new Contato(rs.getString("nome"), rs.getString("email"), rs.getString("telefone")));
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/*
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
	}*/

}
