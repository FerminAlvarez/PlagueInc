package Logica.Entidades.EntidadesGraficas;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class PremioCuarentenaGrafica extends EntidadGrafica {

	protected int alto = 50, ancho = 50;

	public PremioCuarentenaGrafica(int x, int y) {
		super(x, y);
		miColision.setBounds(x, y, alto, ancho);
		InputStream in = JugadorGrafica.class.getClassLoader()
				.getResourceAsStream("imagenes/Entidades/PremioCuarentena.png");
		try {
			imagen = ImageIO.read(in).getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		getImageDimensions();
	}

}