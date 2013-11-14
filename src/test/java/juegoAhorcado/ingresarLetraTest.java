package juegoAhorcado;

import static org.junit.Assert.*;
import juegoAhorcado.JuegoAhorcado;

import org.junit.Test;

public class ingresarLetraTest {

	@Test
	public void ingresarUnaletra() {
		JuegoAhorcado j = new JuegoAhorcado();
		assertEquals("a", j.ingresarLetra("a"));
	}
	
	@Test
	public void verificarSiLaLetraExiste(){
		JuegoAhorcado j = new JuegoAhorcado();
		assertEquals(true, j.verificarLetra("a"));
	}

}
