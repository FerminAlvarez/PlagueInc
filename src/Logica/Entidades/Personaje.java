package Logica.Entidades;

import Logica.Entidades.Fabricas.Fabrica;
import Logica.Estrategias.EstrategiaDisparo;

public abstract class Personaje extends Entidad{

	protected int hp, dano;
	protected EstrategiaDisparo miEstrategiaDisparo;
	protected Fabrica miFabrica;
	
	protected Personaje(int hp, int dano, Fabrica miFabrica) {
		this.hp = hp;
		this.dano = dano;
		this.miFabrica = miFabrica;
	}
	
	public void setAtaque(EstrategiaDisparo e) {
		miEstrategiaDisparo = e;
	}
	
	public EstrategiaDisparo getAtaque() {
		return miEstrategiaDisparo;
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
	
	public void setFabrica(Fabrica miFabrica) {
		this.miFabrica = miFabrica;
		renovarDisparo();
	}
	
	protected abstract void renovarDisparo();
}
