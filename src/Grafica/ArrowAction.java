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
	private String cmd;
	private logica juego;

    public ArrowAction(String cmd, logica juego) {
        this.cmd = cmd;
        this.juego = juego;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (cmd.equalsIgnoreCase("LeftArrow")) {
            System.out.println("The left arrow was pressed!");
        } else if (cmd.equalsIgnoreCase("RightArrow")) {
            System.out.println("The right arrow was pressed!");
        } else if (cmd.equalsIgnoreCase("UpArrow")) {
            System.out.println("The up arrow was pressed!");
        } else if (cmd.equalsIgnoreCase("DownArrow")) {
            System.out.println("The down arrow was pressed!");
        }
        juego.moverJugador(cmd);
    }
}
