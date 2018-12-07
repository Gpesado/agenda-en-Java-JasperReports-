package presentacion.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import javax.swing.JTable;
import modelo.Agenda;
import presentacion.reportes.ReporteAgenda;
import presentacion.vista.VentanaLocalidad;
import presentacion.vista.VentanaPersona;
import presentacion.vista.VentanaPersonaEdicion;
import presentacion.vista.VentanaTipoContacto;
import presentacion.vista.Vista;
import dto.Domicilio;
import dto.Localidad;
import dto.PersonaDTO;
import dto.TipoContacto;

public class Controlador implements ActionListener
{
		private Vista vista;
		private List<PersonaDTO> personas_en_tabla;
		private VentanaPersona ventanaPersona; 
		private VentanaPersonaEdicion ventanaPersonaEdicion;
		private VentanaLocalidad ventanaLocalidad;
		private VentanaTipoContacto ventanaTipoContacto;
		private Agenda agenda;
		private PersonaDTO personaSeleccionada;
		
		public Controlador(Vista vista, Agenda agenda)
		{
			this.vista = vista;
			this.vista.getBtnAgregar().addActionListener(this);
			this.vista.getBtnEditar().addActionListener(this);
			this.vista.getBtnBorrar().addActionListener(this);
			this.vista.getBtnReporte().addActionListener(this);
			this.vista.getBtnEditarLocalidad().addActionListener(this);
			this.vista.getBtnEditarTipoContacto().addActionListener(this);
			this.agenda = agenda;
			this.personas_en_tabla = null;
		}
		
		public void inicializar()
		{
			this.llenarTabla();
		}
		
		private void llenarTabla()
		{
			this.vista.getModelPersonas().setRowCount(0); //Para vaciar la tabla
			this.vista.getModelPersonas().setColumnCount(0);
			this.vista.getModelPersonas().setColumnIdentifiers(this.vista.getNombreColumnas());
			
			this.personas_en_tabla = agenda.obtenerPersonas();
			for (int i = 0; i < this.personas_en_tabla.size(); i ++)
			{
				Object[] fila = {this.personas_en_tabla.get(i).getIdPersona(),this.personas_en_tabla.get(i).getNombre(), this.personas_en_tabla.get(i).getTelefono(),this.personas_en_tabla.get(i).getDomicilio(),this.personas_en_tabla.get(i).getEmail(),this.personas_en_tabla.get(i).getFechaCumpleanos(),this.personas_en_tabla.get(i).getTipoContacto(),this.personas_en_tabla.get(i).getSignoZodiaco()};
				this.vista.getModelPersonas().addRow(fila);
			}
			this.vista.show();
		}
		
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) 
		{
			//PREPARAR PANTALLA DE AGREGAR
			if(e.getSource() == this.vista.getBtnAgregar())
			{
				this.ventanaPersona = new VentanaPersona(this);
				List<Localidad> localidades = agenda.obtenerLocalidades();
				for (Localidad localidad : localidades) {
					this.ventanaPersona.getLocalidadCombo().addItem(localidad.getLocalidad());
				}
				
				List<TipoContacto> tipoContactos = agenda.obtenerTipoContactos();
				for (TipoContacto tipoContacto : tipoContactos) {
					this.ventanaPersona.getTipoContactocombo().addItem(tipoContacto.getTipoContacto());
				}
			}

			//PREPARAR PANTALLA DE EDITAR
			if(e.getSource() == this.vista.getBtnEditar() && vista.getTablaPersonas().getSelectedRow() !=-1)
			{
				this.ventanaPersonaEdicion = new VentanaPersonaEdicion(this);
				List<Localidad> localidades = agenda.obtenerLocalidades();
				for (Localidad localidad : localidades) {
					this.ventanaPersonaEdicion.getLocalidadCombo().addItem(localidad.getLocalidad());
				}
				
				List<TipoContacto> tipoContactos = agenda.obtenerTipoContactos();
				for (TipoContacto tipoContacto : tipoContactos) {
					this.ventanaPersonaEdicion.getTipoContactocombo().addItem(tipoContacto.getTipoContacto());
				}
				
				JTable tabla = this.vista.getTablaPersonas();
				int row = tabla.getSelectedRow();
				
				PersonaDTO persona = new PersonaDTO((Integer)tabla.getValueAt(row, 0), (String)tabla.getValueAt(row, 1), (String)tabla.getValueAt(row, 2), (Domicilio)tabla.getValueAt(row, 3), (String)tabla.getValueAt(row, 4), (Date)tabla.getValueAt(row, 5),(TipoContacto)tabla.getValueAt(row, 6));
				ventanaPersonaEdicion.getTxtNombre().setText(persona.getNombre());
				ventanaPersonaEdicion.getTxtTelefono().setText(persona.getTelefono());
				ventanaPersonaEdicion.getTxtCalle().setText(persona.getDomicilio().getCalle());
				ventanaPersonaEdicion.getTxtAltura().setText(Integer.toString(persona.getDomicilio().getAltura()));
				ventanaPersonaEdicion.getLocalidadCombo().setSelectedItem(persona.getDomicilio().getLocalidad().getLocalidad());
				ventanaPersonaEdicion.getTxtMail().setText(persona.getEmail());
				
				Date fechaCumple = persona.getFechaCumpleanos();
				Calendar cal = Calendar.getInstance();
				cal.setTime(fechaCumple);
				int month = cal.get(Calendar.MONTH);
				int day = cal.get(Calendar.DAY_OF_MONTH);
				int year = cal.get(Calendar.YEAR);
				
				ventanaPersonaEdicion.getDatePicker().getModel().setDate(year,month, day);
				ventanaPersonaEdicion.getDatePicker().getModel().setSelected(true);
				personaSeleccionada = persona;
				ventanaPersonaEdicion.getTipoContactocombo().setSelectedItem(persona.getTipoContacto().getTipoContacto());
			}
			
			//BORRAR PERSONA
			else if(e.getSource() == this.vista.getBtnBorrar())
			{
				int[] filas_seleccionadas = this.vista.getTablaPersonas().getSelectedRows();
				for (int fila:filas_seleccionadas)
				{
					this.agenda.borrarPersona(this.personas_en_tabla.get(fila));
				}
				
				this.llenarTabla();
			}
			//IMPRIMIR REPORTES
			else if(e.getSource() == this.vista.getBtnReporte())
			{
				List<PersonaDTO> personas = agenda.obtenerPersonas();
				ReporteAgenda reporte = new ReporteAgenda(personas);
				reporte.mostrar();				
			}
			
			//VENTANA PERSONA
			
			//AGREGAR PERSONA
			else if(ventanaPersona!= null && e.getSource() == this.ventanaPersona.getBtnAgregarPersona())
			{
				java.util.Date fecha = (java.util.Date)ventanaPersona.getDatePicker().getModel().getValue();
				Date fechaCumple = new Date(fecha.getTime());
				TipoContacto tipoContacto = agenda.obtenerTipoContacto((String)this.ventanaPersona.getTipoContactocombo().getSelectedItem());
				Localidad locSelec = agenda.obtenerLocalidad((String)this.ventanaPersona.getLocalidadCombo().getSelectedItem());
				
				try{
					Domicilio domicilio = new Domicilio(0,this.ventanaPersona.getTxtCalle().getText(), Integer.parseInt(this.ventanaPersona.getTxtAltura().getText()),locSelec);
					PersonaDTO nuevaPersona;
					nuevaPersona = new PersonaDTO(0,this.ventanaPersona.getTxtNombre().getText(), ventanaPersona.getTxtTelefono().getText(),domicilio,this.ventanaPersona.getTxtMail().getText(),fechaCumple,tipoContacto);
					agenda.agregarDomicilio(domicilio);
					this.agenda.agregarPersona(nuevaPersona);
					this.llenarTabla();
					this.ventanaPersona.dispose();
				}
				//error email invalido
				catch(NullPointerException errorAgregarPersona)
				{
				 this.ventanaPersona.mostrarErrorCrearPersona(errorAgregarPersona.getMessage());	
				}
				//error domicilio invalido 
				catch(NumberFormatException error)
				{
					boolean bandera = false;
					if(error.getMessage().equals("Ingrese un telefono valido"))
					{
						ventanaPersona.mostrarErrorTelefono();
						bandera = true;
					}
					if(!bandera)
					{
						this.ventanaPersona.errorCrearDomicilio();
					}	
				}
			}
			
			//ACTUALIZAR PERSONA
			else if(this.ventanaPersonaEdicion != null && e.getSource() == this.ventanaPersonaEdicion.getBtnActualizarPersona())
			{
				TipoContacto tipoContacto = agenda.obtenerTipoContacto((String)this.ventanaPersonaEdicion.getTipoContactocombo().getSelectedItem());
				Localidad locSelec = agenda.obtenerLocalidad((String)this.ventanaPersonaEdicion.getLocalidadCombo().getSelectedItem());			
				Domicilio domicilio = new Domicilio(0,this.ventanaPersonaEdicion.getTxtCalle().getText(), Integer.parseInt(this.ventanaPersonaEdicion.getTxtAltura().getText()),locSelec);
				
				agenda.agregarDomicilio(domicilio);
				personaSeleccionada.setNombre(ventanaPersonaEdicion.getTxtNombre().getText());
				personaSeleccionada.setTelefono(ventanaPersonaEdicion.getTxtTelefono().getText());
				personaSeleccionada.setDomicilio(domicilio);
				personaSeleccionada.setEmail(ventanaPersonaEdicion.getTxtMail().getText());
				java.util.Date fecha =(java.util.Date) ventanaPersonaEdicion.getDatePicker().getModel().getValue();

				personaSeleccionada.setFechaCumpleanos(new Date (fecha.getTime()));
				personaSeleccionada.setTipoContacto(tipoContacto);
			    
				this.agenda.editarPersona(personaSeleccionada);
				this.llenarTabla();
				this.ventanaPersonaEdicion.dispose();
			}	

			//VENTANA LOCALIDAD
			
			else if(e.getSource() == this.vista.getBtnEditarLocalidad())
			{
					this.ventanaLocalidad = new VentanaLocalidad(this);
					List<Localidad> localidades = agenda.obtenerLocalidades();
					for (Localidad localidad : localidades) {
						this.ventanaLocalidad.getComboLocalidadABorrar().addItem(localidad);
						this.ventanaLocalidad.getCmbModificar().addItem(localidad);
					}
			}
			//AGREGAR
			else if(this.ventanaLocalidad != null && e.getSource() == this.ventanaLocalidad.getBtnAgregar())			
			{
					agenda.agregarLocalidad(ventanaLocalidad.getTxtFieldAgregarNombre().getText());
					this.llenarTabla();
					this.ventanaLocalidad.dispose();
			}
			//ELIMINAR		
			else if(ventanaLocalidad != null && e.getSource() == ventanaLocalidad.getBtnEliminar())
			{
				try
				{
					agenda.eliminarLocalidad((Localidad)ventanaLocalidad.getComboLocalidadABorrar().getSelectedItem());
					this.llenarTabla();
					this.ventanaLocalidad.dispose();		
				}
				catch(NullPointerException errorEliminar)
				{
					ventanaLocalidad.mostrarMsjError(errorEliminar.getMessage());
				}
			}
			//EDITAR
			else if(ventanaLocalidad != null && e.getSource() == ventanaLocalidad.getBtnModificar())
			{
				Localidad locAEditar = (Localidad)ventanaLocalidad.getCmbModificar().getSelectedItem();
				String nombreNuevo = ventanaLocalidad.getTxtNuevoNombreModificar().getText();
				agenda.modificarLocalidad(locAEditar.getId(),nombreNuevo);
				this.llenarTabla();
				this.ventanaLocalidad.dispose();		
			}
			
			//VENTANA TIPO DE CONTACTO
			else if(e.getSource() == this.vista.getBtnEditarTipoContacto())
			{
				
				ventanaTipoContacto = new VentanaTipoContacto(this);
				List<TipoContacto> tiposContactos = agenda.obtenerTipoContactos();
				for (TipoContacto tipoContacto2 : tiposContactos) {
					ventanaTipoContacto.getCmbEliminar().addItem(tipoContacto2);
					ventanaTipoContacto.getCmbModificarTipo().addItem(tipoContacto2);
				}
			}
			//AGREGAR
			else if(ventanaTipoContacto != null && e.getSource() == ventanaTipoContacto.getBtnAgregar())
			{
				agenda.agregarTipoContacto(ventanaTipoContacto.getTxtFieldAgregar().getText());
				this.llenarTabla();
				this.ventanaTipoContacto.dispose();
			}
			//ELIMINAR
			else if(ventanaTipoContacto != null && e.getSource() == ventanaTipoContacto.getBtnEliminar())
			{
				try
				{
					agenda.eliminarTipoContacto((TipoContacto) ventanaTipoContacto.getCmbEliminar().getSelectedItem());
					this.llenarTabla();
					this.ventanaTipoContacto.dispose();	
				}
				
				catch(NullPointerException errorEliminar)
				{
					ventanaTipoContacto.mostrarMsjError(errorEliminar.getMessage());
				}
			}
			//MODIFICAR
			else if(ventanaTipoContacto != null && e.getSource() == ventanaTipoContacto.getBtnModificar())
			{
				TipoContacto tipoAEditar = (TipoContacto) ventanaTipoContacto.getCmbModificarTipo().getSelectedItem();
				agenda.modificarTipoContacto( tipoAEditar.getId(), ventanaTipoContacto.getTxtNuevoNombre().getText());
				this.llenarTabla();
				this.ventanaTipoContacto.dispose();
			}
		}
}



