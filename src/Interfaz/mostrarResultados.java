package Interfaz;

import modelo.Jugador;

public class mostrarResultados {

	public mostrarResultados() {
		super();
	}
	
	public void mostrarResultadoTorneo(Jugador j1) {
		System.out.println("Torneo ganado por jugador " + j1.getNombre() + " " + j1.getApellido());
	}
	
	public void mostrarResultadoPartido(Jugador j1, Jugador j2,Jugador g) {
		System.out.println("Partido entre jugador " + j1.getNombre() +" "+ j1.getApellido() + "+" + j2.getNombre() +" "+ j2.getApellido());
		System.out.println("Ganador del partido jugador: " + g.getNombre() +" "+ g.getApellido());
	}
	

}
