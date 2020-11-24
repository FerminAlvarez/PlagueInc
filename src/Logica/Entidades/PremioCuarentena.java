package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.PremioCuarentenaGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Estrategias.MovimientoVertical;

public class PremioCuarentena extends PremioTemporal {
	
	public PremioCuarentena () {
		super();
		miEntidadGrafica = new PremioCuarentenaGrafica(0, 0);
		miEstrategiaMovimiento = new MovimientoVertical(3, 0, 1, this);
	}

	@Override
	public void establecerBeneficio(Jugador jugador) {
		
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

}
