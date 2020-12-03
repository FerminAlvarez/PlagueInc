package Logica.Entidades.Fabricas;

import Logica.Entidades.Entidad;
import Logica.Entidades.PremioVida;

public class FabricaVida implements Fabrica{

	public FabricaVida() {

	}

	@Override
	public Entidad crear() {
		PremioVida p = new PremioVida();
		return p;
	}
}