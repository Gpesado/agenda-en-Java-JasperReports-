package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.Domicilio;
import dto.Localidad;
import dto.TipoContacto;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.DomicilioDAO;
import persistencia.dao.interfaz.LocalidadDAO;

public class DomicilioDAOImpl implements DomicilioDAO 
{
	private static final String insert = "INSERT INTO domicilio(id_domicilio, calle, altura, id_localidad) VALUES(?, ?, ?, ?)";
	private static final Conexion conexion = Conexion.getConexion();
	private LocalidadDAO localidadDAO;
	private static final String updateLocalidad = "UPDATE domicilio set id_localidad = ? where id_localidad = ?";
	private static final String delete = "DELETE FROM domicilio WHERE id_domicilio = ?";
	
	@Override
	public boolean insert(Domicilio domicilio) 
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, domicilio.getIdDomicilio());
			statement.setString(2, domicilio.getCalle());
			statement.setInt(3, domicilio.getAltura());
			statement.setInt(4, domicilio.getLocalidad().getId());
			
			if(statement.executeUpdate() > 0) //Si se ejecutó devuelvo true
				statement = conexion.getSQLConexion().prepareStatement("select MAX(id_domicilio) as max from domicilio;");
				ResultSet resultSet;
				List<Integer> numerosIndices = new ArrayList<Integer>();
				resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				numerosIndices.add(resultSet.getInt("max"));
			}
			int numeroIndiceMaximo = numerosIndices.get(0);
			domicilio.setIdDomicilio(numeroIndiceMaximo);
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
	public boolean delete(Domicilio domicilio_a_borrar) 
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setInt(1, domicilio_a_borrar.getIdDomicilio());
			if(statement.executeUpdate() > 0) //Si se ejecutó devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			throw new NullPointerException("ERROR ELIMINANDO DOMICILIO, 1 O VARIAS PERSONAS ESTAN UTILIZANDO ESTE DOMICILIO");
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}

	@Override
	public Domicilio obtenerDomicilio(int int1) {
		localidadDAO = new LocalidadDAOImpl();
		String number = Integer.toString(int1);
		PreparedStatement statement;
		String consulta = "Select * from domicilio where id_domicilio = "+number+";";
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<Domicilio> domicilios = new ArrayList<Domicilio>();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(consulta);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				Localidad localidad = localidadDAO.obtenerLocalidad(resultSet.getInt("id_localidad"));
				domicilios.add(new Domicilio(resultSet.getInt("id_domicilio"),resultSet.getString("calle"),resultSet.getInt("altura"),localidad));
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
		return domicilios.get(0);
	}

	@Override
	public boolean updateLocalidad(int id_localidad) 
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(updateLocalidad);
			statement.setInt(1, 1);
			statement.setInt(2, id_localidad);
			
			if(statement.executeUpdate() > 0)
				return true; //Si se ejecutó devuelvo true
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
	public List<Domicilio> readAll() 
	{
		// TODO No implementado todavia
		return null;
	}
}
