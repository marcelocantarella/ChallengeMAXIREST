package Interfaz;
import java.util.HashSet;
import java.util.Scanner;
import controller.CalcularTorneo;
import modelo.Jugador;



public class JugarTorneo {
	
		static HashSet<Jugador> listaMasculina = new HashSet<>();
		static HashSet<Jugador> listaFemenina = new HashSet<>();	
		static AltaJugadores altaJugad = new AltaJugadores();
		static Scanner lectura = new Scanner (System.in);
		
		
	public static void main(String[] args) {
		CalcularTorneo calcularTorneo = new CalcularTorneo();
		MostrarResultados mostrarResultados = new MostrarResultados();
		boolean flagPidoOtroJugador = true;
		
		System.out.println("Bienvenido al torneo de tenis");
		System.out.println("Vamos a proceder a cargar los jugadores masculinos");
		
		do {
			agregoJugador();
			if (!((listaMasculina.size()%2) > 0) && !((listaFemenina.size()%2) > 0)){
				System.out.println("¿Desea agregar otros 2 jugadores? ");
				System.out.println("Ingrese 'y'/si ó 'n'/no");
				flagPidoOtroJugador = false;
			}	
		}while(flagPidoOtroJugador || (lectura.next().equals("y")));					
			
		//Cierro la lectura del teclado
		lectura.close();

		
		if(!listaMasculina.isEmpty()) {
			mostrarResultados.mostrarEncabezado(listaMasculina.size(), true);
			calcularTorneo.calcularTorneo(listaMasculina);
		}
		else
			System.out.println("No hubo torneo masculino");
		
		
		if(!listaFemenina.isEmpty()) {
			mostrarResultados.mostrarEncabezado(listaFemenina.size(), false);
			calcularTorneo.calcularTorneo(listaFemenina);
		}else
			System.out.println("No hubo torneo femenino");		
	}
	
	
	static private void agregoJugador() {
		Jugador auxJugador = altaJugad.crearJugador();
		
		if (auxJugador.getClass().getCanonicalName().equals("modelo.JugadorFemenino")) {
			if(!listaMasculina.add(auxJugador)) {
				System.out.println("Esta jugadora ya existe.");
			}else
				System.out.println("La jugadora femenina fue agregada.");
		}else if (auxJugador.getClass().getCanonicalName().equals("modelo.JugadorMasculino")) {
			if(!listaFemenina.add(auxJugador)) {
				System.out.println("Este jugador ya existe.");
			}
			else
				System.out.println("El jugador masculino fue agregado.");
		}
	}
	

}
