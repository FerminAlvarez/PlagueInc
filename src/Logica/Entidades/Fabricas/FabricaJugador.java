package Logica.Entidades.Fabricas;

import Logica.Entidades.Entidad;
import Logica.Entidades.Jugador;

public class FabricaJugador implements Fabrica{

	public Entidad crear() {
		return new Jugador();
	}

}
