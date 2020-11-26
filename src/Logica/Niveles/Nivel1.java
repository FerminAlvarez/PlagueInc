package Logica.Niveles;

import java.util.LinkedList;
import java.util.List;

import Logica.logica;
import Logica.Entidades.Fabricas.Fabrica;
import Logica.Entidades.Fabricas.FabricaAlfa;
import Logica.Entidades.Fabricas.FabricaBeta;

public class Nivel1 extends EstadoNivel{
	

	private String fondo = "imagenes/Niveles/Fondo1.png";
	private final int infectados = 30;
	
	private List<Fabrica> fabricas;
	
	public Nivel1(logica juego) {
		fabricas = new LinkedList<Fabrica>();
		fabricas.add(new FabricaAlfa(juego));
		fabricas.add(new FabricaBeta(juego));
	}
	
	public String obtenerFondo() {
		return fondo;
	}

	@Override
	protected void empezar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EstadoNivel siguienteNivel() {
		return (new Nivel2());
	}
}
