package Logica.Entidades.Fabricas;

import java.util.LinkedList;


import Logica.Entidades.Entidad;
import Logica.Entidades.Jugador;

public class FabricaJugador implements Fabrica {

	private LinkedList<Entidad> lista;
	private Fabrica miFabrica;
	
	public FabricaJugador(LinkedList<Entidad> lista, Fabrica miFabrica) {
		this.lista = lista;
		this.miFabrica = miFabrica;
	}
	
	@Override
	public Entidad crear() {
		Jugador jugador = new Jugador(100, 10, miFabrica);
		lista.addLast(jugador);
		return jugador;
	}
}
