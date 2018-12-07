package persistencia.dao.mysql;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import persistencia.conexion.Conexion;
import persistencia.dao.interfaz.DomicilioDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.TipoContactoDAO;
import dto.Domicilio;
import dto.PersonaDTO;
import dto.TipoContacto;

public class PersonaDAOImpl implements PersonaDAO
{
	private static final String insert = "INSERT INTO personas(idPersona, nombre, telefono,id_domicilio,email,fecha_cumple,id_tipocontacto) VALUES(?, ?, ?, ?, ?, ?, ?)";
	private static final String delete = "DELETE FROM personas WHERE idPersona = ?";
	private static final String readall = "SELECT * FROM personas";
	private static final Conexion conexion = Conexion.getConexion();
	private DomicilioDAO domicilioDAO;
	private TipoContactoDAO tipoContactoDAO;
	private static final String update = "UPDATE personas set nombre = ?, telefono = ?, id_domicilio = ?, email = ?, fecha_cumple = ?, id_tipocontacto = ? where idPersona = ?";
	private static final String updateTipoContacto = "UPDATE personas set id_tipocontacto = ? where id_tipocontacto = ?";
	
	public boolean insert(PersonaDTO persona)
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement("select MAX(id_domicilio) as max from domicilio;");
			ResultSet resultSet;
			List<Integer> numerosIndices = new ArrayList<Integer>();
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				numerosIndices.add(resultSet.getInt("max"));
			}
			int numeroIndiceMaximo = numerosIndices.get(0);
			
			
			statement = conexion.getSQLConexion().prepareStatement(insert);
			statement.setInt(1, persona.getIdPersona());
			statement.setString(2, persona.getNombre());
			statement.setString(3, persona.getTelefono());
			statement.setInt(4, numeroIndiceMaximo);
			statement.setString(5, persona.getEmail());
			statement.setDate(6, persona.getFechaCumpleanos());
			statement.setInt(7, persona.getTipoContacto().getId());
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
	
	public boolean delete(PersonaDTO persona_a_eliminar)
	{
		PreparedStatement statement;
		int chequeoUpdate=0;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(delete);
			statement.setString(1, Integer.toString(persona_a_eliminar.getIdPersona()));
			chequeoUpdate = statement.executeUpdate();
			if(chequeoUpdate > 0) //Si se ejecutó devuelvo true
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
	
	public List<PersonaDTO> readAll()
	{
		domicilioDAO = new DomicilioDAOImpl();
		tipoContactoDAO = new TipoContactoDAOImpl();
		PreparedStatement statement;
		ResultSet resultSet; //Guarda el resultado de la query
		ArrayList<PersonaDTO> personas = new ArrayList<PersonaDTO>();
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(readall);
			resultSet = statement.executeQuery();
			
			while(resultSet.next())
			{
				Domicilio domicilio = domicilioDAO.obtenerDomicilio(resultSet.getInt("id_domicilio"));
				TipoContacto tipoContacto = tipoContactoDAO.obtenerTipoContacto(resultSet.getInt("id_tipocontacto"));
				
				personas.add(new PersonaDTO(resultSet.getInt("idPersona"), resultSet.getString("Nombre"), resultSet.getString("Telefono"),domicilio,resultSet.getString("email"),resultSet.getDate("fecha_cumple"),tipoContacto));
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
		return personas;
	}

	@Override
	public boolean update(PersonaDTO personaSeleccionada) 
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(update);
			statement.setString(1, personaSeleccionada.getNombre());
			statement.setString(2, personaSeleccionada.getTelefono());
			statement.setInt(3, personaSeleccionada.getDomicilio().getIdDomicilio());
			statement.setString(4, personaSeleccionada.getEmail());
			statement.setDate(5, personaSeleccionada.getFechaCumpleanos());
			statement.setInt(6, personaSeleccionada.getTipoContacto().getId());
			statement.setInt(7, personaSeleccionada.getIdPersona());
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
	public boolean modificacionTipoContacto(int id_tipoContactoEliminado) 
	{
		PreparedStatement statement;
		try 
		{
			statement = conexion.getSQLConexion().prepareStatement(updateTipoContacto);
			statement.setInt(1, 1);
			statement.setInt(2, id_tipoContactoEliminado);
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
}
