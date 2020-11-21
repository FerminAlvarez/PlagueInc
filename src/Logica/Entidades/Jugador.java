package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.JugadorGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Estrategias.EstrategiaDisparo;
import Logica.Estrategias.MovimientoHorizontal;

public class Jugador extends Personaje{
	
	private int dirX;
	
	public Jugador(int hp, int dano) {
		super(hp, dano);
		miEntidadGrafica = new JugadorGrafica(300, 300);
		miEstrategiaMovimiento = new MovimientoHorizontal(1, 0, 0, miEntidadGrafica);
		dirX = 0;
		// TODO Auto-generated constructor stub
	}

	
	public void accion(String estado, String cmd) {
		if(cmd == "RightArrow") {
			dirX = estado == "Press" ? 5 : 0;
		}
		if(cmd == "LeftArrow") {
			dirX = estado == "Press" ? -5 : 0;
		}
		miEstrategiaMovimiento.setDireccionX(dirX);
	}
	
	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setAtaque(EstrategiaDisparo e) {
		// TODO Auto-generated method stub
		
	}

}
