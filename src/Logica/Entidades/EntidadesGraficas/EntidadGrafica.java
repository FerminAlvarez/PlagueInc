package Logica.Entidades.EntidadesGraficas;

import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;

//Usado parte de http://zetcode.com/javagames/collision/
public abstract class EntidadGrafica {

	protected Image imagen;
	protected boolean visible;
	protected int x, y, ancho, alto;
	protected Rectangle miColision;
	
	protected EntidadGrafica(int x, int y) {
		this.x = x;
		this.y = y;
		miColision = new Rectangle(x, y, ancho, alto);
	}
	
	protected void getImageDimensions() {
		ancho = imagen.getWidth(null);
		alto = imagen.getHeight(null);
	}
	
	public void setPosicion(int x, int y) {
		this.x = x;
		this.y = y;
		miColision.setLocation(x, y);
	}
	
	public void cambiarImagen(String s) {
		ImageIcon ii = new ImageIcon(s);
        imagen = ii.getImage().getScaledInstance(ancho, alto,  java.awt.Image.SCALE_SMOOTH);
	}
	
	public Image getImagen() {
		return imagen;
	}
	
	public int getPosicionX() {
		return x;
	}
	
	public int getPosicionY() {
		return y;
	}
	
	public Rectangle getBounds() {
		return miColision;
	}
	
}
