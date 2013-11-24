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
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nivel = request.getParameter("nivel");
		if(nivel != null){
			j.inicializarNivel(nivel);
		}
		PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			out.println("<HTML><HEAD><TITLE>Ahorcado</TITLE></HEAD>");
			out.println("<H1>JUEGO DEL AHORCADO</H1>");
			out.println("<BODY BGCOLOR=\"#0080FF\">");
			out.println("<form action=juegoAhorcadoServlet method=post>");
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
				out.println(mensaje);
				out.println("<BR>");
				out.println(j.mostrarRespuesta()+"</H1>");
				out.println("<BR>");
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
			out.println("</BODY></HTML>");
		/*
		
		if(accion.equals("ingresar palabra")){
			out.println("<HTML><HEAD><TITLE>Mostrando diccionario</HEAD></TITLE>");
			out.println("<BODY BGCOLOR=\"#0080FF\">");
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
			out.println("<BODY BGCOLOR=\"#0080FF\">");
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
		//response.getWriter().println("Se recibio el parametro: " + hasta);*/
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		out.println("<HTML><H1>Ahorcado</H1></HTML>");
	}
}