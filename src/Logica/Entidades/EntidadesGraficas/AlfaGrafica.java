package Logica.Entidades.EntidadesGraficas;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class AlfaGrafica extends EntidadGrafica{

	protected int alto = 50, ancho = 50;
	public AlfaGrafica(int x, int y) {
		super(x, y);
		miColision.setBounds(x, y, alto, ancho);
		// TODO Auto-generated constructor stub
		InputStream in = JugadorGrafica.class.getClassLoader().getResourceAsStream("imagenes/Entidades/Infectado1.png");
		try {
			imagen = ImageIO.read(in).getScaledInstance(ancho, alto,  java.awt.Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		getImageDimensions();
	}

}
