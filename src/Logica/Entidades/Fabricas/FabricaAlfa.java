package Logica.Entidades.Fabricas;

import Logica.Entidades.Alfa;
import Logica.Entidades.Entidad;

public class FabricaAlfa implements Fabrica {

	public FabricaAlfa() {

	}

	@Override
	public Entidad crear() {
		Alfa a = new Alfa();
		return a;
	}

}
