package Logica.Estrategias;

import Logica.Entidades.Entidad;
import Logica.Entidades.EntidadesGraficas.EntidadGrafica;

public class MovimientoProyectil extends EstrategiaMovimiento{
	
	public MovimientoProyectil(int velocidad, int direccionX, int direccionY, Entidad miEntidad) {
		super(velocidad, direccionX, direccionY, miEntidad);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void salirsePorX() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void salirsePorY() {
		miEntidad.destruir();
	}

	

}
