package controlador;

import java.awt.Button;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import modelo.LapsoActividad;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import servicio.SLapsoActividad;

import componentes.BotoneraMaestros;
import componentes.Catalogo;

import configuracion.BeanServicios;

/** FASES DE LA PRACTICA PROFESIONAL
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
public class CLapsoActividad extends CGenerico {
	@Wire
	private Div botoneraEstandar;
	@Wire
	private Textbox txtNombreLapsoActividad;
	@Wire
	private Textbox txtDescripcionLapsoActividad;
	@Wire
	private Button btnBuscarLapsoActividad;
	@Wire
	private Div catalogoActividadLapso;
	long id = 0;
	Catalogo<LapsoActividad> catalogo;
	SLapsoActividad servicioLapsoActividad = BeanServicios.getSLapsoActividad();

	public CLapsoActividad() {
		// TODO Auto-generated constructor stub
	}

	@Override
	void inicializar() {
		final Calendar calendario = Calendar.getInstance();
		BotoneraMaestros botonera = new BotoneraMaestros() {

			@Override
			public void guardar() {
				String nombre = txtNombreLapsoActividad.getValue();
				String descripcion = txtDescripcionLapsoActividad.getValue();
				String horaAuditoria = String.valueOf(calendario
						.get(Calendar.HOUR_OF_DAY))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.MINUTE))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.SECOND));
				java.util.Date fecha = new Date();
				boolean estado = true;
				LapsoActividad nuevoActividadLapso = new LapsoActividad(id,
						nombre, descripcion, fecha, horaAuditoria,
						estado);
				
				servicioLapsoActividad.guardar(nuevoActividadLapso);
				limpiar();
				Messagebox.show("Fase Guardada Satisfactoriamente");
				id = 0;
			}

			@Override
			public void limpiar() {
				// Metodo de eliminar
				txtNombreLapsoActividad.setValue("");
				txtDescripcionLapsoActividad.setValue("");
			}

			@Override
			public void salir() {
				//
			}

			@Override
			public void eliminar() {
				LapsoActividad actividadLapso = servicioLapsoActividad
						.buscarLapsoActividad(id);
				actividadLapso.setEstadoEliminacion(false);
				servicioLapsoActividad.guardar(actividadLapso);
				Messagebox.show("Se Elimino Exitosamente");
				id = 0;
				limpiar();
			}
		};
		botoneraEstandar.appendChild(botonera);
	}

	@Listen("onClick = #btnBuscarLapsoActividad")
	public void mostrarCatalogo() {
		List<LapsoActividad> areasAcademicas = servicioLapsoActividad
				.buscarActividadesLapsoActivas();
		catalogo = new Catalogo<LapsoActividad>(catalogoActividadLapso,
				areasAcademicas, "Nombre") {

			@Override
			protected String[] crearRegistros(LapsoActividad actividadLapso) {
				String[] registros = new String[2];
				registros[0] = actividadLapso.getNombre();
		//		registros[1] = actividadLapso.getDescripcion();
				return registros;
			}

			@Override
			protected List<LapsoActividad> buscar(String valor) {
				return servicioLapsoActividad
						.buscarCualquierCampoContiene(valor);
			}
		};
		catalogo.setParent(catalogoActividadLapso);
		catalogo.doModal();
	}

	@Listen("onSeleccion = #catalogoActividadLapso")
	public void seleccion() {
		LapsoActividad actividadLapsoSeleccionada;
		actividadLapsoSeleccionada = catalogo.objetoSeleccionadoDelCatalogo();
		txtNombreLapsoActividad.setValue(actividadLapsoSeleccionada.getNombre());
	//	txtDescripcionLapsoActividad.setValue(actividadLapsoSeleccionada.getDescripcion());
		id = actividadLapsoSeleccionada.getId();
		// Borra el catalogo de la pantalla
		catalogo.setParent(null);
	}
}
