package Logica.Niveles;

import java.util.LinkedList;

import Logica.logica;
import Logica.Entidades.Entidad;
import Logica.Entidades.Fabricas.Fabrica;
import Logica.Entidades.Fabricas.FabricaAlfa;
import Logica.Entidades.Fabricas.FabricaBeta;
import Logica.Entidades.Fabricas.FabricaCuarentena;
import Logica.Entidades.Fabricas.FabricaSuperArma;
import Logica.Entidades.Fabricas.FabricaVelocidad;
import Logica.Entidades.Fabricas.FabricaVida;

public class Nivel1 extends EstadoNivel{
	

	private String fondo = "imagenes/Niveles/Fondo1.png";
	
	public Nivel1(logica juego) {
		this.juego = juego;
		fabricasEntidades = new LinkedList<Fabrica>();
		misPremios = new LinkedList<Fabrica>();
		cantidad = new LinkedList<Integer>();
		misEntidades = new LinkedList<Entidad>();
		fabricasEntidades.add(new FabricaAlfa());
		cantidad.add(3);
		fabricasEntidades.add(new FabricaBeta());
		cantidad.add(2);
		delay = 120;
		probabilidadPremio = 200;
		misPremios.add(new FabricaCuarentena());
		misPremios.add(new FabricaSuperArma());
		misPremios.add(new FabricaVelocidad());
		misPremios.add(new FabricaVida());
	}
	
	public String obtenerFondo() {
		return fondo;
	}

	@Override
	public EstadoNivel siguienteNivel() {
		return (new Nivel2(juego));
	}

	@Override
	public int obtenerNumeroNivel() {
		return 1;
	}
	
}
