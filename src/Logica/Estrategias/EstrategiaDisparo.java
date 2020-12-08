package Logica.Estrategias;


import Logica.logica;
import Logica.Entidades.Entidad;
import Logica.Entidades.Fabricas.Fabrica;

public abstract class EstrategiaDisparo {

	protected int velocidad, dano;
	protected Entidad miEntidad;
	protected Fabrica miFabrica;
	protected logica juego;

	protected EstrategiaDisparo(int dano, int velocidad, Fabrica miFabrica, Entidad miEntidad) {
		this.velocidad = velocidad;
		this.dano = dano;
		this.miEntidad = miEntidad;
		this.miFabrica = miFabrica;
	}

	public void disparar() {
		Entidad proy = miFabrica.crear();
		proy.establecerLogica(juego);
		proy.obtenerMovimiento().establecerVelocidad(velocidad);
		proy.establecerDano(dano);
		proy.obtenerGrafica().establecerPosicion(miEntidad.obtenerPosicionX() + miEntidad.obtenerPuntoDisparoX(),
				miEntidad.obtenerPosicionY() + miEntidad.obtenerPuntoDisparoY());
	}

	public void establecerVelocidad(int v) {
		velocidad = v;
	}

	public void establecerDano(int d) {
		dano = d;
	}

	public void destruir() {
		miEntidad = null;
		miFabrica = null;
	}

	public void establecerLogica(logica juego) {
		this.juego = juego;
	}

	public abstract boolean puedeDisparar();
}
