package juegoAhorcado;

import static org.junit.Assert.*;
import juegoAhorcado.JuegoAhorcado;

import org.junit.Before;
import org.junit.Test;

public class ingresarLetraTest {
	
	private JuegoAhorcado j;
	
	@Before
	public void setUp(){
		j = new JuegoAhorcado("Basico");
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
	
	@Test
	public void mostrarIntentosConletraCorrecta() {
		j.jugar("a");
		assertEquals("Intentos: 6\n", j.getIntentos());
	}
	
	@Test
	public void mostrarIntentosConletraIncorrecta() {
		j.jugar("z");
		assertEquals("Intentos: 5\n", j.getIntentos());
	}
	
	@Test
	public void mostrarNivelActual(){
		assertEquals("Nivel: Basico\n",j.getNivel());
	}
	
	@Test
	public void ingresarPalabra(){
		j.guardarPalabraEnDiccionario("barco");
		assertEquals("casa, pelota, computadora, barco, ",j.getDiccionario());
	}
}