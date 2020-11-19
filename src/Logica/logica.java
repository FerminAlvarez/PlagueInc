package Logica;

import Grafica.GUI;
import Logica.Niveles.EstadoNivel;
import Logica.Niveles.Nivel1;

public class logica {
	private  GUI gui;
	
	public logica (GUI gui) {
		this.gui = gui;
	}
	
	public void iniciar() {
		EstadoNivel nivel = new Nivel1();
		gui.establecerFondo(nivel.obtenerFondo());
	}
}
