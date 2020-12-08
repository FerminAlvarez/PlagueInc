package Logica.Entidades.EntidadesGraficas;

import java.awt.Rectangle;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PremioSuperArmaGrafica extends EntidadGrafica {

	protected int alto = 50, ancho = 50;

	public PremioSuperArmaGrafica() {
		miColision = new Rectangle(-700, 0, ancho, alto);
		InputStream in = PremioSuperArmaGrafica.class.getClassLoader()
				.getResourceAsStream("imagenes/Entidades/PremioSuperArma.png");
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
	
	@Override
	//Codigo sacado de https://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java, mejor respuesta
	public void playSound(String s) {
		AudioInputStream in;
		String nombre = "";
		switch (s) {
		case "Agarrado":
			nombre = "PremioAgarrado.wav";
			break;
		}
		try {
			in = AudioSystem
					.getAudioInputStream(PremioSuperArmaGrafica.class.getClassLoader().getResource("audios/" + nombre));
			Clip clip = AudioSystem.getClip();
			clip.open(in);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}