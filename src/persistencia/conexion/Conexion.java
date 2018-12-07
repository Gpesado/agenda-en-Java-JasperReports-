package persistencia.conexion;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion 
{
	private static Conexion instancia;
	private Connection conexion;
	
	public Conexion()
	{
		if(System.getProperty("os.name").equals("Linux"))
		{

			try
			{
				conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","");
				System.out.println("Conexion exitosa");
			}
			catch(Exception e)
			{
				System.out.println("Conexion fallida");
			}
		}
		
		String thisIp = "";
		try{
			thisIp = InetAddress.getLocalHost().getHostAddress();
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}

		if(thisIp.equals("192.168.1.107")){
			try
			{
				conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","lucho20");
				System.out.println("Conexion exitosa");
			}
			catch(Exception e)
			{
				System.out.println("Conexion fallida");
			}
		}
		
		else
		{
			if(thisIp.equals("192.168.1.71"))
			{
				try
				{
					conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","admin","g33915281");
					System.out.println("Conexion exitosa");
				}
				catch(Exception e)
				{
					System.out.println("Conexion fallida");
				}
			}
			if(thisIp.equals("192.168.0.20"))
			{
				try
				{
					conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/agenda","root","g33915281");
					System.out.println("Conexion exitosa");
				}
				catch(Exception e)
				{
					System.out.println("Conexion fallida");
				}	
			}		
		}		
		
	}
	
	public static Conexion getConexion()   
	{								
		if(instancia == null)
		{
			instancia = new Conexion();
		}
		return instancia;
	}

	public Connection getSQLConexion() 
	{
		return conexion;
	}
	
	public void cerrarConexion()
	{
		instancia = null;
	}
}
