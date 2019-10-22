package br.ufma.ecp.estante_livros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroDAO {
	private Connection conn;
	private PreparedStatement stmt;
	private String url = "jdbc:mysql://localhost/estante?user=root&password=1234&useTimezone=true&serverTimezone=UTC";

	public LivroDAO() {
		try {
			// Conectando com o banco
			conn = DriverManager.getConnection(url);
			System.out.println("Conectaxão ao banco bem sucedida!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void desconectaBanco() {
		try {
			conn.close(); // fecha conexao com o banco
			System.out.println("Desconexão com o banco bem sucedida!");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salvaNoBanco(Livro livro) {
		try {
			String sql = "insert into livros (codigo, nome, autor) values (?, ?, ?)";

			stmt = conn.prepareStatement(sql);
			stmt.setLong(1, livro.getCodigo());
			stmt.setString(2, livro.getNome());
			stmt.setString(3, livro.getAutor());
			stmt.execute();
			System.out.println("Adicionado com sucesso!");
			stmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Livro> recuperarLivros() {
		try {
			List<Livro> result = new ArrayList<Livro>();
			String sql = "select * from livros";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				result.add(new Livro(rs.getInt("codigo"), rs.getString("nome"), rs.getString("autor")));
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
