package Logica.Entidades.Fabricas;

import java.util.LinkedList;

import Logica.Entidades.Beta;
import Logica.Entidades.Entidad;

public class FabricaBeta implements Fabrica{
	
	public FabricaBeta() {
		
	}
	
	@Override
	public Entidad crear() {
		Beta alfa = new Beta(3, 3);
		return alfa;
	}
}
