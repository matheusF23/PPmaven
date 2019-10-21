package br.ufma.ecp.agenda_contatos;



public class CadastraContato {

	public static void main(String[] args) {
		Contato contato = new Contato("Jorge", "jorge@gmail.com", "999353267");
		contato.salvaNoBanco();
		contato.buscaDados();

	}

}