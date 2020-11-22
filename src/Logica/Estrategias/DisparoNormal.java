package Logica.Estrategias;

import Logica.Entidades.Desinfectante;
import Logica.Entidades.EntidadesGraficas.EntidadGrafica;
import Logica.Entidades.Fabricas.Fabrica;

public class DisparoNormal extends EstrategiaDisparo{

	public DisparoNormal(int dano, int velocidad, Fabrica miFabrica, EntidadGrafica miEntidadGrafica) {
		super(dano, velocidad, miFabrica, miEntidadGrafica);
		// TODO Auto-generated constructor stub
	}
	
	public void disparar() {
		Desinfectante proy = (Desinfectante) miFabrica.crear();
		proy.getMovimiento().setVelocidad(velocidad);
		proy.setDano(10);
		proy.getGrafica().setPosicion(miEntidadGrafica.getPosicionX(), miEntidadGrafica.getPosicionY());
	}

}
