package controlador;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.Departamento;
import modelo.Empresa;
import modelo.TutorEmpresarial;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
import org.zkoss.zul.Textbox;

import servicio.SEmpresa;
import servicio.STutorEmpresarial;

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
public class CTutorEmpresarial extends CGenerico {

	@Wire
	private Button btnBuscarTutorEmpresarial;
	@Wire
	private Radiogroup rdbTipoCedulaTutorEmpresarial;
	@Wire
	private Textbox txtCedulaTutorEmpresarial;
	@Wire
	private Textbox txtNombre1TutorEmpresarial;
	@Wire
	private Textbox txtNombre2TutorEmpresarial;
	@Wire
	private Textbox txtApellido1TutorEmpresarial;
	@Wire
	private Textbox txtApellido2TutorEmpresarial;
	@Wire
	private Radiogroup rdbSexoTutorEmpresarial;
	@Wire
	private Textbox txtCorreoTutorEmpresarial;
	@Wire
	private Intbox txtTelefono1TutorEmpresarial;
	@Wire
	private Intbox txtTelefono2TutorEmpresarial;
	@Wire
	private Combobox cmbEmpresa;
	@Wire
	private Div botoneraEstandar;
	@Wire
	private Div catalogoTutorEmpresarial;
	@Wire
	private Radio rdoFemenino;
	@Wire
	private Radio rdoMasculino;
	@Wire
	private Radio rdoVenezolano;
	@Wire
	private Radio rdoExtranjero;
	Catalogo<TutorEmpresarial> catalogo;
	STutorEmpresarial servicioTutorEmpresarial = BeanServicios
			.getSTutorEmpresarial();
	SEmpresa servicioEmpresa = BeanServicios.getSEmpresa();

	public CTutorEmpresarial() {
		// TODO Auto-generated constructor stub
	}

	@Override
	void inicializar() {
		comboEmpresa();
		final Calendar calendario = Calendar.getInstance();
		BotoneraMaestros botonera = new BotoneraMaestros() {

			@Override
			public void guardar() {
				String cedula = txtCedulaTutorEmpresarial.getValue();
				String nacionalidad = rdbTipoCedulaTutorEmpresarial
						.getSelectedItem().getLabel();
				String nombre1 = txtNombre1TutorEmpresarial.getValue();
				String nombre2 = txtNombre2TutorEmpresarial.getValue();
				String apellido1 = txtApellido1TutorEmpresarial.getValue();
				String apellido2 = txtApellido2TutorEmpresarial.getValue();
				String correo = txtCorreoTutorEmpresarial.getValue();
				String telefono1 = String.valueOf(txtTelefono1TutorEmpresarial
						.getValue());
				String telefono2 = String.valueOf(txtTelefono2TutorEmpresarial
						.getValue());
				// Hacer lo de la imagen
				// byte[] fotoe=imagen.getContent().getByteData();
				String nombreEmpresa = cmbEmpresa.getValue();
				Empresa empresa = servicioEmpresa
						.buscarPorNombreEmpresa(nombreEmpresa);
				boolean estado = true;
				String sexo = "";
				if (rdoFemenino.isChecked())
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
				TutorEmpresarial nuevoTutor = new TutorEmpresarial(cedula,
						empresa, nacionalidad, nombre1, nombre2, apellido1,
						apellido2, sexo, correo, telefono1, telefono2, "", "",
						nombre1, fecha, horaAuditoria, true);
				servicioTutorEmpresarial.guardar(nuevoTutor);
				limpiar();
				Messagebox.show("Se Guardo Exitosamente");
			}

			@Override
			public void limpiar() {
				rdoVenezolano.setDisabled(false);
				rdoExtranjero.setDisabled(false);
				rdbTipoCedulaTutorEmpresarial.setSelectedItem(null);
				txtCedulaTutorEmpresarial.setValue("");
				rdoVenezolano.setValue(null);
				rdoExtranjero.setValue(null);
				txtNombre1TutorEmpresarial.setValue("");
				txtNombre2TutorEmpresarial.setValue("");
				txtApellido1TutorEmpresarial.setValue("");
				txtApellido2TutorEmpresarial.setValue("");
				rdbSexoTutorEmpresarial.setSelectedItem(null);
				txtCorreoTutorEmpresarial.setValue("");
				txtTelefono1TutorEmpresarial.setValue(null);
				txtTelefono2TutorEmpresarial.setValue(null);
				cmbEmpresa.setValue(null);
			}

			@Override
			public void salir() {
				//
			}

			@Override
			public void eliminar() {
				String cedula = txtCedulaTutorEmpresarial.getValue();
				TutorEmpresarial tutorEmpresarial = servicioTutorEmpresarial
						.buscarTutorEmpresarial(cedula);
				tutorEmpresarial.setEstadoEliminacion(false);
				servicioTutorEmpresarial.guardar(tutorEmpresarial);
				Messagebox.show("Se Elimino Exitosamente");
				limpiar();
				Messagebox.show("Tutor Eliminado");
			}
		};
		botoneraEstandar.appendChild(botonera);
	}

	public void comboEmpresa() {
		List<Empresa> empresas = servicioEmpresa.buscarEmpresasActivas();
		cmbEmpresa.setModel(new ListModelList<Empresa>(empresas));
	}

	@Listen("onClick = #btnBuscarTutorEmpresarial")
	public void mostrarCatalogo() throws IOException {
		List<TutorEmpresarial> tutoresAcademicos = servicioTutorEmpresarial
				.buscarTutoresActivos();
		catalogo = new Catalogo<TutorEmpresarial>(catalogoTutorEmpresarial,
				tutoresAcademicos, "Cedula", "Nombre", "Apellido", "Correo",
				"Telefono", "Empresa") {

			@Override
			protected String[] crearRegistros(TutorEmpresarial tutorEmpresarial) {
				String[] registros = new String[6];
				registros[0] = tutorEmpresarial.getCedula();
				registros[1] = tutorEmpresarial.getNombre1();
				registros[2] = tutorEmpresarial.getApellido1();
				registros[3] = tutorEmpresarial.getCorreo();
				registros[4] = tutorEmpresarial.getTelefono1();
				registros[5] = tutorEmpresarial.getEmpresa().getNombre();
				return registros;
			}

			@Override
			protected List<TutorEmpresarial> buscar(String valor) {
				return servicioTutorEmpresarial
						.buscarCualquierCampoContiene(valor);
			}
		};
		catalogo.setParent(catalogoTutorEmpresarial);
		catalogo.doModal();
	}

	@Listen("onSeleccion = #catalogoTutorEmpresarial")
	public void seleccion() {
		TutorEmpresarial tutorEmpresarialSeleccionado;
		tutorEmpresarialSeleccionado = catalogo.objetoSeleccionadoDelCatalogo();
		if (tutorEmpresarialSeleccionado.getNacionalidad().equals("V")) {
			rdoVenezolano.setChecked(true);
			rdoExtranjero.setChecked(false);
		} else {
			rdoExtranjero.setChecked(true);
			rdoVenezolano.setChecked(false);
		}
		txtCedulaTutorEmpresarial.setValue(tutorEmpresarialSeleccionado
				.getCedula());
		txtNombre1TutorEmpresarial.setValue(tutorEmpresarialSeleccionado
				.getNombre1());
		txtNombre2TutorEmpresarial.setValue(tutorEmpresarialSeleccionado
				.getNombre2());
		txtApellido1TutorEmpresarial.setValue(tutorEmpresarialSeleccionado
				.getApellido1());
		txtApellido2TutorEmpresarial.setValue(tutorEmpresarialSeleccionado
				.getApellido2());
		if (tutorEmpresarialSeleccionado.getSexo().equals("Femenino")) {
			rdoFemenino.setChecked(true);
			rdoMasculino.setChecked(false);
		} else {
			rdoMasculino.setChecked(true);
			rdoFemenino.setChecked(false);
		}
		txtCorreoTutorEmpresarial.setValue(tutorEmpresarialSeleccionado
				.getCorreo());
		txtTelefono1TutorEmpresarial.setValue(Integer
				.parseInt(tutorEmpresarialSeleccionado.getTelefono1()));
		txtTelefono2TutorEmpresarial.setValue(Integer
				.parseInt(tutorEmpresarialSeleccionado.getTelefono2()));
		cmbEmpresa.setValue(tutorEmpresarialSeleccionado.getEmpresa()
				.getNombre());
		txtCedulaTutorEmpresarial.setDisabled(true);
		rdoVenezolano.setDisabled(true);
		rdoExtranjero.setDisabled(true);
		// Borra el catalogo de la pantalla
		catalogo.setParent(null);
	}
}