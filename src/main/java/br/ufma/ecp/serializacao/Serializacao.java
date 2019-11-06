package br.ufma.ecp.serializacao;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Serializacao {
	private ObjectOutputStream saida;
	private Pessoa o;

	public void binSerializa() {
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
	
	public void binDeserializa() {
		try {
            InputStream f = new FileInputStream("pessoa.bin");
            ObjectInputStream entrada = new ObjectInputStream(f);
            o = (Pessoa)entrada.readObject();
            entrada.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();

        }
		System.out.println(o);
        System.out.println("concluido");
	}

}
