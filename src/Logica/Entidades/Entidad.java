package Logica.Entidades;

import Logica.Entidades.EntidadesGraficas.EntidadGrafica;
import Logica.Entidades.Visitors.Visitor;
import Logica.Estrategias.EstrategiaMovimiento;

public abstract class Entidad {
	
	protected EntidadGrafica miEntidadGrafica;
	protected EstrategiaMovimiento miEstrategiaMovimiento;

	public void mover() {
		miEstrategiaMovimiento.mover();
	}
	
	public abstract void aceptar(Visitor v);
	
	public void setGrafica(EntidadGrafica e) {
		miEntidadGrafica = e;
	}
	
	public EntidadGrafica getGrafica() {
		return miEntidadGrafica;
	}
	
	public EstrategiaMovimiento getMovimiento() {
		return miEstrategiaMovimiento;
	}
	
	public void setMovimiento(EstrategiaMovimiento m) {
		miEstrategiaMovimiento = m;
	}
	
}
