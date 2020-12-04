package Logica.Entidades.Fabricas;

import Logica.Entidades.Entidad;
import Logica.Entidades.Espora;

public class FabricaEspora implements Fabrica {

	public FabricaEspora() {
	}

	@Override
	public Entidad crear() {
		Espora e = new Espora();
		return e;
	}

}
