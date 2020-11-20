package Logica;

import Grafica.GUI;
import java.util.LinkedList;

import Logica.Entidades.Entidad;
import Logica.Entidades.Jugador;
import Logica.Entidades.Fabricas.Fabrica;
import Logica.Entidades.Fabricas.FabricaJugador;
import Logica.Niveles.EstadoNivel;
import Logica.Niveles.Nivel1;

public class logica {
	private  GUI gui;
	private static Jugador jugador;
	private Fabrica fabrica;
	private LinkedList<Entidad> entidades;
	private boolean andando = false;
	
	public logica (GUI gui) {
		this.gui = gui;
	}
	
	public void iniciar() {
		EstadoNivel nivel = new Nivel1();
		gui.establecerFondo(nivel.obtenerFondo());
		fabrica = new FabricaJugador();
		jugador = (Jugador) fabrica.crear();  //TODO Preguntar si está bien
		entidades = new LinkedList<Entidad>();
		entidades.addLast(jugador);
		andando = true;
	}
	
	public void moverJugador(String estado, String cmd) {
		if(jugador != null)
			jugador.mover(estado, cmd);
		else
			System.out.println("JUGADOR NULL");
	}
	
	public LinkedList<Entidad> getEntidades(){
		return entidades;
	}
	
	public boolean enCurso() {
		return andando;
	}
}
