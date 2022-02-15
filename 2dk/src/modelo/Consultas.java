package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Consultas {
	ResultSet rs;

	/*
	 * Ejemplo de como usar el metodo:
	 * Consultas objeto= new Consultas();
	 * Conexion con = new Conexion();
	 * con.abrirConexion();
	 * objeto.consultar("idmontaditos", "montaditos.montaditos", "idmontaditos=1",con.getConexion())
	 * 
	 * Eso ejecutaria la consulta:
	 * Select idmontaditos From montaditos.montaditos Where idmontaditos=1
	 * 
	 * */	

	public ResultSet consultar(String select, String from, String where, Connection con) {

		try {
			
			String query="SELECT "+select+" FROM "+from+" WHERE "+where; 
			System.out.println(query);
			
			PreparedStatement stmt = con.prepareStatement(query);
			rs = stmt.executeQuery();
			//stmt.close();

		} catch (SQLException sqle) {
			System.err.println("Ha dado un error al ejecutar la query");
			sqle.printStackTrace();
		}
		
		return rs;

	}
	
	/*
	 * Ejemplo de como usar el metodo:
	 * Consultas objeto= new Consultas();
	 * Conexion con = new Conexion();
	 * con.abrirConexion();
	 * objeto.insertar("montaditos.montaditos","idmontaditos, nombre, precio, tamanio, premium","1,'ejemplo1',3,'Gatitos',0",con.getConexion())
	 * 
	 * Eso ejecutaria la consulta:
	 * Insert into montaditos.montaditos(idmontaditos, nombre, precio, tamanio, premium) Values (idmontaditos, nombre, precio, tamanio, premium","1,'ejemplo1',3,'Gatitos',0);
	 * 
	 * */	
	
	public void insertar(String into, String variables,String values, Connection con ) {
		
		try {

			String query="INSERT INTO "+into+" "+"("+variables+") "+" Values "+"("+values+")"; 
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.executeUpdate();
			stmt.close();
			

		} catch (SQLException sqle) {
			System.err.println("Ha dado un error al ejecutar la query");
			sqle.printStackTrace();
		}

	}
	
	/*
	 * Ejemplo de como usar el metodo:
	 * Consultas objeto= new Consultas();
	 * Conexion con = new Conexion();
	 * con.abrirConexion();
	 * objeto.borrar("montaditos.montaditos","idmontaditos=1",con.getConexion())
	 * 
	 * Eso ejecutaria la consulta:
	 * Delete From montaditos.montaditos Where idmontaditos=1;	
	 *  
	 * */
	
	public void borrar(String from, String where,Connection con ) {

		try {

			String query="Delete From "+from+" Where "+where; 
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.close();

		} catch (SQLException sqle) {
			System.err.println("Ha dado un error al ejecutar la query");
			sqle.printStackTrace();
		}
	}	
	
	/*
	 * Ejemplo de como usar el metodo:
	 * Consultas objeto= new Consultas();
	 * Conexion con = new Conexion();
	 * con.abrirConexion();
	 * objeto.modificar("montaditos.montaditos","nombre='patitos'","idmontaditos=1",con.getConexion())
	 * 
	 * Eso ejecutaria la consulta:
	 * Update montaditos.montaditos Set nombre='patitos' Where idmontaditos=1;	
	 *  
	 * */

	
	public void modificar(String table, String set, String where,Connection con ) {
		
		try {

			String query="Update "+table+" Set "+set+" Where "+where; 
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException sqle) {
			System.err.println("Ha dado un error al ejecutar la query");
			sqle.printStackTrace();
		}
	}	
}
