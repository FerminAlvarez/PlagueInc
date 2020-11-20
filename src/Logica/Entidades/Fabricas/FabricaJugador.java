package Logica.Entidades.Fabricas;

import Logica.Entidades.Entidad;
import Logica.Entidades.Jugador;

public class FabricaJugador implements Fabrica{

	@Override
	public Entidad crear() {
			return new Jugador(0, 0);
	}
}
