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
	private PremioCuarentena miEntidad;
	
	public VisitorPremioCuarentena (PremioCuarentena miEntidad) {
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
		// Deber�a obtener la velocidad anterior
		int velocidadAnterior = e.obtenerMovimiento().obtenerVelocidad();
		e.obtenerMovimiento().establecerVelocidad(0);
		System.out.println("Alfa");
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				//Para probar. Este hilo sigue "corriendo"
				System.out.println("AAAAAAAAAA");
				e.obtenerMovimiento().establecerVelocidad(velocidadAnterior);
			}

		};
		timer.schedule(task, delay, delay);
	}

	@Override
	public void visitar(Beta e) {
		int velocidadAnterior = e.obtenerMovimiento().obtenerVelocidad();
		e.obtenerMovimiento().establecerVelocidad(0);
		System.out.println("Beta");
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				e.obtenerMovimiento().establecerVelocidad(velocidadAnterior);
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
