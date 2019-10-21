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
	
	public Contato(String nome, String email, String phone) {
		super();
		this.nome = nome;
		this.email = email;
		this.phone = phone;
	}
	
	public void salvaNoBanco() {
		Connection conn;
		String url = "jdbc:mysql://localhost/agenda?user=root&password=1234&useTimezone=true&serverTimezone=UTC";
		try {
			conn = DriverManager.getConnection(url);
			System.out.println("Conectado com sucesso!");
			
			//String sql = "insert into contato (nome, email, telefone) values (?, ?, ?)";
			String sql = "select * from contato";

			PreparedStatement stmt = conn.prepareStatement(sql);
			//stmt.setString(1,  "sergio");
			//stmt.setString(2,  "skosta@gmail");
			//stmt.setString(3,  "sergio");
			//stmt.execute();
			//stmt.close();
			
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				System.out.println("Nome: " + rs.getString("nome"));
				System.out.println("Email: " + rs.getString("email"));
			}
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
