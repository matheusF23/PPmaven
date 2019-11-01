package br.ufma.ecp.estante_livros_prog_reflexiva;

import java.util.List;

public interface AbstractDAO<T> {
	// T refere-se a Tipo
	void create(T obj);

	List<T> read();
}
