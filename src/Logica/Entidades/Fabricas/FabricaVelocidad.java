package Logica.Entidades.Fabricas;

import Logica.Entidades.Entidad;
import Logica.Entidades.PremioVelocidad;

public class FabricaVelocidad implements Fabrica{

	public FabricaVelocidad() {

	}

	@Override
	public Entidad crear() {
		PremioVelocidad p = new PremioVelocidad();
		return p;
	}
}