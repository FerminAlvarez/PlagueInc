package Logica.Entidades.EntidadesGraficas;

import java.awt.Rectangle;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class PremioCuarentenaGrafica extends EntidadGrafica {

	protected int alto = 50, ancho = 50;

	public PremioCuarentenaGrafica() {
		miColision = new Rectangle(-600, 0, ancho, alto);
		InputStream in = JugadorGrafica.class.getClassLoader()
				.getResourceAsStream("imagenes/Entidades/PremioCuarentena.png");
		try {
			imagen = ImageIO.read(in).getScaledInstance(ancho, alto, java.awt.Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		getImageDimensions();
	}

	@Override
	public int obtenerPuntoDisparoX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int obtenerPuntoDisparoY() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	@Override
	protected void actualizarBounds() {
		miColision.setLocation(x, y);
	}

}