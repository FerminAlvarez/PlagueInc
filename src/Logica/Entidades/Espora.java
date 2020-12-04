package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.EsporaGrafica;

import Logica.Entidades.Visitors.Visitor;
import Logica.Estrategias.MovimientoProyectil;

public class Espora extends Proyectil{

	public Espora() {
		super(10);
		miEntidadGrafica = new EsporaGrafica(0, 0);
		miEstrategiaMovimiento = new MovimientoProyectil(3, 0, 1, this);
	}

	@Override
	public void aceptar(Visitor v) {
		v.visitar(this);
	}

	@Override
	public void impacto(Infectado entidad) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void impacto(Jugador entidad) {
		// TODO Auto-generated method stub
		entidad.recibirDano(dano);
		destruir();
	}

}
