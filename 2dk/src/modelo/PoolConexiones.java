package modelo;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;


import org.apache.commons.dbcp2.BasicDataSource;

public class PoolConexiones {

	private String urlServer="jdbc:postgresql://ns3034756.ip-91-121-81.eu:5432/";
	private String userServer="";
	private String passwordServer="";
	
	private String urlLocal="jdbc:postgresql://localhost/prueba";
	private String userLocal="usuario";
	private String passwordLocal="usuaria";
	
	private static PoolConexiones instancia;
    
    public DataSource obtenerFuenteDeDatosServer() {
    	
    	BasicDataSource datos;
    	datos=new BasicDataSource();
    	
    	datos.setUrl(urlServer);
    	datos.setUsername(userServer);
    	datos.setPassword(passwordServer);
    	
    	//datos.setMinIdle(5);
    	//datos.setMaxIdle(20);
    	datos.setMaxTotal(50);
    	datos.setMaxWaitMillis(-1);
    	
    	return datos;
    	
    }
    
    public DataSource obtenerFuenteDeDatosLocal() {
    	
    	BasicDataSource datos;
    	datos=new BasicDataSource();
    	
    	datos.setUrl(urlLocal);
    	datos.setUsername(userLocal);
    	datos.setPassword(passwordLocal);
    	
    	//datos.setMinIdle(5);
    	//datos.setMaxIdle(20);
    	datos.setMaxTotal(50);
    	datos.setMaxWaitMillis(-1);
    	
    	return datos;
    	
    }
    
    public Connection getConnectionServer() {
    	
    	Connection conexion;
    	
    	conexion=null;
		
		try {
			
			conexion= obtenerFuenteDeDatosServer().getConnection();
			
		}catch(SQLException e) {
			
			System.out.println("Error. Excepcion SQL\n"+e.toString());
			
		}
		
		return conexion;
		
	}
	
	public Connection getConnectionLocal() {
		
		Connection conexion;
		
		conexion=null;
		
		try {
			
			conexion= obtenerFuenteDeDatosLocal().getConnection();
			
		}catch(SQLException e) {
			
			System.out.println("Error. Excepcion SQL\n"+e.toString());
			
		}
		
		return conexion;
		
	}
	
	public void desconectar(Connection conexion){
		
		try {
			
			conexion.close();
			
		}catch(SQLException e) {
			
			System.out.println("Error. Excepcion SQL\n"+e.toString());
			
		}
		
	}
	
	public static PoolConexiones getInstance() {
		
		if(instancia==null) {
			
			instancia=new PoolConexiones();
			
		}
		
		return instancia;
		
	}
}
