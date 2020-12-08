package Logica.Entidades.Fabricas;

import Logica.Entidades.Alpha;
import Logica.Entidades.Entidad;

public class FabricaAlpha implements Fabrica {

	public FabricaAlpha() {

	}

	@Override
	public Entidad crear() {
		Alpha a = new Alpha();
		return a;
	}

}
