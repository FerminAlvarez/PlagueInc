package Logica.Entidades.EntidadesGraficas;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class PremioVelocidadGrafica extends EntidadGrafica {

	protected int alto = 20, ancho = 20;

	public PremioVelocidadGrafica(int x, int y) {
		super(x, y);
		miColision.setBounds(x, y, alto, ancho);
		InputStream in = JugadorGrafica.class.getClassLoader()
				.getResourceAsStream("imagenes/Entidades/PremioVelocidad.png");
		try {
			imagen = ImageIO.read(in).getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		getImageDimensions();
	}

}
