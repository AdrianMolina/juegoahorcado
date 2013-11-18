package juegoAhorcado;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class juegoAhorcadoServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		JuegoAhorcado j = new JuegoAhorcado();
		String letra = request.getParameter("letra");
		String pista = request.getParameter("pista");
		if(letra.equals("a")){
			String mensaje = j.jugar(letra, "Basico");
			response.getWriter().println(j.getNivel());
			response.getWriter().println(j.getIntentos());
			response.getWriter().println(mensaje);
			response.getWriter().println(j.mostrarRespuesta());
		}
		if(pista.equals("hola") && letra.equals("") ){
			response.getWriter().println(pista);
		}
		//response.getWriter().println("Se recibio el parametro: " + hasta);
	}
	/*
	public static void main(String[] args) throws Exception{
        Server server = new Server(Integer.valueOf(System.getenv("PORT")));
        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);
        context.addServlet(new ServletHolder(new juegoAhorcadoServlet()),"/*");
        server.start();
        server.join();   
    }
	 */
}
