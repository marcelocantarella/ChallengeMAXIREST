package Interfaz;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import controller.CalcularTorneo;
import controller.CtrlCarac;
import modelo.JugadorFemenino;
import modelo.JugadorMasculino;


public class JugarTorneo {

	public static void main(String[] args) {

		HashSet<JugadorMasculino> listaMasculina = new HashSet<>();
		HashSet<JugadorFemenino> listaFemenina = new HashSet<>();	
		CargarJugadores carga = new CargarJugadores();
		Scanner lectura = new Scanner (System.in);
		CalcularTorneo calcularTorneo = new CalcularTorneo();
		CtrlCarac comp = new CtrlCarac();
		int cantMasc = 0;
		int cantFem = 0;
	
		
		System.out.println("Bienvenido al torneo de tenis");
		System.out.println("Vamos a proceder a cargar los jugadores masculinos");
		do {
			System.out.println("¿Desea agregar un jugador masculino o femenino? ");
			System.out.println("Ingrese 'm'/masculino ó 'f'/femenino");
			cantMasc++;
			//Agrego el nuevo jugador a la lista masculina
			//Si existe otra jugadora con el mismo nombre y habilidad, no se agrega
			if(!listaMasculina.add(carga.cargarNuevoJugador(cantMasc, true))) {
				cantMasc--;
				System.out.println("Este jugador ya existe.");
			}
			
			if(!((cantMasc%2) > 0)){
				System.out.println("¿Desea agregar otros 2 jugadores? ");
				System.out.println("Ingrese 'y'/si ó 'n'/no");
			}
		}while(((cantMasc%2) > 0 && (cantFem%2) > 0) || (lectura.next().equals("y")));					
			

		
		do {
					
						
			//Agrego el nuevo jugador a la lista femenino
			//Si existe otra jugadora con el mismo nombre y habilidad, no se agrega
			if(!listaFemenina.add(auxFem)) {
				cantFem--;
				System.out.println("Esta jugadora ya existe.");
			}
			auxFem = new JugadorFemenino();
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
