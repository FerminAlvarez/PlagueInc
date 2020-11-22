package Logica.Entidades.Fabricas;

import java.util.Stack;

import Logica.Entidades.Desinfectante;
import Logica.Entidades.Entidad;

public class FabricaDesinfectante implements Fabrica{

	
	private Stack<Entidad> cambios;
	
	public FabricaDesinfectante(Stack<Entidad> cambios) {
		this.cambios = cambios;
	}
	
	@Override
	public Entidad crear() {
		Desinfectante d = new Desinfectante(10);
		cambios.push(d);
		return d;
	}
}
