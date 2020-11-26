package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.PremioVidaGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Entidades.Visitors.VisitorPremioVida;
import Logica.Estrategias.MovimientoVertical;

public class PremioVida extends PremioPermanente{
	public PremioVida() {
		miVisitor = new VisitorPremioVida(this);
		miEntidadGrafica = new PremioVidaGrafica(0,0);
		miEstrategiaMovimiento = new MovimientoVertical(5, 0, 1, this);
	}

	public void aceptar (Visitor v) {
		v.visitar(this);
	}

}
