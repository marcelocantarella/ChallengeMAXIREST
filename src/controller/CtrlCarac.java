package controller;

public class CtrlCarac {

	public CtrlCarac() {
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
	
	public boolean controloCadena(String cadena) {
		if (cadena.matches(("[0-9]+"))) {
			System.out.println("El campo no puede contener números. Vuelva a ingresarlo.");
			return false;
		}
		else
			return true;
	}
	
}
