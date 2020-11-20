package Grafica;

import java.util.LinkedList;

import Logica.Entidades.Infectado;

public class HiloInfectados implements Runnable{
	private LinkedList<Infectado> infectados;
	private boolean reproducir=true;
	private long tiempoEspera;
	
	
	public HiloInfectados(LinkedList<Infectado> infectados, long tiempoDesplazamiento) {
		this.infectados = infectados;
		tiempoEspera = tiempoDesplazamiento;
	}
	
	public void detenerHilo() {
		reproducir = false;
	}
	
	
	@Override
	public void run() {
		try {
			while(reproducir) {
				for(Infectado infectado : infectados) {
					System.out.println("Muevo infectado");
					infectado.mover();
				}
				Thread.sleep(tiempoEspera);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
		
	