package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.PremioVelocidadGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Entidades.Visitors.VisitorPremioVelocidad;
import Logica.Estrategias.MovimientoPremio;

public class PremioVelocidad extends PremioPermanente{
	
	public PremioVelocidad () {
		miVisitor = new VisitorPremioVelocidad(this);
		miEntidadGrafica = new PremioVelocidadGrafica();
		miEstrategiaMovimiento = new MovimientoPremio(5, 0, 1, this);
	}
	public void aceptar (Visitor v) {
		v.visitar(this);
	}
}