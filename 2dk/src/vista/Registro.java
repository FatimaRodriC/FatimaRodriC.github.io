package vista;

import java.io.PrintWriter;

public class Registro {

	public void PintarFormulario(PrintWriter out, boolean errorName , boolean errorContrasenia) {
	
		out.print("<html>");
		out.print("<body>");

		out.print("<form method='post'>");
		out.print("<h1>Registro de usuario</h1>");
		out.print("<p>Nombre de usuario</p>");

		out.print("<input name='nombre' type='text'>");
		if(errorName) {
			out.print("<small style='color:red'>*Nombre de usuario ya existe, elija otro.</small>");
		}
		if(errorContrasenia) {
			out.print("<p><small style='color:red'>*Contraseñas no coinciden.</small></p>");

		}
		out.print("<p>Contraseña</p>");
		out.print("<input name='contrasenia' type='password'>");
		out.print("<p>Repetir Contraseña</p>");
		out.print("<input name='contrasenia2' type='password'>");
		out.print("<input type='submit'>");
		out.print("</form>");

		
		out.print("<a href='indice'>Iniciar sesion</a>");

		out.print("</body>");
		out.print("</html>");
	
	}
}
