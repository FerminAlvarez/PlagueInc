package Logica.Entidades;

import Logica.Entidades.Fabricas.FabricaEspora;
import Logica.Entidades.Visitors.VisitorInfectado;

public abstract class Infectado extends Personaje{

	protected final int cooldownMaximo = 120;
	protected int cooldown;
	
	protected Infectado(int hp, int dano) {
		super(hp, dano);
		cooldown = cooldownMaximo;
		miVisitor = new VisitorInfectado(this);
		miFabrica = new FabricaEspora();
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
	
	protected void disparar() {
		miEstrategiaDisparo.disparar();
	}
	
	public void destruir() {
		super.destruir();
		juego.infectadoDestruido(miEntidadGrafica.obtenerPosicionX());
	}
}
