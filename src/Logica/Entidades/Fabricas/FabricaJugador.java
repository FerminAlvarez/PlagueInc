package Logica.Entidades.Fabricas;

import java.util.Stack;

import Logica.Entidades.Entidad;
import Logica.Entidades.Jugador;

public class FabricaJugador implements Fabrica {

	private Stack<Entidad> cambios;
	private Fabrica miFabrica;
	
	public FabricaJugador(Stack<Entidad> cambios, Fabrica miFabrica) {
		this.cambios = cambios;
		this.miFabrica = miFabrica;
	}
	
	@Override
	public Entidad crear() {
		Jugador j = new Jugador(100, 10, miFabrica);
		cambios.push(j);
		return j;
	}
}
