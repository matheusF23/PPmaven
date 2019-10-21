package br.ufma.ecp.agenda_contatos;



public class CadastraContato {

	public static void main(String[] args) {
		Contato contato = new Contato("Matheus", "matheus@gmail.com", "999229832");
		contato.salvaNoBanco();

	}

}