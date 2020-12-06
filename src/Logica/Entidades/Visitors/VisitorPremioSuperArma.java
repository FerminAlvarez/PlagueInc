package Logica.Entidades.Visitors;

import java.util.Timer;
import java.util.TimerTask;

import Logica.Entidades.Alfa;
import Logica.Entidades.Beta;
import Logica.Entidades.Desinfectante;
import Logica.Entidades.Espora;
import Logica.Entidades.Jugador;
import Logica.Entidades.PremioPermanente;
import Logica.Entidades.PremioSuperArma;
import Logica.Entidades.PremioTemporal;

public class VisitorPremioSuperArma implements Visitor{

	PremioSuperArma miEntidad;
	private int delay = 4000;
	
	
	
	public VisitorPremioSuperArma(PremioSuperArma miEntidad) {
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
		int dañoAnterior = e.obtenerDanoInicial();
		e.establecerDano(dañoAnterior * 3);
		Timer timer = new Timer();
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				e.establecerDano(dañoAnterior);
				this.cancel();
			}
		};
		timer.schedule(task, delay, delay);
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
