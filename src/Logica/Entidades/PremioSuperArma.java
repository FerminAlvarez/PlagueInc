package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.PremioSuperArmaGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Entidades.Visitors.VisitorPremioSuperArma;
import Logica.Estrategias.MovimientoPremio;

public class PremioSuperArma extends PremioTemporal{
	
	public PremioSuperArma () {
		miVisitor = new VisitorPremioSuperArma(this);
		miEntidadGrafica = new PremioSuperArmaGrafica(0, 0);
		miEstrategiaMovimiento = new MovimientoPremio(3, 0, 1, this);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

	@Override
	public void establecerBeneficio() {
		// TODO Auto-generated method stub
		
	}

}
