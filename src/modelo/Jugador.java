package modelo;

import java.util.Objects;
import java.util.Random;


//Esta clase es una calse padre con los atributos comunes de los tipos de jugadores
//Ademas esta clase continene un método que permite determinar la suerte del jugador en forma aleatoria
public abstract class Jugador{

	String Nombre;
	String Apellido;
	int nivelHab; //Valores del 1 a 100
	int suerte; //Valores del 1 a 100
	
	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getApellido() {
		return Apellido;
	}

	public void setApellido(String apellido) {
		Apellido = apellido;
	}

	public int getNivelHab() {
		return nivelHab;
	}

	public void setNivelHab(int nivelHab) {
		this.nivelHab = nivelHab;
	}

	public int getSuerte() {
		return suerte;
	}

	public void setSuerte(int suerte) {
		this.suerte = suerte;
	}
	
	
	// Este metodo genera un valor de suerte para el jugador
	protected int determinarSuerte() {
		int max = 99;
		int min = 0;
		
		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	
	}

	@Override
	public int hashCode() {
		return Objects.hash(Apellido, Nombre, nivelHab);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Jugador other = (Jugador) obj;
		return Objects.equals(Apellido, other.Apellido) && Objects.equals(Nombre, other.Nombre)
				&& nivelHab == other.nivelHab;
	}


	
}
