package vista;

import java.io.PrintWriter;

public class Saludo {

	
	public void PintarBienvenida(PrintWriter out, String nombre) {
		out.print("<html>");
		out.print("<body>");
		
		if(nombre == null) {
			out.print("<h1> No tiene acceso a esta web, antes debe <a href='indice'>loguearse</a> </h1>" );
		}else {
			out.print("<h1> Bienvenido " + nombre +  " </h1>" );
		}
		
		out.print("</body>");
		out.print("</html>");
		
		
	}
}
