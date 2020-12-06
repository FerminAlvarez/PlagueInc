package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.DesinfectanteGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Entidades.Visitors.VisitorDesinfectante;
import Logica.Estrategias.MovimientoVertical;

public class Desinfectante extends Proyectil{
	
	public Desinfectante() {
		miVisitor = new VisitorDesinfectante(this);
		miEntidadGrafica = new DesinfectanteGrafica();
		miEstrategiaMovimiento = new MovimientoVertical(3, 0, 1, this);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

}
