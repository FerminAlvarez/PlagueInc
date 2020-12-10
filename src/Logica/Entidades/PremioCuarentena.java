package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.PremioCuarentenaGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Entidades.Visitors.VisitorPremioCuarentena;
import Logica.Entidades.Visitors.VisitorPremioCuarentenaInfectados;
import Logica.Estrategias.MovimientoPremio;

public class PremioCuarentena extends PremioTemporal {
	
	public PremioCuarentena () {
		miVisitor = new VisitorPremioCuarentena(this);
		miEntidadGrafica = new PremioCuarentenaGrafica();
		miEstrategiaMovimiento = new MovimientoPremio(3, 0, 1, this);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

	@Override
	public void establecerBeneficio() {
		VisitorPremioCuarentenaInfectados vis = new VisitorPremioCuarentenaInfectados();
		for (Entidad entidad : juego.obtenerEntidades()) {
			entidad.aceptar(vis);
		}
		destruir();
	}

	

}
