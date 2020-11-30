package Logica.Niveles;

import java.util.LinkedList;

import Logica.logica;
import Logica.Entidades.Fabricas.Fabrica;
import Logica.Entidades.Fabricas.FabricaAlfa;
import Logica.Entidades.Fabricas.FabricaBeta;

public class Nivel1 extends EstadoNivel{
	

	private String fondo = "imagenes/Niveles/Fondo1.png";
	
	public Nivel1(logica juego) {
		this.juego = juego;
		infectados = new LinkedList<Integer>();
		fabricas = new LinkedList<Fabrica>();
		fabricas.add(new FabricaAlfa(juego));
		fabricas.add(new FabricaBeta(juego));
		infectados.add(3);
		infectados.add(5);
		totalInfectados = 8;
		infectadosRestantes = 8;
		delay = 120;
	}
	
	public String getFondo() {
		return fondo;
	}

	
	
	@Override
	protected void empezar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public EstadoNivel siguienteNivel() {
		return (new Nivel2(juego));
	}

	
}
