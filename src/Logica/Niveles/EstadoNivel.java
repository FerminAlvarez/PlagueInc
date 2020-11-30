package Logica.Niveles;

import java.util.List;
import java.util.Random;

import Logica.logica;
import Logica.Entidades.Fabricas.Fabrica;

public abstract class EstadoNivel {
	
	protected List<Fabrica> fabricas;
	protected List<Integer> infectados;
	protected logica juego;
	protected int delay, totalInfectados, infectadosRestantes;
	
	protected abstract void empezar();
	public abstract String getFondo();
	public abstract EstadoNivel siguienteNivel();
	
	public int getTotalInfectados() {
		return totalInfectados;
	}
	
	public int getInfectadosRestantes() {
		return infectadosRestantes;
	}
	
	public int getDelay() {
		return delay;
	}
	
	public Fabrica getFabricaInfectado() {
		Random r = new Random();
		Fabrica result;
		int elegido = r.nextInt(infectados.size());
		result = fabricas.get(elegido);
		if(infectados.get(elegido) - 1 <= 0) {
			infectados.remove(elegido);
			fabricas.remove(elegido);
		}
		else
			infectados.set(elegido, infectados.get(elegido) - 1);
		infectadosRestantes--;
		return result;
	}
}
