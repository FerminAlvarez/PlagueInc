package Logica.Estrategias;

import Logica.Entidades.EntidadesGraficas.EntidadGrafica;
import Logica.Entidades.Fabricas.Fabrica;

public abstract class EstrategiaDisparo {

	protected int velocidad, dano;
	protected EntidadGrafica miEntidadGrafica;
	protected Fabrica miFabrica;

	protected EstrategiaDisparo(int dano, int velocidad, Fabrica miFabrica, EntidadGrafica miEntidadGrafica) {
		this.velocidad = velocidad;
		this.dano = dano;
		this.miEntidadGrafica = miEntidadGrafica;
		this.miFabrica = miFabrica;
	}

	public abstract void disparar();
	
	public void setVelocidad(int v) {
		velocidad = v;
	}
	
	public void setDano(int d) {
		dano = d;
	}

	public void destruir() {
		miEntidadGrafica = null;
		miFabrica = null;
	}
	
}
