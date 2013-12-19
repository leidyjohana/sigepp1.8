package controlador;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import modelo.AreaAcademica;
import modelo.AreaConocimiento;
import modelo.AreaTutorAcademico;
import modelo.Departamento;
import modelo.Programa;
import modelo.TutorAcademico;

import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Controller;
import org.zkoss.bind.annotation.Default;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Columns;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Fileupload;
import org.zkoss.zul.Grid;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Image;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Spinner;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import servicio.SAreaAcademica;
import servicio.SAreaConocimiento;
import servicio.SAreaTutorAcademico;
import servicio.STutorAcademico;

import componentes.BotoneraMaestros;

import componentes.Catalogo;
import configuracion.BeanServicios;

@Controller
public class CTutorAcademico extends CGenerico {

	STutorAcademico servicioTutorAcademico = BeanServicios.getSTutorAcademico();
	SAreaAcademica servicioAreaAcademica = BeanServicios.getSAreaAcademica();
	SAreaConocimiento servicioAreaConocimiento = BeanServicios
			.getSAreaConocimiento();
	SAreaTutorAcademico servicioAreaTutorAcademico = BeanServicios
			.getSAreaTutorAcademico();

	
	@Wire
	private Button btnBuscarTutorAcademico;
	@Wire
	private Radiogroup rdbTipoCedulaTutorAcademico;
	@Wire
	private Radio rdoVenezolano;
	@Wire
	private Radio rdoExtranjero;
	@Wire
	private Radiogroup rdbSexoTutorAcademico;
	@Wire
	private Textbox txtCedulaTutorAcademico;
	@Wire
	private Textbox txtNombre1TutorAcademico;
	@Wire
	private Textbox txtNombre2TutorAcademico;
	@Wire
	private Textbox txtApellido1TutorAcademico;
	@Wire
	private Textbox txtApellido2TutorAcademico;
	@Wire
	private Radio rdoSexoMTutorAcademico;
	@Wire
	private Radio rdoSexoFTutorAcademico;
	@Wire
	private Textbox txtResidenciaTutorAcademico;
	@Wire
	private Textbox txtCorreoTutorAcademico;
	@Wire
	private Intbox txtTelefono1TutorAcademico;
	@Wire
	private Intbox txtTelefono2TutorAcademico;
	@Wire
	private Combobox cmbAreaAcademica;
	@Wire
	private Listbox listaAreasConocimiento;
	@Wire
	private Listbox listaAreasAgregadas;
	@Wire
	private Button pasar1;
	@Wire
	private Button pasar2;
	@Wire
	private Div botoneraEstandar;
	@Wire
	private Div catalogoTutorAcademico;
	Catalogo<TutorAcademico> catalogo;
    public boolean exito = false;
	java.util.Date fecha = new Date();

	public CTutorAcademico() {
		// TODO Auto-generated constructor stub
	}

	@Override
	void inicializar() {
		comboAreaAcademica();
		listaAreasDisponibles();
		listaAreasAgregadas.getItems().clear();
		final Calendar calendario = Calendar.getInstance();

		// Aca se encuentran los metodos CRUD (Guardar, Modificar y Eliminar)
		// para los Tutores
		// Academicos, ademas la opcion salir. Se ejecutan con el click de los
		// botonos de la interfaz.
		BotoneraMaestros botonera = new BotoneraMaestros() {

			@Override
			public void guardar() {
				String cedula = txtCedulaTutorAcademico.getValue();
				String nacionalidad = rdbTipoCedulaTutorAcademico
						.getSelectedItem().getLabel();
				String nombre1 = txtNombre1TutorAcademico.getValue();
				String nombre2 = txtNombre2TutorAcademico.getValue();
				String apellido1 = txtApellido1TutorAcademico.getValue();
				String apellido2 = txtApellido2TutorAcademico.getValue();
				String residencia = txtResidenciaTutorAcademico.getValue();
				String correo = txtCorreoTutorAcademico.getValue();
				String telefono1 = String.valueOf(txtTelefono1TutorAcademico
						.getValue());
				String telefono2 = String.valueOf(txtTelefono2TutorAcademico
						.getValue());
				String nombreAreaAcademica = cmbAreaAcademica.getValue();
				AreaAcademica areaAcademica = servicioAreaAcademica
						.buscarPorNombreAreaAcademica(nombreAreaAcademica);
				String sexo = "";
				if (rdoSexoFTutorAcademico.isChecked())
					sexo = "Femenino";
				else
					sexo = "Masculino";
				String horaAuditoria = String.valueOf(calendario
						.get(Calendar.HOUR_OF_DAY))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.MINUTE))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.SECOND));
				java.util.Date fecha = new Date();

				TutorAcademico nuevoTutorAcademico = new TutorAcademico(cedula,
						areaAcademica, nacionalidad, nombre1, nombre2,
						apellido1, apellido2, sexo, residencia, correo,
						telefono1, telefono2, true, nombre1, fecha,
						horaAuditoria);
				//Guardar Areas de Conocimiento del Tutor
				servicioTutorAcademico.guardar(nuevoTutorAcademico);
				
				TutorAcademico ultimoTutorAcademico = servicioTutorAcademico.buscarTutorAcademico(cedula);
				List<AreaTutorAcademico> areasTutorAcademico = new ArrayList<AreaTutorAcademico>();
				for (int i=0; i<listaAreasAgregadas.getItemCount();i++)
				{
					Listitem itemSeleccionado = listaAreasAgregadas.getItemAtIndex(i);
					int tutoriados =  ((Spinner) itemSeleccionado.getChildren().get(1).getFirstChild()).getValue();
					int idAreaConocimiento = ((Spinner) itemSeleccionado.getChildren().get(2).getFirstChild()).getValue();
					
					AreaConocimiento areaConocimiento = servicioAreaConocimiento.buscarAreaConocimiento(idAreaConocimiento);
					System.out.println(idAreaConocimiento);
					AreaTutorAcademico areaTutorAcademico =new AreaTutorAcademico(areaConocimiento,ultimoTutorAcademico,tutoriados,nombre1, fecha,horaAuditoria);
					areasTutorAcademico.add(areaTutorAcademico);
				}
				servicioAreaTutorAcademico.guardar(areasTutorAcademico);
			
				
				
				Messagebox.show("Se Guardo Exitosamente");
				limpiar();
			}

			@Override
			public void limpiar() {
				rdoExtranjero.setDisabled(false);
				rdoVenezolano.setDisabled(false);
				rdbTipoCedulaTutorAcademico.setSelectedItem(null);
				txtCedulaTutorAcademico.setValue("");
				txtCedulaTutorAcademico.setDisabled(false);
				txtNombre1TutorAcademico.setValue("");
				txtNombre2TutorAcademico.setValue("");
				txtApellido1TutorAcademico.setValue("");
				txtApellido2TutorAcademico.setValue("");
				txtResidenciaTutorAcademico.setValue("");
				txtCorreoTutorAcademico.setValue("");
				rdbSexoTutorAcademico.setSelectedItem(null);
				txtTelefono1TutorAcademico.setValue(null);
				txtTelefono2TutorAcademico.setValue(null);
				cmbAreaAcademica.setValue("");
				listaAreasDisponibles();
				listaAreasAgregadas.getItems().clear();
			}

			@Override
			public void salir() {

			}

			@Override
			public void eliminar() {
				String cedula = txtCedulaTutorAcademico.getValue();
				TutorAcademico tutorAcademico = servicioTutorAcademico
						.buscarTutorAcademico(cedula);
				tutorAcademico.setEstadoEliminacion(false);
				servicioTutorAcademico.guardar(tutorAcademico);
				Messagebox.show("Se Elimino Exitosamente");
				limpiar();
			}
		};
		botoneraEstandar.appendChild(botonera);
	}

	// Ocurre al darle click al boton del catalogo, hace un llamada
	// al metodo que llena el catalogo y lo muestra.
	@Listen("onClick = #btnBuscarTutorAcademico")
	public void mostrarCatalogo() throws IOException {
		List<TutorAcademico> tutoresAcademicos = servicioTutorAcademico
				.buscarTutoresActivos();
		catalogo = new Catalogo<TutorAcademico>(catalogoTutorAcademico,
				tutoresAcademicos, "Cedula","Nombre", "Apellido", "Sexo", "Area de conocimiento") {

			@Override
			protected String[] crearRegistros(TutorAcademico tutorAcademico) {
				String[] registros = new String[5];
				registros[0] = tutorAcademico.getCedula();
				registros[1] = tutorAcademico.getNombre1();
				registros[2] = tutorAcademico.getApellido1();
				registros[3] = tutorAcademico.getSexo();
				registros[4] = tutorAcademico.getAreaAcademica().getNombre();
				return registros;
			}

			@Override
			protected List<TutorAcademico> buscar(String valor) {
				return servicioTutorAcademico
						.buscarCualquierCampoContiene(valor);
			}
		};
		catalogo.setParent(catalogoTutorAcademico);
		catalogo.doModal();
	}

	// Se ejecuta al darle doble click a algun item del catalogo para asi
	// seleccionar lo que se desee modificar O eliminar
	@Listen("onSeleccion = #catalogoTutorAcademico")
	public void seleccion() {
		TutorAcademico tutorAcademicoSeleccionado;
		tutorAcademicoSeleccionado = catalogo.objetoSeleccionadoDelCatalogo();
		exito=true;
		
		txtCedulaTutorAcademico
				.setValue(tutorAcademicoSeleccionado.getCedula());
		this.txtCedulaTutorAcademico.setDisabled(true);
		txtNombre1TutorAcademico.setValue(tutorAcademicoSeleccionado
				.getNombre1());
		txtNombre2TutorAcademico.setValue(tutorAcademicoSeleccionado
				.getNombre2());
		txtApellido1TutorAcademico.setValue(tutorAcademicoSeleccionado
				.getApellido1());
		txtApellido2TutorAcademico.setValue(tutorAcademicoSeleccionado
				.getApellido2());
		txtResidenciaTutorAcademico.setValue(tutorAcademicoSeleccionado
				.getResidencia());
		txtCorreoTutorAcademico
				.setValue(tutorAcademicoSeleccionado.getCorreo());
		txtTelefono1TutorAcademico.setValue(Integer
				.parseInt(tutorAcademicoSeleccionado.getTelefono1()));
		txtTelefono2TutorAcademico.setValue(Integer
				.parseInt(tutorAcademicoSeleccionado.getTelefono2()));
		cmbAreaAcademica.setValue(tutorAcademicoSeleccionado.getAreaAcademica()
				.getNombre());
		if (tutorAcademicoSeleccionado.getSexo().equals("Masculino")) {
			rdoSexoMTutorAcademico.setChecked(true);
			rdoSexoFTutorAcademico.setChecked(false);
		} else {
			rdoSexoFTutorAcademico.setChecked(true);
			rdoSexoMTutorAcademico.setChecked(true);
		}
		rdoExtranjero.setDisabled(true);
		rdoVenezolano.setDisabled(true);
		// Borra el catalogo de la pantalla
		catalogo.setParent(null);
		if (tutorAcademicoSeleccionado.getNacionalidad().equals("E"))
			rdoExtranjero.setChecked(true);
		else
			rdoVenezolano.setChecked(true);
		
		String cedula = txtCedulaTutorAcademico.getValue();
	
		TutorAcademico tutorAcademico = servicioTutorAcademico.buscarTutorAcademico(cedula);
	
		List<AreaTutorAcademico> areaTutorAcademico = servicioAreaTutorAcademico.buscarAreasSegunTutor(tutorAcademico);
		listaAreasAgregadas.setModel(new ListModelList<AreaTutorAcademico>(areaTutorAcademico));
	
		List<AreaConocimiento> areas = servicioAreaConocimiento.buscarAreasDisponiblesParaTutor(tutorAcademico);
		listaAreasConocimiento.setModel(new ListModelList<AreaConocimiento>(areas));
		
	}

	// Llena la lista que se mostrara en el combo de areas academicas del tutor
	public void comboAreaAcademica() {
		List<AreaAcademica> areaAcademica = servicioAreaAcademica
				.buscarAreasActivas();
		cmbAreaAcademica.setModel(new ListModelList<AreaAcademica>(
				areaAcademica));

	}

	// --------------Cosas que tienen que ver con el doble grid (No es necesario
	// para ustedes (por ahora jeje xD))----------
	// Funcion de boton de izquierda a derecha del doble grid
	@Listen("onClick = #pasar1")
	public void moverDerecha() {
		Listitem list1 = listaAreasConocimiento.getSelectedItem();
		if (list1 == null)
			Messagebox.show("Seleccione un Item");
		else
			list1.setParent(listaAreasAgregadas);
	}

	// Funcion de boton de derecha a izquierda del doble grid
	@Listen("onClick = #pasar2")
	public void moverIzquierda() {
		Listitem list2 = listaAreasAgregadas.getSelectedItem();
		System.out.println(list2.getValue().toString());
		if (list2 == null)
			Messagebox.show("Seleccione un Item");
		else
			list2.setParent(listaAreasConocimiento);
	}

	// Listas para llenar el doble grid (aun se esta trabajando en ello)
	public void listaAreasDisponibles() {

		List<AreaConocimiento> areas = servicioAreaConocimiento
				.buscarAreasActivas();
		listaAreasConocimiento.setModel(new ListModelList<AreaConocimiento>(
				areas));

//		List<AreaTutorAcademico> areasTutor = servicioAreaTutorAcademico
//				.buscarAreasTutoresActivos();
//		listaAreasAgregadas.setModel(new ListModelList<AreaTutorAcademico>(
//				areasTutor));
	}
}