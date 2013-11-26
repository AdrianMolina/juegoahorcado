package juegoAhorcado;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Usuario implements java.io.Serializable {
	private String nombre;
	private String login;
	private String password;
	
	public void setUsuario(String nombre, String login, String password){
		this.nombre = nombre;
		this.login = login;
		this.password = password;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public void guardarDatos(){
		try
		{
			FileOutputStream fileOut = new FileOutputStream("usuario.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			System.out.println("datos guardados en usuario.ser");
		}catch (IOException i)
		{
			i.printStackTrace();
		}
	}
}
