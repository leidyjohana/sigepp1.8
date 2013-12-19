package controlador;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.AreaAcademica;
import modelo.Departamento;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import servicio.SAreaAcademica;
import servicio.SDepartamento;

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
public class CAreaAcademica extends CGenerico {
	@Wire
	private Textbox txtNombreAreaAcademica;
	@Wire
	private Textbox txtDescripcionAreaAcademica;
	@Wire
	private Combobox cmbDepartamento;
	@Wire
	private Button btnBuscarAreaAcademica;
	@Wire
	private Div botoneraEstandar;
	@Wire
	private Div catalogoAreaAcademica;
	long id = 0;
	Catalogo<AreaAcademica> catalogo;
	SAreaAcademica servicioAreaAcademica = BeanServicios.getSAreaAcademica();
	SDepartamento servicioDepartamento = BeanServicios.getSDepartamento();
	
	public CAreaAcademica() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	void inicializar() {
		comboDepartamento();
		final Calendar calendario = Calendar.getInstance();
		BotoneraMaestros botonera = new BotoneraMaestros() {

			@Override
			public void guardar() {
				// Metodo de guardar
				String nombre = txtNombreAreaAcademica.getValue();
				String descripcion = txtDescripcionAreaAcademica.getValue();
				boolean estado = true;
				String nombred = cmbDepartamento.getValue();
				Departamento departamento = servicioDepartamento
						.buscarPorNombreDepartamento(nombred);
				String horaAuditoria = String.valueOf(calendario
						.get(Calendar.HOUR_OF_DAY))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.MINUTE))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.SECOND));
				java.util.Date fecha = new Date();
				AreaAcademica nuevaAreaAcademica = new AreaAcademica(id,
						departamento, nombre, descripcion, nombre, fecha,
						horaAuditoria, estado);
				servicioAreaAcademica.guardar(nuevaAreaAcademica);
				Messagebox.show("Se Guardo Exitosamente");
				id = 0;
				limpiar();
			}

			@Override
			public void limpiar() {
				txtNombreAreaAcademica.setValue("");
				txtDescripcionAreaAcademica.setValue("");
				cmbDepartamento.setValue("");
			}

			@Override
			public void salir() {
				//
			}

			@Override
			public void eliminar() {
				AreaAcademica areaAcademica = servicioAreaAcademica
						.buscarAreaAcademica(id);
				areaAcademica.setEstadoEliminacion(false);
				servicioAreaAcademica.guardar(areaAcademica);
				Messagebox.show("Se Elimino Exitosamente");
				id = 0;
				limpiar();
			}
		};
		botoneraEstandar.appendChild(botonera);
	}

	public void comboDepartamento() {
		List<Departamento> departamento = servicioDepartamento
				.buscarDepartamentosActivos();
		cmbDepartamento.setModel(new ListModelList<Departamento>(departamento));
	}

	@Listen("onClick = #btnBuscarAreaAcademica")
	public void mostrarCatalogo() {
		List<AreaAcademica> areasAcademicas = servicioAreaAcademica
				.buscarAreasActivas();
		catalogo = new Catalogo<AreaAcademica>(catalogoAreaAcademica,
				areasAcademicas, "Nombre", "Descripcion") {

			@Override
			protected String[] crearRegistros(AreaAcademica areaAcademica) {
				String[] registros = new String[2];
				registros[0] = areaAcademica.getNombre();
				registros[1] = areaAcademica.getDescripcion();
				return registros;
			}

			@Override
			protected List<AreaAcademica> buscar(String valor) {
				return servicioAreaAcademica
						.buscarCualquierCampoContiene(valor);
			}
		};
		catalogo.setParent(catalogoAreaAcademica);
		catalogo.doModal();
	}

	@Listen("onSeleccion = #catalogoAreaAcademica")
	public void seleccion() {
		AreaAcademica areaAcademicaSeleccionada;
		areaAcademicaSeleccionada = catalogo.objetoSeleccionadoDelCatalogo();
		txtNombreAreaAcademica.setValue(areaAcademicaSeleccionada
				.getNombre());
		txtDescripcionAreaAcademica.setValue(areaAcademicaSeleccionada
				.getDescripcion());
		cmbDepartamento.setValue(areaAcademicaSeleccionada.getDepartamento().getNombre());
		id = areaAcademicaSeleccionada.getId();
		// Borra el catalogo de la pantalla
		catalogo.setParent(null);
	}
}
