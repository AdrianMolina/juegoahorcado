package juegoAhorcado;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminDiccionarioServlet  extends HttpServlet {
	
	JuegoAhorcado j = new JuegoAhorcado();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<HTML><HEAD><TITLE>Administrar Diccionario</TITLE></HEAD>");
			out.println("<BODY BGCOLOR=\"#0080FF\">");
			out.println("<CENTER>");
			out.println("<H1>ADMINISTRAR DICCIONARIO</H1>");
			out.println("<form action=AdminDiccionarioServlet>");
			out.println("<BR>");
			out.println("<H3>Ingresar Palabra: ");
			out.println("<input type=text name=palabra>&nbsp;");
			out.println("<input type=submit value=Aceptar></H3>");
			out.println("</form>");
			String palabra = request.getParameter("palabra");
			if(palabra == null){
				j.inicializarJuego("Basico");
				out.println("<BR>");
				out.println("<H1>"+j.mostrarDiccionario());
				out.println("<BR>");
			}
			else{
				j.guardarPalabraEnDiccionario(palabra);
				out.println("<BR>");
				out.println("<H1>"+j.mostrarDiccionario());
				out.println("<BR>");
			}
			out.println("<form action=index.html>");
			out.println("<input type=submit name=volver value=Volver>");
			out.println("</form>");
			out.println("</CENTER>");
			out.println("</BODY></HTML>");
	}
}
