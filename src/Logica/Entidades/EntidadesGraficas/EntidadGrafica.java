package Logica.Entidades.EntidadesGraficas;

import java.awt.Image;
import java.awt.Rectangle;

//Usado parte de http://zetcode.com/javagames/collision/
public abstract class EntidadGrafica {

	protected Image imagen;
	protected boolean visible;
	protected int x, y, ancho, alto;
	
	public void cambiarPosicion(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	public void cambiarImagen(String s) {
		//TODO
	}
	
	public int getPosicionX() {
		return x;
	}
	
	public int getPosicionY() {
		return y;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, ancho, alto);
	}
	
}
