package juegoAhorcado;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class usuarioTest {
	
	private Usuario u;
	
	@Before
	public void setUp(){
		u = new Usuario();
		u.setUsuario("pedro", "p", "123");
	}

	@Test
	public void verificarNombreDeUsuario() {
		assertEquals("pedro", u.getNombre());
	}
	
	@Test
	public void verificarloginDeUsuario() {
		assertEquals("p", u.getLogin());
	}
	
	@Test
	public void verificarPasswordDeUsuario() {
		assertEquals("123", u.getPass());
	}

}
