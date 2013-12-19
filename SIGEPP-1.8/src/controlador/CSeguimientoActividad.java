package controlador;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.SeguimientoActividad;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import servicio.SSeguimientoActividad;

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
* Autor: Luis Devides
* Revisado por: Ysolmery Maiorano
* Fecha: 15/12/2013
* Descripcion: Se le integro el componente de Catalogo
* ----------------------------
* 
*/

@Controller
public class CSeguimientoActividad extends CGenerico {

	@Wire
	private Textbox txtDescripcionActividad;
	@Wire
	private Textbox txtFactorActividad;
	@Wire
	private Div botoneraEstandar;
	@Wire
	private Button btnBuscarSeguimientoActividad;
	@Wire
	private Div catalogoSeguimientoActividad;
	public long id = 0;
	public boolean exito = false;
	Catalogo<SeguimientoActividad> catalogo;
	SSeguimientoActividad servicioSeguimientoActividad = BeanServicios
			.getSSeguimientoActividad();

	public CSeguimientoActividad() {
		// TODO Auto-generated constructor stub
	}

	@Override
	void inicializar() {
		// TODO Auto-generated method stub
		final Calendar calendario = Calendar.getInstance();
		BotoneraMaestros botonera = new BotoneraMaestros() {

			@Override
			public void guardar() {
				if (txtDescripcionActividad.equals("")) {
					System.out.print("Existen Campos Vacios");
				} else {
					boolean estado = true;
					String descripcion = txtDescripcionActividad.getValue();
					String factor = txtFactorActividad.getValue();
					String horaAuditoria = String.valueOf(calendario
							.get(Calendar.HOUR_OF_DAY))
							+ ":"
							+ String.valueOf(calendario.get(Calendar.MINUTE))
							+ ":"
							+ String.valueOf(calendario.get(Calendar.SECOND));
					java.util.Date fecha = new Date();
					SeguimientoActividad actividad = new SeguimientoActividad(
							id, descripcion, factor, descripcion, fecha,
							horaAuditoria, estado);
					Messagebox.show("Se ha Guardado Exitosamente");
					servicioSeguimientoActividad.guardar(actividad);
					limpiar();
				}
			}

			@Override
			public void limpiar() {
				txtDescripcionActividad.setValue("");
				txtFactorActividad.setValue("");
			}

			@Override
			public void salir() {

			}

			@Override
			public void eliminar() {
				if (exito == true) {
					SeguimientoActividad actividad = servicioSeguimientoActividad
							.buscarSeguimientoActividad(id);
					actividad.setEstadoEliminacion(false);
					servicioSeguimientoActividad.guardar(actividad);
					Messagebox.show("Se ha Eliminado Exitosamente");
					limpiar();
					exito = false;
				} else {
					Messagebox
							.show("No ha seleccionado ningun Seguimiento de Actividad");
				}
			}
		};
		botoneraEstandar.appendChild(botonera);
	}

	@Listen("onClick = #btnBuscarSeguimientoActividad")
	public void mostrarCatalogo() throws IOException {
		List<SeguimientoActividad> seguimientoActividades = servicioSeguimientoActividad
				.buscarSeguimientoActividadActivos();
		catalogo = new Catalogo<SeguimientoActividad>(
				catalogoSeguimientoActividad, seguimientoActividades,
				"Descripcion","Factor") {

			@Override
			protected String[] crearRegistros(SeguimientoActividad seguimientoActividad) {
				String[] registros = new String[2];
				registros[0] = seguimientoActividad.getDescripcion();
				registros[1] = seguimientoActividad.getFactor();
				return registros;
			}

			@Override
			protected List<SeguimientoActividad> buscar(String valor) {
				return servicioSeguimientoActividad
						.buscarCualquierCampoContiene(valor);
			}
		};
		catalogo.setParent(catalogoSeguimientoActividad);
		catalogo.doModal();
	}

	@Listen("onSeleccion = #catalogoSeguimientoActividad")
	public void seleccion() {
		SeguimientoActividad seguimientoActidiadSeleccionada;
		seguimientoActidiadSeleccionada = catalogo.objetoSeleccionadoDelCatalogo();
		txtDescripcionActividad.setValue(seguimientoActidiadSeleccionada
				.getDescripcion());
		txtFactorActividad.setValue(seguimientoActidiadSeleccionada
				.getFactor());
		id = seguimientoActidiadSeleccionada.getId();
		// Borra el catalogo de la pantalla
		catalogo.setParent(null);
	}
}