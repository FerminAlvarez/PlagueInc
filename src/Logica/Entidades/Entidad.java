package Logica.Entidades;

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
	
	public void mover() {
		miEstrategiaMovimiento.mover();
	}
	
	public abstract void aceptar(Visitor v);
	
	public void setGrafica(EntidadGrafica e) {
		miEntidadGrafica = e;
	}
	
	public EntidadGrafica getGrafica() {
		return miEntidadGrafica;
	}
	
	public EstrategiaMovimiento getMovimiento() {
		return miEstrategiaMovimiento;
	}
	
	public void setMovimiento(EstrategiaMovimiento m) {
		miEstrategiaMovimiento = m;
	}
	
	public void destruir() {
		destruido = true;
	}
	
	public boolean getDestruido() {
		return destruido;
	}

	public void setLogica(logica juego) {
		this.juego = juego;
		juego.agregar(this);
	}
	
	public void colision(Entidad otro) {
		otro.aceptar(miVisitor);
	}
	
	public Visitor getVisitor() {
		return miVisitor;
	}
	
}
