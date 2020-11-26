package Logica.Entidades;

import Logica.Entidades.Visitors.Visitor;

public abstract class Premio extends Entidad {

	public abstract void aceptar(Visitor v);
}
