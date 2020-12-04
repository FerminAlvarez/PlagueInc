package Logica.Entidades.Fabricas;

import Logica.Entidades.Desinfectante;
import Logica.Entidades.Entidad;

public class FabricaDesinfectante implements Fabrica{
	
	public FabricaDesinfectante() {
		
	}
	
	@Override
	public Entidad crear() {
		Desinfectante d = new Desinfectante();
		return d;
	}
}
