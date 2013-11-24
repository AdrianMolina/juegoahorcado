package juegoAhorcado;

import java.util.ArrayList;

public class Diccionario {
	private ArrayList<Palabra> diccionario = new ArrayList<Palabra>();
	
	public void setPalabraEnDiccionario(String palabra, String categoria){
		Palabra p = new Palabra();
		p.setPalabra(palabra, categoria);
		diccionario.add(p);
	}
	
	public void setPistaEnPalabra(Palabra palabra, String pista){
		int puntero = diccionario.indexOf(palabra);
		Palabra p = diccionario.get(puntero);
		p.setPista(pista);
	}
	
	public String getDiccionario(){
		String dic = "";
		for(int i=0; i<diccionario.size(); i++){
			dic = dic + diccionario.get(i).getPalabra() + ", ";
		}
		return dic;
	}
	
	public String getPalabra(int posicion){
		Palabra p = diccionario.get(posicion);
		return p.getPalabra();
	}
	
	public String getPistaPalabraEspecifica(Palabra palabra){
		int puntero = diccionario.indexOf(palabra);
		Palabra p = diccionario.get(puntero);
		return p.getPista();
	}
	
	public int getTamanio(){
		return diccionario.size();
	}
	
	public Palabra getPalabraObjeto(int posicion){
		return diccionario.get(posicion);
	}
	
	public char getPistaDeLetra(Palabra palabra){
		String p = palabra.getPalabra();
		int num = (int) (Math.random() * p.length());
		return p.charAt(num);
	}
}
