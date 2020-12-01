package Logica.Niveles;

import java.util.LinkedList;

import Logica.logica;
import Logica.Entidades.Fabricas.Fabrica;
import Logica.Entidades.Fabricas.FabricaAlfa;
import Logica.Entidades.Fabricas.FabricaBeta;

public class Nivel2 extends EstadoNivel{
	

	private String fondo = "imagenes/Niveles/Fondo2.png";
	
	public Nivel2(logica juego) {
		this.juego = juego;
		infectados = new LinkedList<Integer>();
		fabricas = new LinkedList<Fabrica>();
		fabricas.add(new FabricaAlfa());
		fabricas.add(new FabricaBeta());
		infectados.add(3);
		infectados.add(5);
		totalInfectados = 8;
		infectadosRestantes = 8;
		delay = 120;
		probabilidadPremioPermanente = 4;
		probabilidadPremioTemporal = 2;
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
		return (new Nivel3(juego));
	}

	@Override
	public int obtenerNumeroNivel() {
		return 2;
	}

	
}
