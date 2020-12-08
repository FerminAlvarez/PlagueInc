package Logica.Entidades.Visitors;

import Logica.Entidades.*;

public interface Visitor {

	public void visitar(Desinfectante e);
	public void visitar(Espora e);
	public void visitar(Alpha e);
	public void visitar(Beta e);
	public void visitar(Jugador e);
	public void visitar(PremioTemporal e);
	public void visitar(PremioPermanente e);
	
}
