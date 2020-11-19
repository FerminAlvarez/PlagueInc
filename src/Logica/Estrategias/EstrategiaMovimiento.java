package Logica.Estrategias;

import Logica.Entidades.EntidadesGraficas.EntidadGrafica;

public abstract class EstrategiaMovimiento {

	protected int velocidad, direccionX, direccionY;
	protected EntidadGrafica miEntidadGrafica;
	
	protected EstrategiaMovimiento(int velocidad, int direccionX, int direccionY, EntidadGrafica miEntidadGrafica) {
		this.velocidad = velocidad;
		this.direccionX = direccionX;
		this.direccionY = direccionY;
		this.miEntidadGrafica = miEntidadGrafica;
	}
	
	public void mover() {
		//int nuevoX = miEntidadGrafica.getPosicionX() + direccionX * velocidad;
		//TODO Agregar checkeo de si se sale del mapa
		miEntidadGrafica.setPosicion(miEntidadGrafica.getPosicionX() + direccionX * velocidad,miEntidadGrafica.getPosicionY() + direccionY * velocidad);
		if(miEntidadGrafica.getPosicionX() < 0 || miEntidadGrafica.getPosicionX() > 400)
			salirsePorX();
		if(miEntidadGrafica.getPosicionY() < 0 || miEntidadGrafica.getPosicionY() > 300)
			salirsePorY();
	}

	public void setVelocidad(int v) {
		velocidad = v;
	}
	
	protected abstract void salirsePorX();
	protected abstract void salirsePorY();
	
}