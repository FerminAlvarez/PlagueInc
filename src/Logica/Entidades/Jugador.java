package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.JugadorGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Estrategias.EstrategiaDisparo;
import Logica.Estrategias.MovimientoJugador;

public class Jugador extends Personaje{
	
	public Jugador(int hp, int dano) {
		super(hp, dano);
		miEntidadGrafica = new JugadorGrafica(300, 300);
		miEstrategiaMovimiento = new MovimientoJugador(1, 1, 0, miEntidadGrafica);
		// TODO Auto-generated constructor stub
	}

	public void mover() {
		
	}
	
	public void mover(String cmd) {
		switch (cmd){
			case "LeftArrow" : {
	            System.out.println("Izquierda");
				miEstrategiaMovimiento.mover();
				break;
			}
			case "RightArrow" : {
	            System.out.println("Derecha");
				
				break;
			}
		}
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
