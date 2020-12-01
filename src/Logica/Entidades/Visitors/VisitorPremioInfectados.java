package Logica.Entidades.Visitors;

import Logica.Entidades.Alfa;
import Logica.Entidades.Beta;
import Logica.Entidades.Desinfectante;
import Logica.Entidades.Espora;
import Logica.Entidades.Jugador;
import Logica.Entidades.PremioPermanente;
import Logica.Entidades.PremioTemporal;

public class VisitorPremioInfectados implements Visitor{

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
		int velocidadAnterior = e.obtenerMovimiento().obtenerVelocidad();
		try {
			e.obtenerMovimiento().establecerVelocidad(0);
			System.out.println("AAAA");
			Thread.sleep(1000);
			e.obtenerMovimiento().establecerVelocidad(velocidadAnterior);
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void visitar(Beta e) {
		int velocidadAnterior = e.obtenerMovimiento().obtenerVelocidad();
		try {
			e.obtenerMovimiento().establecerVelocidad(0);
			System.out.println("BBB");
			Thread.sleep(1000);
			e.obtenerMovimiento().establecerVelocidad(velocidadAnterior);
			
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	@Override
	public void visitar(Jugador e) {
		System.out.println("ADSFASDFASASDFASDFASFSDAF");
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
