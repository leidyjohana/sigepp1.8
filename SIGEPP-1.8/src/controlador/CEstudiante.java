package controlador;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.Estudiante;
import modelo.Programa;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Datebox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

import servicio.SEstudiante;
import servicio.SPrograma;

import componentes.BotoneraMaestros;
import componentes.Catalogo;

import configuracion.BeanServicios;

/**
* 
* Autor: 
* Revisado por: Ysolmery Maiorano
* Version: 1.0
* Fecha Creacion: 02/12/2013
* 
* ----------------------------
* HISTORIAL DE MODIFICACIONES
* ----------------------------
* Autor: Michell Lobo
* Revisado por: Ysolmery Maiorano
* Fecha: 15/12/2013
* Descripcion: Se le integro el componente de Catalogo
* ----------------------------
* 
*/

@Controller
public class CEstudiante extends CGenerico {

	@Wire
	private Radiogroup rdgTipoCedulaEstudiante;
	@Wire
	private Radio rdoExtranjero;
	@Wire
	private Radio rdoVenezolano;
	@Wire
	private Textbox txtCedulaEstudiante;
	@Wire
	private Textbox txtNombre1Estudiante;
	@Wire
	private Textbox txtNombre2Estudiante;
	@Wire
	private Textbox txtApellido1Estudiante;
	@Wire
	private Textbox txtApellido2Estudiante;
	@Wire
	private Radiogroup rdgSexoEstudiante;
	@Wire
	private Radio rdoSexoFemeninoEstudiante;
	@Wire
	private Radio rdoAprobado;
	@Wire
	private Radio rdoNoAprobado;
	@Wire
	private Radio rdoSexoMasculinoEstudiante;
	@Wire
	private Combobox cmbEstadoCivilEstudiante;
	@Wire
	private Datebox dtbFechaNacimientoEstudiante;
	@Wire
	private Textbox txtResidenciaEstudiante;
	@Wire
	private Textbox txtCorreo;
	@Wire
	private Intbox txtTelefonoMovilEstudiante;
	@Wire
	private Intbox txtTelefonoLocalEstudiante;
	// @Wire
	// private Image imagen;
	// @Wire
	// private Fileupload fotoEstudiante;
	// @Wire
	// private Media media;
	@Wire
	private Combobox cmbPrograma;
	@Wire
	private Textbox txtPromedio;
	@Wire
	private Combobox cmbSemestre;
	@Wire
	private Intbox txtCreditosAprobados;
	@Wire
	private Radiogroup rdgServicioComunitario;
	@Wire
	private Div botoneraEstandar;
	@Wire
	private Div catalogoEstudiante;
	Catalogo<Estudiante> catalogo;
	SEstudiante servicioEstudiante = BeanServicios.getSEstudiante();
	SPrograma servicioPrograma = BeanServicios.getSPrograma();

	public CEstudiante() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	void inicializar() {
		comboPrograma();
		rdoVenezolano.setChecked(true);
		final Calendar calendario = Calendar.getInstance();
		BotoneraMaestros botonera = new BotoneraMaestros() {

			@Override
			public void guardar() {
				String cedula = txtCedulaEstudiante.getValue();
				String nacionalidad = rdgTipoCedulaEstudiante.getSelectedItem()
						.getLabel();
				String nombre1 = txtNombre1Estudiante.getValue();
				String nombre2 = txtNombre2Estudiante.getValue();
				String apellido1 = txtApellido1Estudiante.getValue();
				String apellido2 = txtApellido2Estudiante.getValue();
				// String sexoe =
				// rdgSexoEstudiante.getSelectedItem().getLabel();
				String estadoCivil = cmbEstadoCivilEstudiante.getValue();
				Date fechaNacimiento = dtbFechaNacimientoEstudiante.getValue();
				String residencia = txtResidenciaEstudiante.getValue();
				String correo = txtCorreo.getValue();
				String telefono1 = String.valueOf(txtTelefonoMovilEstudiante
						.getValue());
				String telefono2 = String.valueOf(txtTelefonoLocalEstudiante
						.getValue());
				// Hacer lo de la imagen
				// byte[] fotoe=imagen.getContent().getByteData();
				String nombrePrograma = cmbPrograma.getValue();
				Programa programa = servicioPrograma
						.buscarPorNombrePrograma(nombrePrograma);
				float promedio = Float.parseFloat(txtPromedio.getValue());
				int semestre = Integer.parseInt(cmbSemestre.getValue());
				int creditos = txtCreditosAprobados.getValue();
				boolean estadoEliminacion = true;
				boolean servicioComunitario = false;
				String sexo = "";
				String horaAuditoria = String.valueOf(calendario
						.get(Calendar.HOUR_OF_DAY))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.MINUTE))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.SECOND));
				java.util.Date fechaAuditoria = new Date();
				if (rdoSexoFemeninoEstudiante.isChecked())
					sexo = "Femenino";
				if (rdoSexoMasculinoEstudiante.isChecked())
					sexo = "Masculino";
				if (rdgServicioComunitario.getSelectedItem().getValue() == "Aprobado")
					servicioComunitario = true;
				Estudiante nuevoEstudiante = new Estudiante(cedula, programa,
						nacionalidad, nombre1, nombre2, apellido1, apellido2,
						sexo, estadoCivil, fechaNacimiento, residencia, correo,
						telefono1, telefono2, promedio, semestre, creditos,
						servicioComunitario, nombre1, nombre2, fechaAuditoria,
						horaAuditoria, estadoEliminacion);
				servicioEstudiante.guardar(nuevoEstudiante);
				Messagebox.show("Estudiante Guardado Satisfactoriamente");
				limpiar();
			}

			@Override
			public void limpiar() {
				// Metodo de limíar
				txtCedulaEstudiante.setValue("");
				rdgTipoCedulaEstudiante.setSelectedItem(null);
				txtNombre1Estudiante.setValue("");
				txtNombre2Estudiante.setValue("");
				txtApellido1Estudiante.setValue("");
				txtApellido2Estudiante.setValue("");
				cmbEstadoCivilEstudiante.setValue("");
				dtbFechaNacimientoEstudiante.setValue(null);
				txtResidenciaEstudiante.setValue("");
				txtCorreo.setValue("");
				txtTelefonoMovilEstudiante.setValue(null);
				txtTelefonoLocalEstudiante.setValue(null);
				cmbPrograma.setValue("");
				txtPromedio.setValue("");
				cmbSemestre.setValue("");
				txtCreditosAprobados.setValue(null);
				rdgServicioComunitario.setSelectedItem(null);
				rdgSexoEstudiante.setSelectedItem(null);
			}

			@Override
			public void salir() {
				//
			}

			@Override
			public void eliminar() {
				Estudiante nuevoEstudiante = servicioEstudiante
						.buscarEstudiante(txtCedulaEstudiante.getValue());
				nuevoEstudiante.setEstadoEliminacion(false);
				servicioEstudiante.guardar(nuevoEstudiante);
				Messagebox.show("Estudiante Eliminado Satisfactoriamente");
				limpiar();
			}
		};
		botoneraEstandar.appendChild(botonera);
	}

	public void comboPrograma() {
		List<Programa> programas = servicioPrograma.buscarProgramasActivos();
		cmbPrograma.setModel(new ListModelList<Programa>(programas));
	}

	// @Listen("onUpload = #fotoEstudiante")
	// public void processMedia(UploadEvent event) {
	// media=event.getMedia();
	// imagen.setContent((org.zkoss.image.Image) media);
	//
	// }

	@Listen("onClick = #btnBuscar")
	public void mostrarCatalogo() throws IOException {
		List<Estudiante> estudiantes = servicioEstudiante
				.buscarEstudiantesActivos();
		catalogo = new Catalogo<Estudiante>(catalogoEstudiante, estudiantes,
				"Cedula", "Nombre", "Apellido", "Sexo", "Programa") {

			@Override
			protected String[] crearRegistros(Estudiante estudiante) {
				String[] registros = new String[5];
				registros[0] = estudiante.getCedula();
				registros[1] = estudiante.getNombre1();
				registros[2] = estudiante.getApellido1();
				registros[3] = estudiante.getSexo();
				registros[4] = estudiante.getPrograma().getNombre();
				return registros;
			}

			@Override
			protected List<Estudiante> buscar(String valor) {
				return servicioEstudiante.buscarCualquierCampoContiene(valor);
			}
		};
		catalogo.setParent(catalogoEstudiante);
		catalogo.doModal();
	}

	@Listen("onSeleccion = #catalogoEstudiante")
	public void seleccion() {
		Estudiante estudianteSeleccionado;
		estudianteSeleccionado = catalogo.objetoSeleccionadoDelCatalogo();
		txtCedulaEstudiante.setValue(estudianteSeleccionado.getCedula());
		txtNombre1Estudiante.setValue(estudianteSeleccionado.getNombre1());
		txtNombre2Estudiante.setValue(estudianteSeleccionado.getNombre2());
		txtApellido1Estudiante.setValue(estudianteSeleccionado.getApellido1());
		txtApellido2Estudiante.setValue(estudianteSeleccionado.getApellido2());
		cmbPrograma.setValue(estudianteSeleccionado.getPrograma().getNombre());
		cmbEstadoCivilEstudiante.setValue(estudianteSeleccionado.getEdoCivil());
		dtbFechaNacimientoEstudiante.setValue(estudianteSeleccionado
				.getFechaNacimiento());
		txtResidenciaEstudiante
				.setValue(estudianteSeleccionado.getResidencia());
		txtCorreo.setValue(estudianteSeleccionado.getCorreo());
		txtTelefonoMovilEstudiante.setValue(Integer
				.valueOf(estudianteSeleccionado.getTelefono1()));
		txtTelefonoLocalEstudiante.setValue(Integer
				.valueOf(estudianteSeleccionado.getTelefono2()));
		txtPromedio.setValue(String.valueOf(estudianteSeleccionado
				.getPromedio()));
		cmbSemestre.setValue(String.valueOf(estudianteSeleccionado
				.getSemestre()));
		txtCreditosAprobados.setValue(estudianteSeleccionado.getCreditos());

		// BufferedImage imag=ImageIO.read(new
		// ByteArrayInputStream(estudiantes.getFoto()));
		// imagen.setContent(imag);

		if (estudianteSeleccionado.getNacionalidad().equals("V")) {
			rdoVenezolano.setChecked(true);
			rdoExtranjero.setChecked(false);
		} else {
			rdoExtranjero.setChecked(true);
			rdoVenezolano.setChecked(false);
		}
		if (estudianteSeleccionado.getSexo().equals("Femenino")) {
			rdoSexoFemeninoEstudiante.setChecked(true);
			rdoSexoMasculinoEstudiante.setChecked(false);
		} else {
			rdoSexoMasculinoEstudiante.setChecked(true);
			rdoSexoFemeninoEstudiante.setChecked(false);
		}
		if (estudianteSeleccionado.getServicioComunitario() == true) {
			rdoAprobado.setSelected(true);
			rdoNoAprobado.setSelected(false);
		} else {
			rdoNoAprobado.setSelected(true);
			rdoAprobado.setSelected(false);
		}
		txtCedulaEstudiante.setDisabled(true);
		rdoVenezolano.setDisabled(true);
		rdoExtranjero.setDisabled(true);
		catalogo.setParent(null);
	}
}
