package juegoAhorcado;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class adminUsuarioTest {

private AdminUsuario au;
	
	@Before
	public void setUp(){
		au = new AdminUsuario();
		au.guardarUsuario("pedro", "p", "123");
		au.guardarUsuario("carlos", "c", "321");
		au.guardarUsuario("andrea", "a", "123");
		au.guardarUsuario("juan", "j", "456");
	}
	
	@Test
	public void tamanioListaDeUsuarios() {
		assertEquals("5", au.UsuariosSize());
	}
	
	@Test
	public void loginDeUsuarioConExito() {
		assertEquals("Usuario logueado exitosamente", au.login("j", "456"));
	}
	
	@Test
	public void loginDeUsuarioSinExito() {
		assertEquals("usuario no esta registrado", au.login("z", "123"));
	}
	
	@Test
	public void usuarioLogueadoActualmente() {
		au.login("j", "456");
		assertEquals("j", au.usuarioLogueado());
	}
}
