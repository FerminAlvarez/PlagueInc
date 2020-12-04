package Logica.Entidades.Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Logica.Entidades.Alfa;
import Logica.Entidades.Beta;
import Logica.Entidades.Desinfectante;
import Logica.Entidades.Espora;
import Logica.Entidades.Jugador;
import Logica.Entidades.PremioCuarentena;
import Logica.Entidades.PremioPermanente;
import Logica.Entidades.PremioTemporal;

public class VisitorPremioCuarentena implements Visitor{
	private long delay = 5000;
	
	private static VisitorPremioCuarentena miInstancia;
	private TimerTask miTimerTaskAlfa, miTimerTaskBeta;
	private int velocidadAnterior;
	
	private VisitorPremioCuarentena () {
		
	}
	
	public static VisitorPremioCuarentena obtenerVisitorPremioCuarentena() {
		if(miInstancia == null)
			miInstancia = new VisitorPremioCuarentena();
		return miInstancia;
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
		// Debería obtener la velocidad anterior
		int velocidadAnterior;
		if(miTimerTaskAlfa == null) {
			velocidadAnterior = e.obtenerVelocidad();
			miTimerTaskAlfa = new TimerTask() {
				@Override
				public void run() {
					e.establecerVelocidad(velocidadAnterior);
					this.cancel();
				}
				
				public int obtenerVelocidadAnterior() {
					return velocidadAnterior;
				}
			};
			
		}
		else {
			
		}
		e.establecerVelocidad(0);
		Timer timer = new Timer();
		timer.schedule(miTimerTaskAlfa, delay, delay);
	}

	@Override
	public void visitar(Beta e) {
		int velocidadAnterior = e.obtenerVelocidad();
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
