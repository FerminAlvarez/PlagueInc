package Logica.Entidades.EntidadesGraficas;

import java.awt.Rectangle;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class JugadorGrafica extends EntidadGrafica{

	protected int alto = 50, ancho = 50, puntoDisparoX = 30, puntoDisparoY = -30;
	
	public JugadorGrafica() {
		miColision = new Rectangle(-500, 0, ancho - 10, alto - 30);
		InputStream in = JugadorGrafica.class.getClassLoader().getResourceAsStream("imagenes/Entidades/jugador.png");
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
		miColision.setLocation(x + 10, y + 30);
	}
}
