package juegoAhorcado;

import static org.junit.Assert.*;
import juegoAhorcado.JuegoAhorcado;

import org.junit.Before;
import org.junit.Test;

public class juegoAhorcadoTest {
	
	private JuegoAhorcado j;
	
	@Before
	public void setUp(){
		j = new JuegoAhorcado();
		j.inicializarJuego("Basico");
		j.inicializadorPalabraParaTest("arbol");
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
		assertEquals("Error, letra incorrecta", j.ingresarLetra("z"));
	}
	
	@Test
	public void mostrarIntentosConletraCorrecta() {
		j.jugar("a");
		assertEquals("Intentos restantes: 6\n", j.getIntentos());
	}
	
	@Test
	public void mostrarIntentosConletraIncorrecta() {
		j.jugar("z");
		assertEquals("Intentos restantes: 5\n", j.getIntentos());
	}
	
	@Test
	public void mostrarNivelActual(){
		assertEquals("Nivel: Basico\n",j.getNivel());
	}
	
	@Test
	public void ingresarPalabra(){
		j.guardarPalabraEnDiccionario("barco");
		assertEquals("casa<BR> pelota<BR> computadora<BR> cacatua<BR> gato<BR> caballo<BR> arbol<BR> mesa<BR> celular<BR> barco<BR> ",j.mostrarDiccionario());
	}
	
	@Test
	public void verPistasUsadas(){
		assertEquals("Pistas usadas: 0/3",j.getPistasUsadas());
	}
	
	@Test
	public void noIngresarLetraAlJugar(){
		assertEquals("Esperando a que ingrese una letra", j.jugar(null));
	}
	
	@Test
	public void ganarJuego(){
		j.jugar("a");
		j.jugar("r");
		j.jugar("b");
		j.jugar("o");
		j.jugar("l");
		assertEquals("GANO!!!!\n", j.jugar(""));
	}
	
	@Test
	public void perderJuego(){
		j.jugar("x");
		j.jugar("y");
		j.jugar("z");
		j.jugar("f");
		j.jugar("t");
		j.jugar("q");
		assertEquals("PERDIO!!!\n", j.jugar(""));
	}
	
	@Test
	public void dibujarMunecoSinEquivocarse(){
		assertEquals("",j.dibujarMuneco());
	}
	
	@Test
	public void dibujarMunecoConUnaEquivocacion(){
		j.jugar("z");
		assertEquals("    O    ",j.dibujarMuneco());
	}
	
	@Test
	public void dibujarMunecoConDosEquivocaciones(){
		j.jugar("z");
		j.jugar("v");
		assertEquals("    O  <BR>   /   <BR>",j.dibujarMuneco());
	}
	
	@Test
	public void dibujarMunecoCuandoSePerdio(){
		j.jugar("z");
		j.jugar("v");
		j.jugar("c");
		j.jugar("t");
		j.jugar("m");
		j.jugar("x");
		assertEquals("    O   <BR>   /|\\ <BR>   / \\   ",j.dibujarMuneco());
	}
	
	@Test
	public void mostraraPuntuacionConTresAciertos(){
		j.jugar("a");
		j.jugar("r");
		j.jugar("b");
		assertEquals("Puntuacion: 30", j.getPuntuacion());
	}
	
	@Test
	public void mostrarPuntuacionPerfectaMasBono(){
		j.jugar("a");
		j.jugar("r");
		j.jugar("b");
		j.jugar("o");
		j.jugar("l");
		j.jugar("");
		assertEquals("Puntuacion: 80", j.getPuntuacion());
	}
	
	@Test
	public void bonoDePuntuacion(){
		j.jugar("a");
		j.jugar("r");
		j.jugar("b");
		j.jugar("o");
		j.jugar("l");
		j.jugar("");
		assertEquals("Bono de puntuacion: 30", j.getBonoPuntuacion());
	}
	
}