package Logica.Entidades.Visitors;

import Logica.Entidades.Alfa;

import Logica.Entidades.Beta;
import Logica.Entidades.Desinfectante;
import Logica.Entidades.Espora;
import Logica.Entidades.Jugador;
import Logica.Entidades.Premio;
import Logica.Entidades.PremioPermanente;
import Logica.Entidades.PremioTemporal;

public class VisitorPremio implements Visitor{

	private Premio miEntidad;
	
	public VisitorPremio(Premio miEntidad) {
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
	public void visitar(Alfa e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Beta e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void visitar(Jugador e) {
		miEntidad.establecerBeneficio(e);
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
