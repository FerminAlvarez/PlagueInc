package Logica.Entidades.Fabricas;

import Logica.Entidades.Beta;
import Logica.Entidades.Entidad;

public class FabricaBeta implements Fabrica{
	
	public FabricaBeta() {
		
	}
	
	@Override
	public Entidad crear() {
		Beta beta = new Beta(50, 30);
		return beta;
	}
}
