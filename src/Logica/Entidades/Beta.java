package Logica.Entidades;

import Logica.Entidades.Fabricas.Fabrica;
import Logica.Entidades.Visitors.Visitor;

public class Beta extends Infectado{

	public Beta(int hp, int dano, Fabrica miFabrica) {
		super(hp, dano, miFabrica);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void aceptar(Visitor v) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void renovarDisparo() {
		// TODO Auto-generated method stub
		
	}

}
