package Logica.Estrategias;

import java.util.Timer;
import java.util.TimerTask;

import Logica.logica;
import Logica.Entidades.Entidad;
import Logica.Entidades.Fabricas.Fabrica;

public abstract class EstrategiaDisparo {

	protected int velocidad, dano;
	protected Entidad miEntidad;
	protected Fabrica miFabrica;
	protected logica juego;
	protected int delayDisparo;
	protected boolean puedeDisparar;
	

	protected EstrategiaDisparo(int dano, int velocidad, Fabrica miFabrica, Entidad miEntidad) {
		this.velocidad = velocidad;
		this.dano = dano;
		this.miEntidad = miEntidad;
		this.miFabrica = miFabrica;
		delayDisparo = 180;
		puedeDisparar = true;
	}

	public void disparar() {
		if(puedeDisparar) {
			Entidad proy = miFabrica.crear();
			proy.establecerLogica(juego);
			proy.obtenerMovimiento().establecerVelocidad(velocidad);
			proy.establecerDano(dano);
			proy.obtenerGrafica().establecerPosicion(miEntidad.obtenerPosicionX() + miEntidad.obtenerPuntoDisparoX(), miEntidad.obtenerPosicionY() + miEntidad.obtenerPuntoDisparoY());
			delayDisparo();
		}
	}
	
	
	public void delayDisparo() {
		puedeDisparar=false;
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				puedeDisparar=true;
				this.cancel();
			}
		};
		timer.schedule(task, delayDisparo, delayDisparo);
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
	
}
