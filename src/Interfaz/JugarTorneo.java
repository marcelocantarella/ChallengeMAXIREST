package Interfaz;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import controller.CalcularTorneo;
import controller.CtrlCarac;
import modelo.Jugador;
import modelo.JugadorFemenino;
import modelo.JugadorMasculino;
import modelo.TipoJugador;

public class JugarTorneo {
	
		static int cantMasc = 0;
		static int cantFem = 0;
		static HashSet<Jugador> listaMasculina = new HashSet<>();
		static HashSet<Jugador> listaFemenina = new HashSet<>();	
		static CargarJugadores carga = new CargarJugadores();
		static Scanner lectura = new Scanner (System.in);
		
		
	public static void main(String[] args) {
		CalcularTorneo calcularTorneo = new CalcularTorneo();
		MostrarResultados mostrarResultados = new MostrarResultados();
		boolean flagPidoOtroJugador = true;
		
		System.out.println("Bienvenido al torneo de tenis");
		System.out.println("Vamos a proceder a cargar los jugadores masculinos");
		
		do {
			System.out.println("¿Desea agregar un jugador masculino o femenino? ");
			System.out.println("Ingrese 'm'/masculino ó 'f'/femenino");
			switch(lectura.next()) {
				case "m":
					agregoJugadorMasc();
					break;
				case"f":
					agregoJugadorFem();
					break;
				default:	
					System.out.println("El comando ingresado no es valido");
					break;
			}
			if (!((cantMasc%2) > 0) && !((cantFem%2) > 0)){
				System.out.println("¿Desea agregar otros 2 jugadores? ");
				System.out.println("Ingrese 'y'/si ó 'n'/no");
				flagPidoOtroJugador = false;
			}	
		}while(flagPidoOtroJugador || (lectura.next().equals("y")));					
			
		//Cierro la lectura del teclado
		lectura.close();

		mostrarResultados.mostrarEncabezado(listaMasculina.size(), true);
		calcularTorneo.calcularTorneo(listaMasculina);
		
		mostrarResultados.mostrarEncabezado(listaFemenina.size(), false);
		calcularTorneo.calcularTorneo(listaFemenina);
		
	}
	
	static private void agregoJugadorMasc() {
		//Agrego el nuevo jugador a la lista masculina
		//Si existe otra jugadora con el mismo nombre y habilidad, no se agrega
		cantMasc++;
		if(!listaMasculina.add(carga.cargarNuevoJugador(cantMasc, TipoJugador.valueOf("MASCULINO")) )) {
			cantMasc--;
			System.out.println("Este jugador ya existe.");
		}
	}
	
	static private void agregoJugadorFem() {
		//Agrego el nuevo jugador a la lista femenino
		//Si existe otra jugadora con el mismo nombre y habilidad, no se agrega
		cantFem++;
		if(!listaFemenina.add(carga.cargarNuevoJugador(cantFem, TipoJugador.valueOf("FEMENINO")))) {
			cantFem--;
			System.out.println("Esta jugadora ya existe.");
		}
	}

}
