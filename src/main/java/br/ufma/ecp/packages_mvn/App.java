package br.ufma.ecp.packages_mvn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App {

	public static void main(String[] args) {
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
				
			}
			
			conn.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}