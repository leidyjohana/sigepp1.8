package controlador;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import modelo.Departamento;
import modelo.Programa;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Intbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Radio;
import org.zkoss.zul.Radiogroup;
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
* Autor: Michell Lobo
* Revisado por: Ysolmery Maiorano
* Fecha: 15/12/2013
* Descripcion: Se le integro el componente de Catalogo
* ----------------------------
* 
*/

@Controller
public class CPrograma extends CGenerico {

	@Wire
	private Textbox txtNombrePrograma;
	@Wire
	private Textbox txtDescripcionPrograma;
	@Wire
	private Intbox txtTelefonoPrograma;
	@Wire
	private Div botoneraEstandar;
	@Wire
	private Div catalogoPrograma;
	@Wire
	private Radio rdbVariasPasantiasSi;
	@Wire
	private Radio rdbVariasPasantiasNo;
	@Wire
	private Textbox txtTutoriadosPrograma;
	@Wire
	private Radiogroup rdbPasantiasPrograma;
	@Wire
	private Listbox listaDepartamento;
	@Wire
	private Listbox listaDepartamentosAgregados;
	@Wire
	private Button pasar1;
	@Wire
	private Button pasar2;
	private long id;
	Catalogo<Programa> catalogo;
	SPrograma servicioPrograma = BeanServicios.getSPrograma();
	SDepartamento servicioDepartamento = BeanServicios.getSDepartamento();

	public CPrograma() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	void inicializar() {
		listaDepartamentosDisponibles();
		id = 0;
		final Calendar calendario = Calendar.getInstance();
		BotoneraMaestros botonera = new BotoneraMaestros() {

			@Override
			public void guardar() {
				// Metodo de guardar
				boolean estado = true;
				boolean variasPasantias = false;
				String horaAuditoria = String.valueOf(calendario
						.get(Calendar.HOUR_OF_DAY))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.MINUTE))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.SECOND));
				java.util.Date fecha = new Date();
				String nombre = txtNombrePrograma.getValue();
				String descripcion = txtDescripcionPrograma.getValue();
				String telefono = String
						.valueOf(txtTelefonoPrograma.getValue());
				int cantidadTutoriados = Integer.parseInt(txtTutoriadosPrograma
						.getValue());
				if (rdbVariasPasantiasSi.isChecked())
					variasPasantias = true;
				Set<Departamento> arregloDepartamentos = new HashSet<Departamento>();
				for (int i = 0; i < listaDepartamentosAgregados.getItemCount(); i++) {
					Departamento departamento = listaDepartamentosAgregados
							.getItems().get(i).getValue();
					arregloDepartamentos.add(departamento);
				}
				System.out.println(id);
				System.out.println(arregloDepartamentos);
				Programa nuevoPrograma = new Programa(id, nombre, descripcion,
						telefono, variasPasantias, cantidadTutoriados,
						descripcion, fecha, horaAuditoria, estado,
						arregloDepartamentos);
				servicioPrograma.guardar(nuevoPrograma);
				

				
				limpiar();
				Messagebox.show("Programa Guardado Satisfactoriamente");
				id = 0;
			}

			@Override
			public void limpiar() {
				// Metodo de limíar
				txtNombrePrograma.setValue("");
				txtDescripcionPrograma.setValue("");
				txtTelefonoPrograma.setValue(null);
				txtTutoriadosPrograma.setValue("");
				rdbPasantiasPrograma.setSelectedItem(null);
			}

			@Override
			public void salir() {
				//
			}

			@Override
			public void eliminar() {
				Programa nuevoPrograma = servicioPrograma.buscarPrograma(id);
				nuevoPrograma.setEstadoEliminacion(false);
				servicioPrograma.guardar(nuevoPrograma);
				limpiar();
				Messagebox.show("Programa Eliminado Satisfactoriamente");
				id = 0;
			}
		};
		botoneraEstandar.appendChild(botonera);
	}

	@Listen("onClick = #btnBuscarPrograma")
	public void mostrarCatalogo() {
		List<Programa> programas = servicioPrograma.buscarProgramasActivos();
		catalogo = new Catalogo<Programa>(catalogoPrograma, programas,
				"Nombre", "Descripcion", "Telefono", "Tutoriados Permitidos") {

			@Override
			protected String[] crearRegistros(Programa programa) {
				String[] registros = new String[4];
				registros[0] = programa.getNombre();
				registros[1] = programa.getDescripcion();
				registros[2] = programa.getTelefono();
				registros[3] = String.valueOf(programa.getCantidadSugTutorar());
				return registros;
			}

			@Override
			protected List<Programa> buscar(String valor) {
				return servicioPrograma.buscarCualquierCampoContiene(valor);
			}
		};
		catalogo.setParent(catalogoPrograma);
		catalogo.doModal();
	}

	@Listen("onSeleccion = #catalogoPrograma")
	public void seleccion() {
		Programa programaSeleccionado;
		programaSeleccionado = catalogo.objetoSeleccionadoDelCatalogo();
		txtNombrePrograma.setValue(programaSeleccionado.getNombre());
		txtDescripcionPrograma.setValue(programaSeleccionado.getDescripcion());
		id = programaSeleccionado.getId();
		txtTelefonoPrograma.setValue(Integer.valueOf(programaSeleccionado
				.getTelefono()));
		txtTutoriadosPrograma.setValue(String.valueOf(programaSeleccionado
				.getCantidadSugTutorar()));
		if (programaSeleccionado.isPermiteVariasPasantias()) {
			rdbVariasPasantiasSi.setChecked(true);
			rdbVariasPasantiasNo.setChecked(false);
		} else {
			rdbVariasPasantiasSi.setChecked(false);
			rdbVariasPasantiasNo.setChecked(true);
		}
		// Borra el catalogo de la pantalla
		catalogo.setParent(null);
	}

	// Faltaria que se muestre los departamentos del programa seleccionado

	// --------------Cosas que tienen que ver con el doble grid (No es necesario
	// para ustedes (por ahora jeje xD))----------
	// Funcion de boton de izquierda a derecha del doble grid
	@Listen("onClick = #pasar1")
	public void moverDerecha() {
		Listitem list1 = listaDepartamento.getSelectedItem();
		if (list1 == null)
			Messagebox.show("Seleccione un Item");
		else
			list1.setParent(listaDepartamentosAgregados);
	}

	// Funcion de boton de derecha a izquierda del doble grid
	@Listen("onClick = #pasar2")
	public void moverIzquierda() {
		Listitem list2 = listaDepartamentosAgregados.getSelectedItem();
		if (list2 == null)
			Messagebox.show("Seleccione un Item");
		else
			list2.setParent(listaDepartamento);
	}

	// Listas para llenar el doble grid (aun se esta trabajando en ello)
	public void listaDepartamentosDisponibles() {

		List<Departamento> departamentos = servicioDepartamento
				.buscarDepartamentosActivos();
		listaDepartamento.setModel(new ListModelList<Departamento>(
				departamentos));
	}
}