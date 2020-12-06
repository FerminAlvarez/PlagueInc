package Logica.Estrategias;

import Logica.Entidades.Entidad;

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
		miEntidad.establecerPosicion(miEntidad.obtenerPosicionX() + direccionX * velocidad,
				miEntidad.obtenerPosicionY() + direccionY * velocidad);
		if (miEntidad.obtenerPosicionX() < 0)
			salirsePorXIzq();
		if(miEntidad.obtenerPosicionX() > 500)
			salirsePorXDer();
		if (miEntidad.obtenerPosicionY() < -100 || miEntidad.obtenerPosicionY() > 400)
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
	
	protected abstract void salirsePorXIzq();
	
	protected abstract void salirsePorXDer();

	protected abstract void salirsePorY();

}
