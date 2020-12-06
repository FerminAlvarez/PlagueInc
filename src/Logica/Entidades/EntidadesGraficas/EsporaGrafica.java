package Logica.Entidades.EntidadesGraficas;

import java.awt.Rectangle;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class EsporaGrafica extends EntidadGrafica{

protected int alto = 20, ancho = 20;
	
	public EsporaGrafica() {
		miColision = new Rectangle(-400, 0, ancho, alto);
		InputStream in = JugadorGrafica.class.getClassLoader().getResourceAsStream("imagenes/Entidades/Espora.png");
		try {
			imagen = ImageIO.read(in).getScaledInstance(ancho, alto,  java.awt.Image.SCALE_SMOOTH);
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
