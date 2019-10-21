package br.ufma.ecp.agenda_contatos;


public class Contato {
	private String nome;
	private String email;
	private String phone;
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Contato(String nome, String email, String phone) {
		super();
		this.nome = nome;
		this.email = email;
		this.phone = phone;
	}	
}
