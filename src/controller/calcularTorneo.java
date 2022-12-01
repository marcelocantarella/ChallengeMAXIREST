package controller;

import java.util.ArrayList;
import java.util.HashSet;

import Interfaz.mostrarResultados;
import modelo.jugadorFemenino;
import modelo.jugadorMasculino;

public class calcularTorneo {
	//Instancio la clase que muestra los resultados
	mostrarResultados mostrarResultados = new mostrarResultados();

	public calcularTorneo() {
		super();
	}

	//Método que calcula el torneo masculino
	public void calcularTorneoMasc(HashSet<jugadorMasculino> listaMasc) {
		ArrayList<jugadorMasculino> jugadoresRondaAct = new ArrayList<>(listaMasc);
		ArrayList<jugadorMasculino> jugadoresRondaSig = new ArrayList<>();

		//En este punto tengo la lista actual de jugadores que me pasaron y si hay mas de 1
		//jugador procedo a calcular los partidos de a cuerdo al orden con el que se anotaron los jugadores
		//Los jugadores ganadores de cada partido se copian a la lista jugadores en ronda siguiente
		//A medida que transcurren los partidos se borran ambos jugadores de la lista actual
		while(jugadoresRondaAct.size()>1) {
			while(jugadoresRondaAct.size()>=2) {
				jugadoresRondaSig.add(juagadaMasc(jugadoresRondaAct.get(0),jugadoresRondaAct.get(1)));
				jugadoresRondaAct.remove(0);
				jugadoresRondaAct.remove(0);
			}
			jugadoresRondaAct = jugadoresRondaSig;
			jugadoresRondaSig = new ArrayList<>();
		}
		mostrarResultados.mostrarResultadoTorneo(jugadoresRondaAct.get(0)); 
	}
	
	
	//Método que calcula el torneo masculino
	public void calcularTorneoFem(HashSet<jugadorFemenino> listaFem) {
		ArrayList<jugadorFemenino> jugadoresRondaAct = new ArrayList<>(listaFem);
		ArrayList<jugadorFemenino> jugadoresRondaSig = new ArrayList<>();

		while(jugadoresRondaAct.size()>1) {
			while(jugadoresRondaAct.size()>=2) {
				jugadoresRondaSig.add(juagadaFem(jugadoresRondaAct.get(0),jugadoresRondaAct.get(1)));
				jugadoresRondaAct.remove(0);
				jugadoresRondaAct.remove(0);
			}
			jugadoresRondaAct = jugadoresRondaSig;
			jugadoresRondaSig = new ArrayList<>();
		}
		mostrarResultados.mostrarResultadoTorneo(jugadoresRondaAct.get(0)); 
	}
	
	//Este método calcula el ganador de un partido entre dos participantes masculinos
	private jugadorMasculino juagadaMasc(jugadorMasculino j1, jugadorMasculino j2){
		int puntaje1 = (j1.getFuerza() + j1.getNivelHab() + j1.getVelocidad()) * (j1.getSuerte()/100);
		int puntaje2 = (j2.getFuerza() + j2.getNivelHab() + j2.getVelocidad()) * (j2.getSuerte()/100);
		if (puntaje1>puntaje2) {
			mostrarResultados.mostrarResultadoPartido(j1, j2, j1);
			return j1;
		}
		else {
			mostrarResultados.mostrarResultadoPartido(j1, j2, j2);
			return j2;
		}	
	}
	
	//Este método calcula el ganador de un partido entre dos participantes femeninos
	private jugadorFemenino juagadaFem(jugadorFemenino j1, jugadorFemenino j2){
		int puntaje1 = (j1.getNivelHab() + j1.gettReaccion()) * (j1.getSuerte()/100);
		int puntaje2 = (j2.getNivelHab() + j2.gettReaccion()) * (j2.getSuerte()/100);
		if (puntaje1>puntaje2) {
			mostrarResultados.mostrarResultadoPartido(j1, j2, j1);
			return j1;
		}
		else {
			mostrarResultados.mostrarResultadoPartido(j1, j2, j2);
			return j2;
		}		
	}
	
	
}
