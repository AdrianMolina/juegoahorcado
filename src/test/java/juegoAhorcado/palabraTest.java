package juegoAhorcado;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class palabraTest {
	
	private Palabra p;
	
	@Before
	public void setUp(){
		p = new Palabra();
	}

	@Test
	public void guardarPalabra(){
		p.setPalabra("perro", "animales");
		assertEquals("perro",p.getPalabra());
	}
	
	@Test
	public void guardarPista(){
		p.setPalabra("perro", "animales");
		p.setPista("ladra");
		assertEquals("ladra",p.getPista());
	}

}
