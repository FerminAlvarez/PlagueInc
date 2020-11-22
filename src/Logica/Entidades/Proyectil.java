package Logica.Entidades;


public abstract class Proyectil extends Entidad{

	protected int dano;
	
	protected Proyectil(int dano) {
		this.dano = dano;
	}
	
	public void setDano(int dano) {
		this.dano = dano;
	}
	
	public int getDano() {
		return dano;
	}
}
