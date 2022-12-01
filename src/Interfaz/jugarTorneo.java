package Interfaz;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

import controller.calcularTorneo;
import controller.casteoCarac;
import modelo.jugadorFemenino;
import modelo.jugadorMasculino;
public class jugarTorneo {

	public static void main(String[] args) {
		jugadorMasculino auxMasc = new jugadorMasculino();
		jugadorFemenino auxFem = new jugadorFemenino();
		HashSet<jugadorMasculino> listaMasculina = new HashSet<>();
		HashSet<jugadorFemenino> listaFemenina = new HashSet<>();	
		calcularTorneo calcularTorneo = new calcularTorneo();
		casteoCarac comp = new casteoCarac();
		int cantMasc = 0;
		int cantFem = 0;
		//Creo el objeto que leera del teclado
		Scanner lectura = new Scanner (System.in);
		
		
		
		
		System.out.println("Bienvenido al torneo de tenis");
		System.out.println("Vamos a proceder a cargar los jugadores masculinos");
		do {
			//Pido todos los parametros del nuevo jugador masculino
			cantMasc++;
			System.out.println("******Nuevo jugador******");
			System.out.println("Jugador num: " + cantMasc);
			System.out.println("Ingrese el nombre: ");
			auxMasc.setNombre(lectura.next());
			System.out.println("Ingrese el apellido: ");
			auxMasc.setApellido(lectura.next());
			System.out.println("Ingrese el nivel de hab: ");
			System.out.println("[valores entre 0 y 100]");
			auxMasc.setNivelHab(comp.controloCualidad(lectura.nextInt()));			
			System.out.println("Ingrese el nivel de fuerza: ");
			System.out.println("[valores entre 0 y 100]");
			auxMasc.setFuerza(comp.controloCualidad(lectura.nextInt()));			
			System.out.println("Ingrese el nivel de velocidad: ");
			System.out.println("[valores entre 0 y 100]");
			auxMasc.setVelocidad(comp.controloCualidad(lectura.nextInt()));			
			//Agrego el nuevo jugador a la lista masculina
			//Si existe otra jugadora con el mismo nombre y habilidad, no se agrega
			if(!listaMasculina.add(auxMasc)) {
				cantMasc--;
				System.out.println("Este jugador ya existe.");
			}
			auxMasc = new jugadorMasculino();
			if(!((cantMasc%2) > 0)){
				System.out.println("¿Desea agregar otros 2 jugadores? ");
				System.out.println("Ingrese 'y'/si ó 'n'/no");
			}
		}while((cantMasc%2) > 0 || (lectura.next().equals("y")));					
			
		System.out.println("Vamos a proceder a cargar las jugadoras femeninas");	
		do {
			//Pido todos los parametros del nuevo jugador femenino
			cantFem++;
			System.out.println("******Nuevo jugadora******");
			System.out.println("Jugador num: " + cantFem);
			System.out.println("Ingrese el nombre: ");
			auxFem.setNombre(lectura.next());
			System.out.println("Ingrese el apellido: ");
			auxFem.setApellido(lectura.next());
			System.out.println("Ingrese el nivel de hab: ");
			System.out.println("[valores entre 0 y 100]");
			auxFem.setNivelHab(comp.controloCualidad(lectura.nextInt()));					
			System.out.println("Ingrese el tiempo de reacción: ");
			System.out.println("[valores entre 0 y 100]");
			auxFem.settReaccion(comp.controloCualidad(lectura.nextInt()));					
			//Agrego el nuevo jugador a la lista femenino
			//Si existe otra jugadora con el mismo nombre y habilidad, no se agrega
			if(!listaFemenina.add(auxFem)) {
				cantFem--;
				System.out.println("Esta jugadora ya existe.");
			}
			auxFem = new jugadorFemenino();
			if(!((cantFem%2) > 0)) {
				System.out.println("¿Desea agregar otros 2 jugadoras? ");
				System.out.println("Ingrese 'y'/si ó 'n'/no");
			}
		}while((cantFem%2) > 0 || (lectura.next().equals("y")));	
		//Cierro la lectura del teclado
		lectura.close();
		
		//Muestro torneo masculino y calculo el resultado
		System.out.println("***********************");
		System.out.println("   Torneo Masculino  ");
		System.out.println("Cantidad de participantes: " + cantMasc);
		System.out.println("***********************");
		calcularTorneo.calcularTorneoMasc(listaMasculina);
		
		//Muestro torneo femenino y calculo el resultado
		System.out.println("***********************");
		System.out.println("   Torneo Femenino   ");
		System.out.println("Cantidad de participantes: " + cantFem);
		System.out.println("***********************");
		calcularTorneo.calcularTorneoFem(listaFemenina);
	}
	

}
