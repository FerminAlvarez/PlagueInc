package Logica.Entidades;

import Logica.Entidades.Visitors.Visitor;
import Logica.Entidades.Visitors.VisitorPremio;

public abstract class Premio extends Entidad{
	
	protected Premio() {
		miVisitor = new VisitorPremio(this);
	}
	
	public abstract void establecerBeneficio();
	public abstract void aceptar(Visitor v);
}
