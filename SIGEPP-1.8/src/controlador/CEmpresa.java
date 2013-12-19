package controlador;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.Empresa;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import servicio.SEmpresa;

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
* Fecha: 16/12/2013
* Descripcion: Se le integro el componente de Catalogo
* ----------------------------
* 
*/

@Controller
public class CEmpresa extends CGenerico {

	@Wire
	private Button btnBuscarEmpresa;
	@Wire
	private Textbox txtRifEmpresa;
	@Wire
	private Textbox txtNombreEmpresa;
	@Wire
	private Textbox txtDireccion1Empresa;
	@Wire
	private Textbox txtDireccion2Empresa;
	@Wire
	private Intbox txtTelefonolocalEmpresa;
	@Wire
	private Intbox txtTelefonoMovilEmpresa;
	@Wire
	private Textbox txtCorreo1Empresa;
	@Wire
	private Textbox txtCorreo2Empresa;
	@Wire
	private Textbox txtNombreContacto;
	@Wire
	private Div botoneraEstandar;
	@Wire
	private Div catalogoEmpresa;
	Catalogo<Empresa> catalogo;
	SEmpresa servicioEmpresa = BeanServicios.getSEmpresa();

	public CEmpresa() {
		// TODO Auto-generated constructor stub
	}

	@Override
	void inicializar() {
		final Calendar calendario = Calendar.getInstance();
		BotoneraMaestros botonera = new BotoneraMaestros() {

			@Override
			public void guardar() {
				String rif = txtRifEmpresa.getValue();
				String nombre = txtNombreEmpresa.getValue();
				String direccion1 = txtDireccion1Empresa.getValue();
				String direccion2 = txtDireccion2Empresa.getValue();
				String telefono1 = String.valueOf(txtTelefonolocalEmpresa
						.getValue());
				String telefono2 = String.valueOf(txtTelefonolocalEmpresa
						.getValue());
				String correo1 = txtCorreo1Empresa.getValue();
				String correo2 = txtCorreo2Empresa.getValue();
				String nombreContacto = txtNombreContacto.getValue();
				boolean estado = true;
				String horaAuditoria = String.valueOf(calendario
						.get(Calendar.HOUR_OF_DAY))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.MINUTE))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.SECOND));
				java.util.Date fecha = new Date();
				Empresa nuevaEmpresa = new Empresa(rif, nombre, direccion1,
						direccion2, telefono1, telefono2, correo1, correo2,
						nombreContacto, fecha, horaAuditoria, nombre, true);
				servicioEmpresa.guardar(nuevaEmpresa);
				Messagebox.show("Se Guardo Exitosamente");
				limpiar();
			}

			@Listen("onClick = #botonlimpiar")
			public void limpiar() {
				txtRifEmpresa.setDisabled(false);
				txtRifEmpresa.setValue("");
				txtNombreEmpresa.setValue("");
				txtDireccion1Empresa.setValue("");
				txtDireccion2Empresa.setValue("");
				txtTelefonolocalEmpresa.setValue(null);
				txtTelefonoMovilEmpresa.setValue(null);
				txtCorreo1Empresa.setValue("");
				txtCorreo2Empresa.setValue("");
				txtNombreContacto.setValue("");
			}

			@Override
			public void salir() {
				//
			}

			@Override
			public void eliminar() {
				String rif = txtRifEmpresa.getValue();
				Empresa empresa = servicioEmpresa.buscarEmpresa(rif);
				empresa.setEstadoEliminacion(false);
				servicioEmpresa.guardar(empresa);
				limpiar();
				Messagebox.show("Se Elimino Exitosamente");
			}
		};
		botoneraEstandar.appendChild(botonera);
	}

	@Listen("onClick = #btnBuscarEmpresa")
	public void mostrarCatalogo() throws IOException {
		List<Empresa> empresas = servicioEmpresa.buscarEmpresasActivas();
		catalogo = new Catalogo<Empresa>(catalogoEmpresa, empresas, "RIF",
				"Nombre", "Direccion", "Telefono", "Correo") {

			@Override
			protected String[] crearRegistros(Empresa empresa) {
				String[] registros = new String[5];
				registros[0] = empresa.getRif();
				registros[1] = empresa.getNombre();
				registros[2] = empresa.getDireccion1();
				registros[3] = empresa.getTelefono1();
				registros[4] = empresa.getCorreoElectronico1();
				return registros;
			}

			@Override
			protected List<Empresa> buscar(String valor) {
				return servicioEmpresa.buscarCualquierCampoContiene(valor);
			}
		};
		catalogo.setParent(catalogoEmpresa);
		catalogo.doModal();
	}

	@Listen("onSeleccion = #catalogoEmpresa")
	public void seleccion() {
		Empresa empresaSeleccionada;
		empresaSeleccionada = catalogo.objetoSeleccionadoDelCatalogo();
		txtRifEmpresa.setValue(empresaSeleccionada.getRif());
		txtRifEmpresa.setDisabled(true);
		txtNombreEmpresa.setValue(empresaSeleccionada.getNombre());
		txtDireccion1Empresa.setValue(empresaSeleccionada.getDireccion1());
		txtDireccion2Empresa.setValue(empresaSeleccionada.getDireccion2());
		txtTelefonolocalEmpresa.setValue(Integer.parseInt(empresaSeleccionada
				.getTelefono1()));
		txtTelefonoMovilEmpresa.setValue(Integer.parseInt(empresaSeleccionada
				.getTelefono2()));
		txtCorreo1Empresa.setValue(empresaSeleccionada.getCorreoElectronico1());
		txtCorreo2Empresa.setValue(empresaSeleccionada.getCorreoElectronico2());
		txtNombreContacto.setValue(empresaSeleccionada.getPersonaContacto());
		// Borra el catalogo de la pantalla
		catalogo.setParent(null);
	}
}
