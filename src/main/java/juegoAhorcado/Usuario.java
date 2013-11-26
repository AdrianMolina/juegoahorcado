package juegoAhorcado;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Usuario implements java.io.Serializable {
	private String nombre;
	private String login;
	private String password;
	
	public Usuario(){
		this.nombre = "";
		this.login = "";
		this.password = "";
	}
	
	public void setUsuario(String nombre, String login, String password){
		this.nombre = nombre;
		this.login = login;
		this.password = password;
	}
	
	public String getNombre(){
		return this.nombre;
	}
	
	public String getLogin(){
		return this.login;
	}
	
	public String getPass(){
		return this.password;
	}
	
	public void guardarDatos(){
		try
		{
			FileOutputStream fileOut = new FileOutputStream("usuario.ser",true);
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
			System.out.println("datos guardados en usuario.ser");
		}catch (IOException i)
		{
			i.printStackTrace();
		}
	}
}
