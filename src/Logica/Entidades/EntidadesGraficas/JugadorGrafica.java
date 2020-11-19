package Logica.Entidades.EntidadesGraficas;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class JugadorGrafica extends EntidadGrafica{

	protected int alto = 50, ancho = 50;
	
	public JugadorGrafica(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		InputStream in = JugadorGrafica.class.getClassLoader().getResourceAsStream("imagenes/Entidades/jugador.png");
		try {
			imagen = ImageIO.read(in).getScaledInstance(ancho, alto,  java.awt.Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		getImageDimensions();
	}

}
