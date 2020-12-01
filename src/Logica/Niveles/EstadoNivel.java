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
	protected int probabilidadPremioTemporal;
	protected int probabilidadPremioPermanente;
	
	protected abstract void empezar();
	public abstract String obtenerFondo();
	public abstract EstadoNivel siguienteNivel();
	public abstract int obtenerNumeroNivel();
	
	public int obtenerTotalInfectados() {
		return totalInfectados;
	}
	
	public int obtenerInfectadosRestantes() {
		return infectadosRestantes;
	}
	
	public int obtenerDelay() {
		return delay;
	}
	
	public Fabrica obtenerFabricaInfectado() {
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
	
	public int obtenerProbabilidadPremioTemporal () {
		return probabilidadPremioTemporal;
	}
	public int obtenerProbabilidadPremioPermanente () {
		return probabilidadPremioPermanente;
	}
}
