package modelo;

public class JugadorFemenino extends Jugador{
	
	int tReaccion; //Tiempo de reaccion en segundos
	
	public JugadorFemenino() {
		super();
		super.setSuerte(super.determinarSuerte());
	}

	public JugadorFemenino(int tReaccion) {
		super();
		this.tReaccion = tReaccion;
		super.setSuerte(super.determinarSuerte());
	}

	public int gettReaccion() {
		return tReaccion;
	}

	public void settReaccion(int tReaccion) {
		this.tReaccion = tReaccion;
	}
	
	
	
	
}
