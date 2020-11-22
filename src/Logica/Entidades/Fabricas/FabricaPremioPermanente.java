package Logica.Entidades.Fabricas;

import java.util.Random;
import java.util.Stack;

import Logica.Entidades.Entidad;
import Logica.Entidades.Jugador;
import Logica.Entidades.PremioPermanente;

public class FabricaPremioPermanente implements Fabrica {

	private Stack<Entidad> cambios;
	private Jugador jugador;

	public FabricaPremioPermanente(Stack<Entidad> cambios, Jugador jugador) {
		this.cambios = cambios;
		this.jugador = jugador;
	}

	@Override
	public Entidad crear() {
		Random aleatorio = new Random();
		int numeroAleatorio = aleatorio.nextInt(PremioPermanente.getCantidadBeneficios());
		PremioPermanente d = new PremioPermanente(jugador, numeroAleatorio);
		cambios.push(d);
		return d;
	}

}