package juegoAhorcado;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class juegoAhorcadoServlet extends HttpServlet {
	
	JuegoAhorcado j = new JuegoAhorcado();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nivel = request.getParameter("nivel");
		if(nivel != null){
			j.inicializarJuego(nivel);
		}
		PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<HTML><HEAD><TITLE>Ahorcado</TITLE></HEAD>");
			out.println("<BODY BGCOLOR=\"#0080FF\">");
			out.println("<CENTER>");
			out.println("<H1>JUEGO DEL AHORCADO</H1>");
			out.println("<form action=juegoAhorcadoServlet>");
			out.println("<BR>");
			out.println("<H3>Seleccionar accion: <select size=1 name=accion>");
			out.println("<option>ingresar letra</option>");
			out.println("<option>pista de letra</option>");
			out.println("<option>pista de frase</option>");
			out.println("</select></H3>&nbsp;");
			out.println("<input type=text name=contenido>&nbsp;");
			out.println("<input type=submit value=Aceptar>");
			out.println("</form>");
			String contenido = request.getParameter("contenido");
			String accion = request.getParameter("accion");
			//out.println(contenido);
			//out.println(accion);
			//out.println(j.intentosParaGanar);
			if(accion == null){
				out.println("<BR>");
				String mensaje = j.jugar(contenido);
				out.println("<H1>"+j.getNivel());
				out.println("<BR>");
				out.println(j.getIntentos());
				out.println("<BR>");
				out.println(mensaje);
				out.println("<BR>");
				out.println(j.mostrarRespuesta()+"</H1>");
				out.println("<BR>");
			}
			else{
				if(accion.equals("ingresar letra")){
				out.println("<BR>");
				String mensaje = j.jugar(contenido);
				out.println("<H1>"+j.getNivel());
				out.println("<BR>");
				out.println(j.getIntentos());
				out.println("<BR>");
				out.println("<BR>");
				out.println(mensaje);
				out.println("<BR>");
				out.println("<BR>");
				out.println(j.mostrarRespuesta());
				out.println("<BR>");
				out.println("<BR>");
				out.println(j.letrasUtilizadas()+"</H1>");
				out.println("<BR>");
				out.println("<H1><CENTER>"+j.dibujarMuneco()+"</CENTER></H1>");
				}
				if(accion.equals("pista de letra")){
					out.println("<BR>");
					out.println("<H1>PISTA: "+j.getPistaLetra()+"</H1>");
					out.println("<H2>"+j.getPistasUsadas()+"</H2>");
					out.println("<BR>");
				}
				if(accion.equals("pista de frase")){
					out.println("<BR>");
					out.println("<H1>PISTA: "+j.getPista()+"</H1>");
					out.println("<H2>"+j.getPistasUsadas()+"</H2>");
					out.println("<BR>");
				}
			}
			out.println("<form action=index.html>");
			out.println("<input type=submit name=volver value=ReiniciarJuego>");
			out.println("</form>");
			out.println("</CENTER>");
			out.println("</BODY></HTML>");
	}
}