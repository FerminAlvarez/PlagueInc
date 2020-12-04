package Logica.Entidades.Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Logica.Entidades.Alfa;
import Logica.Entidades.Beta;
import Logica.Entidades.Desinfectante;
import Logica.Entidades.Espora;
import Logica.Entidades.Jugador;
import Logica.Entidades.PremioPermanente;
import Logica.Entidades.PremioTemporal;

public class VisitorPremioCuarentena implements Visitor{
	private long delay = 5000;
	
	public VisitorPremioCuarentena () {
		
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
		int velocidadAnterior = e.obtenerVelocidadInicial();
		e.obtenerMovimiento().establecerVelocidad(0);
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				e.establecerVelocidad(velocidadAnterior);
				System.out.println("Ya no ralentizo.");
				this.cancel();
			}
		};
		timer.schedule(task, delay, delay);
	}

	@Override
	public void visitar(Beta e) {
		int velocidadAnterior = e.obtenerVelocidadInicial();
		e.establecerVelocidad(0);
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				e.establecerVelocidad(velocidadAnterior);
				this.cancel();
			}

		};
		timer.schedule(task, delay, delay);
	}

	@Override
	public void visitar(Jugador e) {
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
