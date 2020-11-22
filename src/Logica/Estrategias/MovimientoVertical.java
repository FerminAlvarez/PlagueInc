package Logica.Estrategias;

import Logica.Entidades.Entidad;
import Logica.Entidades.EntidadesGraficas.EntidadGrafica;

public class MovimientoVertical extends EstrategiaMovimiento{

	public MovimientoVertical(int velocidad, int direccionX, int direccionY, Entidad miEntidad) {
		super(velocidad, direccionX, direccionY, miEntidad);
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void salirsePorX() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void salirsePorY() {
		miEntidad.getGrafica().setPosicion(miEntidad.getGrafica().getPosicionX(), -60); //TODO que use la parte más alta de la zona de juego
		
	}
	
	

}
