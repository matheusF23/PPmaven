package br.ufma.ecp.estante_livros;

import br.ufma.ecp.estante_livros_prog_reflexiva.CollumnAnnotation;

public class Livro {
	@CollumnAnnotation(nome = "Código", posicao = 0)
	private int codigo;
	@CollumnAnnotation(nome = "Nome", posicao = 1)
	private String nome;
	@CollumnAnnotation(nome = "Autor", posicao = 2)
	private String autor;

	public Livro(int codigo, String nome, String autor) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.autor = autor;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	@Override
	public String toString() {
		return "[codigo = " + this.getCodigo() + ", nome = " + this.getNome() + ", autor = " + this.getAutor() + "]";
	}
}
