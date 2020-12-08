package Logica.Entidades.EntidadesGraficas;

import java.awt.Rectangle;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class JugadorGrafica extends EntidadGrafica{

	protected int alto = 50, ancho = 50, puntoDisparoX = 30, puntoDisparoY = -30;
	
	public JugadorGrafica() {
		miColision = new Rectangle(-500, 0, ancho - 10, alto - 30);
		InputStream in = JugadorGrafica.class.getClassLoader().getResourceAsStream("imagenes/Entidades/jugador.png");
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
		miColision.setLocation(x + 10, y + 30);
	}
	
	@Override
	//Codigo sacado de https://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java, mejor respuesta
	public void playSound(String s) {
		AudioInputStream in;
		String nombre = "";
		switch (s) {
		case "Disparo":
			nombre = "JugadorDisparo.wav";
			break;
		case "Golpeado":
			nombre = "JugadorGolpeado.wav";
			break;
		}
		try {
			in = AudioSystem.getAudioInputStream(JugadorGrafica.class.getClassLoader().getResource("audios/" + nombre));
			Clip clip = AudioSystem.getClip();
			clip.open(in);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
