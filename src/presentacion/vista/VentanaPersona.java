package presentacion.vista;


import java.util.Properties;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import presentacion.controlador.Controlador;
import javax.swing.JComboBox;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.SystemColor;

public class VentanaPersona extends JFrame 
{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JButton btnAgregarPersona;
	private Controlador controlador;
	@SuppressWarnings("rawtypes")
	private JComboBox tipoContactocombo;
	@SuppressWarnings("rawtypes")
	private JComboBox localidadCombo;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtMail;
	private JDatePickerImpl datePicker;
	private String msjerrorAgregarPersona = "Error de formato creando la persona: ";
	private String msjeerrorTelefono = "Error al ingresar telefono, pruebe uno valido";
	private String msjErrorCrearDomicilio = "Error al crear el domicilio, recuerde que debe llenar todos los campos y la altura debe estar expresada en formato numerico";

	@SuppressWarnings("rawtypes")
	public VentanaPersona(Controlador controlador) 
	{
		super();
		setForeground(new Color(0, 0, 51));
		setBackground(new Color(0, 0, 51));
		setTitle("Agregar una persona");
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 660, 338);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(12, 8, 307, 293);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNombreYApellido = new JLabel("Nombre y apellido");
		lblNombreYApellido.setForeground(Color.WHITE);
		lblNombreYApellido.setBounds(10, 11, 113, 14);
		panel.add(lblNombreYApellido);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono");
		lblTelfono.setForeground(Color.WHITE);
		lblTelfono.setBounds(10, 52, 113, 14);
		panel.add(lblTelfono);
		
		txtNombre = new JTextField();
		txtNombre.setBackground(Color.WHITE);
		txtNombre.setForeground(Color.BLACK);
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBackground(Color.WHITE);
		txtTelefono.setForeground(Color.BLACK);
		txtTelefono.setBounds(133, 49, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnAgregarPersona = new JButton("Agregar");
		btnAgregarPersona.setBackground(Color.WHITE);
		btnAgregarPersona.setForeground(Color.BLACK);
		btnAgregarPersona.setBounds(190, 257, 89, 23);
		panel.add(btnAgregarPersona);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 51));
		panel_3.setBounds(10, 76, 287, 169);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setForeground(Color.WHITE);
		lblDomicilio.setBackground(Color.WHITE);
		lblDomicilio.setBounds(123, 11, 106, 14);
		panel_3.add(lblDomicilio);
		
		txtCalle = new JTextField();
		txtCalle.setBackground(Color.WHITE);
		txtCalle.setForeground(Color.BLACK);
		txtCalle.setBounds(124, 50, 153, 20);
		panel_3.add(txtCalle);
		txtCalle.setColumns(10);
		
		JLabel lblCalle = new JLabel("Calle");
		lblCalle.setForeground(Color.WHITE);
		lblCalle.setBounds(10, 53, 46, 14);
		panel_3.add(lblCalle);
		
		JLabel lblAltura = new JLabel("Altura");
		lblAltura.setForeground(Color.WHITE);
		lblAltura.setBounds(10, 101, 46, 14);
		panel_3.add(lblAltura);
		
		txtAltura = new JTextField();
		txtAltura.setBackground(Color.WHITE);
		txtAltura.setForeground(Color.BLACK);
		txtAltura.setBounds(124, 98, 153, 20);
		panel_3.add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setForeground(Color.WHITE);
		lblLocalidad.setBounds(10, 144, 65, 14);
		panel_3.add(lblLocalidad);
		
		localidadCombo = new JComboBox();
		localidadCombo.setBackground(Color.WHITE);
		localidadCombo.setForeground(Color.BLACK);
		localidadCombo.setBounds(124, 141, 153, 20);
		panel_3.add(localidadCombo);
		btnAgregarPersona.addActionListener(this.controlador);
		
		UtilDateModel model = new UtilDateModel();
		model.setDate(2017, 11, 22);
		model.setSelected(true);
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel,new DateComponentFormatter());
		datePicker.getJFormattedTextField().setBackground(Color.WHITE);
		datePicker.setForeground(Color.BLACK);
		datePicker.setBackground(Color.WHITE);
		datePicker.getJFormattedTextField().setForeground(Color.BLACK);
		datePicker.setSize(191, 48);
		datePicker.setLocation(422, 67);
		 
		getContentPane().add(datePicker);
		
		txtMail = new JTextField();
		txtMail.setBackground(Color.WHITE);
		txtMail.setForeground(Color.BLACK);
		txtMail.setBounds(422, 16, 164, 20);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(337, 18, 46, 14);
		contentPane.add(lblEmail);
		
		tipoContactocombo = new JComboBox();
		tipoContactocombo.setBackground(Color.WHITE);
		tipoContactocombo.setForeground(Color.BLACK);
		tipoContactocombo.setBounds(465, 194, 121, 20);
		contentPane.add(tipoContactocombo);
		
		JLabel lblTipoContacto = new JLabel("Tipo Contacto");
		lblTipoContacto.setForeground(Color.WHITE);
		lblTipoContacto.setBounds(337, 197, 89, 14);
		contentPane.add(lblTipoContacto);
		
		JLabel lblFechaDeCumpleaos = new JLabel("Fecha de cumpleaños");
		lblFechaDeCumpleaos.setForeground(Color.WHITE);
		lblFechaDeCumpleaos.setBounds(329, 68, 83, 35);
		contentPane.add(lblFechaDeCumpleaos);
			
		try 
		{
			ImageIcon icon = new ImageIcon("res/fondoazul2.jpg");
			this.setVisible(true);
		} 
		catch (NullPointerException e1) {
			System.out.println("NO SE PUEDE CARGAR EL FONDO DE LA VENTANA LOCALIDAD");
		}
		
		this.setVisible(true);
	}
	


	public JDatePickerImpl getDatePicker() {
		return datePicker;
	}



	public JTextField getTxtMail() {
		return txtMail;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



	public JTextField getTxtCalle() {
		return txtCalle;
	}



	public JTextField getTxtAltura() {
		return txtAltura;
	}



	public JPanel getContentPane() {
		return contentPane;
	}

	public Controlador getControlador() {
		return controlador;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getTipoContactocombo() {
		return tipoContactocombo;
	}

	

	@SuppressWarnings("rawtypes")
	public JComboBox getLocalidadCombo() {
		return localidadCombo;
	}

	public JTextField getTxtNombre() 
	{
		return txtNombre;
	}

	public JTextField getTxtTelefono() 
	{
		return txtTelefono;
	}

	public JButton getBtnAgregarPersona() 
	{
		return btnAgregarPersona;
	}
	
	@SuppressWarnings("rawtypes")
	public JComboBox getContactoCombo()
	{
		return tipoContactocombo;
	}



	public void mostrarErrorCrearPersona(String stringMensajeError) {
		JOptionPane.showMessageDialog(null,msjerrorAgregarPersona + stringMensajeError); 
	}



	public void errorCrearDomicilio() {
		JOptionPane.showMessageDialog(null,msjErrorCrearDomicilio); 
	}
	public void mostrarErrorTelefono()
{
		JOptionPane.showMessageDialog(null,msjeerrorTelefono); 
}
}

