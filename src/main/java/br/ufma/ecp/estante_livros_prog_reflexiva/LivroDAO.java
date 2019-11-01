package br.ufma.ecp.estante_livros_prog_reflexiva;

import java.util.Arrays;
import java.util.List;

import br.ufma.ecp.estante_livros.Livro;

public class LivroDAO implements AbstractDAO<Livro> {

	List<Livro> livros = Arrays.asList(new Livro(1, "O planeta dos macacos", "Pierre Boulle"),
			new Livro(2, "172 horas na lua", "Não lembro"));

	public void create(Livro livro) {
	}

	public List<Livro> read() {
		return livros;
	}

}
