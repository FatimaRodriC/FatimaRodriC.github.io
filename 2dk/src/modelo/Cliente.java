package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



public class Cliente {
	
	PreparedStatement ps;
	ResultSet rs;
	Connection con;
	Consultas consultas;
	
	private Session sesion;
	
	
	public boolean consultar(String nombre, String contrasenia) {
		boolean existe = false;
		try {
			//Comprobar dentro de la base de datos los datos del usuario
			//Realizando una query SELECT para consultar el nombre de usuario y su contraseña
			//dentro de la tabla usuario
			//Devuelve true si existe
			
			consultas = new Consultas();
			String where = "nombre='" + nombre +"' AND contrasenia='" + contrasenia + "'";
			rs = consultas.consultar("*", "\"2dk\".\"cliente\"", where , con);
			
//			ps = con.prepareStatement("SELECT ? FROM ? WHERE ?=?");
//			ps.setString(1, nombre);
//			ps.setString(2, contrasenia);
//			rs = ps.executeQuery();
			
			if(rs.next()) {
				existe = true;
			}
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return existe;
	}
	
	public boolean ConsultarNombre(String nombre) {
		boolean existe = false;

		try {
			consultas = new Consultas();
			String where = "nombre='" + nombre + "'";
			rs = consultas.consultar("*", "2dk.cliente", where , con);
			if(rs.next()) {
				existe = true;
			}
		} catch (SQLException e) {
			System.err.println("ERROR al obtener la consulta");
			e.printStackTrace();
		}
		
		return existe;
	}
	
	
	public void InsertarUsuario(String nombre, String contrasenia) {
		consultas = new Consultas();
		consultas.insertar("2dk.cliente", "nombre, contrasenia", "'"+nombre+"', '"+contrasenia+"'", con);
	}
	
	public void EnviarGmail(String destinatario, String asunto, String cuerpo) {
		
		
		Properties properties = System.getProperties();
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port",25);
		properties.put("mail.smtp.mail.sender","smtpenvio88@gmail.com");
		properties.put("mail.smtp.user", "smtp");
		properties.put("mail.smtp.auth", "true");
		
		try{
			MimeMessage mensaje = new MimeMessage(sesion);
			mensaje.setFrom(new InternetAddress((String)properties.get("mail.smtp.mail.sender")));
			mensaje.addRecipient(Message.RecipientType.TO, new InternetAddress(destinatario));
			mensaje.setSubject(asunto);
			mensaje.setText(cuerpo);
			
			Transport transporte = sesion.getTransport("smtp");
			transporte.connect("smtp.gmail.com", "smtpenvio88@gmail.com");
			transporte.sendMessage(mensaje, mensaje.getAllRecipients());
			
		}catch (MessagingException e) {
			e.getStackTrace();
			// TODO: handle exception
		}
		}
	


	public void setCon(Connection con) {
		this.con = con;
	}

}
