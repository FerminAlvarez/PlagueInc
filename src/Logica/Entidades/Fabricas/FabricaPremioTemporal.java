package Logica.Entidades.Fabricas;

import java.util.LinkedList;

import Logica.Entidades.Entidad;
import Logica.Entidades.Jugador;
import Logica.Entidades.PremioTemporal;

public class FabricaPremioTemporal implements Fabrica{

private LinkedList<Entidad> lista;
	public FabricaPremioTemporal(LinkedList<Entidad> lista) {
		this.lista = lista;
	}
	
	@Override
	public Entidad crear() {
		PremioTemporal d = new PremioTemporal();
		lista.addLast(d);
		return d;
	}

}
