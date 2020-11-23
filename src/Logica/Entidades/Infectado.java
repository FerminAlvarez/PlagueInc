package Logica.Entidades;

import Logica.Entidades.Fabricas.Fabrica;
import Logica.Entidades.Visitors.VisitorInfectado;

public abstract class Infectado extends Personaje{

	protected final int cooldownMaximo = 120;
	protected int cooldown;
	
	protected Infectado(int hp, int dano, Fabrica miFabrica) {
		super(hp, dano, miFabrica);
		cooldown = cooldownMaximo;
		miVisitor = new VisitorInfectado(this);
		// TODO Auto-generated constructor stub
	}
	
	public void mover() {
		super.mover();
		if(cooldown <= 0) {
			cooldown = cooldownMaximo;
			disparar();
		}
		else
			cooldown--;
	}
	
	protected void disparar() {
		miEstrategiaDisparo.disparar();
	}
	
}
