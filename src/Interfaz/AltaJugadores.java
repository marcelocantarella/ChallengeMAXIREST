package Interfaz;

import java.util.Scanner;

import controller.CtrlCarac;
import modelo.Jugador;
import modelo.JugadorFemenino;
import modelo.JugadorMasculino;

class AltaJugadores {
	Scanner lectura = new Scanner (System.in);
	CtrlCarac control = new CtrlCarac();
	String auxTyped;
	int cantMasc = 0;
	int cantFem = 0;
	
	public AltaJugadores() {
		super();
	}
	
	public Jugador crearJugador(){
		
		//Pido todos los parametros del nuevo jugador
		System.out.println("******Nuevo jugador******");
		System.out.println("Jugador num: " + (cantMasc + cantFem + 1));
		System.out.println("¿Desea agregar un jugador masculino o femenino? ");
		System.out.println("Ingrese 'm'/masculino ó 'f'/femenino");
		switch(lectura.next()) {
			case "m":
				cantMasc++;
				return new JugadorMasculino(pedirNombre(), pedirApellido(), pedirNivelHab(), pedirNivelFuerza(), pedirVelocidad());
			case "f":
				cantFem++;
				return new JugadorFemenino(pedirNombre(), pedirApellido(), pedirNivelHab(), pedirTiempoReac());
			default:
				System.out.println("Comando no valido.");
				return new JugadorMasculino();
		}		
	}
	
	private String pedirNombre() {
		boolean valido = false;
		System.out.println("Ingrese el nombre del jugador: ");
		//Este método pide y valida el nombre del jugador. De ser necesario lo vuelve a solicitar
		while(!valido) {
			auxTyped = lectura.next();
			if (control.controloCadena(auxTyped)) {
				valido = true;
			}else 
				System.out.println("Ingrese el nombre nuevamente: ");
		}
		return auxTyped;
	}
	
	private String pedirApellido() {
		boolean valido = false;
		
		System.out.println("Ingrese el apellido del jugador: ");
		//Este método pide y valida el nombre del jugador. De ser necesario lo vuelve a solicitar
		while(!valido) {
			auxTyped = lectura.next();
			if (control.controloCadena(auxTyped)) {
				valido = true;
			} else
				System.out.println("Ingrese el apellido nuevamente: ");
		}
		return auxTyped;
	}
	
	private int pedirNivelHab() {
		System.out.println("Ingrese el nivel de hab: ");
		System.out.println("[valores entre 0 y 100]");
		return control.controloCualidad(lectura.nextInt());		
	}

	private int pedirNivelFuerza() {
		System.out.println("Ingrese el nivel de fuerza: ");
		System.out.println("[valores entre 0 y 100]");
		return control.controloCualidad(lectura.nextInt());		
	}
	
	
	private int pedirVelocidad() {
		System.out.println("Ingrese el nivel de velocidad: ");
		System.out.println("[valores entre 0 y 100]");
		return control.controloCualidad(lectura.nextInt());				
	}
	
	
	private int pedirTiempoReac() {
		System.out.println("Ingrese el tiempo de reacción: ");
		System.out.println("[valores entre 0 y 100]");
		return control.controloCualidad(lectura.nextInt());		
	}
	
}
