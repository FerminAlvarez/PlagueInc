package Logica.Estrategias;

import Logica.Entidades.Entidad;
import Logica.Entidades.EntidadesGraficas.EntidadGrafica;

public abstract class EstrategiaMovimiento {

	protected int velocidad, direccionX, direccionY;
	protected Entidad miEntidad;
	protected int velocidadInicial;

	protected EstrategiaMovimiento(int velocidad, int direccionX, int direccionY, Entidad miEntidad) {
		this.velocidad = velocidad;
		this.direccionX = direccionX;
		this.direccionY = direccionY;
		this.miEntidad = miEntidad;
		this.velocidadInicial = velocidad;
	}

	public void mover() {
		// int nuevoX = miEntidadGrafica.obtenerPosicionX() + direccionX * velocidad;
		// TODO Agregar checkeo de si se sale del mapa
		EntidadGrafica miEntidadGrafica = miEntidad.obtenerGrafica();
		miEntidadGrafica.establecerPosicion(miEntidadGrafica.obtenerPosicionX() + direccionX * velocidad,
				miEntidadGrafica.obtenerPosicionY() + direccionY * velocidad);
		if (miEntidadGrafica.obtenerPosicionX() < 0 || miEntidadGrafica.obtenerPosicionX() > 400)
			salirsePorX();
		if (miEntidadGrafica.obtenerPosicionY() < -100 || miEntidadGrafica.obtenerPosicionY() > 400)
			salirsePorY();
	}

	public void establecerDireccionX(int x) {
		direccionX = x;
	}

	public void establecerDireccionY(int y) {
		direccionY = y;
	}

	public void establecerVelocidad(int v) {
		velocidad = v;
	}
	
	public int obtenerVelocidad() {
		return velocidad;
	}
	public int obtenerVelocidadInicial() {
		return velocidad;
	}
	protected abstract void salirsePorX();

	protected abstract void salirsePorY();

}
