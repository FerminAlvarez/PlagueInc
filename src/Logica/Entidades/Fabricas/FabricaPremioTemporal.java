package Logica.Entidades.Fabricas;

import java.util.Random;

import Logica.Entidades.Entidad;
import Logica.Entidades.PremioCuarentena;
import Logica.Entidades.PremioSuperArma;
import Logica.Entidades.PremioTemporal;

public class FabricaPremioTemporal implements Fabrica {

	public FabricaPremioTemporal() {

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
		return premio;
	}

}
