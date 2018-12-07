package dto;

public class Localidad
{
	int idLocalidad;
	String localidad;
	
	public Localidad(int i, String localidad){
		this.localidad = localidad;
		this.idLocalidad= i;
	}

	public String getLocalidad()
	{
		return localidad;
	}

	public int getId()
	{
		return idLocalidad;
	}

	@Override
	public String toString() {
		return localidad;
	}
}
