package Logica.Entidades.Fabricas;

import java.util.LinkedList;

import Logica.Entidades.Beta;
import Logica.Entidades.Entidad;

public class FabricaBeta implements Fabrica{

	private LinkedList<Entidad> lista;
	private Fabrica miFabrica;
	
	public FabricaBeta(LinkedList<Entidad> lista, Fabrica miFabrica) {
		this.lista = lista;
		this.miFabrica = miFabrica;
	}
	
	@Override
	public Entidad crear() {
		Beta alfa = new Beta(3, 3, miFabrica);
		lista.addLast(alfa);
		return alfa;
	}
}
