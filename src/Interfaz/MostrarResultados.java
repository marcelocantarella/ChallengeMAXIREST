package Interfaz;

import modelo.Jugador;

public class MostrarResultados {

	public MostrarResultados() {
		super();
	}
	
	public void mostrarEncabezado(int cantMasc, boolean tipo) {
	//Muestro torneo masculino y calculo el resultado
			System.out.println("***********************");
			if (tipo) 
				System.out.println("   Torneo Masculino  ");
			else
				System.out.println("   Torneo Femenino  ");
			System.out.println("Cantidad de participantes: " + cantMasc);
			System.out.println("***********************");
	}
			
	public void mostrarResultadoTorneo(Jugador j1) {
		System.out.println("***********************");
		System.out.println("Torneo ganado por jugador " + j1.getNombre() + " " + j1.getApellido());
		System.out.println("Nivel de habilidad: " + j1.getNivelHab());
		System.out.println("Nivel de suerte: " + j1.getSuerte());
		System.out.println("***********************");
	}
	
	public void mostrarResultadoPartido(Jugador j1, Jugador j2, Jugador g) {
		System.out.println("***********************");
		System.out.println("Partido entre jugador " + j1.getNombre() +" "+ j1.getApellido() + " y jugador " + j2.getNombre() +" "+ j2.getApellido());
		System.out.println("Ganador del partido jugador: " + g.getNombre() +" "+ g.getApellido());
	}
	

}
