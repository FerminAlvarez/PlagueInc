package Logica.Entidades.Fabricas;

import Logica.logica;
import Logica.Entidades.Alfa;
import Logica.Entidades.Entidad;

public class FabricaAlfa implements Fabrica {

	public FabricaAlfa(logica juego) {

	}

	@Override
	public Entidad crear() {
		Alfa a = new Alfa(30, 10);
		return a;
	}

}
