package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.PremioCuarentenaGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Entidades.Visitors.VisitorPremio;
import Logica.Entidades.Visitors.VisitorPremioCuarentena;
import Logica.Estrategias.MovimientoVertical;

public class PremioCuarentena extends PremioTemporal {
	VisitorPremioCuarentena vis = new VisitorPremioCuarentena();
	public PremioCuarentena () {
		miVisitor = new VisitorPremio(this);
		miEntidadGrafica = new PremioCuarentenaGrafica(0, 0);
		miEstrategiaMovimiento = new MovimientoVertical(3, 0, 1, this);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

	@Override
	public void establecerBeneficio() {
		for (Entidad entidad : juego.obtenerEntidades()) {
			entidad.aceptar(vis);
		}
		destruido = true;
	}

	

}
