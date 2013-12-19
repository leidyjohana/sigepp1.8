package controlador;

import java.awt.Button;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.AreaConocimiento;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Div;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import servicio.SAreaConocimiento;

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
public class CAreaConocimiento extends CGenerico {

	@Wire
	private Div botoneraEstandar;
	@Wire
	private Textbox txtNombreAreaConocimiento;
	@Wire
	private Textbox txtDescripcionAreaConocimiento;
	@Wire
	private Button btnBuscarAreaConocimiento;
	@Wire
	private Div catalogoAreaConocimiento;
	long id = 0;
	Catalogo<AreaConocimiento> catalogo;
	SAreaConocimiento servicioAreaConocimiento = BeanServicios
			.getSAreaConocimiento();
	
	public CAreaConocimiento() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	void inicializar() {
		final Calendar calendario = Calendar.getInstance();
		BotoneraMaestros botonera = new BotoneraMaestros() {

			@Override
			public void guardar() {
				// Metodo de guardar
				String nombre = txtNombreAreaConocimiento.getValue();
				String descripcion = txtDescripcionAreaConocimiento.getValue();

				boolean estado = true;

				String horaAuditoria = String.valueOf(calendario
						.get(Calendar.HOUR_OF_DAY))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.MINUTE))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.SECOND));
				java.util.Date fecha = new Date();
				AreaConocimiento areaConocimiento = new AreaConocimiento(id,
						nombre, descripcion, nombre, fecha, horaAuditoria, true);
				servicioAreaConocimiento.guardar(areaConocimiento);
				Messagebox.show("Se Guardo Exitosamente");
				id = 0;
				limpiar();
			}

			@Override
			public void limpiar() {
				// Metodo de limíar
				txtNombreAreaConocimiento.setValue("");
				txtDescripcionAreaConocimiento.setValue("");
			}

			@Override
			public void salir() {
			}

			@Override
			public void eliminar() {
				AreaConocimiento areaConocimiento = servicioAreaConocimiento
						.buscarAreaConocimiento(id);
				areaConocimiento.setEstadoEliminacion(false);
				servicioAreaConocimiento.guardar(areaConocimiento);
				Messagebox.show("Se Elimino Exitosamente");
				id = 0;
				limpiar();
			}
		};
		botoneraEstandar.appendChild(botonera);
	}

	@Listen("onClick = #btnBuscarAreaConocimiento")
	public void mostrarCatalogo() {
		List<AreaConocimiento> areasConocimiento = servicioAreaConocimiento
				.buscarAreasActivas();
		catalogo = new Catalogo<AreaConocimiento>(catalogoAreaConocimiento,
				areasConocimiento, "Nombre", "Descripcion") {

			@Override
			protected String[] crearRegistros(AreaConocimiento areaConocimiento) {
				String[] registros = new String[2];
				registros[0] = areaConocimiento.getNombre();
				registros[1] = areaConocimiento.getDescripcion();
				return registros;
			}

			@Override
			protected List<AreaConocimiento> buscar(String valor) {
				return servicioAreaConocimiento
						.buscarCualquierCampoContiene(valor);
			}
		};
		catalogo.setParent(catalogoAreaConocimiento);
		catalogo.doModal();
	}

	@Listen("onSeleccion = #catalogoAreaConocimiento")
	public void seleccion() {
		AreaConocimiento areaConocimientoSeleccionada;
		areaConocimientoSeleccionada = catalogo.objetoSeleccionadoDelCatalogo();
		txtNombreAreaConocimiento.setValue(areaConocimientoSeleccionada
				.getNombre());
		txtDescripcionAreaConocimiento.setValue(areaConocimientoSeleccionada
				.getDescripcion());
		id = areaConocimientoSeleccionada.getId();
		// Borra el catalogo de la pantalla
		catalogo.setParent(null);
	}
}