package Logica.Entidades.Fabricas;

import java.util.Random;

import java.util.Stack;

import Logica.Entidades.Entidad;
import Logica.Entidades.PremioPermanente;

public class FabricaPremioPermanente implements Fabrica {

	private Stack<Entidad> cambios;

	public FabricaPremioPermanente(Stack<Entidad> cambios) {
		this.cambios = cambios;
	}

	@Override
	public Entidad crear() {
		Random aleatorio = new Random();
		int numeroAleatorio = aleatorio.nextInt(PremioPermanente.getCantidadBeneficios());
		PremioPermanente d = new PremioPermanente(numeroAleatorio);
		cambios.push(d);
		return d;
	}

}