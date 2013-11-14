package juegoAhorcado;

public class JuegoAhorcado {
	
	public String letra_predeterminada = "a";
	
	public String ingresarLetra(String letra) {
		if (verificarLetra(letra))
			return letra;
		else
			return "Error, letra incorrecta";
	}

	public boolean verificarLetra(String letra) {
		return letra_predeterminada == letra;
	}
	
	public String jugar(String letra){
		String resultado = "";
		resultado = ingresarLetra(letra);
		return resultado;
	}
}
