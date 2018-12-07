package modelo;

import java.util.List;


import dto.Domicilio;
import dto.Localidad;
import dto.PersonaDTO;
import dto.TipoContacto;
import persistencia.dao.interfaz.DomicilioDAO;
import persistencia.dao.interfaz.LocalidadDAO;
import persistencia.dao.interfaz.PersonaDAO;
import persistencia.dao.interfaz.TipoContactoDAO;
import persistencia.dao.mysql.DomicilioDAOImpl;
import persistencia.dao.mysql.LocalidadDAOImpl;
import persistencia.dao.mysql.PersonaDAOImpl;
import persistencia.dao.mysql.TipoContactoDAOImpl;


public class Agenda 
{
	private PersonaDAO persona;
	private LocalidadDAO localidad;
	private DomicilioDAO domicilio;
	private TipoContactoDAO tipoContacto;
	
	public Agenda()
	{
		persona = new PersonaDAOImpl();
		localidad = new LocalidadDAOImpl();
		domicilio = new DomicilioDAOImpl();
		tipoContacto = new TipoContactoDAOImpl();
	}
	
	public void agregarPersona(PersonaDTO nuevaPersona)
	{
		persona.insert(nuevaPersona);
	}

	public void borrarPersona(PersonaDTO persona_a_eliminar) 
	{
		persona.delete(persona_a_eliminar);
	}
	
	public List<PersonaDTO> obtenerPersonas()
	{
		return persona.readAll();		
	}

	public List<Localidad> obtenerLocalidades() 
	{
		return localidad.readAll();
	}

	public Localidad obtenerLocalidad(String nombreLocalidad) 
	{
		Localidad localidad2 = localidad.getLocalidad(nombreLocalidad);
		return localidad2;
	}

	public void agregarDomicilio(Domicilio domicilio) 
	{
		this.domicilio.insert(domicilio);
	}

	public List<TipoContacto> obtenerTipoContactos() 
	{
		return tipoContacto.readAll();
	}

	public TipoContacto obtenerTipoContacto(String selectedItem) 
	{
		return tipoContacto.getTipoContacto(selectedItem);
	}

	public void editarPersona(PersonaDTO personaSeleccionada) 
	{
		persona.update(personaSeleccionada);
	}

	public void agregarLocalidad(String nombre) 
	{
		localidad.insert(new Localidad(0,nombre));
	}

	public void eliminarLocalidad(Localidad localidad2) 
	{
		localidad.delete(localidad2);
	}

	public void agregarTipoContacto(String text) 
	{
		TipoContacto tipoContacto = new TipoContacto(0, text);
		this.tipoContacto.insert(tipoContacto);
	}
	
	public void eliminarTipoContacto(TipoContacto tipoAEliminar) 
	{
		this.tipoContacto.delete(tipoAEliminar);
	}
	
	public void modificarLocalidad(int id, String nombreNuevo) {
		localidad.update(id, nombreNuevo);
	}
	
	public void modificarTipoContacto(int idTipoContacto, String nuevoNombre) 
	{
		tipoContacto.update(idTipoContacto,nuevoNombre);
	}
	
}
