package Logica.Estrategias;

import java.util.Timer;
import java.util.TimerTask;

import Logica.Entidades.Entidad;
import Logica.Entidades.Fabricas.Fabrica;

public class DisparoNormal extends EstrategiaDisparo{
	
	protected int delayDisparo;
	protected boolean puedeDisparar;

	public DisparoNormal(int dano, int velocidad, Fabrica miFabrica, Entidad miEntidad) {
		super(dano, velocidad, miFabrica, miEntidad);
		// TODO Auto-generated constructor stub
		delayDisparo = 180;
		puedeDisparar = true;
	}
	
	public void disparar() {
		if(puedeDisparar) {
			super.disparar();
			delayDisparo();
		}
	}

	public void delayDisparo() {
		puedeDisparar = false;
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				puedeDisparar = true;
				this.cancel();
			}
		};
		timer.schedule(task, delayDisparo, delayDisparo);
	}

	@Override
	public boolean puedeDisparar() {
		return puedeDisparar;
	}

}
