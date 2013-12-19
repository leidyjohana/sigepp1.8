package controlador;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.Departamento;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import servicio.SDepartamento;
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
* Autor: Luis Devides
* Revisado por: Ysolmery Maiorano
* Fecha: 16/12/2013
* Descripcion: Se le integro el componente de Catalogo
* ----------------------------
* 
*/

@Controller
public class CDepartamento extends CGenerico {

	@Wire
	private Textbox txtNombreDepartamento;
	@Wire
	private Textbox txtDescripcionDepartamento;
	@Wire
	private Div botoneraEstandar;
	@Wire
	private Div catalogoDepartamento;
	@Wire
	private Button btnBuscarDepartamento;
	private long id;
	Catalogo<Departamento> catalogo;
	SDepartamento servicioDepartamento = BeanServicios.getSDepartamento();
	SPrograma servicioPrograma = BeanServicios.getSPrograma();

	public CDepartamento() {
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
				String nombre = txtNombreDepartamento.getValue();
				String descripcion = txtDescripcionDepartamento.getValue();
				Departamento nuevoDepartamento = new Departamento(id, nombre,
						descripcion, nombre, fecha, horaAuditoria, estado);
				servicioDepartamento.guardar(nuevoDepartamento);
				Messagebox.show("Departamento Guardado Satisfactoriamente");
				limpiar();
				id = 0;
			}

			@Override
			public void limpiar() {
				// Metodo de limíar
				txtNombreDepartamento.setValue("");
				txtDescripcionDepartamento.setValue("");
			}

			@Override
			public void salir() {
			}

			@Override
			public void eliminar() {
				Departamento nuevoDepartamento = servicioDepartamento
						.buscarDepartamento(id);
				nuevoDepartamento.setEstadoEliminacion(false);
				servicioDepartamento.guardar(nuevoDepartamento);
				Messagebox.show("Departamento Eliminado Satisfactoriamente");
				limpiar();
				id = 0;
			}
		};
		botoneraEstandar.appendChild(botonera);
	}

	@Listen("onClick = #btnBuscarDepartamento")
	public void mostrarCatalogo() {
		List<Departamento> departamentos = servicioDepartamento
				.buscarDepartamentosActivos();
		catalogo = new Catalogo<Departamento>(catalogoDepartamento,
				departamentos, "Nombre", "Descripcion") {

			@Override
			protected String[] crearRegistros(Departamento departamento) {
				String[] registros = new String[2];
				registros[0] = departamento.getNombre();
				registros[1] = departamento.getDescripcion();
				return registros;
			}

			@Override
			protected List<Departamento> buscar(String valor) {
				return servicioDepartamento.buscarCualquierCampoContiene(valor);
			}
		};
		catalogo.setParent(catalogoDepartamento);
		catalogo.doModal();
	}

	@Listen("onSeleccion = #catalogoDepartamento")
	public void seleccion() {
		Departamento departamentoSeleccionado;
		departamentoSeleccionado = catalogo.objetoSeleccionadoDelCatalogo();
		txtNombreDepartamento.setValue(departamentoSeleccionado.getNombre());
		txtDescripcionDepartamento.setValue(departamentoSeleccionado
				.getDescripcion());
		id = departamentoSeleccionado.getId();
		// Borra el catalogo de la pantalla
		catalogo.setParent(null);
	}
}