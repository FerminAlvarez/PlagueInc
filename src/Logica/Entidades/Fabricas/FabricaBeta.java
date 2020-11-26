package Logica.Entidades.Fabricas;

import Logica.logica;
import Logica.Entidades.Beta;
import Logica.Entidades.Entidad;

public class FabricaBeta implements Fabrica{
	
	public FabricaBeta(logica juego) {
		
	}
	
	@Override
	public Entidad crear() {
		Beta beta = new Beta(3, 3);
		return beta;
	}
}
