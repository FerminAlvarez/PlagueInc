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
		miEstrategiaMovimiento = new MovimientoHorizontal(1, 1, 0, miEntidadGrafica);
		// TODO Auto-generated constructor stub
	}

	public void mover() {
		//TODO Cuando ande el mover() para todos, borrar el método
	}
	
	public void mover(String estado, String cmd) {
		if(cmd == "RightArrow") {
			dirX = estado == "Press" ? 1 : 0;
		}
		if(cmd == "LeftArrow") {
			dirX = estado == "Press" ? -1 : 0;
		}
		miEstrategiaMovimiento.setDireccionX(dirX);
		//TODO Cuando ande el mover() para todos, borrar lo siguiente
		miEstrategiaMovimiento.mover();
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
