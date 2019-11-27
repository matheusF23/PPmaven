package br.ufma.ecp.testes;

public class Carro {
	private int speed;
	private int enginePower;

	public Carro(int power) {
		this.enginePower = power;
		this.speed = 0;
	}

	public void acelerar() {
		speed += Math.abs(enginePower);
	}

	public void frear() {
		speed /= 2;
	}

	public int getVelocidade() {
		return speed;
	}
}
