package controller;

import java.util.ArrayList;
import java.util.HashSet;

import Interfaz.MostrarResultados;
import modelo.Jugador;
import modelo.JugadorFemenino;
import modelo.JugadorMasculino;

public class CalcularTorneo {
	//Instancio la clase que muestra los resultados
	MostrarResultados mostrarResultados = new MostrarResultados();

	public CalcularTorneo() {
		super();
	}

	//Método publico que resuelve el torneo 
	public void calcularTorneo(HashSet<Jugador> lista){
		ArrayList<Jugador> jugadoresRondaAct = new ArrayList<>(lista);
		ArrayList<Jugador> jugadoresRondaSig = new ArrayList<>();
	
		//En este punto tengo la lista actual de jugadores que me pasaron y si hay mas de 1
		//jugador procedo a calcular los partidos de a cuerdo al orden con el que se anotaron los jugadores
		//Los jugadores ganadores de cada partido se copian a la lista jugadores en ronda siguiente
		//A medida que transcurren los partidos se borran ambos jugadores de la lista actual
		while(jugadoresRondaAct.size()>1) {
			while(jugadoresRondaAct.size()>=2) {
				jugadoresRondaSig.add(juagada(jugadoresRondaAct.get(0),jugadoresRondaAct.get(1)));
				jugadoresRondaAct.remove(0);
				jugadoresRondaAct.remove(0);
			}
			jugadoresRondaAct = jugadoresRondaSig;
			jugadoresRondaSig = new ArrayList<>();
		}
		mostrarResultados.mostrarResultadoTorneo(jugadoresRondaAct.get(0));
	}
	
	//Este método calcula el ganador de un partido entre dos participantes masculinos
	private Jugador juagada(Jugador j1, Jugador j2){
		//La determinación del puntaje del jugador para el partido se realizo pensandando que el factor de suerte
		//afecte tanto en forma positiva, negativa o no afectar si la misma tiene valor medio de 50.
		if (j1.getPuntaje()>j1.getPuntaje()) {
				mostrarResultados.mostrarResultadoPartido(j1, j2, j1);
				return j1;
		}
		else {
			mostrarResultados.mostrarResultadoPartido(j1, j2, j2);
			return j2;
		}	
	}
	
	
}
