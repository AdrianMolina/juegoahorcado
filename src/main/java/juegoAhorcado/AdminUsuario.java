package juegoAhorcado;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class AdminUsuario {
	private ArrayList<Usuario> usuarios;
	
	public AdminUsuario(){
		usuarios = new ArrayList<Usuario>();
		cargarUsuarios();
	}
	
	public void guardarUsuario(String nombre, String login, String password){
		Usuario u = new Usuario();
		u.setUsuario(nombre, login, password);
		usuarios.add(u);
		u.guardarDatos();
	}
	
	public String listaDeUsuarios(){
		String lista= "";
		for(int i = 0; i < usuarios.size(); i++){
			lista = lista + usuarios.get(i).getNombre() + "<BR>";
		}
		return lista;
	}
	
	public void cargarUsuarios(){
		Usuario usuario = null;
		boolean ciclo = false;
		try
		{
			FileInputStream fileIn = new FileInputStream("usuario.ser");
			ObjectInputStream in = new ObjectInputStream(fileIn);
			while(!ciclo){	
				usuario = (Usuario) in.readObject();
				usuarios.add(usuario);
			}
				in.close();
				fileIn.close();
		}catch(IOException i)
		{
			i.printStackTrace();
			return;
		}catch(ClassNotFoundException c)
		{
			System.out.println("Clase usuario vacia");
			c.printStackTrace();
			return;
		}
	}
}
