package Logica.Entidades.EntidadesGraficas;

import java.awt.Rectangle;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class BetaGrafica extends EntidadGrafica{

	protected int alto = 70, ancho = 70, puntoDisparoX = 25, puntoDisparoY = 30;
	public BetaGrafica() {
		miColision = new Rectangle(-200, 0, ancho, alto);
		// TODO Auto-generated constructor stub
		InputStream in = BetaGrafica.class.getClassLoader().getResourceAsStream("imagenes/Entidades/Infectado2.png");
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
			in = AudioSystem.getAudioInputStream(BetaGrafica.class.getClassLoader().getResourceAsStream("audios/" + nombre));
			Clip clip = AudioSystem.getClip();
			clip.open(in);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
