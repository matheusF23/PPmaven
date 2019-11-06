package br.ufma.ecp.serializacao;

public class App {

	public static void main(String[] args) {
		Serializacao s = new Serializacao();

		// s.binSerializa(); // Serializa no formato bin
		// s.binDeserializa(); // Deserializa no formato bin
		s.xmlSerializa(); // Serializa no formato XML
	}

}
