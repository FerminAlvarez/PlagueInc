package Logica.Entidades.Fabricas;

import java.util.LinkedList;

import Logica.Entidades.Alfa;
import Logica.Entidades.Entidad;

public class FabricaAlfa implements Fabrica{

	private LinkedList<Entidad> lista;
	private Fabrica miFabrica;
	
	public FabricaAlfa(LinkedList<Entidad> lista, Fabrica miFabrica) {
		this.lista = lista;
		this.miFabrica = miFabrica;
	}
	
	@Override
	public Entidad crear() {
		Alfa alfa = new Alfa(3, 3, miFabrica);
		lista.addLast(alfa);
		return alfa;
	}

}
