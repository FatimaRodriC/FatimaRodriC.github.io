package controlador;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Conexion;
import modelo.Cliente;

/**
 * Servlet implementation class indice
 */
@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int intentos = 3;
	boolean error = false;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.getRequestDispatcher("login.jsp").forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre;
		String contrasenia;
		Cliente cliente;
		
		cliente = new Cliente();
		
		Conexion conexion;
		
		conexion = new Conexion();
		
		Connection con;
		
		con = conexion.conectar();
		
		cliente.setCon(con);
		
		nombre = request.getParameter("nombre");
		contrasenia = request.getParameter("contrasenia");
		
		if(cliente.consultar(nombre, contrasenia)){
//			response.sendRedirect(arg0); Ir a cualquier otro sitio
			request.getRequestDispatcher("saludo").forward(request, response);
		}else if(intentos>0){
//			request.getRequestDispatcher("indice").forward(request, response); Realiza un bucle
			response.sendRedirect("login");
			error=true;
			
			intentos--;
		}
		
	}

}
