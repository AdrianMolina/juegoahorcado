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
	private String letrasUsadas = "";
	private int intentos = 0; //numero de intentos que le quedan la jugador para adivinar la palabra
	private int aciertos = 0;
	private int tamanioPalabra;
	private int pistasPermitidas = 0; //limite de pistas permitidas
	private int pistasUsadas = 0; //nuemro de pistas usadas
	private int tiempo;
	
	public JuegoAhorcado(){
	}
	
	public JuegoAhorcado(String nivel){
		//inicializarDiccionario();
		//inicializarPalabras();
		//inicializarNivel(nivel);
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
	
	public String getPistaLetra(){
		return pedirPistaDeLetra();
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
	
	public String letrasUtilizadas(){
		return "Letras usadas: " + letrasUsadas;
	}
	
	public int getTiempoRestante(){
		return tiempo;
	}
	
	public String printTiempo(){
		return "" + tiempo;
	}

//DIBUJAR MUÑECO
	public String dibujarMuneco(){
		String m = "";
		if(nivel.equals("Basico")){
			m = munecoBasico();
		}
		if(nivel.equals("Intermedio")){
			m = munecoIntermedio();
		}
		if(nivel.equalsIgnoreCase("Avanzado")){
			m = munecoAvanzado();
		}
		return m;
	}
	
//RELOJ
	public void reducirTiempo(int sec){
		tiempo = tiempo - sec;
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
		if(aciertos != tamanioPalabra){
			if (intentos > 0){
				if (verificarLetra(letra)){
					return "letra correcta";
				}
				else{
					intentos--;
					return "Error, letra incorrecta";
				}
			}
			else{
				return "PERDIO!!!";
			}
		}
		else{
			return "GANO!!!!";
		}
	}

	public boolean verificarLetra(String letra) {
		int verificacion = 0;
		letrasUsadas = letrasUsadas + letra + " ";
		for(int i=1; i<palabraActual.length; i++){
			if(palabraActual[i].equals(letra)){
				palabraRespuesta.set(i-1,letra);
				palabraActual[i] = "_";
				verificacion++;
				aciertos++;
			}
		}
		return verificacion != 0;
	}
	
//INICIALIZADORES
	public void inicializarJuego(String nivel){
		reiniciarDatos();
		inicializarDiccionario();
		inicializarPalabras();
		inicializarNivel(nivel);
	}
	
	public void inicializarTiempo(){
		tiempo = 60;
	}
	
	private void inicializarDiccionario(){
		diccionario.setPalabraEnDiccionario("casa", "categoria");
		diccionario.setPalabraEnDiccionario("pelota", "categoria");
		diccionario.setPalabraEnDiccionario("computadora", "categoria");
		diccionario.setPalabraEnDiccionario("cacatua", "animales");
		diccionario.setPalabraEnDiccionario("gato", "animales");
		diccionario.setPalabraEnDiccionario("caballo", "animales");
		diccionario.setPalabraEnDiccionario("arbol", "categoria");
		diccionario.setPalabraEnDiccionario("mesa", "categoria");
		diccionario.setPalabraEnDiccionario("celular", "categoria");
		diccionario.setPistaEnPalabra(diccionario.getPalabraObjeto(0), "lugar donde vives");
		diccionario.setPistaEnPalabra(diccionario.getPalabraObjeto(1), "es redonda");
		diccionario.setPistaEnPalabra(diccionario.getPalabraObjeto(2), "guarda archivos");
		diccionario.setPistaEnPalabra(diccionario.getPalabraObjeto(3), "tiene alas");
		diccionario.setPistaEnPalabra(diccionario.getPalabraObjeto(4), "maulla");
		diccionario.setPistaEnPalabra(diccionario.getPalabraObjeto(5), "relincha");
		diccionario.setPistaEnPalabra(diccionario.getPalabraObjeto(6), "vive en la tierra");
		diccionario.setPistaEnPalabra(diccionario.getPalabraObjeto(7), "tiene cuantro patas");
		diccionario.setPistaEnPalabra(diccionario.getPalabraObjeto(8), "tiene antena");
	}
	private void inicializarPalabras(){
		int num = (int) (Math.random() * diccionario.getTamanio());
		palabraActual = diccionario.getPalabra(num).split("");
		palabraActualObjeto = diccionario.getPalabraObjeto(num);
		for(int i=1; i<palabraActual.length; i++){
			palabraRespuesta.add("_");
		}
		tamanioPalabra = palabraActual.length - 1;
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
	
	private void reiniciarDatos(){
		nivel = "";
		intentos = 0;
		aciertos = 0;
		pistasPermitidas = 0;
		pistasUsadas = 0;
		letrasUsadas = "";
		diccionario = new Diccionario();
		palabraRespuesta = new ArrayList<String>();
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
	
	private String pedirPistaDeLetra(){
		if(pistasAgotadas()){
			pistasUsadas++;
			return Character.toString(diccionario.getPistaDeLetra(palabraActualObjeto));
		}
		else{
			return "se agoto el numero de pistas";
		}
	}
	
	private String munecoBasico(){
		String muneco = "";
		if(intentos == 5){
			muneco = muneco + "    O    ";
		}
		if(intentos == 4){
			muneco = muneco + "    O  <BR>"+
							  "   /   <BR>";
		}
		if(intentos == 3){
			muneco = muneco + "    O   <BR>"+
							  "   /|   <BR>";
		}
		if(intentos == 2){
			muneco = muneco + "    O   <BR>"+
							  "   /|\\ <BR>";
		}
		if(intentos == 1){
			muneco = muneco + "    O   <BR>"+
							  "   /|\\ <BR>"+
							  "   /      ";
		}
		if(intentos == 0){
			muneco = muneco + "    O   <BR>"+
							  "   /|\\ <BR>"+
							  "   / \\   ";
		}
		return muneco;
	}
	
	private String munecoIntermedio(){
		String muneco = "";
		if(intentos == 3){
			muneco = muneco + "    O   <BR>"+
							  "   /    <BR>";
		}
		if(intentos == 2){
			muneco = muneco + "    O   <BR>"+
							  "   /|\\ <BR>";
		}
		if(intentos == 1){
			muneco = muneco + "    O   <BR>"+
							  "   /|\\ <BR>"+
							  "   /      ";
		}
		if(intentos == 0){
			muneco = muneco + "    O   <BR>"+
							  "   /|\\ <BR>"+
							  "   / \\   ";
		}
		return muneco;
	}
	
	private String munecoAvanzado(){
		String muneco = "";
		if(intentos == 1){
			muneco = muneco + "    O   <BR>"+
							  "   /|\\ <BR>";
		}
		if(intentos == 0){
			muneco = muneco + "    O   <BR>"+
							  "   /|\\ <BR>"+
							  "   / \\    ";
		}
		return muneco;
	}
}
