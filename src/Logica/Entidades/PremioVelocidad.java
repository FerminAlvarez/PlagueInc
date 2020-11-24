package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.PremioVelocidadGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Estrategias.MovimientoVertical;

public class PremioVelocidad extends PremioPermanente{
	
	public PremioVelocidad () {
		super();
		miEntidadGrafica = new PremioVelocidadGrafica(0,0);
		miEstrategiaMovimiento = new MovimientoVertical(5, 0, 1, this);
	}
	public void aceptar (Visitor v) {
		v.visitar(this);
	}
	
	@Override
	public void establecerBeneficio(Jugador jugador) {
		jugador.getMovimiento().setVelocidad(4);
		System.out.println("Se estableció el beneficio de velociad");
		destruir();
	}
}
