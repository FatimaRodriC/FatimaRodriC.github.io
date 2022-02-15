package controlador;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.PoolConexiones;
import modelo.Cliente;
import vista.Registro;

/**
 * Servlet implementation class CRegistro
 */
@WebServlet("/registro")
public class CRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HttpSession sesion;
	Registro VRegistro;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		sesion = request.getSession();

		if (sesion.getAttribute("errorContrasenia") == null) {
			sesion.setAttribute("errorContrasenia", false);
			request.setAttribute("contraseniaMal", "El nombre o la contraseña es incorrecta");
		}else {
			request.setAttribute("contraseniaMal", "El nombre o la contraseña es incorrecta");
		}
		if (sesion.getAttribute("errorName") == null) {
			sesion.setAttribute("errorName", false);
			request.setAttribute("contraseniaMal", "El nombre o la contraseña es incorrecta");
		}else {
			request.setAttribute("contraseniaMal", "El nombre o la contraseña es incorrecta");
		}
			
		
		request.getRequestDispatcher("registro.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		sesion = request.getSession();
		String nombre;
		String contrasenia;
		String contrasenia2;
		Cliente usuario;

		usuario = new Cliente();

		Connection con;

		con = (Connection) sesion.getAttribute("connection");

		if (con == null) {
			sesion.setAttribute("connection", con);
		}

		usuario.setCon(con);

		if (con != null) {

			nombre = request.getParameter("nombre");
			contrasenia = request.getParameter("contrasenia");
			contrasenia2 = request.getParameter("contrasenia2");

			if (!usuario.ConsultarNombre(nombre)) {

				sesion.setAttribute("errorName", false);

				if (!contrasenia.equals(contrasenia2)) {

					sesion.setAttribute("errorContrasenia", true);

					response.sendRedirect("registro");

				} else {

					sesion.setAttribute("errorContraseña", false);

					usuario.InsertarUsuario(nombre, contrasenia);

					response.sendRedirect("login");
				}

			} else {

				sesion.setAttribute("errorName", true);

				response.sendRedirect("registro");

			}

		}
	}

}