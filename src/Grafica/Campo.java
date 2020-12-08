package Grafica;

import java.awt.Graphics;

import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

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
			Entidad entidad;
			Iterator<Entidad> it = juego.obtenerEntidades().iterator();
			while(it.hasNext()) {
				entidad = it.next();
				EntidadGrafica e = entidad.obtenerGrafica();
				g.drawImage(e.obtenerImagen(), e.obtenerPosicionX(), e.obtenerPosicionY(), this);
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		//repaint();
	}
	
	public void establecerFondo(String direccionFondo) {
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
