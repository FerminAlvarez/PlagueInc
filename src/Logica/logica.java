package Logica;

import Grafica.GUI;
import Grafica.HiloInfectados;

import java.util.LinkedList;

import Logica.Entidades.Entidad;
import Logica.Entidades.Infectado;
import Logica.Entidades.Jugador;
import Logica.Entidades.Fabricas.Fabrica;
import Logica.Entidades.Fabricas.FabricaAlfa;
import Logica.Entidades.Fabricas.FabricaJugador;
import Logica.Niveles.EstadoNivel;
import Logica.Niveles.Nivel1;

public class logica {
	private  GUI gui;
	private static Jugador jugador;
	private Fabrica fabrica;
	private LinkedList<Entidad> entidades;
	private boolean andando = false;
	
	//NO VA ES PARA TESTEAR
	private LinkedList<Infectado> infectados;
	private HiloInfectados hiloInfectados;
	
	public logica (GUI gui) {
		this.gui = gui;
	}
	
	public void iniciar() {
		EstadoNivel nivel = new Nivel1();
		entidades = new LinkedList<Entidad>();
		gui.establecerFondo(nivel.obtenerFondo());
		
		fabrica = new FabricaJugador();
		jugador = (Jugador) fabrica.crear();  //TODO Preguntar si está bien
		entidades.addLast(jugador);
		andando = true;
		
		crearInfectados(3, 1000);
		
		
	}
	
	private void crearInfectados(int cantidad, int tiempoEspera) {
		fabrica = new FabricaAlfa();
		infectados = new LinkedList<Infectado>();
		int distancia = 100;
		for(int i = 0; i<cantidad; i++) {
			Infectado infectado = (Infectado) fabrica.crear();
			infectado.getGrafica().setPosicion(distancia*i, 10);
			entidades.add(infectado);
			infectados.add(infectado);
		}

		hiloInfectados= new HiloInfectados(infectados,230);
		Thread d = new Thread(this.hiloInfectados);
	    d.start();
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
