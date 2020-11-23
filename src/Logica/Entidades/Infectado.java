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
		gracePeriod = gracePeriod > 0 ? gracePeriod - 1 : 0;
	}
	
	public void atacar(Jugador entidad) {
		entidad.recibirDano(dano);
	}
	
	protected void disparar() {
		miEstrategiaDisparo.disparar();
	}
	
}
