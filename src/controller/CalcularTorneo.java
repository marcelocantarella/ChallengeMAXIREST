package controller;

import java.util.ArrayList;
import java.util.HashSet;

import Interfaz.MostrarResultados;
import modelo.JugadorFemenino;
import modelo.JugadorMasculino;

public class CalcularTorneo {
	//Instancio la clase que muestra los resultados
	MostrarResultados mostrarResultados = new MostrarResultados();

	public CalcularTorneo() {
		super();
	}

	//Método que calcula el torneo masculino
	public void calcularTorneoMasc(HashSet<JugadorMasculino> listaMasc) {
		ArrayList<JugadorMasculino> jugadoresRondaAct = new ArrayList<>(listaMasc);
		ArrayList<JugadorMasculino> jugadoresRondaSig = new ArrayList<>();

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
	
	//Método que calcula el torneo femenino
	public void calcularTorneoFem(HashSet<JugadorFemenino> listaFem) {
		ArrayList<JugadorFemenino> jugadoresRondaAct = new ArrayList<>(listaFem);
		ArrayList<JugadorFemenino> jugadoresRondaSig = new ArrayList<>();

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
	private JugadorMasculino juagadaMasc(JugadorMasculino j1, JugadorMasculino j2){
		//La determinación del puntaje del jugador para el partido se realizo pensandando que el factor de suerte
		//afecte tanto en forma positiva, negativa o no afectar si la misma tiene valor medio de 50.
		int puntaje1 = (j1.getFuerza() + j1.getNivelHab() + j1.getVelocidad()) * (j1.getSuerte()/50);
		int puntaje2 = (j2.getFuerza() + j2.getNivelHab() + j2.getVelocidad()) * (j2.getSuerte()/50);
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
	private JugadorFemenino juagadaFem(JugadorFemenino j1, JugadorFemenino j2){
		//La determinación del puntaje del jugador para el partido se realizo pensandando que el factor de suerte
		//afecte tanto en forma positiva, negativa o no afectar si la misma tiene valor medio de 50.
		int puntaje1 = (j1.getNivelHab() + j1.gettReaccion()) * (j1.getSuerte()/50);
		int puntaje2 = (j2.getNivelHab() + j2.gettReaccion()) * (j2.getSuerte()/50);
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
