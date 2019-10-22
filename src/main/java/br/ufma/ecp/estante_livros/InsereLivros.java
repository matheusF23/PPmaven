package br.ufma.ecp.estante_livros;

public class InsereLivros {

	public static void main(String[] args) {
		Livro livro1 = new Livro(2, "O dançarino", "Gilson");
		
		LivroDAO ldao = new LivroDAO();
		
		ldao.salvaNoBanco(livro1);
		ldao.buscaDados();
	}

}
