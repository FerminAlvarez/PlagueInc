package Logica.Entidades.Fabricas;

import Logica.Entidades.Entidad;
import Logica.Entidades.PremioSuperArma;

public class FabricaSuperArma implements Fabrica{

	public FabricaSuperArma() {

	}

	@Override
	public Entidad crear() {
		PremioSuperArma p = new PremioSuperArma();
		return p;
	}
}