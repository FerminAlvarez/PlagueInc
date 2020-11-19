package Logica.Niveles;

public abstract class EstadoNivel {
	protected abstract void empezar();
	public abstract String obtenerFondo();
	public abstract EstadoNivel siguienteNivel();
}
