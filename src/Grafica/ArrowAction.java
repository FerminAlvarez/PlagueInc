package Grafica;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import Logica.logica;

//Codigo sacado de https://stackoverflow.com/questions/15422488/java-keybindings
public class ArrowAction extends AbstractAction{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String cmd, estado;
	private logica juego;

    public ArrowAction(String estado, String cmd, logica juego) {
    	this.estado = estado;
        this.cmd = cmd;
        this.juego = juego;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (cmd.equalsIgnoreCase("LeftArrow") && estado.equalsIgnoreCase("Press")) {
            System.out.println("The left arrow was pressed!");
        } else if (cmd.equalsIgnoreCase("LeftArrow") && estado.equalsIgnoreCase("Release")) {
            System.out.println("The left arrow was released!");
        } else if (cmd.equalsIgnoreCase("RightArrow") && estado.equalsIgnoreCase("Press")) {
            System.out.println("The right arrow was pressed!");
        } else if (cmd.equalsIgnoreCase("RightArrow") && estado.equalsIgnoreCase("Release")) {
            System.out.println("The right arrow was released!");
        }
        juego.accionJugador(estado, cmd);
    }
    
    
    
}
