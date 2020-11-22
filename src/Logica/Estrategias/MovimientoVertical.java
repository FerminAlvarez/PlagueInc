package Logica.Estrategias;

import Logica.Entidades.EntidadesGraficas.EntidadGrafica;

public class MovimientoVertical extends EstrategiaMovimiento{

	public MovimientoVertical(int velocidad, int direccionX, int direccionY, EntidadGrafica miEntidadGrafica) {
		super(velocidad, direccionX, direccionY, miEntidadGrafica);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void salirsePorX() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void salirsePorY() {
		miEntidadGrafica.setPosicion(miEntidadGrafica.getPosicionX(), -60); //TODO que use la parte más alta de la zona de juego
		
	}

}
