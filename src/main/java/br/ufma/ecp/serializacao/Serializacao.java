package br.ufma.ecp.serializacao;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Serializacao {
	private ObjectOutputStream saida;

	public void binSerialization() {
		// Serializando objetos para o formato binário
		try {
			OutputStream f = new FileOutputStream("pessoa.bin");
			saida = new ObjectOutputStream(f);
			Pessoa p = new Pessoa("joao", "45454", 30, 1.65);
			saida.writeObject(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
