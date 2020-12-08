package Logica.Estrategias;

import Logica.Entidades.Entidad;
import Logica.Entidades.Fabricas.Fabrica;

public class DisparoEspora extends EstrategiaDisparo{

	public DisparoEspora(int dano, int velocidad, Fabrica miFabrica, Entidad miEntidad) {
		super(dano, velocidad, miFabrica, miEntidad);
	}

	@Override
	public boolean puedeDisparar() {
		return false;
	}

}
