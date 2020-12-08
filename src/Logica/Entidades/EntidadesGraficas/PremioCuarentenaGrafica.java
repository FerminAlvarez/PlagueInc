package Logica.Entidades.EntidadesGraficas;

import java.awt.Rectangle;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class PremioCuarentenaGrafica extends EntidadGrafica {

	protected int alto = 50, ancho = 50;

	public PremioCuarentenaGrafica() {
		miColision = new Rectangle(-600, 0, ancho, alto);
		InputStream in = PremioCuarentenaGrafica.class.getClassLoader()
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
	
	@Override
	//Codigo sacado de https://stackoverflow.com/questions/26305/how-can-i-play-sound-in-java, mejor respuesta
	public void playSound(String s) {
		AudioInputStream in;
		String nombre = "";
		switch (s) {
		case "Agarrado" : nombre = "PremioAgarrado.wav";
		}
		try {
			in = AudioSystem.getAudioInputStream(PremioCuarentenaGrafica.class.getClassLoader().getResourceAsStream("audios/" + nombre));
			Clip clip = AudioSystem.getClip();
			clip.open(in);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}