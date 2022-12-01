package Interfaz;
import java.util.HashSet;
import java.util.Scanner;

import controller.calcularTorneo;
import modelo.jugadorFemenino;
import modelo.jugadorMasculino;
public class jugarTorneo {

	public static void main(String[] args) {
		jugadorMasculino auxMasc = new jugadorMasculino();
		jugadorFemenino auxFem = new jugadorFemenino();
		HashSet<jugadorMasculino> listaMasculina = new HashSet<>();
		HashSet<jugadorFemenino> listaFemenina = new HashSet<>();	
		calcularTorneo calcularTorneo = new calcularTorneo();
		int cantMasc = 0;
		int cantFem = 0;
		//Creo el objeto que leera del teclado
		Scanner lectura = new Scanner (System.in);
		
		do {
			//Pido todos los parametros del nuevo jugador masculino
			cantMasc++;
			System.out.println("Bienvenido al torneo de tenis");
			System.out.println("Vamos a proceder a cargar los jugadores masculinos");
			System.out.println("Jugador num: " + cantMasc);
			System.out.println("Ingrese el nombre: ");
			auxMasc.setNombre(lectura.next());
			System.out.println("Ingrese el apellido: ");
			auxMasc.setApellido(lectura.next());
			System.out.println("Ingrese el nivel de hab: ");
			auxMasc.setNivelHab(lectura.nextInt());
			System.out.println("Ingrese el nivel de fuerza: ");
			auxMasc.setFuerza(lectura.nextInt());
			System.out.println("Ingrese el nivel de velocidad: ");
			auxMasc.setVelocidad(lectura.nextInt());
			//Agrego el nuevo jugador a la lista masculina
			listaMasculina.add(auxMasc);
			auxMasc = new jugadorMasculino();
			System.out.println("¿Desea agregar otro jugador? ");
			System.out.println("Ingrese y/si ó n/no");
		}while((lectura.next().equals("y")));
			
			
		do {
			//Pido todos los parametros del nuevo jugador femenino
			cantFem++;
			System.out.println("Vamos a proceder a cargar los jugadores femeninos");
			System.out.println("Jugador num: " + cantFem);
			System.out.println("Ingrese el nombre: ");
			auxFem.setNombre(lectura.next());
			System.out.println("Ingrese el apellido: ");
			auxFem.setApellido(lectura.next());
			System.out.println("Ingrese el nivel de hab: ");
			auxFem.setNivelHab(lectura.nextInt());
			System.out.println("Ingrese el nivel de fuerza: ");
			auxFem.settReaccion(lectura.nextInt());
			//Agrego el nuevo jugador a la lista femenino
			listaFemenina.add(auxFem);
			auxFem = new jugadorFemenino();
			System.out.println("¿Desea agregar otro jugador? ");
			System.out.println("Ingrese y/si ó n/no");
		}while((lectura.next().equals("y")));	
		
		lectura.close();
		
		calcularTorneo.calcularTorneoMasc(listaMasculina);
		calcularTorneo.calcularTorneoFem(listaFemenina);
	}

}
