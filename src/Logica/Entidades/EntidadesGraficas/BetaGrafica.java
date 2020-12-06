package Logica.Entidades.EntidadesGraficas;

import java.awt.Rectangle;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class BetaGrafica extends EntidadGrafica{

	protected int alto = 70, ancho = 70, puntoDisparoX = 25, puntoDisparoY = 30;
	public BetaGrafica() {
		miColision = new Rectangle(-200, 0, ancho, alto);
		// TODO Auto-generated constructor stub
		InputStream in = JugadorGrafica.class.getClassLoader().getResourceAsStream("imagenes/Entidades/Infectado2.png");
		try {
			imagen = ImageIO.read(in).getScaledInstance(ancho, alto,  java.awt.Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		getImageDimensions();
	}
	
	public int obtenerPuntoDisparoX() {
		return puntoDisparoX;
	}
	
	public int obtenerPuntoDisparoY() {
		return puntoDisparoY;
	}
	
	@Override
	protected void actualizarBounds() {
		miColision.setLocation(x, y);
	}
}
