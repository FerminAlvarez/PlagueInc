package Logica.Entidades.Fabricas;

import java.util.Random;

import java.util.Stack;

import Logica.Entidades.Entidad;
import Logica.Entidades.PremioPermanente;
import Logica.Entidades.PremioVelocidad;
import Logica.Entidades.PremioVida;

public class FabricaPremioPermanente implements Fabrica {

	private Stack<Entidad> cambios;

	public FabricaPremioPermanente(Stack<Entidad> cambios) {
		this.cambios = cambios;
	}

	@Override
	public Entidad crear() {
		Random aleatorio = new Random();
		int numeroAleatorio = aleatorio.nextInt(2);
		PremioPermanente premio = null;
		switch (numeroAleatorio) {
			case 0: {
				premio = new PremioVida ();
				break;
			}
			case 1: {
				premio = new PremioVelocidad();
				break;
			}
		}
		cambios.push(premio);
		return premio;
	}
}