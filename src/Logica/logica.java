package Logica;

import Grafica.GUI;

import java.util.Random;
import java.awt.Rectangle;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

import Logica.Entidades.Entidad;
import Logica.Entidades.Jugador;
import Logica.Entidades.PremioPermanente;
import Logica.Entidades.PremioTemporal;
import Logica.Entidades.Fabricas.Fabrica;
import Logica.Entidades.Fabricas.FabricaPremioPermanente;
import Logica.Entidades.Fabricas.FabricaPremioTemporal;
import Logica.Niveles.EstadoNivel;
import Logica.Niveles.Nivel1;

public class logica {
	private GUI gui;
	private Jugador jugador;
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
	
	public void infectadoDestruido(int x) {
		infectadosDestruidos++;
		Random rnd = new Random();
		int numero = rnd.nextInt(9);
		if (numero < nivelActual.obtenerProbabilidadPremioPermanente())
			crearPremioPermanente(x);
		else {
			numero = rnd.nextInt (9);
			if (numero < nivelActual.obtenerProbabilidadPremioTemporal())
				crearPremioTemporal(x);
		}
	}
	private void crearPremioTemporal (int x) {
		Fabrica fabrica = new FabricaPremioTemporal();
		PremioTemporal premio = (PremioTemporal) fabrica.crear();
		premio.establecerLogica(this);
		premio.obtenerGrafica().establecerPosicion(x,-10);
	}
	
	private void crearPremioPermanente (int x) {
		Fabrica fabrica = new FabricaPremioPermanente();
		PremioPermanente premio = (PremioPermanente) fabrica.crear();
		premio.establecerLogica(this);
		premio.obtenerGrafica().establecerPosicion(x,-10);
	}
	private void empezarNivel(EstadoNivel n) {
		infectadosDestruidos = 0;
		nivelActual = n;
		gui.establecerFondo(n.obtenerFondo());
		gui.establecerNivel(n.obtenerNumeroNivel());
	}
	
	public void actualizarHP(int hp) {
		gui.establecerVida(hp);
	}
}
