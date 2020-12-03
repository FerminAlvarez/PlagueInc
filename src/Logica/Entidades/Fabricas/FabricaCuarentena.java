package Logica.Entidades.Fabricas;

import Logica.Entidades.Entidad;
import Logica.Entidades.PremioCuarentena;

public class FabricaCuarentena implements Fabrica{

	public FabricaCuarentena() {

	}

	@Override
	public Entidad crear() {
		PremioCuarentena p = new PremioCuarentena();
		return p;
	}
}
