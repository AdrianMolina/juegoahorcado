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
		String register = request.getParameter("register");
		String loginn = request.getParameter("loginn");
		String edit = request.getParameter("edit");
		
		response.setContentType("text/html");
		out.println("<HTML><HEAD><TITLE>Registro</TITLE></HEAD>");
		out.println("<BODY BGCOLOR=\"#0080FF\">");
		if(au.getUsuario() != null){
			out.println("<H2>"+au.usuarioLogueado()+"</H2>");
		}
		if(register != null){
			String nombre = request.getParameter("nombre");
			String login = request.getParameter("login");
			String pass = request.getParameter("pass");
			
			out.println("<H1>Lista de usuarios</H1>");
			
			au.guardarUsuario(nombre, login, pass);
			out.println("<H1>"+au.listaDeUsuarios()+"</H1>");	
		}
		if(loginn != null){
			String loginuser = request.getParameter("loginuser");
			String pass = request.getParameter("pass");
			if(au.login(loginuser,pass).equals("Usuario logueado exitosamente")){
				out.println("<H2>"+"Usuario logueado exitosamente"+"</H2>");
				response.sendRedirect("jugar.html");
			}
			else{
				//response.sendRedirect("login.html");
				out.println(au.UsuariosSize());
			}
		}
		if(edit != null){
			if(au.getUsuario() != null){
				String nombreeditar = request.getParameter("nombreeditar");
				String logineditar = request.getParameter("logineditar");
				String passeditar = request.getParameter("passeditar");
				au.editarUsuario(nombreeditar, logineditar, passeditar);
			}
			else{
				response.sendRedirect("login.html");
			}
		}
			out.println("<form action=index.html>");
			out.println("<input type=submit name=volver value=Volver>");
			out.println("</form>");
			out.println("</BODY></HTML>");
	}
}
