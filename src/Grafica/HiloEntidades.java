package Grafica;

import java.awt.Rectangle;
import java.util.List;
import java.util.Stack;

import javax.swing.JPanel;

import Logica.Entidades.Entidad;

public class HiloEntidades implements Runnable{
	private List<Entidad> entidades;
	private Stack<Entidad> paraAgregar;
	private Stack<Integer> paraBorrar;
	private JPanel Campo;
	private boolean reproducir = true;
	private long tiempoEspera;
	
	
	public HiloEntidades(List<Entidad> entidades, Stack<Entidad> paraAgregar, long tiempoDesplazamiento, JPanel Campo) {
		this.entidades = entidades;
		this.paraAgregar = paraAgregar;
		this.Campo = Campo;
		paraBorrar = new Stack<Integer>();
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
			int i;
			while (reproducir) {
				i = 0;
				Entidad e;
				Rectangle colisionA, colisionB;
				for (Entidad it : entidades) {
					it.mover();

					colisionA = it.getGrafica().getBounds();
					for (Entidad otro : entidades) {
						if (it != otro) {
							colisionB = otro.getGrafica().getBounds();
							if (colisionA.intersects(colisionB)) {
								it.colision(otro);
							}
						}
					}

					if (it.getDestruido())
						paraBorrar.push(i);
					i++;
				}
				while (!paraBorrar.isEmpty()) {
					i = paraBorrar.pop();
					entidades.remove(i);
				}
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
	
		
	