package Logica.Entidades.Fabricas;

import java.util.LinkedList;

import Logica.Entidades.Desinfectante;
import Logica.Entidades.Entidad;

public class FabricaDesinfectante implements Fabrica{

	
private LinkedList<Entidad> lista;
	
	public FabricaDesinfectante(LinkedList<Entidad> lista) {
		this.lista = lista;
	}
	
	@Override
	public Entidad crear() {
		Desinfectante d = new Desinfectante(0);
		lista.addLast(d);
		return d;
	}

}
