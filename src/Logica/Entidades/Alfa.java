package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.AlfaGrafica;
import Logica.Entidades.Fabricas.Fabrica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Estrategias.MovimientoVertical;

public class Alfa extends Infectado {

	public Alfa(int hp, int dano, Fabrica miFabrica) {
		super(hp, dano, miFabrica);
		miEntidadGrafica = new AlfaGrafica(10, 10);
		miEstrategiaMovimiento = new MovimientoVertical(1, 0, 1, miEntidadGrafica);
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void renovarDisparo() {
		// TODO Auto-generated method stub
		
	}

}
