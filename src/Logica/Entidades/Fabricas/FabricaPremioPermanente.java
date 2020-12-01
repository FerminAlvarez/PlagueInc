package Logica.Entidades.Fabricas;

import java.util.Random;

import Logica.Entidades.Entidad;
import Logica.Entidades.PremioPermanente;
import Logica.Entidades.PremioVelocidad;
import Logica.Entidades.PremioVida;

public class FabricaPremioPermanente implements Fabrica {

	public FabricaPremioPermanente() {

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
		return premio;
	}

}
