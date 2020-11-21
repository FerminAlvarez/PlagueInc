package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.AlfaGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Estrategias.MovimientoVertical;

public class Alfa extends Infectado{

	public Alfa(int hp, int dano) {
		super(hp, dano);
		miEntidadGrafica = new AlfaGrafica(10, 10);
		miEstrategiaMovimiento = new MovimientoVertical(1,0,5,miEntidadGrafica);
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
