package Grafica;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Logica.logica;

//Codigo sacado de https://stackoverflow.com/questions/15422488/java-keybindings
public class Action extends AbstractAction{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmd, estado;
	private logica juego;

    public Action(String estado, String cmd, logica juego) {
    	this.estado = estado;
        this.cmd = cmd;
        this.juego = juego;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        juego.accionJugador(estado, cmd);
    }
    
    
    
}
