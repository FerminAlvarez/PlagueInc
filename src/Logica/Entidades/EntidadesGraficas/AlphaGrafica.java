package Logica.Entidades.EntidadesGraficas;

import java.awt.Rectangle;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AlphaGrafica extends EntidadGrafica{

	protected int alto = 50, ancho = 50, puntoDisparoX = 15, puntoDisparoY = 10;
	public AlphaGrafica() {
		miColision = new Rectangle(-100, 0, ancho, alto);
		// TODO Auto-generated constructor stub
		InputStream in = AlphaGrafica.class.getClassLoader().getResourceAsStream("imagenes/Entidades/Infectado1.png");
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
		miColision.setLocation(x, y);
	}

	@Override
	//Codigo sacado de https://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java, mejor respuesta
	public void playSound(String s) {
		AudioInputStream in;
		String nombre = "";
		switch (s) {
		case "Disparo" : nombre = "InfectadoDisparo.wav";
		case "Golpeado" : nombre = "InfectadoGolpeado.wav";
		}
		try {
			in = AudioSystem.getAudioInputStream(AlphaGrafica.class.getClassLoader().getResource("audios/" + nombre));
			Clip clip = AudioSystem.getClip();
			clip.open(in);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
