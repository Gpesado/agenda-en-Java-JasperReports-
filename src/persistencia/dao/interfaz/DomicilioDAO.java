package persistencia.dao.interfaz;

import java.util.List;

import dto.Domicilio;

public interface DomicilioDAO {
	public boolean insert(Domicilio domicilio);

	public boolean delete(Domicilio domicilio_a_borrar);
	
	public List<Domicilio> readAll();

	public Domicilio obtenerDomicilio(int int1);
	
	public boolean updateLocalidad(int id_localidad);

}
