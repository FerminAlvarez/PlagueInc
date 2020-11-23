package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.PremioPermanenteGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Estrategias.MovimientoVertical;

public class PremioPermanente extends Premio {

	private int indicePremio;

	public PremioPermanente(int indicePremio) {
		super();
		this.indicePremio = indicePremio;
		miEntidadGrafica = new PremioPermanenteGrafica(0, 0, indicePremio);
		miEstrategiaMovimiento = new MovimientoVertical(obtenerVelocidad(), 0, 1, this);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

	public static int getCantidadBeneficios() {
		return 2;
	}

	// PARA PROBAR.
	private int obtenerVelocidad() {
		int velocidad = 0;
		switch (indicePremio) {
		case 0: {
			velocidad = 2;
			break;
		}
		case 1: {
			velocidad = 5;
			break;
		}
		}
		return velocidad;
	}

	@Override
	public void establecerBeneficio(Jugador jugador) {
		switch (indicePremio) {
			case 0: {
				jugador.setHP(100);
				System.out.println("Se estableció el beneficio de HP");
				break;
			}
			case 1: {
				jugador.getMovimiento().setVelocidad(3);
				System.out.println("se estableció el beneficio de velocidad");
				break;
			}
		}
		destruir();
	}
	

}
