package Logica.Entidades.Visitors;

import Logica.Entidades.Alfa;
import Logica.Entidades.Beta;
import Logica.Entidades.Desinfectante;
import Logica.Entidades.Espora;
import Logica.Entidades.Jugador;
import Logica.Entidades.PremioCuarentena;
import Logica.Entidades.PremioPermanente;
import Logica.Entidades.PremioTemporal;

public class VisitorPremio implements Visitor{

	PremioCuarentena miEntidad;
	public VisitorPremio(PremioCuarentena miEntidad) {
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
		
	}

	@Override
	public void visitar(Beta e) {
		
	}

	@Override
	public void visitar(Jugador e) {
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
