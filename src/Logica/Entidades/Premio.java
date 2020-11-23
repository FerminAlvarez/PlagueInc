package Logica.Entidades;

import Logica.Entidades.Visitors.VisitorPremio;

public abstract class Premio extends Entidad{
	
	protected Premio() {
		miVisitor = new VisitorPremio(this);
	}
	
	abstract void establecerBeneficio();
}
