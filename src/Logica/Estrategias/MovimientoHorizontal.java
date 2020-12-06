package Logica.Estrategias;

import Logica.Entidades.Entidad;

public class MovimientoHorizontal extends EstrategiaMovimiento{


	public MovimientoHorizontal(int velocidad, int direccionX, int direccionY, Entidad miEntidad) {
		super(velocidad, direccionX, direccionY, miEntidad);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void salirsePorY() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void salirsePorXIzq() {
		miEntidad.establecerPosicion(miEntidad.obtenerPosicionX() + velocidad, miEntidad.obtenerPosicionY());
	}

	@Override
	protected void salirsePorXDer() {
		miEntidad.establecerPosicion(miEntidad.obtenerPosicionX() - velocidad, miEntidad.obtenerPosicionY());
		
	}

}
