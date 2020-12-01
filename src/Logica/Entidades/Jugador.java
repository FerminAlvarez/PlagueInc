package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.JugadorGrafica;
import Logica.Entidades.Fabricas.FabricaDesinfectante;
import Logica.Entidades.Visitors.Visitor;
import Logica.Entidades.Visitors.VisitorJugador;
import Logica.Estrategias.DisparoNormal;
import Logica.Estrategias.EstrategiaDisparo;
import Logica.Estrategias.MovimientoHorizontal;

public class Jugador extends Personaje{
	
	private int dirX;
	private final int velocidadDisparo = -5;
	private final int velocidad = 5;
	private final int maxGracePeriod = 60;
	
	public Jugador(int hp, int dano) {
		super(hp, dano);
		miFabrica = new FabricaDesinfectante();
		miEntidadGrafica = new JugadorGrafica(300, 300);
		miEstrategiaMovimiento = new MovimientoHorizontal(1, 0, 0, this);
		miEstrategiaDisparo = new DisparoNormal(dano, velocidadDisparo, miFabrica, miEntidadGrafica);
		miVisitor = new VisitorJugador(this);
		dirX = 0;
	}

	
	public void accion(String estado, String cmd) {
		if(cmd == "RightArrow") {
			if(estado == "Press")
				dirX = velocidad;
			else
				dirX = dirX == velocidad ? 0 : dirX;
		}
		if(cmd == "LeftArrow") {
			if(estado == "Press")
				dirX = -velocidad;
			else
				dirX = dirX == -velocidad ? 0 : dirX;
		}
		if(cmd == "Fire")
			miEstrategiaDisparo.disparar();
		miEstrategiaMovimiento.establecerDireccionX(dirX);
	}
	
	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

	@Override
	public void establecerAtaque(EstrategiaDisparo e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	protected void renovarDisparo() {
		miEstrategiaDisparo = new DisparoNormal(dano, velocidadDisparo, miFabrica, miEntidadGrafica);
		
	}


	@Override
	protected void golpeado() {
		gracePeriod = maxGracePeriod;
		System.out.println("JUGADOR HP" + hp);
	}

}
