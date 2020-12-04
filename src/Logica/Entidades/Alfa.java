package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.AlfaGrafica;

import Logica.Entidades.Visitors.Visitor;
import Logica.Estrategias.DisparoEspora;
import Logica.Estrategias.MovimientoVertical;

public class Alfa extends Infectado {

	protected final int velocidadDisparo = 3;
	protected final int maxGracePeriod = 15;
	
	public Alfa() {
		super(30, 10);
		miEntidadGrafica = new AlfaGrafica(10, 10);
		miEstrategiaMovimiento = new MovimientoVertical(1, 0, 1, this);
		miEstrategiaDisparo = new DisparoEspora(dano, velocidadDisparo, miFabrica, miEntidadGrafica);
		
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

	@Override
	protected void renovarDisparo() {
		miEstrategiaDisparo = new DisparoEspora(dano, velocidadDisparo, miFabrica, miEntidadGrafica);
	}

	@Override
	protected void golpeado() {
		gracePeriod = maxGracePeriod;
		System.out.println("ZOMBIE ALFA HP" + hp);
	}

}
