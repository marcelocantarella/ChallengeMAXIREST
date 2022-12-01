package controller;

public class casteoCarac {

	public casteoCarac() {
		super();
	}
	
	public int controloCualidad(int cualidad) {
		//En el caso de que el usuario ingrese un valores fuera de rango
		//se modifica automaticamente al limite correspondiente, sin avisar
		if(cualidad > 100)
			return 100;
		else if (cualidad < 0)
			return 0;
		else
			return cualidad;
	}
	
}
