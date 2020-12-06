package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.EsporaGrafica;

import Logica.Entidades.Visitors.Visitor;
import Logica.Entidades.Visitors.VisitorEspora;
import Logica.Estrategias.MovimientoProyectil;

public class Espora extends Proyectil{

	public Espora() {
		miVisitor = new VisitorEspora(this);
		miEntidadGrafica = new EsporaGrafica();
		miEstrategiaMovimiento = new MovimientoProyectil(3, 0, 1, this);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

}
