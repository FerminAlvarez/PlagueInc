package Logica.Entidades.Fabricas;

import java.util.Stack;

import Logica.Entidades.Alfa;
import Logica.Entidades.Entidad;

public class FabricaAlfa implements Fabrica{

	private Stack<Entidad> cambios;
	private Fabrica miFabrica;
	
	public FabricaAlfa(Stack<Entidad> cambios, Fabrica miFabrica) {
		this.cambios = cambios;
		this.miFabrica = miFabrica;
	}
	
	@Override
	public Entidad crear() {
		Alfa a = new Alfa(30, 10, miFabrica);
		cambios.push(a);
		return a;
	}

}
