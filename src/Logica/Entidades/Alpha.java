package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.AlphaGrafica;

import Logica.Entidades.Visitors.Visitor;
import Logica.Estrategias.DisparoEspora;
import Logica.Estrategias.MovimientoVertical;

public class Alpha extends Infectado {

	protected final int velocidadDisparo = 3;
	protected final int maxGracePeriod = 15;
	
	public Alpha() {
		super(30, 30);
		miEntidadGrafica = new AlphaGrafica();
		miEstrategiaMovimiento = new MovimientoVertical(1, 0, 1, this);
		miEstrategiaDisparo = new DisparoEspora(dano, velocidadDisparo, miFabrica, this);
		
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

	@Override
	protected void renovarDisparo() {
		miEstrategiaDisparo = new DisparoEspora(dano, velocidadDisparo, miFabrica, this);
	}

	@Override
	protected void golpeado() {
		super.golpeado();
		if(hp <= 10)
			establecerVelocidad(2);
		gracePeriod = maxGracePeriod;
	}

}
