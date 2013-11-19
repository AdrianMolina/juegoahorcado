package juegoAhorcado;

import java.util.ArrayList;

public class Palabra {
	private String palabra;
	private String categoria;
	private ArrayList<String> pista = new ArrayList<String>();
	
	public void setPalabra(String palabra, String categoria){
		this.palabra = palabra;
		this.categoria = categoria;
	}
	
	public void setPista(String pista){
		this.pista.add(pista);
	}
	
	public String getPalabra(){
		return palabra;
	}
	
	public String getPista(){
		return pista.get(0);
	}
}
