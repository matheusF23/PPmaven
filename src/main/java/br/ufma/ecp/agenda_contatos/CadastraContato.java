package br.ufma.ecp.agenda_contatos;



public class CadastraContato {

	public static void main(String[] args) {
		Contato contato = new Contato("Gilson", "gilson@gmail.com", "996627834");	// Adiciona um contato na agenda
		
		ContatoDAO dao = new ContatoDAO();
		dao.salvaNoBanco(contato);
		dao.buscaDados();
		dao.desconectaBanco();
	}

}