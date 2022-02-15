package vista;

import java.io.PrintWriter;

public class FormularioInicio {

	public void PintarFormulario(PrintWriter out, int intentos, boolean error) {
		
		out.print("<html>");
		out.print("<body>");
		if(intentos > 0) {
			out.print("<form method='post'>");
			out.print("<h1>Inicio de Sesion</h1>");
			out.print("<p>Nombre de usuario</p>");
			out.print("<input name='nombre' type='text'>");
			out.print("<p>Contraseña</p>");
			out.print("<input name='contrasenia' type='password'>");
			out.print("<input type='submit'>");
			out.print("</form>");
			if(error) {
				out.print("<p>Usuario o contraseña incorrecto</p>");

				out.print("<h3>Tienes "+ intentos + " intentos</h3>");
			}
			
			out.print("<a href='registro'>Registrarme</a>");

		}else {
			out.print("<h1>Has acabado con todos los intentos, espere 1 hora para volver a intentar iniciar sesion</h1>");
		}

		out.print("</body>");
		out.print("</html>");
		
		
	}
	
}
