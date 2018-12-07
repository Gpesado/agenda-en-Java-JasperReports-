package dto;

public class Domicilio {
	int idDomicilio;
	String calle;
	int altura;
	Localidad localidad;
	public Domicilio(int idDomicilio,String calle, int altura, Localidad localidad)
	{
		this.idDomicilio = idDomicilio;
		this.calle = calle;
		this.altura = altura;
		this.localidad = localidad;
	}
	public int getIdDomicilio() {
		return idDomicilio;
	}
	public void setIdDomicilio(int idDomicilio) {
		this.idDomicilio = idDomicilio;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public int getAltura() {
		return altura;
	}
	public void setAltura(int altura) {
		this.altura = altura;
	}
	public Localidad getLocalidad() {
		return localidad;
	}
	public void setLocalidad(Localidad localidad) {
		this.localidad = localidad;
	}
	@Override
	public String toString() {
		return calle + "" + altura + ", " + localidad.toString();
	}
	
	
}
