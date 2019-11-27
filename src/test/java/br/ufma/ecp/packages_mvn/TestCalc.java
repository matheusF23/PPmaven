package br.ufma.ecp.packages_mvn;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.ufma.ecp.testes.Calc;

public class TestCalc {
	@Test
	public void testAdd() {
		Calc c = new Calc();
		int i = c.add(2,3);
		assertEquals(5,i);
	}
}
