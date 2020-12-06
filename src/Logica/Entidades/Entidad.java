package Logica.Entidades;

import java.awt.Rectangle;

import Logica.logica;
import Logica.Entidades.EntidadesGraficas.EntidadGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Estrategias.EstrategiaMovimiento;

public abstract class Entidad {
	
	protected EntidadGrafica miEntidadGrafica;
	protected EstrategiaMovimiento miEstrategiaMovimiento;
	protected boolean destruido;
	protected Visitor miVisitor;
	protected logica juego;
	protected int dano;
	
	public void mover() {
		miEstrategiaMovimiento.mover();
	}
	
	public abstract void aceptar(Visitor v);
	
	public void establecerGrafica(EntidadGrafica e) {
		miEntidadGrafica = e;
	}
	
	public void establecerPosicion(int x, int y) {
		miEntidadGrafica.establecerPosicion(x, y);
	}

	public int obtenerPosicionX() {
		return miEntidadGrafica.obtenerPosicionX();
	}
	
	public int obtenerPosicionY() {
		return miEntidadGrafica.obtenerPosicionY();
	}
	
	public EntidadGrafica obtenerGrafica() {
		return miEntidadGrafica;
	}
	
	public EstrategiaMovimiento obtenerMovimiento() {
		return miEstrategiaMovimiento;
	}
	
	public void establecerMovimiento(EstrategiaMovimiento m) {
		miEstrategiaMovimiento = m;
	}
	
	public void destruir() {
		destruido = true;
	}
	
	public boolean obtenerDestruido() {
		return destruido;
	}

	public void establecerLogica(logica juego) {
		this.juego = juego;
		juego.agregar(this);
	}
	
	public void colision(Entidad otro) {
		otro.aceptar(miVisitor);
	}
	
	public Visitor obtenerVisitor() {
		return miVisitor;
	}
	
	public void establecerVelocidad(int n) {
		miEstrategiaMovimiento.establecerVelocidad(n);
	}
	
	public int obtenerVelocidad() {
		return miEstrategiaMovimiento.obtenerVelocidad();
	}
	
	public int obtenerVelocidadInicial() {
		return miEstrategiaMovimiento.obtenerVelocidadInicial();
	}
	
	public Rectangle obtenerBounds() {
		return miEntidadGrafica.obtenerBounds();
	}
	
	public void establecerDano(int d) {
		dano = d;
	}
	
	public int obtenerDano() {
		return dano;
	}
	
	public int obtenerPuntoDisparoX() {
		return miEntidadGrafica.obtenerPuntoDisparoX();
	}
	
	public int obtenerPuntoDisparoY() {
		return miEntidadGrafica.obtenerPuntoDisparoY();
	}
}
