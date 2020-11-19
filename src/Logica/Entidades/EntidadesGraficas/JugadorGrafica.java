package Logica.Entidades.EntidadesGraficas;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class JugadorGrafica extends EntidadGrafica{

	public JugadorGrafica(int x, int y) {
		super(x, y);
		// TODO Auto-generated constructor stub
		InputStream in = JugadorGrafica.class.getClassLoader().getResourceAsStream("imagenes/Entidades/jugador.png");
		try {
			imagen = ImageIO.read(in).getScaledInstance(50, 50,  java.awt.Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		getImageDimensions();
	}

}
