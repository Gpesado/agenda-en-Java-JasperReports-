package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import dto.TipoContacto;
import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.TipoContactoDAO;

public class TipoContactoDAOImpl implements TipoContactoDAO 
{
	private static final String insert = "INSERT INTO tipocontacto(id_tipocontacto, tipocontacto_nombre) VALUES(?, ?)";
	private static final String delete = "DELETE FROM tipocontacto WHERE id_tipocontacto = ?";
	private static final String readall = "SELECT * FROM tipocontacto";
	private static final String update = "UPDATE tipocontacto SET tipocontacto_nombre = ? WHERE id_tipocontacto = ?";
	private static final Conexion conexion = Conexion.getConexion();
	@Override
	public boolean insert(TipoContacto tipoContacto) 
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, tipoContacto.getId());
			statement.setString(2, tipoContacto.getTipoContacto());
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
	public boolean delete(TipoContacto tipoContacto_a_borrar) 
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setInt(1, tipoContacto_a_borrar.getId());
			if(statement.executeUpdate() > 0) //Si se ejecutó devuelvo true
				return true;
		} 
		catch (SQLException e) 
		{
			throw new NullPointerException("ERROR ELIMINANDO TIPO DE CONTACTO, 1 O VARIAS PERSONAS ESTAN UTILIZANDO ESTE DOMICILIO");
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return false;
	}

	@Override
	public List<TipoContacto> readAll() 
	{
		PreparedStatement statement;
		ResultSet resultSet;
		ArrayList<TipoContacto> tipoContactos = new ArrayList<TipoContacto>();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				tipoContactos.add(new TipoContacto(resultSet.getInt("id_tipocontacto"),resultSet.getString("tipocontacto_nombre")));				
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			conexion.cerrarConexion();
		}
		return tipoContactos;
	}

	@Override
	public TipoContacto obtenerTipoContacto(int int1) 
	{
		String number = Integer.toString(int1);
		PreparedStatement statement;
		String consulta = "Select * from tipocontacto where id_tipocontacto = "+number+";";
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<TipoContacto> tipoContactos = new ArrayList<TipoContacto>();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(consulta);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				tipoContactos.add(new TipoContacto(resultSet.getInt("id_tipocontacto"),resultSet.getString("tipocontacto_nombre")));
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
		return tipoContactos.get(0);
	}

	@Override
	public TipoContacto getTipoContacto(String selectedItem) 
	{
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<TipoContacto> tipoContactos = new ArrayList<TipoContacto>();
		try 
		{
			
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				tipoContactos.add(new TipoContacto(resultSet.getInt("id_tipocontacto"),resultSet.getString("tipocontacto_nombre")));
			}
			TipoContacto tipoContactoSeleccionado = null;
			for (TipoContacto tipocontacto : tipoContactos){
				if(tipocontacto.getTipoContacto().equals(selectedItem))
					tipoContactoSeleccionado = tipocontacto;
			}
			tipoContactos.clear();
			tipoContactos.add(tipoContactoSeleccionado);
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally //Se ejecuta siempre
		{
			conexion.cerrarConexion();
		}
		return tipoContactos.get(0);
	}

	@Override
	public boolean update(int idTipoContacto, String nuevoNombre) 
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, nuevoNombre);
			statement.setInt(2, idTipoContacto);
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
