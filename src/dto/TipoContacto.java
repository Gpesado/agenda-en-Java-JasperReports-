package dto;

public class TipoContacto
{
	int id;
	String tipoContacto;
	public TipoContacto(int id,String tipoContacto)
	{
		this.id = id;
		this.tipoContacto = tipoContacto;
	}
	public String getTipoContacto() {
		// TODO Auto-generated method stub
		return this.tipoContacto;
	}
	public int getId()
	{
		return id;
	}
	@Override
	public String toString() {
		return tipoContacto;
	}
	
}
