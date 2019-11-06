package br.ufma.ecp.serializacao;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class Serializacao {
	private ObjectOutputStream saida;
	private Pessoa o;

	// Serializando objetos para o formato binário
	public void binSerializa() {
		try {
			OutputStream f = new FileOutputStream("pessoa.bin");
			saida = new ObjectOutputStream(f);
			Pessoa p = new Pessoa("joao", "45454", 30, 1.65);
			saida.writeObject(p);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Deserializando
	public void binDeserializa() {
		try {
			InputStream f = new FileInputStream("pessoa.bin");
			ObjectInputStream entrada = new ObjectInputStream(f);
			o = (Pessoa) entrada.readObject();
			entrada.close();
			System.out.println(o);
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("concluido");
	}

	// Serializando objetos para o formato XML
	public void xmlSerializa() {
		try {
			OutputStream f = new FileOutputStream("saida.xml");
			XMLEncoder encoder = new XMLEncoder(f);
			Pessoa p = new Pessoa("joao", "45454", 30, 1.65);
			encoder.writeObject(p);
			encoder.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Deserializando
	public void xmlDeserializa() {
		try {
			InputStream f = new FileInputStream("saida.xml");
			XMLDecoder dec = new XMLDecoder(f);
			Pessoa p = (Pessoa) dec.readObject();
			dec.close();
			System.out.println(p);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
