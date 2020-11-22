package Logica.Estrategias;

import Logica.Entidades.Entidad;
import Logica.Entidades.EntidadesGraficas.EntidadGrafica;

public abstract class EstrategiaMovimiento {

	protected int velocidad, direccionX, direccionY;
	protected Entidad miEntidad;

	protected EstrategiaMovimiento(int velocidad, int direccionX, int direccionY, Entidad miEntidad) {
		this.velocidad = velocidad;
		this.direccionX = direccionX;
		this.direccionY = direccionY;
		this.miEntidad = miEntidad;
	}

	public void mover() {
		// int nuevoX = miEntidadGrafica.getPosicionX() + direccionX * velocidad;
		// TODO Agregar checkeo de si se sale del mapa
		EntidadGrafica miEntidadGrafica = miEntidad.getGrafica();
		miEntidadGrafica.setPosicion(miEntidadGrafica.getPosicionX() + direccionX * velocidad,
				miEntidadGrafica.getPosicionY() + direccionY * velocidad);
		if (miEntidadGrafica.getPosicionX() < 0 || miEntidadGrafica.getPosicionX() > 400)
			salirsePorX();
		if (miEntidadGrafica.getPosicionY() < -100 || miEntidadGrafica.getPosicionY() > 400)
			salirsePorY();
	}

	public void setDireccionX(int x) {
		direccionX = x;
	}

	public void setDireccionY(int y) {
		direccionY = y;
	}

	public void setVelocidad(int v) {
		velocidad = v;
	}

	protected abstract void salirsePorX();

	protected abstract void salirsePorY();

}
