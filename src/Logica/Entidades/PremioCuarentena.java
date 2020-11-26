package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.PremioCuarentenaGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Entidades.Visitors.VisitorPremioCuarentena;
import Logica.Estrategias.MovimientoVertical;

public class PremioCuarentena extends PremioTemporal {
	
	public PremioCuarentena () {
		miVisitor = new VisitorPremioCuarentena(this);
		miEntidadGrafica = new PremioCuarentenaGrafica(0, 0);
		miEstrategiaMovimiento = new MovimientoVertical(3, 0, 1, this);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

}
