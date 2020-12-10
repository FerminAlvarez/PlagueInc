package Logica.Entidades.Visitors;

import Logica.Entidades.Alpha;
import Logica.Entidades.Beta;
import Logica.Entidades.Desinfectante;
import Logica.Entidades.Espora;
import Logica.Entidades.Jugador;
import Logica.Entidades.PremioPermanente;
import Logica.Entidades.PremioTemporal;

public class VisitorPremioCuarentena implements Visitor{

	PremioTemporal miEntidad;
	public VisitorPremioCuarentena(PremioTemporal miEntidad) {
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
		
	}

	@Override
	public void visitar(Beta e) {
		
	}

	@Override
	public void visitar(Jugador e) {
		miEntidad.agarrado();
		miEntidad.establecerBeneficio();
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
