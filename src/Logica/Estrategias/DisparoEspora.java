package Logica.Estrategias;

import Logica.Entidades.Espora;
import Logica.Entidades.EntidadesGraficas.EntidadGrafica;
import Logica.Entidades.Fabricas.Fabrica;

public class DisparoEspora extends EstrategiaDisparo{

	public DisparoEspora(int dano, int velocidad, Fabrica miFabrica, EntidadGrafica miEntidadGrafica) {
		super(dano, velocidad, miFabrica, miEntidadGrafica);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void disparar() {
		Espora proy = (Espora) miFabrica.crear();
		proy.establecerLogica(juego);
		proy.obtenerMovimiento().establecerVelocidad(velocidad);
		proy.establecerDano(dano);
		proy.obtenerGrafica().establecerPosicion(miEntidadGrafica.obtenerPosicionX(), miEntidadGrafica.obtenerPosicionY());
		
	}

}
