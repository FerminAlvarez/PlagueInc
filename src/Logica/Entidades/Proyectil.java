package Logica.Entidades;

import Logica.Entidades.Visitors.VisitorProyectil;

public abstract class Proyectil extends Entidad{

	protected int dano;
	
	protected Proyectil(int dano) {
		this.dano = dano;
		miVisitor = new VisitorProyectil(this);
	}
	
	public void setDano(int dano) {
		this.dano = dano;
	}
	
	public int getDano() {
		return dano;
	}
}
