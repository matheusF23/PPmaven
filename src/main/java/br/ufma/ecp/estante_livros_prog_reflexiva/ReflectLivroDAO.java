package br.ufma.ecp.estante_livros_prog_reflexiva;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.ufma.ecp.estante_livros.Livro;

public class ReflectLivroDAO implements AbstractDAO<Livro> {
	private Connection conn;
	private PreparedStatement stmt;
	private final String url = "jdbc:mysql://localhost/estante?user=root&password=1234&useTimezone=true&serverTimezone=UTC";

	public ReflectLivroDAO() {
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

	public void create(Livro livro) {
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

	public List<Livro> read() {
		return null;
	}
	

}
