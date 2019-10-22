package br.ufma.ecp.estante_livros;

public class Livro {
	private int codigo;
	private String nome;
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
		return "Livro [codigo=" + this.getCodigo() + ", nome=" + this.getNome() + ", autor=" + this.getAutor() + "]";
	}
	
}
