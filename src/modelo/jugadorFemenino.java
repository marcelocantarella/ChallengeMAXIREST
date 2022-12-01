package modelo;

public class jugadorFemenino extends Jugador{
	
	int tReaccion; //Tiempo de reaccion en segundos
	
	public jugadorFemenino() {
		super();
		super.setSuerte(super.determinarSuerte());
	}

	public jugadorFemenino(int tReaccion) {
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
