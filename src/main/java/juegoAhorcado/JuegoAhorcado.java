package juegoAhorcado;

import java.util.ArrayList;

public class JuegoAhorcado {
	
	private Diccionario diccionario = new Diccionario(); //diccionario donde se van almacenando las palabras
	//variables donde se guarda la palabra actual (objeto y parseada) y la palabra donde se guardan los aciertos
	private String[] palabraActual; //palabra con la que se va comparando
	private ArrayList<String> palabraRespuesta = new ArrayList<String>(); //palabra donde se va almacenando los aciertos
	private Palabra palabraActualObjeto;
	//variables que se inicializan en el constructor depende del nivel
	private String nivel = ""; //se guarda el nivel del juego(basico,intemedio,avanzado)
	private int intentos = 0; //numero de intentos que le quedan la jugador para adivinar la palabra
	private int pistasPermitidas = 0; //limite de pistas permitidas
	
	private int pistasUsadas = 0; //nuemro de pistas usadas
	
	public JuegoAhorcado(){
	}
	
	public JuegoAhorcado(String nivel){
		diccionario.setPalabraEnDiccionario("casa", "categoria");
		diccionario.setPalabraEnDiccionario("pelota", "categoria");
		diccionario.setPalabraEnDiccionario("computadora", "categoria");
		diccionario.setPistaEnPalabra(diccionario.getPalabraObjeto(0), "lugar donde vives");
		diccionario.setPistaEnPalabra(diccionario.getPalabraObjeto(1), "es redonda");
		diccionario.setPistaEnPalabra(diccionario.getPalabraObjeto(2), "guarda archivos");
		inicializarPalabras();
		inicializarNivel(nivel);
	}
	
//SETS
	public void guardarPalabraEnDiccionario(String palabra){
		diccionario.setPalabraEnDiccionario(palabra, "categoria");
	}
	
//GETS	
	public String mostrarDiccionario(){
		return diccionario.getDiccionario();
	}
	
	public String getPista(){
		return pedirPista();
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
		return "Intentos restantes: "+intentos+"\n";
	}
	
	
	public String getPistasUsadas(){
		return "Pistas usadas: "+pistasUsadas+"/"+pistasPermitidas;
	}
	
	public int intentos(){ //esta funcion solo sirve para probar en consola 
		return intentos;
	}
	
//PRINCIPAL	
	public String jugar(String letra){
		if(letra == null){
			return "Esperando a que ingrese una letra";
		}
		else{
			String mensaje = ingresarLetra(letra);
			return mensaje+"\n";
		}
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
	
//INICIALIZADORES
	private void inicializarPalabras(){
		int num = (int) (Math.random() * diccionario.getTamanio());
		palabraActual = diccionario.getPalabra(num).split("");
		palabraActualObjeto = diccionario.getPalabraObjeto(num);
		for(int i=1; i<palabraActual.length; i++){
			palabraRespuesta.add("_");
		}
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
	
//MEOTODOS PRIVADOS(extract methods)
	private boolean pistasAgotadas() {
		return pistasUsadas < pistasPermitidas;
	}
	
	private String pedirPista() {
		if(pistasAgotadas()){
			pistasUsadas++;
			return diccionario.getPistaPalabraEspecifica(palabraActualObjeto)+"\n";
		}
		else{
			return "Se agoto el numero de pistas";
		}
	}
}
