package juegoAhorcado;

import java.util.ArrayList;

public class JuegoAhorcado {
	
	private ArrayList<String> diccionario = new ArrayList<String>();
	private String[] palabraActual;
	private ArrayList<String> palabraRespuesta = new ArrayList<String>();
	private String nivel = "";
	private int intentos = 0;
	
	public JuegoAhorcado(){
		diccionario.add("casa");
		diccionario.add("pelota");
		diccionario.add("computadora");
		inicializarPalabras();
	}
	
	public void mostrarDiccionario(){
		for(int i=0; i<diccionario.size(); i++){
			System.out.println(diccionario.get(i));
		}
	}
	
	public void mostrarPalabraActual(){
		for(int i=1; i<palabraActual.length; i++){
			System.out.println(palabraActual[i]);
		}
	}

	public String mostrarRespuesta(){
		String resp = "";
		for(int i=0; i<palabraRespuesta.size(); i++){
			resp = resp + palabraRespuesta.get(i) + " ";
		}
		return resp+"\n";
	}
	
	public String getNivel(){
		return "Nivel: "+nivel+"\n";
	}
	
	public String getIntentos(){
		return "Intentos: "+intentos+"\n";
	}
	
	public String ingresarLetra(String letra) {
		if (verificarLetra(letra))
			return "letra correcta";
		else
			intentos--;
			return "Error, letra incorrecta";
	}

	public boolean verificarLetra(String letra) {
		int verificacion = 0;
		for(int i=1; i<palabraActual.length; i++){
			if(palabraActual[i].equals(letra)){
				palabraRespuesta.set(i-1,letra);
				palabraActual[i] = "_";
				verificacion++;
			}
		}
		return verificacion != 0;
	}
	
	public String jugar(String letra, String nivelIngresado){
		inicializarNivel(nivelIngresado);
		String mensaje = ingresarLetra(letra);
		return mensaje+"\n";
	}
	
	private void inicializarPalabras(){
		int num = (int) (Math.random() * diccionario.size());
		palabraActual = diccionario.get(num).split("");
		for(int i=1; i<palabraActual.length; i++){
			palabraRespuesta.add("_");
		}
	}
	
	private void inicializarNivel(String nivelIngresado){
		if(nivelIngresado.equals("Basico")){
	           nivel = nivel + nivelIngresado;
	           intentos = 6;
		}
	    if(nivelIngresado.equals("Intermedio")){
	    	   nivel = nivel + "Intermedio";
	           intentos = 4;
	    }
	    if(nivelIngresado.equals("Avanzado")){
	    	   nivel = nivel + "Avanzado";
	           intentos = 2;
	    }
	}
}
