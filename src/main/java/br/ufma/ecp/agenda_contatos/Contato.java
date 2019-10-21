package br.ufma.ecp.agenda_contatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Contato {
	private String nome;
	private String email;
	private String phone;
	private Connection conn;
	private PreparedStatement stmt;
	
	public Contato(String nome, String email, String phone) {
		super();
		this.nome = nome;
		this.email = email;
		this.phone = phone;
	}
	
	public void conectaBanco() {
		String url = "jdbc:mysql://localhost/agenda?user=root&password=1234&useTimezone=true&serverTimezone=UTC";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("Conectado com sucesso!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void desconectaBanco() {
		try {
			conn.close();
			System.out.println("Conecção fechada.");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void salvaNoBanco() {
		try {
			this.conectaBanco();
			String sql = "insert into contato (nome, email, telefone) values (?, ?, ?)";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, nome);
			stmt.setString(2, email);
			stmt.setString(3, phone);
			stmt.execute();
			System.out.println("Adicionado com sucesso!");
			stmt.close();
			
			this.desconectaBanco();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void buscaDados() {
		try {
			this.conectaBanco();
			String sql = "select * from contato";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("Nome: " + rs.getString("nome"));
				System.out.println("Email: " + rs.getString("email"));
			}
			
			this.desconectaBanco();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
