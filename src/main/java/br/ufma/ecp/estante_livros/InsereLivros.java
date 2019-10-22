package br.ufma.ecp.estante_livros;

import java.util.List;

public class InsereLivros {

	public static void main(String[] args) {
		
		LivroDAO ldao = new LivroDAO();
		List<Livro> livros = ldao.recuperarLivros();
		System.out.println(livros);
	}

}
