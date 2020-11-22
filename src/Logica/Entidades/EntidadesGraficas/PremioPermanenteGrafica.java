package Logica.Entidades.EntidadesGraficas;

import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class PremioPermanenteGrafica extends EntidadGrafica{

protected int alto = 20, ancho = 20;
	
	String[] imagenes = {"PremioVida.png","PremioVelocidad.png"};
	public PremioPermanenteGrafica(int x, int y, int indicePremio) {
		super(x, y);
		InputStream in = JugadorGrafica.class.getClassLoader().getResourceAsStream("imagenes/Entidades/"+imagenes[indicePremio]);
		try {
			imagen = ImageIO.read(in).getScaledInstance(ancho, alto,  java.awt.Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
		getImageDimensions();
	}

}
