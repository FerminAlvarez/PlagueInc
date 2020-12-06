package Logica.Estrategias;

import Logica.Entidades.Entidad;

public class MovimientoProyectil extends EstrategiaMovimiento{
	
	public MovimientoProyectil(int velocidad, int direccionX, int direccionY, Entidad miEntidad) {
		super(velocidad, direccionX, direccionY, miEntidad);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void salirsePorY() {
		miEntidad.destruir();
	}

	@Override
	protected void salirsePorXIzq() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void salirsePorXDer() {
		// TODO Auto-generated method stub
		
	}

	

}
