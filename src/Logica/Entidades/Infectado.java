package Logica.Entidades;


import java.util.Random;

import Logica.Entidades.Fabricas.FabricaEspora;
import Logica.Entidades.Visitors.VisitorInfectado;

public abstract class Infectado extends Personaje{

	protected final int cooldownMaximo = 60;
	protected int cooldown;
	
	protected Infectado(int hp, int dano) {
		super(hp, dano);
		cooldown = cooldownMaximo;
		miVisitor = new VisitorInfectado(this);
		miFabrica = new FabricaEspora();
	}
	
	public void mover() {
		super.mover();
		Random r = new Random();
		if(cooldown <= 0) {
			cooldown = r.nextInt(cooldownMaximo) + 120;
			miEntidadGrafica.playSound("Disparo");
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
		Entidad miPremio = juego.obtenerPremio();
		if(miPremio != null) {
			miPremio.establecerLogica(juego);
			miPremio.obtenerGrafica().establecerPosicion(miEntidadGrafica.obtenerPosicionX(), -10);
		}
	}
}
