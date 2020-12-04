package Logica;

import Grafica.GUI;

import java.util.Random;
import java.awt.Rectangle;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.swing.JOptionPane;

import Logica.Entidades.Entidad;
import Logica.Entidades.Jugador;
import Logica.Niveles.EstadoNivel;
import Logica.Niveles.Nivel1;
import Logica.Niveles.Nivel3;

public class logica {
	private GUI gui;
	private Jugador jugador;
	private List<Entidad> entidades, paraInvocar;
	private Stack<Entidad> paraAgregar;
	private Stack<Integer> paraBorrar;
	private boolean andando = false;
	private EstadoNivel nivelActual;
	private int infectadoDelay;
	private Iterator<Entidad> itInvocador;
	
	private HiloEntidades hiloEntidades;
	
	public logica (GUI gui) {
		this.gui = gui;
	}
	
	public void iniciar() {
		paraAgregar = new Stack<Entidad>();
		paraBorrar = new Stack<Integer>();
		paraInvocar = new LinkedList<Entidad>();
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
			if (it.obtenerDestruido()) {
				nivelActual.entidadDestruida(it);
				paraBorrar.push(i);	
			}
			i++;
		}
		while (!paraBorrar.isEmpty()) {
			i = paraBorrar.pop();
			entidades.remove(i);
		}
	}
	
	private void agregarInfectado() {
		Entidad e;
		Random r = new Random();
		if(infectadoDelay <= 0) {
			if(itInvocador.hasNext()) {
				e = itInvocador.next();
				e.establecerLogica(this);
				e.obtenerGrafica().establecerPosicion(r.nextInt(500) + 10, -50);
				infectadoDelay = nivelActual.obtenerDelay();
			}
		}
		else
			infectadoDelay = infectadoDelay > 0 ? infectadoDelay - 1 : 0;
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
	
	public Entidad getPremio() {
		return nivelActual.getPremio();
	}
	
	private void pasarNivel() {
		if(nivelActual.termino()) {
			if(nivelActual.siguienteNivel() != null)
				empezarNivel(nivelActual.siguienteNivel());
			else {
				gui.mostrarMensajeTerminado("¡Felicitaciones ha ganado!");
			}
				
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

	private void empezarNivel(EstadoNivel n) {
		nivelActual = n;
		n.inicializar();
		for(Entidad it : n.getEntidades())
			paraInvocar.add(it);
		Collections.shuffle(paraInvocar);
		itInvocador = paraInvocar.iterator();
		
		gui.establecerFondo(n.obtenerFondo());
		gui.establecerNivel(n.obtenerNumeroNivel());
	}
	
	public void actualizarHP(int hp) {
		gui.establecerVida(hp);
		if(hp<=0) {
			gui.mostrarMensajeTerminado("¡UPS! Usted se ha contagiado, realice cuarentena obligatoria");
		}
	}
	
	
}
