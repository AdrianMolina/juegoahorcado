package juegoAhorcado;

import static org.junit.Assert.*;
import juegoAhorcado.JuegoAhorcado;

import org.junit.Before;
import org.junit.Test;

public class ingresarLetraTest {
	
	private JuegoAhorcado j;
	
	@Before
	public void setUp(){
		j = new JuegoAhorcado();
	}

	@Test
	public void ingresarUnaletraCorrecta() {
		assertEquals("letra correcta", j.ingresarLetra("a"));
	}
	
	@Test
	public void verificarSiLaLetraExiste(){
		assertEquals(true, j.verificarLetra("a"));
	}
	
	@Test
	public void ingresarUnaletraIncorrecta() {
		assertEquals("Error, letra incorrecta", j.ingresarLetra("b"));
	}
	

}