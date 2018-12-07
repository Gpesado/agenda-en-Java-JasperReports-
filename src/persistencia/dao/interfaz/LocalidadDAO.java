package persistencia.dao.interfaz;

import java.util.List;

import dto.Localidad;
public interface LocalidadDAO {
	public boolean insert(Localidad localidad);

	public boolean delete(Localidad localidad_a_borrar);
	
	public List<Localidad> readAll();

	Localidad getLocalidad(String nombreLocalidad);
	
	public Localidad obtenerLocalidad(int n);

	public boolean update(int id, String nombreNuevo);
}
