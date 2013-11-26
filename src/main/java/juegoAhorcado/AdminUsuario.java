package juegoAhorcado;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class AdminUsuario {
	private ArrayList<Usuario> usuarios;
	private Usuario usuarioLogueado;
	
	public AdminUsuario(){
		usuarios = new ArrayList<Usuario>();
		cargarUsuarios();
		usuarioLogueado = null;
	}
	
	public void guardarUsuario(String nombre, String login, String password){
		Usuario u = new Usuario();
		u.setUsuario(nombre, login, password);
		usuarios.add(u);
		u.guardarDatos();
	}
	
	public String UsuariosSize(){
		String size = "";
		return size + usuarios.size();
	}
	
	public String usuarioLogueado(){
		return usuarioLogueado.getLogin();
	}
	
	public Usuario getUsuario(){
		return usuarioLogueado;
	}
	
	public void editarUsuario(String nombre, String login, String pass){
		Usuario u = new Usuario();
		u.setUsuario(nombre, login, pass);
		int posicion = usuarios.indexOf(usuarioLogueado);
		usuarios.set(posicion, u);
		usuarioLogueado = u;
	}
	
	public String login(String login, String password){
		String confirmacion = "";
		for(int i = 0; i < usuarios.size(); i++){
			if((login.equals(usuarios.get(i).getLogin())) && (password.equals(usuarios.get(i).getPass()))){
				confirmacion = confirmacion + "Usuario logueado exitosamente";
				usuarioLogueado = usuarios.get(i);
			}
		}
		if(confirmacion.equals("")){
			return "usuario no esta registrado";
		}
		else{
			return confirmacion;
		}
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
		}catch(ClassNotFoundException c)
		{
			System.out.println("Clase usuario vacia");
			c.printStackTrace();
		}
	}
}
