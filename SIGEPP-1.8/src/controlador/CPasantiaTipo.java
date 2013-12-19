package controlador;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.PasantiaTipo;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import servicio.SPrograma;
import servicio.SPasantiaTipo;

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
* Autor:  Luis Devides
* Revisado por: Ysolmery Maiorano
* Fecha: 15/12/2013
* Descripcion: Se le integro el componente de Catalogo
* ----------------------------
* 
*/

@Controller
public class CPasantiaTipo extends CGenerico {

	@Wire
	private Textbox txtDescripcionTipoPasantia;
	@Wire
	private Textbox txtObservacionTipoPasantia;
	@Wire
	private Div botoneraEstandar;
	@Wire
	private Div catalogoTipoPasantia;
	@Wire
	private Button btnBuscarTipoPasantia;
	private long id;
	Catalogo<PasantiaTipo> catalogo;
	SPasantiaTipo servicioPasantiaTipo = BeanServicios.getSPasantiaTipo();
	SPrograma servicioPrograma = BeanServicios.getSPrograma();

	public CPasantiaTipo() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	void inicializar() {
		id = 0;
		final Calendar calendario = Calendar.getInstance();
		BotoneraMaestros botonera = new BotoneraMaestros() {

			@Override
			public void guardar() {
				// Metodo de guardar
				boolean estado = true;
				String horaAuditoria = String.valueOf(calendario
						.get(Calendar.HOUR_OF_DAY))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.MINUTE))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.SECOND));
				java.util.Date fecha = new Date();
				String descripcion = txtDescripcionTipoPasantia.getValue();
				String observacion = txtObservacionTipoPasantia.getValue();
				PasantiaTipo nuevoTipoPasantia = new PasantiaTipo(id,
						descripcion, observacion, descripcion, fecha,
						horaAuditoria, estado);
				servicioPasantiaTipo.guardar(nuevoTipoPasantia);
				Messagebox.show("Tipo de Pasantia Guardado Satisfactoriamente");
				limpiar();
				id = 0;
			}

			@Override
			public void limpiar() {
				// Metodo de limíar
				txtDescripcionTipoPasantia.setValue("");
				txtObservacionTipoPasantia.setValue("");
			}

			@Override
			public void salir() {
				//
			}

			@Override
			public void eliminar() {
			PasantiaTipo nuevoTipoPasantia = servicioPasantiaTipo
						.buscarTipoPasantia(id);
				nuevoTipoPasantia.setEstadoEliminacion(false);
				servicioPasantiaTipo.guardar(nuevoTipoPasantia);
				limpiar();
				Messagebox
						.show("Tipo de Pasantia Eliminado Satisfactoriamente");
				id = 0;
			}
		};
		botoneraEstandar.appendChild(botonera);
	}

	@Listen("onClick = #btnBuscarTipoPasantia")
	public void mostrarCatalogo() {
		List<PasantiaTipo> tipoPasantia = servicioPasantiaTipo.buscarTipoPasantiasActivos();
		catalogo = new Catalogo<PasantiaTipo>(catalogoTipoPasantia,
				tipoPasantia, "Descripcion", "Observacion") {

			@Override
			protected String[] crearRegistros(PasantiaTipo tipoPasantia) {
				String[] registros = new String[2];
				registros[0] = tipoPasantia.getDescripcion();
				registros[1] = tipoPasantia.getObservacion();
				return registros;
			}

			@Override
			protected List<PasantiaTipo> buscar(String valor) {
				return servicioPasantiaTipo
						.buscarCualquierCampoContiene(valor);
			}
		};
		catalogo.setParent(catalogoTipoPasantia);
		catalogo.doModal();
	}

	@Listen("onSeleccion = #catalogoTipoPasantia")
	public void seleccion() {
		PasantiaTipo tipoPasantiaSeleccionado;
		tipoPasantiaSeleccionado = catalogo.objetoSeleccionadoDelCatalogo();
		txtDescripcionTipoPasantia.setValue(tipoPasantiaSeleccionado.getDescripcion());
		txtObservacionTipoPasantia.setValue(tipoPasantiaSeleccionado.getObservacion());
		id = tipoPasantiaSeleccionado.getId();
		// Borra el catalogo de la pantalla
		catalogo.setParent(null);
	}
}