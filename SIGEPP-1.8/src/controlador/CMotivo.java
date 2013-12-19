package controlador;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.Motivo;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import servicio.SMotivo;

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
public class CMotivo extends CGenerico {

	@Wire
	private Div botoneraEstandar;
	@Wire
	private Textbox txtDescripcionMotivo;
	@Wire
	private Button btnBuscarMotivo;
	@Wire
	private Div catalogoMotivo;
	Catalogo<Motivo> catalogo;
	public long id = 0;
	public boolean exito = false;
	SMotivo servicioMotivo = BeanServicios.getSMotivo();
	
	public CMotivo() {
		// TODO Auto-generated constructor stub
	}

	@Override
	void inicializar() {
		// TODO Auto-generated method stub
		final Calendar calendario = Calendar.getInstance();
		BotoneraMaestros botonera = new BotoneraMaestros() {

			@Override
			public void guardar() {
				// Metodo de guardar
				if (txtDescripcionMotivo.equals("")) {
					System.out.println("Existen campos vacios!");
				} else {
					String descripcion = txtDescripcionMotivo.getValue();
					java.util.Date fecha = new Date();
					String horaAuditoria = String.valueOf(calendario
							.get(Calendar.HOUR_OF_DAY))
							+ ":"
							+ String.valueOf(calendario.get(Calendar.MINUTE))
							+ ":"
							+ String.valueOf(calendario.get(Calendar.SECOND));
					boolean estado = true;
					Motivo motivo = new Motivo(id, descripcion, descripcion,
							fecha, horaAuditoria, estado);
					servicioMotivo.guardar(motivo);
					Messagebox.show("Se ha Guardado Exitosamente");
					limpiar();
				}
			}

			@Override
			public void limpiar() {
				txtDescripcionMotivo.setValue("");
			}

			@Override
			public void salir() {
				//
			}

			@Override
			public void eliminar() {
				if (exito == true) {
					Motivo motivo = servicioMotivo.buscarMotivo(id);
					motivo.setEstadoEliminacion(false);
					servicioMotivo.guardar(motivo);
					Messagebox.show("Se ha Eliminado Exitosamente");
					limpiar();
					exito = false;
				} else {
					Messagebox.show("No ha seleccionado ningun motivo");
				}
			}
		};
		botoneraEstandar.appendChild(botonera);
	}

	@Listen("onClick = #btnBuscarMotivo")
	public void mostrarCatalogo() throws IOException {
		List<Motivo> motivos = servicioMotivo
				.buscarMotivosActivos();
		catalogo = new Catalogo<Motivo>(catalogoMotivo,
				motivos, "Descripcion") {

			@Override
			protected String[] crearRegistros(Motivo motivo) {
				String[] registros = new String[1];
				registros[0] = motivo.getDescripcion();
				return registros;
			}

			@Override
			protected List<Motivo> buscar(String valor) {
				return servicioMotivo.buscarCualquierCampoContiene(valor);
			}
		};
		catalogo.setParent(catalogoMotivo);
		catalogo.doModal();
	}

	@Listen("onSeleccion = #catalogoMotivo")
	public void seleccion() {
		Motivo motivoSeleccionado;
		motivoSeleccionado = catalogo.objetoSeleccionadoDelCatalogo();
		txtDescripcionMotivo.setText(motivoSeleccionado.getDescripcion());
		id = motivoSeleccionado.getId();
		//Borra el catalogo de la pantalla
		catalogo.setParent(null);
	}
}