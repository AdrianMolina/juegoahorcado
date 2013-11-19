package juegoAhorcado;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class juegoAhorcadoServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		JuegoAhorcado j = new JuegoAhorcado("Basico");
		
		String accion = request.getParameter("accion");
		String contenido = request.getParameter("contenido");
		
		if(accion.equals("ingresar letra")){
			String mensaje = j.jugar(contenido);
			out.println("<HTML><HEAD><TITLE>Mostrando resultados del juego</HEAD></TITLE>");
			out.println("<BODY BGCOLOR=\"#0040FF\">");
			out.println("<H1>"+j.getNivel());
			out.println("<BR>");
			out.println(j.getIntentos());
			out.println("<BR>");
			out.println(mensaje);
			out.println("<BR>");
			out.println(j.mostrarRespuesta()+"</H1>");
			out.println("<BR>");
			out.println("</BODY></HTML>");
		}
		if(accion.equals("ingresar palabra")){
			out.println("<HTML><HEAD><TITLE>Mostrando diccionario</HEAD></TITLE>");
			out.println("<BODY BGCOLOR=\"#0040FF\">");
			out.println("<H1>");
			out.println("DICCIONARIO<BR>");
			j.guardarPalabraEnDiccionario(contenido);
			out.println(j.mostrarDiccionario());
			out.println("<BR>");
			out.println("</H1>");
			out.println("</BODY></HTML>");
		}
		if(accion.equals("pedir pista")){
			out.println("<HTML><HEAD><TITLE>Pistas</HEAD></TITLE>");
			out.println("<BODY BGCOLOR=\"#0040FF\">");
			out.println("<H1>");
			out.println("Pista: "+j.getPista());
			out.println("<BR>");
			out.println(j.getPistasUsadas());
			out.println("<BR>");
			out.println("</H1>");
			out.println("</BODY></HTML>");
		}
		//String mensaje = j.jugar(letra);
		//j.guardarPalabraEnDiccionario(letra);
		//String mensaje = j.jugar(letra);
		//response.sendRedirect("/pagina.jsp");
		//out.println(mensaje);
		//response.sendRedirect("/pagina.html");
		//String pista = request.getParameter("pista");
		//if(letra.equals("a")){
		//String mensaje = j.jugar(letra, "Basico");
		
		//response.sendRedirect("/index.html");
		//out.close();
		//}
		//if(pista.equals("hola") && letra.equals("") ){
		//	response.getWriter().println(pista);
		//}
		//response.getWriter().println("Se recibio el parametro: " + hasta);
	}
}