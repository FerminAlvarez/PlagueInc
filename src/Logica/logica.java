package Logica;

import Grafica.GUI;

import Grafica.HiloEntidades;

import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

import Logica.Entidades.Entidad;
import Logica.Entidades.Infectado;
import Logica.Entidades.Jugador;
import Logica.Entidades.PremioPermanente;
import Logica.Entidades.Fabricas.Fabrica;
import Logica.Entidades.Fabricas.FabricaAlfa;
import Logica.Entidades.Fabricas.FabricaDesinfectante;
import Logica.Entidades.Fabricas.FabricaEspora;
import Logica.Entidades.Fabricas.FabricaJugador;
import Logica.Entidades.Fabricas.FabricaPremioPermanente;
import Logica.Niveles.EstadoNivel;
import Logica.Niveles.Nivel1;

public class logica {
	private GUI gui;
	private static Jugador jugador;
	private Fabrica fabrica;
	private List<Entidad> entidades;
	private Stack<Entidad> paraAgregar;
	private boolean andando = false;
	
	private HiloEntidades hiloEntidades;
	
	public logica (GUI gui) {
		this.gui = gui;
	}
	
	public void iniciar() {
		paraAgregar = new Stack<Entidad>();
		EstadoNivel nivel = new Nivel1();
		entidades = new CopyOnWriteArrayList<Entidad>();
		gui.establecerFondo(nivel.obtenerFondo());
		
		fabrica = new FabricaJugador(paraAgregar, new FabricaDesinfectante(paraAgregar));
		jugador = (Jugador) fabrica.crear();  //TODO Preguntar si está bien
		andando = true;
		
		hiloEntidades= new HiloEntidades(entidades, paraAgregar, 16, gui.getCampo());
		Thread d = new Thread(this.hiloEntidades);
	    d.start();
		crearInfectados(3, 1000);
		
		
	}
	
	private void crearInfectados(int cantidad, int tiempoEspera) {
		fabrica = new FabricaAlfa(paraAgregar, new FabricaEspora(paraAgregar));
		int distancia = 100;
		for(int i = 0; i<cantidad; i++) {
			Infectado infectado = (Infectado) fabrica.crear();
			infectado.getGrafica().setPosicion(distancia * i, 10);
		}
		
		
		//Quitar comentario para testear beneficios permanentes.
		
		
		fabrica = new FabricaPremioPermanente(paraAgregar ,jugador);
		PremioPermanente premio = (PremioPermanente) fabrica.crear();
		premio.getGrafica().setPosicion(250,10);
		premio = (PremioPermanente) fabrica.crear();
		premio.getGrafica().setPosicion(123,10);
		premio.establecerBeneficio();
		premio = (PremioPermanente) fabrica.crear();
		premio.getGrafica().setPosicion(234,10);
		premio.establecerBeneficio();
		premio = (PremioPermanente) fabrica.crear();
		premio.getGrafica().setPosicion(123,10);
		premio.establecerBeneficio();
		premio = (PremioPermanente) fabrica.crear();
		premio.getGrafica().setPosicion(444,10);
		premio.establecerBeneficio();
		premio = (PremioPermanente) fabrica.crear();
		premio.getGrafica().setPosicion(55,10);
		premio.establecerBeneficio();
		premio = (PremioPermanente) fabrica.crear();
		premio.getGrafica().setPosicion(2,10);
		premio.establecerBeneficio();
		
		
		
	}
	
	
	public void accionJugador(String estado, String cmd) {
		if(jugador != null)
			jugador.accion(estado, cmd);
		else
			System.out.println("JUGADOR NULL");
	}
	
	public List<Entidad> getEntidades(){
		return entidades;
	}
	
	public boolean enCurso() {
		return andando;
	}
}
