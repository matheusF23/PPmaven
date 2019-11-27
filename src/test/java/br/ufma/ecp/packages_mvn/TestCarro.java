package br.ufma.ecp.packages_mvn;

import br.ufma.ecp.testes.Carro;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class TestCarro {
	@Test
	public void TestAcelerar() {
		Carro c = new Carro(10);
		c.acelerar();
		assertEquals(10, c.getVelocidade());
	}

	@Test
	public void TestAcelerarMaisDeUmaVez() {
		Carro c = new Carro(10);
		c.acelerar();
		c.acelerar();
		c.acelerar();
		assertEquals(30, c.getVelocidade());
	}
	
	@Test
	public void testFrear() {
		Carro c = new Carro(10);
		c.acelerar();
		c.frear();
		assertEquals(5, c.getVelocidade());
	}
	
	@Test
	public void testFrearAteZero() {
		Carro c = new Carro(10);
		c.acelerar();
		c.frear();
		c.frear();
		c.frear();
		c.frear();
		assertEquals(0, c.getVelocidade());
	}
}
