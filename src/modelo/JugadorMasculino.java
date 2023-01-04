package modelo;


//Esta clase es una calse padre con los atributos comunes de los tipos de jugadores
//Ademas esta clase determina la suerte del jugador dentro del constructor
public class JugadorMasculino extends Jugador{

	int fuerza; //Valores del 1 a 100
	int velocidad; //Valores del 1 a 100
	
	public JugadorMasculino() {
		super();
		super.setSuerte(super.determinarSuerte());
	}
	
	public JugadorMasculino(String nombre, String apellido, int nivHab, int fza, int vel) {
		super();
		super.Nombre = nombre;
		super.Apellido = apellido;
		super.nivelHab = nivHab;
		this.fuerza = fza;
		this.velocidad = vel;
		super.setSuerte(super.determinarSuerte());
		calculaPuntaje();
	}
	
	private void calculaPuntaje() {
		super.puntaje = (fuerza + super.getNivelHab() + velocidad) * (super.getSuerte()/50);
	}


	public JugadorMasculino(int fuerza, int velocidad) {
		super();
		this.fuerza = fuerza;
		this.velocidad = velocidad;
		super.setSuerte(super.determinarSuerte());
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	
	}
