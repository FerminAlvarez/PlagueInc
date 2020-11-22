package Grafica;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import Logica.logica;
import Logica.Entidades.Entidad;
import Logica.Entidades.EntidadesGraficas.EntidadGrafica;

public class Campo extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private logica juego;
	private Image fondo;
	
	public Campo(logica juego) {
		this.juego = juego;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);		
		if (fondo != null) {
			g.drawImage(fondo, 0, 0, getSize().width, getSize().height, null);
		}
		drawObjects(g);
		Toolkit.getDefaultToolkit().sync();
		repaint();
	}
	
	private void drawObjects(Graphics g) {
		if(juego.enCurso()) {
			LinkedList<Entidad> elementos = juego.getEntidades();
			for(Entidad entidad : elementos) {
				EntidadGrafica e = entidad.getGrafica();
				g.drawImage(e.getImagen(), e.getPosicionX(), e.getPosicionY(), this);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		repaint();
	}
	
	public void establecerFondo(String direccionFondo) {
		System.out.println("Intento colocar fondo");
		InputStream in = GUI.class.getClassLoader().getResourceAsStream(direccionFondo);
		ImageIcon imagen;
		try {
			imagen = new ImageIcon(ImageIO.read(in));
			setOpaque(false);
			fondo = imagen.getImage().getScaledInstance(getSize().width, getSize().height,  java.awt.Image.SCALE_SMOOTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
