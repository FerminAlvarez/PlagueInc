package Logica.Entidades.Visitors;

import Logica.Entidades.Alpha;
import Logica.Entidades.Beta;
import Logica.Entidades.Desinfectante;
import Logica.Entidades.Espora;
import Logica.Entidades.Jugador;
import Logica.Entidades.PremioPermanente;
import Logica.Entidades.PremioTemporal;

public class VisitorPremioVelocidad implements Visitor{

	private PremioPermanente miEntidad;
	
	public VisitorPremioVelocidad(PremioPermanente miEntidad) {
		this.miEntidad = miEntidad;
	}
	
	@Override
	public void visitar(Desinfectante e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Espora e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Alpha e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Beta e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Jugador e) {
		e.establecerVelocidad(10);
		miEntidad.agarrado();
		miEntidad.destruir();
	}

	@Override
	public void visitar(PremioTemporal e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(PremioPermanente e) {
		// TODO Auto-generated method stub
		
	}

}
