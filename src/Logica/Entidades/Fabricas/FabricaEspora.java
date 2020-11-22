package Logica.Entidades.Fabricas;

import java.util.Stack;

import Logica.Entidades.Entidad;
import Logica.Entidades.Espora;

public class FabricaEspora implements Fabrica {

	private Stack<Entidad> cambios;

	public FabricaEspora(Stack<Entidad> cambios) {
		this.cambios = cambios;
	}

	@Override
	public Entidad crear() {
		Espora e = new Espora(10);
		cambios.push(e);
		return e;
	}

}
