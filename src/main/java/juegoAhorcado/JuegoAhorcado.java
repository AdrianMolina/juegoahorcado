package juegoAhorcado;

import java.util.ArrayList;

public class JuegoAhorcado {
	
	private ArrayList<String> diccionario = new ArrayList<String>();
	private String[] palabraActual;
	private ArrayList<String> palabraRespuesta = new ArrayList<String>();
	private String nivel = "";
	private int intentos = 0;
	
	public JuegoAhorcado(){
	}
	
	public JuegoAhorcado(String nivel){
		diccionario.add("casa");
		diccionario.add("pelota");
		diccionario.add("computadora");
		inicializarPalabras();
		inicializarNivel(nivel);
	}
	
//GETS	
	public String getDiccionario(){
		String dicc = "";
		for(int i=0; i<diccionario.size(); i++){
			dicc = dicc + diccionario.get(i) + ", ";
		}
		return dicc;
	}
	
	/*public void mostrarPalabraActual(){
		for(int i=1; i<palabraActual.length; i++){
			System.out.println(palabraActual[i]);
		}
	}*/

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
//FIN_GETS
	
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
	
	public void guardarPalabraEnDiccionario(String palabra){
		diccionario.add(palabra);
	}
	
//PRINCIPAL	
	public String jugar(String letra){
		String mensaje = ingresarLetra(letra);
		return mensaje+"\n";
	}
	
//INICIALIZADORES
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
//FIN_INICIALIZADORES
}
