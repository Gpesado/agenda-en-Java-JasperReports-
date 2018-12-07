package presentacion.vista;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class Vista
{
	private JFrame frame;
	private JTable tablaPersonas;
	private JButton btnAgregar;
	private JButton btnBorrar;
	private JButton btnReporte;
	JButton btnEditar;
	private DefaultTableModel modelPersonas;
	private  String[] nombreColumnas = {"IdPersona","Nombre y apellido","Teléfono","Domicilio","Email"," Fecha cumpleaños"," Tipo de Contacto", "Signo Zodiaco"};
	private JButton btnEditarLocalidad;
	private JButton btnEditarTipoContacto;
	private JLabel lblFondo;

	public Vista() 
	{
		super();
		initialize();
	}


	private void initialize() 
	{
		frame = new JFrame("Agenda");
		frame.setBounds(100, 100, 610, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 599, 273);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JScrollPane spPersonas = new JScrollPane();
		spPersonas.setBounds(10, 11, 585, 182);
		panel.add(spPersonas);
		
		modelPersonas = new DefaultTableModel(null,nombreColumnas);
		tablaPersonas = new JTable(modelPersonas);
		
		tablaPersonas.getColumnModel().getColumn(0).setPreferredWidth(103);
		tablaPersonas.getColumnModel().getColumn(0).setResizable(false);
		tablaPersonas.getColumnModel().getColumn(1).setPreferredWidth(100);
		tablaPersonas.getColumnModel().getColumn(1).setResizable(false);
		
		spPersonas.setViewportView(tablaPersonas);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(10, 228, 89, 23);
		panel.add(btnAgregar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(109, 228, 89, 23);
		panel.add(btnEditar);
		
		btnBorrar = new JButton("Borrar");
		btnBorrar.setBounds(208, 228, 89, 23);
		panel.add(btnBorrar);
		
		btnReporte = new JButton("Reporte");
		btnReporte.setBounds(307, 228, 89, 23);
		panel.add(btnReporte);
		
		btnEditarLocalidad = new JButton("Editar localidades");
		btnEditarLocalidad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEditarLocalidad.setBounds(478, 205, 117, 25);
		panel.add(btnEditarLocalidad);
		
		btnEditarTipoContacto = new JButton("Editar Tipos de Contactos");
		btnEditarTipoContacto.setBounds(478, 227, 117, 25);
		panel.add(btnEditarTipoContacto);
		
		try 
		{
			ImageIcon icon = new ImageIcon("res/fondomarron.jpg");  
			JLabel lblFondo = new JLabel("");
			lblFondo.setBackground(Color.BLACK);
			lblFondo.setIcon(icon);
			lblFondo.setBounds(new Rectangle(0, 0, 614, 273));
			lblFondo.setVisible(true);
			panel.add(lblFondo);
		} 
		catch (NullPointerException e1) {
			System.out.println("NO SE PUEDE CARGAR EL FONDO DE LA VENTANA LOCALIDAD");
		}
		
	}
	
	public void show()
	{
		this.frame.setVisible(true);
	}
	
	public JButton getBtnEditarLocalidad() {
		return btnEditarLocalidad;
	}


	public JButton getBtnEditarTipoContacto() {
		return btnEditarTipoContacto;
	}


	public JButton getBtnAgregar() 
	{
		return btnAgregar;
	}

	public JButton getBtnBorrar() 
	{
		return btnBorrar;
	}
	
	public JButton getBtnReporte() 
	{
		return btnReporte;
	}
	
	public DefaultTableModel getModelPersonas() 
	{
		return modelPersonas;
	}
	
	public JButton getBtnEditar() {
		return this.btnEditar;
	}


	public JTable getTablaPersonas()
	{
		return tablaPersonas;
	}

	public String[] getNombreColumnas() 
	{
		return nombreColumnas;
	}
}
