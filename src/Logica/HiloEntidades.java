package Logica;

public class HiloEntidades implements Runnable{
	private logica juego;
	private boolean reproducir = true;
	private long tiempoEspera;
	
	
	public HiloEntidades(logica juego, long tiempoDesplazamiento) {
		this.juego = juego;
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
			while (reproducir) {
				
				juego.moverEntidades();
				juego.checkearColisiones();
				juego.checkearDestruidos();
				juego.agregarNuevos();
				juego.actualizarGrafica();
				
				Thread.sleep(tiempoEspera);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	
		
	