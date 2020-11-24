package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.PremioVidaGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Estrategias.MovimientoVertical;

public class PremioVida extends PremioPermanente{
	public PremioVida() {
		super();
		miEntidadGrafica = new PremioVidaGrafica(0,0);
		miEstrategiaMovimiento = new MovimientoVertical(5, 0, 1, this);
	}

	public void aceptar (Visitor v) {
		v.visitar(this);
	}
	
	@Override
	public void establecerBeneficio(Jugador jugador) {
		jugador.setHP(100);
		System.out.println("Se estableció el beneficio de HP");
		destruir();
	}

}
