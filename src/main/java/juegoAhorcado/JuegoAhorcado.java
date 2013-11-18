package juegoAhorcado;

import java.util.ArrayList;

public class JuegoAhorcado {
	
	private ArrayList<String> diccionario = new ArrayList<String>(); //diccionario donde se van almacenando las palabras
	private ArrayList<String> pistas = new ArrayList<String>(); //Variable donde se almacenan las pistas
	private String[] palabraActual; //palabra con la que se va comparando
	private ArrayList<String> palabraRespuesta = new ArrayList<String>(); //palabra donde se va almacenando los aciertos
	private String nivel = ""; //se guarda el nivel del juego(basico,intemedio,avanzado)
	private int intentos = 0; //numero de intentos que le quedan la jugador para adivinar la palabra
	private int pistasUsadas = 0; //nuemro de pistas usadas
	private int pistasPermitidas = 0; //limite de pistas permitidas
	private int posicionPalabra = 0; //numero de la posicion en la que se encuentra la palabra en el diccionario
	
	public JuegoAhorcado(){
	}
	
	public JuegoAhorcado(String nivel){
		diccionario.add("casa");
		diccionario.add("pelota");
		diccionario.add("computadora");
		pistas.add("lugar donde vives");
		pistas.add("es redonda");
		pistas.add("guarda archivos");
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
	
	public int intentos(){ //esta funcion solo sirve para probar en consola 
		return intentos;
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
	
	public String getPista(){
		if(pistasUsadas <= pistasPermitidas){
			pistasUsadas++;
			return pistas.get(posicionPalabra)+"\n";
		}
		else{
			return "Se agoto el numero de pistas";
		}
	}
	
	public String getPistasUsadas(){
		return "Pistas: "+pistasUsadas+"/"+pistasPermitidas;
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
		posicionPalabra = num;
	}
	
	private void inicializarNivel(String nivelIngresado){
		if(nivelIngresado.equals("Basico")){
	           nivel = nivel + nivelIngresado;
	           intentos = 6;
	           pistasPermitidas = 3;
		}
	    if(nivelIngresado.equals("Intermedio")){
	    	   nivel = nivel + "Intermedio";
	           intentos = 4;
	           pistasPermitidas = 2;
	    }
	    if(nivelIngresado.equals("Avanzado")){
	    	   nivel = nivel + "Avanzado";
	           intentos = 2;
	           pistasPermitidas = 1;
	    }
	}
//FIN_INICIALIZADORES
}
