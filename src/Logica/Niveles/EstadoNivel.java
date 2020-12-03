package Logica.Niveles;

import java.util.List;
import java.util.Random;

import Logica.logica;
import Logica.Entidades.Entidad;
import Logica.Entidades.Fabricas.Fabrica;

public abstract class EstadoNivel {
	
	protected List<Fabrica> fabricasEntidades, misPremios;
	protected List<Integer> cantidad;
	protected List<Entidad> misEntidades;
	protected logica juego;
	protected int delay;
	protected int probabilidadPremio;
	
	public abstract String obtenerFondo();
	public abstract EstadoNivel siguienteNivel();
	public abstract int obtenerNumeroNivel();
	
	public void entidadDestruida(Entidad e) {
		misEntidades.remove(e);
	}
	
	public boolean termino() {
		return misEntidades.isEmpty();
	}
	
	public Entidad getPremio() {
		Entidad result = null;
		Random r = new Random();
		if(r.nextInt(probabilidadPremio) >= 100) {
			result = misPremios.get(r.nextInt(misPremios.size())).crear();
		}
		return result;
	}
	
	public void inicializar() {
		int fabricaActual = 0;
		for(int itInteger : cantidad) {
			for(int i = 0; i < itInteger; i++) {
				misEntidades.add(fabricasEntidades.get(fabricaActual).crear());
			}
			fabricaActual++;
		}
	}
	
	public int obtenerDelay() {
		return delay;
	}
	
	public List<Entidad> getEntidades() {
		return misEntidades;
	}
}
