package br.ufma.ecp.agenda_contatos;



public class CadastraContato {

	public static void main(String[] args) {
		Contato contato = new Contato("Gilson", "gilson@gmail.com", "996627834");	// Adiciona um contato na agenda
		
		ContatoDAO dao = new ContatoDAO();	// Cria uma conexao com o banco de dados permitindo operacoes no banco
		dao.salvaNoBanco(contato);	// salva os dados no banco
		dao.buscaDados();	// busca os dados no banco
		dao.desconectaBanco();	// Fecha conexao com o banco
	}

}