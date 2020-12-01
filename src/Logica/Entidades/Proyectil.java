package Logica.Entidades;

import Logica.Entidades.Visitors.VisitorProyectil;

public abstract class Proyectil extends Entidad{

	protected int dano;
	
	protected Proyectil(int dano) {
		this.dano = dano;
		miVisitor = new VisitorProyectil(this);
	}
	
	public abstract void impacto(Infectado entidad);
	public abstract void impacto(Jugador entidad);
	
	public void establecerDano(int dano) {
		this.dano = dano;
	}
	
	public int obtenerDano() {
		return dano;
	}
}
