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
	private final String url = "jdbc:mysql://localhost/estante?user=root&password=1234&useTimezone=true&serverTimezone=UTC";

	public LivroDAO() {
		try {
			// Conectando com o banco
			conn = DriverManager.getConnection(url);
			System.out.println("Conectado ao banco!");
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

	public List<Livro> readLivros() {
		List<Livro> livros = new ArrayList<Livro>();
		String sql = "select * from livros";
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				livros.add(new Livro(rs.getInt("codigo"), rs.getString("nome"), rs.getString("autor")));
			}
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return livros;
	}
	
	public void update(Livro livro) {
		String sql = "update livros set nome = ?, autor = ? where codigo = ?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, livro.getNome());
			stmt.setString(2, livro.getAutor());
			stmt.setLong(3, livro.getCodigo());
			stmt.execute();
			System.out.println("Atualizado com sucesso!");
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
