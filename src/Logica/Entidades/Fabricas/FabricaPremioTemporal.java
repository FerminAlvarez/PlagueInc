package Logica.Entidades.Fabricas;

import java.util.Random;
import java.util.Stack;

import Logica.Entidades.Entidad;
import Logica.Entidades.PremioCuarentena;
import Logica.Entidades.PremioSuperArma;
import Logica.Entidades.PremioTemporal;

public class FabricaPremioTemporal implements Fabrica {

	private Stack<Entidad> cambios;

	public FabricaPremioTemporal(Stack<Entidad> cambios) {
		this.cambios = cambios;
	}

	@Override
	public Entidad crear() {
		Random aleatorio = new Random();
		int numeroAleatorio = aleatorio.nextInt(1);
		PremioTemporal premio = null;
		switch (numeroAleatorio) {
			case 0: {
				premio = new PremioCuarentena ();
				break;
			}
			case 1: {
				premio = new PremioSuperArma();
				break;
			}
		}
		cambios.push(premio);
		return premio;
	}
}
