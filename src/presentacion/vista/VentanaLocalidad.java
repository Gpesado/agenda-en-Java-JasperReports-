package presentacion.vista;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import presentacion.controlador.Controlador;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.awt.event.ActionEvent;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import java.awt.Color;

public class VentanaLocalidad extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Controlador controlador;
	private JTextField txtFieldAgregarNombre;
	private JTextField txtNuevoNombreModificar;
	private JButton btnEliminar;
	private JButton btnAgregar;
	private JButton btnModificar;
	@SuppressWarnings("rawtypes")
	private JComboBox comboLocalidadABorrar;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbModificar;

	@SuppressWarnings("rawtypes")
	public VentanaLocalidad(Controlador controlador) {
		setBackground(Color.BLACK);
		this.controlador = controlador;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 573, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblAgregarNombre = new JLabel("Nombre localidad");
		lblAgregarNombre.setForeground(Color.WHITE);
		lblAgregarNombre.setToolTipText("Escriba aqui el nombre de la localidad a agregar");
		lblAgregarNombre.setBounds(78, 74, 111, 23);
		contentPane.add(lblAgregarNombre);
		
		txtFieldAgregarNombre = new JTextField();
		txtFieldAgregarNombre.setForeground(Color.WHITE);
		txtFieldAgregarNombre.setBackground(Color.BLACK);
		txtFieldAgregarNombre.setBounds(217, 75, 189, 20);
		contentPane.add(txtFieldAgregarNombre);
		txtFieldAgregarNombre.setColumns(10);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBackground(Color.BLACK);
		btnAgregar.setForeground(Color.WHITE);
		btnAgregar.addActionListener(this.controlador);
		btnAgregar.setBounds(319, 106, 89, 23);
		contentPane.add(btnAgregar);
		
		JButton btnVaciarAgregar = new JButton("Vaciar");
		btnVaciarAgregar.setBackground(Color.BLACK);
		btnVaciarAgregar.setForeground(Color.WHITE);
		btnVaciarAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFieldAgregarNombre.setText("");
			}
		});
		btnVaciarAgregar.setToolTipText("borrar contenido de la casilla nombre localidad");
		btnVaciarAgregar.setBounds(217, 106, 78, 23);
		contentPane.add(btnVaciarAgregar);
		
		JLabel lvlCartelAgregarLocalidad = new JLabel("AGREGAR UNA LOCALIDAD");
		lvlCartelAgregarLocalidad.setForeground(Color.WHITE);
		lvlCartelAgregarLocalidad.setFont(new Font("Tahoma", Font.BOLD, 18));
		lvlCartelAgregarLocalidad.setToolTipText("");
		lvlCartelAgregarLocalidad.setBounds(156, 28, 252, 23);
		contentPane.add(lvlCartelAgregarLocalidad);
		
		
		
		JLabel lblCartelEliminarLocalidad = new JLabel("ELIMINAR UNA LOCALIDAD");
		lblCartelEliminarLocalidad.setForeground(Color.WHITE);
		lblCartelEliminarLocalidad.setToolTipText("");
		lblCartelEliminarLocalidad.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCartelEliminarLocalidad.setBounds(140, 165, 266, 23);
		contentPane.add(lblCartelEliminarLocalidad);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.setBackground(Color.BLACK);
		btnEliminar.setForeground(Color.WHITE);
		btnEliminar.addActionListener(this.controlador);
		btnEliminar.setBounds(319, 243, 89, 23);
		contentPane.add(btnEliminar);
		
		JLabel lblEliminarNombre = new JLabel("Nombre localidad");
		lblEliminarNombre.setForeground(Color.WHITE);
		lblEliminarNombre.setToolTipText("Escriba aqui la localidad que desee eliminar");
		lblEliminarNombre.setBounds(96, 208, 111, 23);
		contentPane.add(lblEliminarNombre);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 151, 575, 9);
		contentPane.add(separator);
		
		comboLocalidadABorrar = new JComboBox();
		comboLocalidadABorrar.setForeground(Color.WHITE);
		comboLocalidadABorrar.setBackground(Color.BLACK);
		comboLocalidadABorrar.setBounds(217, 207, 177, 24);
		contentPane.add(comboLocalidadABorrar);
		
		cmbModificar = new JComboBox();
		cmbModificar.setForeground(Color.WHITE);
		cmbModificar.setBackground(Color.BLACK);
		cmbModificar.setBounds(213, 359, 189, 24);
		contentPane.add(cmbModificar);
		
		JLabel lblCartelModificar = new JLabel("MODIFICAR UNA LOCALIDAD");
		lblCartelModificar.setForeground(Color.WHITE);
		lblCartelModificar.setBackground(Color.WHITE);
		lblCartelModificar.setToolTipText("");
		lblCartelModificar.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblCartelModificar.setBounds(140, 316, 282, 23);
		contentPane.add(lblCartelModificar);
		
		JLabel lblLocalidadAModificar = new JLabel("Localidad a modificar");
		lblLocalidadAModificar.setForeground(Color.WHITE);
		lblLocalidadAModificar.setToolTipText("Escriba aqui la localidad que desee modificar");
		lblLocalidadAModificar.setBounds(78, 360, 111, 23);
		contentPane.add(lblLocalidadAModificar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 277, 575, 9);
		contentPane.add(separator_1);
		
		txtNuevoNombreModificar = new JTextField();
		txtNuevoNombreModificar.setForeground(Color.WHITE);
		txtNuevoNombreModificar.setBackground(Color.BLACK);
		txtNuevoNombreModificar.setColumns(10);
		txtNuevoNombreModificar.setBounds(211, 394, 189, 20);
		contentPane.add(txtNuevoNombreModificar);
		
		JButton btnVaciarModificar = new JButton("Vaciar");
		btnVaciarModificar.setBackground(Color.BLACK);
		btnVaciarModificar.setForeground(Color.WHITE);
		btnVaciarModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtNuevoNombreModificar.setText("");
			}
		});
		btnVaciarModificar.setToolTipText("borrar contenido de la casilla nombre localidad");
		btnVaciarModificar.setBounds(211, 425, 78, 23);
		contentPane.add(btnVaciarModificar);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBackground(Color.BLACK);
		btnModificar.setForeground(Color.WHITE);
		btnModificar.addActionListener(this.controlador);
		btnModificar.setBounds(313, 425, 89, 23);
		contentPane.add(btnModificar);
		
		JLabel lblNuevoNombre = new JLabel("Nuevo nombre");
		lblNuevoNombre.setForeground(Color.WHITE);
		lblNuevoNombre.setToolTipText("Escriba aqui la localidad que desee eliminar");
		lblNuevoNombre.setBounds(78, 393, 111, 23);
		contentPane.add(lblNuevoNombre);
		
		try 
		{
			ImageIcon icon = new ImageIcon("res/fondo3.jpg");  
			JLabel lblFondo = new JLabel("");
			lblFondo.setBackground(Color.BLACK);
			lblFondo.setIcon(icon);
			lblFondo.setBounds(new Rectangle(0, 0, 565, 459));
			lblFondo.setVisible(true);
			contentPane.add(lblFondo);
			this.setVisible(true);
		} 
		catch (NullPointerException e1) {
			System.out.println("NO SE PUEDE CARGAR EL FONDO DE LA VENTANA LOCALIDAD");
		}
		
	}

	public JButton getBtnModificar() {
		return btnModificar;
	}

	public void setBtnModificar(JButton btnModificar) {
		this.btnModificar = btnModificar;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getCmbModificar() {
		return cmbModificar;
	}

	@SuppressWarnings("rawtypes")
	public void setCmbModificar(JComboBox cmbModificar) {
		this.cmbModificar = cmbModificar;
	}

	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	
	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public JTextField getTxtFieldAgregarNombre() {
		return txtFieldAgregarNombre;
	}

	public JTextField getTxtNuevoNombreModificar() {
		return txtNuevoNombreModificar;
	}

	public void setTxtNuevoNombreModificar(JTextField txtNuevoNombreModificar) {
		this.txtNuevoNombreModificar = txtNuevoNombreModificar;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboLocalidadABorrar() {
		return comboLocalidadABorrar;
	}

	public void setTxtFieldAgregarNombre(JTextField txtFieldAgregarNombre) {
		this.txtFieldAgregarNombre = txtFieldAgregarNombre;
	}
	
	public void mostrarMsjError(String mensaje)
	{
		JOptionPane.showMessageDialog(null,mensaje); 
	}
}
