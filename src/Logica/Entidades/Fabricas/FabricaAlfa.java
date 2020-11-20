package Logica.Entidades.Fabricas;

import Logica.Entidades.Alfa;
import Logica.Entidades.Entidad;

public class FabricaAlfa implements Fabrica{

	@Override
	public Entidad crear() {
		return new Alfa(3,3);
	}

}
