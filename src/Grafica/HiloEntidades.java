package Grafica;

import java.util.List;
import java.util.Stack;

import javax.swing.JPanel;

import Logica.Entidades.Entidad;

public class HiloEntidades implements Runnable{
	private List<Entidad> entidades;
	private Stack<Entidad> paraAgregar;
	private JPanel Campo;
	private boolean reproducir = true;
	private long tiempoEspera;
	
	
	public HiloEntidades(List<Entidad> entidades, Stack<Entidad> paraAgregar, long tiempoDesplazamiento, JPanel Campo) {
		this.entidades = entidades;
		this.paraAgregar = paraAgregar;
		this.Campo = Campo;
		tiempoEspera = tiempoDesplazamiento;
	}
	
	public void arrancarHilo() {
		reproducir = true;
	}
	
	public void detenerHilo() {
		reproducir = false;
	}
	
	
	@Override
	public void run() {
		try {
			while(reproducir) {
				for(Entidad e : entidades) {
					e.mover();
				}
				Entidad e;
				while(!paraAgregar.isEmpty()) {
					e = paraAgregar.pop();
					entidades.add(e);
				}
				Campo.repaint();
				Thread.sleep(tiempoEspera);
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
	
		
	