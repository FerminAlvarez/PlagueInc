package Grafica;

import java.util.LinkedList;

import Logica.Entidades.Entidad;

public class HiloEntidades implements Runnable{
	private LinkedList<Entidad> entidades;
	private boolean reproducir = true;
	private long tiempoEspera;
	
	
	public HiloEntidades(LinkedList<Entidad> entidades, long tiempoDesplazamiento) {
		this.entidades = entidades;
		tiempoEspera = tiempoDesplazamiento;
	}
	
	public void arrancarHilo() {
		reproducir = true;
	}
	
	public void detenerHilo() {
		reproducir = false;
	}
	
	
	@Override
	public void run() {
		try {
			while(reproducir) {
				for(Entidad e : entidades) {
					e.mover();
				}
				Thread.sleep(tiempoEspera);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
		
	