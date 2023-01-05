package modelo;

public class JugadorFemenino extends Jugador{
	
	int tReaccion; //Tiempo de reaccion en segundos
	int puntaje;
	
	public JugadorFemenino() {
		super();
		super.setSuerte(super.determinarSuerte());
	}
	
	public JugadorFemenino(String nombre, String apellido, int nivHab, int tReac) {
		super();
		super.Nombre = nombre;
		super.Apellido = apellido;
		super.nivelHab = nivHab;
		this.tReaccion = tReac;
		super.setSuerte(super.determinarSuerte());
		calculaPuntaje();
	}
	
	@Override
	protected void calculaPuntaje() {
		super.puntaje = (tReaccion + super.getNivelHab()) * (super.getSuerte()/50);
	}

	public int getPuntaje() {
		return puntaje;
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
