package persistencia.dao.interfaz;

import java.util.List;
import dto.TipoContacto;

public interface TipoContactoDAO {
	public boolean insert(TipoContacto tipoContacto);

	public boolean delete(TipoContacto tipoContacto_a_borrar);
	
	public List<TipoContacto> readAll();

	public TipoContacto obtenerTipoContacto(int int1);

	public TipoContacto getTipoContacto(String selectedItem);

	public boolean update(int idTipoContacto, String nuevoNombre);
}
