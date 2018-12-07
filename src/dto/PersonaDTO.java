package dto;

import java.sql.Date;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PersonaDTO 
{
	private int idPersona;
	private String nombre;
	private String telefono;
	private Domicilio domicilio;
	private String email;
	private Date fechaCumpleanos;
	private TipoContacto tipoContacto;
	private String signoZodiaco;
	
	private static final String PATTERN_EMAIL = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PATTERN_TELEFONO = "-?\\d+(\\.\\d+)?";

	public PersonaDTO(int idPersona, String nombre, String telefono, Domicilio domicilio,String email, Date fechaCumpleanos,TipoContacto tipoContacto)
	{
		
		if(!camposEstanLlenos(nombre,telefono,email))
		{
			throw new NullPointerException("Debe completar todos los campos");
		}
		if (!emailValido(email))
		{
			throw new NullPointerException("Ingrese un email valido");
		}
		if (!telefonoValidoLargo(telefono))
		{
			throw new NumberFormatException("Ingrese un telefono valido");
		}
		
		this.idPersona = idPersona;
		this.nombre = nombre;
		this.telefono = telefono;
		this.domicilio = domicilio;
		this.email = email;
		this.fechaCumpleanos = fechaCumpleanos;
		this.tipoContacto = tipoContacto;
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.fechaCumpleanos);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		int year = cal.get(Calendar.YEAR);
		if((month == 2 && day >=21)||(month == 3 && day <=21))
		{
			signoZodiaco = "Aries";
		}
		
		if((month == 3 && day >=22)||(month == 4 && day <=21))
		{
			signoZodiaco = "Tauro";
		}
		if((month == 4 && day >=22)||(month == 5 && day <=21))
		{
			signoZodiaco = "Geminis";
		}
		if((month == 4 && day >=22)||(month == 5 && day <=21))
		{
			signoZodiaco = "Geminis";
		}
		if((month == 5 && day >=22)||(month == 6 && day <=21))
		{
			signoZodiaco = "Cancer";
		}
		if((month == 6 && day >=22)||(month == 7 && day <=22))
		{
			signoZodiaco = "Leo";
		}
		if((month == 7 && day >=23)||(month == 8 && day <=22))
		{
			signoZodiaco = "Virgo";
		}
		if((month == 8 && day >=23)||(month == 9 && day <=22))
		{
			signoZodiaco = "Libra";
		}
		if((month == 9 && day >=23)||(month == 10 && day <=22))
		{
			signoZodiaco = "Escorpio";
		}
		if((month == 10 && day >=23)||(month == 11 && day <=21))
		{
			signoZodiaco = "Sagitario";
		}
		if((month == 11 && day >=22)||(month == 0 && day <=21))
		{
			signoZodiaco = "Capricornio";
		}
		if((month == 0 && day >=22)||(month == 1 && day <=18))
		{
			signoZodiaco = "Acuario";
		}
		if((month == 1 && day >=19)||(month == 2 && day <=20))
		{
			signoZodiaco = "Acuario";
		}

	}
	
	private boolean camposEstanLlenos(String nombre2 , String telefono2 , String email2) {
		if(nombre2.equals("") || telefono2.equals("") || email2.equals(""))
		{
			return false;
		}
		return true;
	}

	private boolean telefonoValidoLargo(String telefono2) {
		
		Pattern pattern = Pattern.compile(PATTERN_TELEFONO);
        Matcher matcher = pattern.matcher(telefono2);
        return matcher.matches() && (telefono2.length() == 8 || telefono2.length() == 11);
	}


	private boolean emailValido(String email2) {
		Pattern pattern = Pattern.compile(PATTERN_EMAIL);
		 
        // Match the given input against this pattern
        Matcher matcher = pattern.matcher(email2);
        return matcher.matches();
	}

	public Domicilio getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getFechaCumpleanos() {
		return fechaCumpleanos;
	}

	public void setFechaCumpleanos(Date fechaCumpleanos) {
		this.fechaCumpleanos = fechaCumpleanos;
	}

	public TipoContacto getTipoContacto() {
		return tipoContacto;
	}

	public void setTipoContacto(TipoContacto tipoContacto) {
		this.tipoContacto = tipoContacto;
	}

	public int getIdPersona() 
	{
		return this.idPersona;
	}

	public void setIdPersona(int idPersona) 
	{
		this.idPersona = idPersona;
	}

	public String getNombre() 
	{
		return this.nombre;
	}

	public void setNombre(String nombre) 
	{
		this.nombre = nombre;
	}

	public String getTelefono() 
	{
		return this.telefono;
	}

	public void setTelefono(String telefono) 
	{
		this.telefono = telefono;
	}
	public String getSignoZodiaco() {
		return signoZodiaco;
	}

	
//string
	@Override
	public String toString() {
		return "PersonaDTO [idPersona=" + idPersona + ", nombre=" + nombre + ", telefono=" + telefono + ", domicilio="
				+ domicilio + ", email=" + email + ", fechaCumpleaños=" + fechaCumpleanos + ", tipoContacto="
				+ tipoContacto + "]";
	}
	
}
