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
	
	public void establecerAtaque(EstrategiaDisparo e) {
		miEstrategiaDisparo = e;
	}
	
	public EstrategiaDisparo obtenerAtaque() {
		return miEstrategiaDisparo;
	}
	
	public int obtenerHP() {
		return hp;
	}
	
	public void establecerHP(int n) {
		hp = n;
	}
	
	public int obtenerDano() {
		return dano;
	}
	
	public void establecerFabrica(Fabrica miFabrica) {
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
	
	public void establecerLogica(logica juego) {
		super.establecerLogica(juego);
		miEstrategiaDisparo.establecerLogica(juego);
	}
	
	public logica obtenerLogica() {
		return juego;
	}
	
	protected abstract void golpeado();
	protected abstract void renovarDisparo();
}
