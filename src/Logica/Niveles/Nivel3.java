package Logica.Niveles;

public class Nivel3 extends EstadoNivel{

	private String fondo = "imagenes/Niveles/Fondo3.png";
	@Override
	protected void empezar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String obtenerFondo() {
		return fondo;
	}

	@Override
	public EstadoNivel siguienteNivel() {
		return null;
	}
}
