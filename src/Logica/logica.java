package Logica;

import Grafica.GUI;

import java.util.Random;
import java.awt.Rectangle;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

import Logica.Entidades.Entidad;
import Logica.Entidades.Infectado;
import Logica.Entidades.Jugador;
import Logica.Entidades.PremioPermanente;
import Logica.Entidades.PremioTemporal;
import Logica.Entidades.Fabricas.Fabrica;
import Logica.Entidades.Fabricas.FabricaAlfa;
import Logica.Entidades.Fabricas.FabricaPremioPermanente;
import Logica.Entidades.Fabricas.FabricaPremioTemporal;
import Logica.Niveles.EstadoNivel;
import Logica.Niveles.Nivel1;

public class logica {
	private GUI gui;
	private Jugador jugador;
	private Fabrica fabrica;
	private List<Entidad> entidades;
	private Stack<Entidad> paraAgregar;
	private Stack<Integer> paraBorrar;
	private boolean andando = false;
	private EstadoNivel nivelActual;
	private int infectadoDelay, infectadosDestruidos;
	
	private HiloEntidades hiloEntidades;
	
	public logica (GUI gui) {
		this.gui = gui;
	}
	
	public void iniciar() {
		paraAgregar = new Stack<Entidad>();
		paraBorrar = new Stack<Integer>();
		empezarNivel(new Nivel1(this));
		
		entidades = new CopyOnWriteArrayList<Entidad>();
		
		jugador = new Jugador(100, 10);
		jugador.establecerLogica(this);
		andando = true;
		
		hiloEntidades= new HiloEntidades(this, 16);
		Thread d = new Thread(this.hiloEntidades);
	    d.start();
	    
	    //Para probar los premios, actualmente causa un error si se muere el jugador
		//crearInfectados(3, 1000);
		
		
	}
	
	private void crearInfectados(int cantidad, int tiempoEspera) {
		fabrica = new FabricaAlfa();
		int distancia = 250;
		for(int i = 0; i<cantidad; i++) {
			Infectado infectado = (Infectado) fabrica.crear();
			infectado.establecerLogica(this);
			infectado.obtenerGrafica().establecerPosicion(distancia * i, 10);
		}
		
		
		//Quitar comentario para testear beneficios permanentes.
		
		fabrica = new FabricaPremioPermanente();
		PremioPermanente premio = (PremioPermanente) fabrica.crear();
		premio.establecerLogica(this);
		premio.obtenerGrafica().establecerPosicion(250,10);
		
		
		fabrica = new FabricaPremioTemporal();
		
		PremioTemporal premio1 = (PremioTemporal) fabrica.crear();
		premio1.establecerLogica(this);
		premio1.obtenerGrafica().establecerPosicion(100,10);
		
		
		/*
		premio = (PremioPermanente) fabrica.crear();
		premio.obtenerGrafica().establecerPosicion(123,10);
		premio.establecerBeneficio();
		premio = (PremioPermanente) fabrica.crear();
		premio.obtenerGrafica().establecerPosicion(234,10);
		premio.establecerBeneficio();
		premio = (PremioPermanente) fabrica.crear();
		premio.obtenerGrafica().establecerPosicion(123,10);
		premio.establecerBeneficio();
		premio = (PremioPermanente) fabrica.crear();
		premio.obtenerGrafica().establecerPosicion(444,10);
		premio.establecerBeneficio();
		premio = (PremioPermanente) fabrica.crear();
		premio.obtenerGrafica().establecerPosicion(55,10);
		premio.establecerBeneficio();
		premio = (PremioPermanente) fabrica.crear();
		premio.obtenerGrafica().establecerPosicion(2,10);
		premio.establecerBeneficio();
		
		*/
		
		
	}
	
	public void pasarFrame() {
		moverEntidades();
		checkearColisiones();
		checkearDestruidos();
		agregarInfectado();
		agregarNuevos();
		actualizarGrafica();
		pasarNivel();
	}
	
	private void moverEntidades() {
		for (Entidad it : entidades) {
			it.mover();
		}
	}

	private void checkearColisiones() {
		Rectangle colisionA, colisionB;
		for (Entidad it : entidades) {
			colisionA = it.obtenerGrafica().obtenerBounds();
			for (Entidad otro : entidades) {
				if (it != otro) {
					colisionB = otro.obtenerGrafica().obtenerBounds();
					if (colisionA.intersects(colisionB))
						it.colision(otro);
				}
			}
		}
	}
	
	private void checkearDestruidos() {
		int i = 0;
		for (Entidad it : entidades) {
			if (it.obtenerDestruido())
				paraBorrar.push(i);
			i++;
		}
		while (!paraBorrar.isEmpty()) {
			i = paraBorrar.pop();
			entidades.remove(i);
		}
	}
	
	private void agregarInfectado() {
		Fabrica f;
		Entidad e;
		Random r = new Random();
		if(nivelActual.obtenerInfectadosRestantes() > 0) {
			if(infectadoDelay <= 0) {
				f = nivelActual.obtenerFabricaInfectado();
				e = f.crear();
				e.establecerLogica(this);
				e.obtenerGrafica().establecerPosicion(r.nextInt(750) + 10, -50);
				infectadoDelay = nivelActual.obtenerDelay();
			}
			else
				infectadoDelay--;
		}
	}
	
	private void agregarNuevos() {
		Entidad e;
		while(!paraAgregar.isEmpty()) {
			e = paraAgregar.pop();
			entidades.add(e);
		}
	}
	
	private void actualizarGrafica() {
		gui.actualizarGrafica();
	}
	
	private void pasarNivel() {
		if(infectadosDestruidos >= nivelActual.obtenerTotalInfectados()) {
			empezarNivel(nivelActual.siguienteNivel());
		}
	}
	
	public void agregar(Entidad e){
		paraAgregar.push(e);
	}
	
	public void accionJugador(String estado, String cmd) {
		if(jugador != null)
			jugador.accion(estado, cmd);
		else
			System.out.println("JUGADOR NULL");
	}
	
	public List<Entidad> obtenerEntidades(){
		return entidades;
	}
	
	public boolean enCurso() {
		return andando;
	}
	
	public void infectadoDestruido() {
		infectadosDestruidos++;
	}
	
	private void empezarNivel(EstadoNivel n) {
		infectadosDestruidos = 0;
		nivelActual = n;
		gui.establecerFondo(n.obtenerFondo());
	}
}
