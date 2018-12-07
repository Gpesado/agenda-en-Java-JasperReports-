package presentacion.vista;

import java.util.Properties;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import org.jdatepicker.impl.DateComponentFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import presentacion.controlador.Controlador;
import java.awt.Color;

public class VentanaPersonaEdicion extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JButton btnActualizarPersona;
	private Controlador controlador;
	@SuppressWarnings("rawtypes")
	private JComboBox tipoContactocombo;
	@SuppressWarnings("rawtypes")
	private JComboBox localidadCombo;
	private JTextField txtCalle;
	private JTextField txtAltura;
	private JTextField txtMail;
	private JDatePickerImpl datePicker;
	private JLabel lblFechaDeCumpleaos;

	public JDatePickerImpl getDatePicker() {
		return datePicker;
	}



	public void setDatePicker(JDatePickerImpl datePicker) {
		this.datePicker = datePicker;
	}



	@SuppressWarnings("rawtypes")
	public VentanaPersonaEdicion(Controlador controlador) 
	{
		setTitle("Editar un contacto");
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 613, 338);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 51));
		panel.setBounds(10, 11, 307, 293);
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
		txtNombre.setBounds(133, 8, 164, 20);
		panel.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(133, 49, 164, 20);
		panel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		btnActualizarPersona = new JButton("Actualizar");
		btnActualizarPersona.setBounds(190, 257, 89, 23);
		panel.add(btnActualizarPersona);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 51));
		panel_3.setBounds(10, 77, 287, 169);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblDomicilio = new JLabel("Domicilio");
		lblDomicilio.setForeground(Color.WHITE);
		lblDomicilio.setBounds(112, 11, 46, 14);
		panel_3.add(lblDomicilio);
		
		txtCalle = new JTextField();
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
		txtAltura.setBounds(124, 98, 153, 20);
		panel_3.add(txtAltura);
		txtAltura.setColumns(10);
		
		JLabel lblLocalidad = new JLabel("Localidad");
		lblLocalidad.setForeground(Color.WHITE);
		lblLocalidad.setBounds(10, 144, 46, 14);
		panel_3.add(lblLocalidad);
		
		localidadCombo = new JComboBox();
		localidadCombo.setBounds(124, 141, 153, 20);
		panel_3.add(localidadCombo);
		btnActualizarPersona.addActionListener(this.controlador);
		
		tipoContactocombo = new JComboBox();
		tipoContactocombo.setBounds(442, 229, 121, 20);
		contentPane.add(tipoContactocombo);
		JLabel lblTipoContacto = new JLabel("Tipo Contacto");
		lblTipoContacto.setForeground(Color.WHITE);
		lblTipoContacto.setBounds(335, 232, 89, 14);
		contentPane.add(lblTipoContacto);
		
		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel,new DateComponentFormatter());
		datePicker.setBackground(Color.WHITE);
		datePicker.getJFormattedTextField().setBackground(Color.WHITE);
		datePicker.setSize(191, 48);
		datePicker.setLocation(422, 67);
		 
		getContentPane().add(datePicker);
		
		txtMail = new JTextField();
		txtMail.setBounds(434, 16, 164, 20);
		contentPane.add(txtMail);
		txtMail.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBounds(335, 18, 46, 14);
		contentPane.add(lblEmail);
		
		lblFechaDeCumpleaos = new JLabel("Fecha de cumpleaños");
		lblFechaDeCumpleaos.setForeground(Color.WHITE);
		lblFechaDeCumpleaos.setBounds(334, 71, 70, 15);
		contentPane.add(lblFechaDeCumpleaos);
		
		this.setVisible(true);
	}
	


	public JTextField getTxtMail() {
		return txtMail;
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

	public JButton getBtnActualizarPersona() 
	{
		return btnActualizarPersona;
	}
	
	@SuppressWarnings("rawtypes")
	public JComboBox getContactoCombo()
	{
		return tipoContactocombo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
