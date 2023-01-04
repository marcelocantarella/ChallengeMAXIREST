package Interfaz;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import controller.CalcularTorneo;
import controller.CtrlCarac;
import modelo.Jugador;
import modelo.JugadorFemenino;
import modelo.JugadorMasculino;


public class JugarTorneo {
	
		static int cantMasc = 0;
		static int cantFem = 0;
		static HashSet<Jugador> listaMasculina = new HashSet<>();
		static HashSet<Jugador> listaFemenina = new HashSet<>();	
		static CargarJugadores carga = new CargarJugadores();
		static Scanner lectura = new Scanner (System.in);
		
		
	public static void main(String[] args) {
		CalcularTorneo calcularTorneo = new CalcularTorneo();
		CtrlCarac comp = new CtrlCarac();
		MostrarResultados mostrarResultados = new MostrarResultados();
		
		System.out.println("Bienvenido al torneo de tenis");
		System.out.println("Vamos a proceder a cargar los jugadores masculinos");
		
		do {
			System.out.println("¿Desea agregar un jugador masculino o femenino? ");
			System.out.println("Ingrese 'm'/masculino ó 'f'/femenino");
			if(lectura.next().equals("m")) {
				cantMasc++;
				agregoJugadorMasc();
			} else if(lectura.next().equals("f")) {
				cantFem++;
				agregoJugadorFem();
			}
		}while(((cantMasc%2) > 0 && (cantFem%2) > 0) || (lectura.next().equals("y")));					
			
		//Cierro la lectura del teclado
		lectura.close();

		mostrarResultados.mostrarEncabezado(listaMasculina.size(), true);
		calcularTorneo.calcularTorneo(listaMasculina);
		
		mostrarResultados.mostrarEncabezado(listaFemenina.size(), true);
		calcularTorneo.calcularTorneo(listaFemenina);
		
	}
	
	
	static private void agregoJugadorMasc() {
		//Agrego el nuevo jugador a la lista masculina
		//Si existe otra jugadora con el mismo nombre y habilidad, no se agrega
		
		if(!listaMasculina.add(carga.cargarNuevoJugador(cantMasc, true) )) {
			cantMasc--;
			System.out.println("Este jugador ya existe.");
		}
		
		if(!((cantMasc%2) > 0)){
			System.out.println("¿Desea agregar otros 2 jugadores? ");
			System.out.println("Ingrese 'y'/si ó 'n'/no");
		}
	}
	
	static private void agregoJugadorFem() {
		//Agrego el nuevo jugador a la lista femenino
		//Si existe otra jugadora con el mismo nombre y habilidad, no se agrega
		if(!listaFemenina.add(carga.cargarNuevoJugador(cantFem, false))) {
			cantFem--;
			System.out.println("Esta jugadora ya existe.");
		}
		if(!((cantFem%2) > 0)) {
			System.out.println("¿Desea agregar otros 2 jugadoras? ");
			System.out.println("Ingrese 'y'/si ó 'n'/no");
		}
	}
	
	
	

}
