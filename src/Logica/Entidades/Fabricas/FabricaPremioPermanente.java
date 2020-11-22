package Logica.Entidades.Fabricas;

import java.util.LinkedList;
import java.util.Random;

import Logica.Entidades.Entidad;
import Logica.Entidades.Jugador;
import Logica.Entidades.PremioPermanente;

public class FabricaPremioPermanente implements Fabrica{

private LinkedList<Entidad> lista;
private Jugador jugador;
	public FabricaPremioPermanente(LinkedList<Entidad> lista, Jugador jugador) {
		this.lista = lista;
		this.jugador = jugador;
	}
	
	@Override
	public Entidad crear() {
		Random aleatorio = new Random();
		int numeroAleatorio = aleatorio.nextInt(PremioPermanente.getCantidadBeneficios());
		PremioPermanente d = new PremioPermanente(jugador, numeroAleatorio);
		lista.addLast(d);
		return d;
	}

}