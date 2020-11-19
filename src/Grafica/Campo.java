package Grafica;

import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;

import javax.swing.JPanel;

import Logica.logica;
import Logica.Entidades.Entidad;

public class Campo extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private logica juego;
	
	public Campo(logica juego) {
		this.juego = juego;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		drawObjects(g);
		Toolkit.getDefaultToolkit().sync();
	}
	
	private void drawObjects(Graphics g) {
		LinkedList<Entidad> elementos = logica.getEntidades();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
