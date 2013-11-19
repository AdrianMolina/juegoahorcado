package juegoAhorcado;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class diccionarioTest {
	
	private Diccionario d;
	
	@Before
	public void setUp(){
		d = new Diccionario();
		d.setPalabraEnDiccionario("perro", "animales");
		Palabra p = d.getPalabraObjeto(0);
		d.setPistaEnPalabra(p, "ladra");
	}
	
	@Test
	public void mostrarTamnioDiccionario(){
		assertEquals(1, d.getTamanio());
	}

	@Test
	public void mostrarPalabraDelDiccionario() {
		assertEquals("perro", d.getPalabra(0));
	}
	
	@Test
	public void mostrarPistaDeUnaPalabraEspecifica(){
		assertEquals("ladra", d.getPistaPalabraEspecifica(d.getPalabraObjeto(0)));
	}
	
	@Test
	public void mostrarTodasLasPalabrasDelDiccionario(){
		assertEquals("perro, ", d.getDiccionario());
	}

}
