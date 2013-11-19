package juegoAhorcado;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		String nivel;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Ingrese el nivel que desea jugar (Basico,Intermedio,Avanzado): ");
		nivel = scanner.nextLine();
		JuegoAhorcado j = new JuegoAhorcado(nivel);
		while(j.intentos() != 0){
			String opcion;
			System.out.println("Elija una opcion: ");
			System.out.println("1.-ingresar letra");
			System.out.println("2.-pedir pista");
			System.out.println("3.-registrar palabra\n");
			opcion = scanner.nextLine();
			if(opcion.equals("1")){
				String letra;
				System.out.println("Ingrese una letra: ");
				letra = scanner.nextLine();
				String msg = j.jugar(letra);
				System.out.println(j.getNivel());
				System.out.println(j.getIntentos());
				System.out.println(j.getPistasUsadas());
				System.out.println(msg);
				System.out.println(j.mostrarRespuesta());
			}
			if(opcion.equals("2")){
				System.out.println(j.getPista());
			}
			if(opcion.equals("3")){
				String palabra;
				palabra = scanner.nextLine();
				j.guardarPalabraEnDiccionario(palabra);
				System.out.println(j.mostrarDiccionario());
			}
		}
	}

}
