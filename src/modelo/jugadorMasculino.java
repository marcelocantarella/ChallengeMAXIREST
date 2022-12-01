package modelo;


//Esta clase es una calse padre con los atributos comunes de los tipos de jugadores
//Ademas esta clase determina la suerte del jugador dentro del constructor
public class jugadorMasculino extends Jugador{

	int fuerza; //Valores del 1 a 100
	int velocidad; //Valores del 1 a 100
	
	public jugadorMasculino() {
		super();
		super.setSuerte(super.determinarSuerte());
	}

	public jugadorMasculino(int fuerza, int velocidad) {
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
