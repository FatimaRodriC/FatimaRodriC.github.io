package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Conexion {
	
	Connection conexion;
	String url = "jdbc:postgresql://ns3034756.ip-91-121-81.eu/a21_frodca";
	String user = "a21_frodca";
	String password = "a21_frodca";
	
	
	public Connection conectar() {
		conexion=null; 
		try {
			conexion = DriverManager.getConnection(url, user, password);
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("No se ha podido conectar con la base de datos.");
			e.printStackTrace();
		}
		return conexion;
	}


	public PreparedStatement prepareStatement(String query) {
		// TODO Auto-generated method stub
		PreparedStatement prstmt = null;
		try {
			prstmt = conectar().prepareStatement(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prstmt;
	}
	
}
