package Logica.Estrategias;

import Logica.Entidades.EntidadesGraficas.EntidadGrafica;

public abstract class EstrategiaMovimiento {

	protected int velocidad, direccionX, direccionY;
	protected EntidadGrafica miEntidadGrafica;
	
	public void mover() {
		//miEntidadGrafica.cambiarPosicion();
		//if(miEntidadGrafica.getPosicionX() )
	}

	protected abstract void salirsePorX();
	protected abstract void salirsePorY();
	
}
