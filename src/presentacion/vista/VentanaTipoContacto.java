package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JComboBox;
import javax.swing.JSeparator;
import presentacion.controlador.Controlador;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;

public class VentanaTipoContacto extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtFieldAgregar;
	private Controlador controlador;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JButton btnModificar;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbEliminar;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbModificarTipo;
	private JTextField txtNuevoNombre;

	
	@SuppressWarnings("rawtypes")
	public VentanaTipoContacto(Controlador controlador) {
		this.controlador = controlador;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 411, 462);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtFieldAgregar = new JTextField();
		txtFieldAgregar.setBounds(165, 54, 163, 20);
		contentPane.add(txtFieldAgregar);
		txtFieldAgregar.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBackground(Color.WHITE);
		btnAgregar.setForeground(Color.BLACK);
		btnAgregar.addActionListener(this.controlador);
		btnAgregar.setBounds(246, 85, 82, 23);
		contentPane.add(btnAgregar);
		
		JButton btnVaciar = new JButton("Vaciar");
		btnVaciar.setBackground(Color.WHITE);
		btnVaciar.setForeground(Color.BLACK);
		btnVaciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtFieldAgregar.setText("");
			}
		});
		btnVaciar.setToolTipText("vacia el contenido del casillero");
		btnVaciar.setBounds(165, 85, 71, 23);
		contentPane.add(btnVaciar);
		
		JLabel lblNombreTipoContacto = new JLabel("Nombre Tipo Contacto");
		lblNombreTipoContacto.setForeground(Color.WHITE);
		lblNombreTipoContacto.setBounds(46, 57, 125, 14);
		contentPane.add(lblNombreTipoContacto);
		
		JLabel lblCartelAgregar = new JLabel("Agregar tipo de contacto");
		lblCartelAgregar.setForeground(Color.WHITE);
		lblCartelAgregar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCartelAgregar.setBounds(104, 11, 213, 32);
		contentPane.add(lblCartelAgregar);
		
		JLabel lblCartelEliminar = new JLabel("Eliminar tipo de contacto");
		lblCartelEliminar.setForeground(Color.WHITE);
		lblCartelEliminar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCartelEliminar.setBounds(104, 139, 213, 32);
		contentPane.add(lblCartelEliminar);
		
		JLabel lblTipoContacto = new JLabel("Tipo Contacto");
		lblTipoContacto.setForeground(Color.WHITE);
		lblTipoContacto.setBounds(84, 185, 71, 14);
		contentPane.add(lblTipoContacto);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.WHITE);
		btnEliminar.setForeground(Color.BLACK);
		btnEliminar.addActionListener(this.controlador);
		btnEliminar.setBounds(257, 213, 71, 23);
		contentPane.add(btnEliminar);
		
		cmbEliminar = new JComboBox();
		cmbEliminar.setBounds(165, 182, 163, 20);
		contentPane.add(cmbEliminar);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 129, 434, 9);
		contentPane.add(separator);
		
		cmbModificarTipo = new JComboBox();
		cmbModificarTipo.setBounds(165, 327, 163, 20);
		contentPane.add(cmbModificarTipo);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBackground(Color.WHITE);
		btnModificar.setForeground(Color.BLACK);
		btnModificar.addActionListener(this.controlador);
		btnModificar.setBounds(251, 389, 77, 23);
		contentPane.add(btnModificar);
		
		JLabel lblCartelModificar = new JLabel("Modificar tipo de contacto");
		lblCartelModificar.setForeground(Color.WHITE);
		lblCartelModificar.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCartelModificar.setBounds(91, 284, 226, 32);
		contentPane.add(lblCartelModificar);
		
		JLabel lblTipoDeContactoModificar = new JLabel("Tipo de contacto a modificar");
		lblTipoDeContactoModificar.setForeground(Color.WHITE);
		lblTipoDeContactoModificar.setHorizontalAlignment(SwingConstants.CENTER);
		lblTipoDeContactoModificar.setBounds(5, 321, 150, 32);
		contentPane.add(lblTipoDeContactoModificar);
		
		JButton btnVaciarModificar = new JButton("Vaciar");
		btnVaciarModificar.setBackground(Color.WHITE);
		btnVaciarModificar.setForeground(Color.BLACK);
		btnVaciarModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNuevoNombre.setText("");
			}
		});
		btnVaciarModificar.setToolTipText("vacia el contenido del casillero");
		btnVaciarModificar.setBounds(165, 389, 71, 23);
		contentPane.add(btnVaciarModificar);
		
		txtNuevoNombre = new JTextField();
		txtNuevoNombre.setColumns(10);
		txtNuevoNombre.setBounds(165, 358, 163, 20);
		contentPane.add(txtNuevoNombre);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 264, 434, 9);
		contentPane.add(separator_1);
		
		JLabel lblNuevoNombreModificar = new JLabel("Nuevo nombre");
		lblNuevoNombreModificar.setForeground(Color.WHITE);
		lblNuevoNombreModificar.setBounds(84, 361, 71, 14);
		contentPane.add(lblNuevoNombreModificar);
		
		try 
		{
			ImageIcon icon = new ImageIcon("res/fondoazul2.jpg");  
			JLabel lblFondo = new JLabel("");
			lblFondo.setBackground(Color.BLACK);
			lblFondo.setIcon(icon);
			lblFondo.setBounds(new Rectangle(-84, -13, 622, 462));
			lblFondo.setVisible(true);
			contentPane.add(lblFondo);
			this.setVisible(true);
		} 
		catch (NullPointerException e1) {
			System.out.println("NO SE PUEDE CARGAR EL FONDO DE LA VENTANA LOCALIDAD");
		}
		
	}


	public JTextField getTxtNuevoNombre() {
		return txtNuevoNombre;
	}


	public void setTxtNuevoNombre(JTextField txtNuevoNombre) {
		this.txtNuevoNombre = txtNuevoNombre;
	}


	public JButton getBtnModificar() {
		return btnModificar;
	}


	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}


	@SuppressWarnings("rawtypes")
	public JComboBox getCmbModificarTipo() {
		return cmbModificarTipo;
	}


	@SuppressWarnings("rawtypes")
	public void setCmbModificarTipo(JComboBox cmbModificarTipo) {
		this.cmbModificarTipo = cmbModificarTipo;
	}


	public JButton getBtnEliminar() {
		return btnEliminar;
	}


	public JTextField getTxtFieldAgregar() {
		return txtFieldAgregar;
	}


	public void setTxtFieldAgregar(JTextField txtFieldAgregar) {
		this.txtFieldAgregar = txtFieldAgregar;
	}


	@SuppressWarnings("rawtypes")
	public JComboBox getCmbEliminar() {
		return cmbEliminar;
	}


	@SuppressWarnings("rawtypes")
	public void setCmbEliminar(JComboBox cmbEliminar) {
		this.cmbEliminar = cmbEliminar;
	}


	public void setBtnEliminar(JButton btnEliminar) {
		this.btnEliminar = btnEliminar;
	}


	public JButton getBtnAgregar() {
		return btnAgregar;
	}


	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}
	
	public void mostrarMsjError(String mensaje)
	{
		JOptionPane.showMessageDialog(null,mensaje); 	
	}
}
