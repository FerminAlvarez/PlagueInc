package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.BetaGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Estrategias.MovimientoVertical;

public class Beta extends Infectado{

	public Beta(int hp, int dano) {
		super(hp, dano);
		miEntidadGrafica = new BetaGrafica(10, 10);
		miEstrategiaMovimiento = new MovimientoVertical(1, 0, 1, this);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

	@Override
	protected void renovarDisparo() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void golpeado() {
		// TODO Auto-generated method stub
		
	}

}
