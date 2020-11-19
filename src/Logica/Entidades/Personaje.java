package Logica.Entidades;

import Logica.Estrategias.EstrategiaDisparo;

public abstract class Personaje extends Entidad{

	protected int hp, dano;
	protected EstrategiaDisparo miEstrategiaDisparo;
	
	protected Personaje(int hp, int dano) {
		this.hp = hp;
		this.dano = dano;
	}
	
	public void setAtaque(EstrategiaDisparo e) {
		miEstrategiaDisparo = e;
	}
	
	public int getHP() {
		return hp;
	}
	
	public void setHP(int n) {
		hp = n;
	}
	
	public int getDano() {
		return dano;
	}
	
}
