package Interfaz;

import java.util.Scanner;

import controller.CtrlCarac;
import modelo.Jugador;
import modelo.JugadorFemenino;
import modelo.JugadorMasculino;

class CargarJugadores {

	JugadorMasculino auxMasc = new JugadorMasculino();
	JugadorFemenino auxFem = new JugadorFemenino();
	Scanner lectura = new Scanner (System.in);
	CtrlCarac control = new CtrlCarac();
	String auxTyped;
	
	public CargarJugadores() {
		super();
	}
	
	public Jugador cargarNuevoJugador(int numJugIng, boolean tipoJugador) {
		auxMasc = new JugadorMasculino();
		auxFem = new JugadorFemenino();
		
		//Pido todos los parametros del nuevo jugador masculino
		System.out.println("******Nuevo jugador******");
		System.out.println("Jugador num: " + numJugIng);
		if (tipoJugador == true) {
			pedirNombre(auxMasc);
			pedirApellido(auxMasc);
			pedirNivelHab(auxMasc);
			pedirNivelFuerza(auxMasc);
			pedirVelocidad(auxMasc);
			return auxMasc;
		} else {
			pedirNombre(auxFem);
			pedirApellido(auxFem);
			pedirNivelHab(auxFem);
			pedirTiempoReac(auxFem);
			return auxFem;
		}
		
	}
	
	
	private void pedirNombre(Jugador auxJug) {
		boolean valido = false;
		//Este método pide y valida el nombre del jugador. De ser necesario lo vuelve a solicitar
		while(!valido) {
			System.out.println("Ingrese el nombre: ");
			auxTyped = lectura.next();
			if (control.controloCadena(auxTyped)) {
				auxJug.setNombre(auxTyped);
				valido = true;
			}
		}
	}
	
	private void pedirApellido(Jugador auxJug) {
		boolean valido = false;
		//Este método pide y valida el nombre del jugador. De ser necesario lo vuelve a solicitar
		while(!valido) {
			System.out.println("Ingrese el apellido: ");
			auxTyped = lectura.next();
			if (control.controloCadena(auxTyped)) {
				auxJug.setNombre(auxTyped);
				valido = true;
			}
		}
	}
	
	private void pedirNivelHab(Jugador auxJug) {
		System.out.println("Ingrese el nivel de hab: ");
		System.out.println("[valores entre 0 y 100]");
		auxJug.setNivelHab(control.controloCualidad(lectura.nextInt()));		
	}

	private void pedirNivelFuerza(JugadorMasculino auxJug) {
		System.out.println("Ingrese el nivel de fuerza: ");
		System.out.println("[valores entre 0 y 100]");
		auxJug.setFuerza(control.controloCualidad(lectura.nextInt()));		
	}
	
	
	private void pedirVelocidad(JugadorMasculino auxJug) {
		System.out.println("Ingrese el nivel de velocidad: ");
		System.out.println("[valores entre 0 y 100]");
		auxJug.setVelocidad(control.controloCualidad(lectura.nextInt()));				
	}
	
	
	private void pedirTiempoReac(JugadorFemenino auxJug) {
		System.out.println("Ingrese el tiempo de reacción: ");
		System.out.println("[valores entre 0 y 100]");
		auxJug.settReaccion(control.controloCualidad(lectura.nextInt()));		
	}
	
	
}
