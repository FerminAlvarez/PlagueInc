package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.PremioTemporalGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Estrategias.MovimientoVertical;

public class PremioTemporal extends Premio{
	public PremioTemporal() {
		super();
		miEntidadGrafica = new PremioTemporalGrafica(0, 0);
		miEstrategiaMovimiento = new MovimientoVertical(3, 0, 1, this);
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	void establecerBeneficio() {
		
	}

	
}
