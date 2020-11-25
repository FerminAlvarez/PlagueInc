package Logica.Entidades;

import Logica.logica;
import Logica.Entidades.Fabricas.Fabrica;
import Logica.Estrategias.EstrategiaDisparo;

public abstract class Personaje extends Entidad{

	protected int hp, dano, gracePeriod;
	protected EstrategiaDisparo miEstrategiaDisparo;
	protected Fabrica miFabrica;
	
	protected Personaje(int hp, int dano) {
		this.hp = hp;
		this.dano = dano;
	}
	
	public void mover() {
		super.mover();
		gracePeriod = gracePeriod > 0 ? gracePeriod - 1 : 0;
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
	
	public void recibirDano(int dano) {
		if(vulnerable()) {
			hp -= dano;
			if(hp <= 0)
				destruir();
			golpeado();
		}
	}
	
	protected boolean vulnerable() {
		return gracePeriod <= 0;
	}
	
	public void setLogica(logica juego) {
		super.setLogica(juego);
		miEstrategiaDisparo.setLogica(juego);
	}
	
	protected abstract void golpeado();
	protected abstract void renovarDisparo();
}
