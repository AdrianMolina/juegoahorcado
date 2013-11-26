package juegoAhorcado;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdminUsuarioServlet extends HttpServlet {
	
	AdminUsuario au = new AdminUsuario();
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String nombre = request.getParameter("nombre");
		String login = request.getParameter("login");
		String pass = request.getParameter("pass");
			response.setContentType("text/html");
			out.println("<HTML><HEAD><TITLE>Registro</TITLE></HEAD>");
			out.println("<BODY BGCOLOR=\"#0080FF\">");
			out.println("<H1>Lista de usuarios</H1>");
			
			au.guardarUsuario(nombre, login, pass);
			out.println("<H1>"+au.listaDeUsuarios()+"</H1>");	
				
			out.println("<form action=index.html>");
			out.println("<input type=submit name=volver value=Volver>");
			out.println("</form>");
			out.println("</BODY></HTML>");
	}
}
