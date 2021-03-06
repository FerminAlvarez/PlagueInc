package Logica.Entidades.Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Logica.Entidades.Alpha;
import Logica.Entidades.Beta;
import Logica.Entidades.Desinfectante;
import Logica.Entidades.Espora;
import Logica.Entidades.Jugador;
import Logica.Entidades.PremioPermanente;
import Logica.Entidades.PremioTemporal;

public class VisitorPremioSuperArma implements Visitor{

	PremioTemporal miEntidad;
	private int delay = 4000;
	
	
	
	public VisitorPremioSuperArma(PremioTemporal miEntidad) {
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
		int daņoAnterior = e.obtenerDanoInicial();
		e.establecerDano(daņoAnterior * 3);
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				e.establecerDano(daņoAnterior);
				this.cancel();
			}
		};
		timer.schedule(task, delay, delay);
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
