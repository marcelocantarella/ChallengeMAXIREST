package modelo;

public enum TipoJugador {
	
	MASCULINO("m"), FEMENINO("f");
	
	private String letraIdent;
	
	private TipoJugador(String letra) {
		letraIdent = letra;
	}
	
	public String getLetra() {
		return letraIdent;
	}
	
}
