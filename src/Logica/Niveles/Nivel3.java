package Logica.Niveles;

import java.util.LinkedList;

import Logica.logica;
import Logica.Entidades.Fabricas.Fabrica;
import Logica.Entidades.Fabricas.FabricaAlfa;
import Logica.Entidades.Fabricas.FabricaBeta;

public class Nivel3 extends EstadoNivel{
	

	private String fondo = "imagenes/Niveles/Fondo3.png";
	
	public Nivel3(logica juego) {
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
		probabilidadPremioPermanente = 3;
		probabilidadPremioTemporal = 1;
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
		return (new Nivel1(juego));
	}

	@Override
	public int obtenerNumeroNivel() {
		return 3;
	}

	
}
