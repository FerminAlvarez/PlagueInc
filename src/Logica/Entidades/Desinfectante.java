package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.DesinfectanteGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Estrategias.MovimientoVertical;

public class Desinfectante extends Proyectil{
	
	public Desinfectante(int dano) {
		super(dano);
		miEntidadGrafica = new DesinfectanteGrafica(0, 0);
		miEstrategiaMovimiento = new MovimientoVertical(3, 0, 1, miEntidadGrafica);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

}
