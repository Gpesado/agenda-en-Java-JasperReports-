package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Localidad;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.LocalidadDAO;

public class LocalidadDAOImpl implements LocalidadDAO{
	private static final String insert = "INSERT INTO localidad(id_localidad, localidad_nombre) VALUES(?, ?)";
	private static final String delete = "DELETE FROM localidad WHERE id_localidad = ?";
	private static final String readall = "SELECT * FROM localidad";
	private static final Conexion conexion = Conexion.getConexion();
	private static final String update = "UPDATE localidad SET localidad_nombre = ? WHERE id_localidad= ?";
	
	@Override
	public boolean insert(Localidad localidad) 
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, localidad.getId());
			statement.setString(2, localidad.getLocalidad());
			if(statement.executeUpdate() > 0) //Si se ejecutó devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}

	@Override
	public boolean delete(Localidad localidad_a_borrar) 
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setInt(1, localidad_a_borrar.getId());
			if(statement.executeUpdate() > 0) //Si se ejecutó devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			throw new NullPointerException("ERROR ELIMINANDO LOCALIDAD, 1 O VARIOS DOMICILIOS ESTAN UTILIZANDO ESTA LOCALIDAD");
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}

	@Override
	public List<Localidad> readAll() {
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				localidades.add(new Localidad(resultSet.getInt("id_localidad"),resultSet.getString("localidad_nombre")));
				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return localidades;
	}

	@Override
	public Localidad getLocalidad(String nombreLocalidad) 
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				localidades.add(new Localidad(resultSet.getInt("id_localidad"),resultSet.getString("localidad_nombre")));
			}
			Localidad localidadSeleccionada = null;
			for (Localidad localidad : localidades){
				if (localidad.getLocalidad().equals(nombreLocalidad))
					localidadSeleccionada = localidad;
			}
			localidades.clear();
			localidades.add(localidadSeleccionada);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return localidades.get(0);
	}

	@Override
	public Localidad obtenerLocalidad(int n) 
	{
		String number = Integer.toString(n);
		PreparedStatement statement;
		String consulta = "Select * from localidad where id_localidad = "+number+";";
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Localidad> localidades = new ArrayList<Localidad>();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(consulta);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				localidades.add(new Localidad(resultSet.getInt("id_localidad"),resultSet.getString("localidad_nombre")));
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return localidades.get(0);
	}

	@Override
	public boolean update(int id, String nombreNuevo) 
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, nombreNuevo);
			statement.setInt(2,id);
			if(statement.executeUpdate() > 0)
				return true;
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			conexion.cerrarConexion();
		}
		return false;
	}
}
