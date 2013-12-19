package controlador;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.PlantillaDocumento;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import servicio.SPlantillaDocumento;

import componentes.BotoneraMaestros;

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
* FALTA EL INTEGRARLE EL CATALOGO
*/

@Controller
public class CPlantillaDocumento extends CGenerico {

	@Wire
	private Button btnBuscarPlantilla;
	@Wire
	private Textbox txtDescripcionPlantilla;
	@Wire
	private Textbox txtVersion;
	@Wire
	private Combobox cmbEstadoVigencia;
	@Wire
	private Div botoneraEstandar;
	@Wire
	private Div catalogoRecaudo;
	@Wire
	private Listbox listaPlantilla;
	private long id;
	SPlantillaDocumento servicioPlantilla = BeanServicios
			.getSPlantillaDocumento();

	public CPlantillaDocumento() {
		// TODO Auto-generated constructor stub
	}

	@Override
	void inicializar() {
		listaPlantilla.setVisible(false);
		id = 0;
		listadoPlantillas();
		final Calendar calendario = Calendar.getInstance();
		BotoneraMaestros botonera = new BotoneraMaestros() {

			@Override
			public void guardar() {
				String descripcion = txtDescripcionPlantilla.getValue();
				String estadoVigencia = cmbEstadoVigencia.getText();
				String version = txtVersion.getText();
				boolean estado = true;
				String horaAuditoria = String.valueOf(calendario
						.get(Calendar.HOUR_OF_DAY))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.MINUTE))
						+ ":"
						+ String.valueOf(calendario.get(Calendar.SECOND));
				java.util.Date fecha = new Date();
				PlantillaDocumento nuevaPlantilla = new PlantillaDocumento(id,
						descripcion, estadoVigencia, version, fecha,
						descripcion, fecha, horaAuditoria);
				// public PlantillaDocumento(long id, String descripcion,
				// String estadoVigencia, String version, Date fechaCreacion,
				// String usuarioId, Date fechaAuditoria, String horaAuditoria)
				servicioPlantilla.guardar(nuevaPlantilla);
				Messagebox.show("Se Guardo Exitosamente");
				limpiar();
			}

			@Listen("onClick = #botonlimpiar")
			public void limpiar() {
				txtDescripcionPlantilla.setValue("");
				cmbEstadoVigencia.setValue("");
				txtVersion.setValue("");
				id = 0;
			}

			@Override
			public void salir() {
				//
			}

			@Override
			public void eliminar() {
				PlantillaDocumento plantillaDocumento = servicioPlantilla
						.buscarPlantillaDocumento(id);
				// Plantilla no tiene estado de esliminacion =S
				// ????????????????????????????????????
				// plantillaDocumento.setEstadoEliminacion(false);
				servicioPlantilla.guardar(plantillaDocumento);
				limpiar();
				listadoPlantillas();
				Messagebox.show("Se Elimino Exitosamente");
			}
		};
		botoneraEstandar.appendChild(botonera);
	}

	@Listen("onClick = #btnBuscarPlantilla")
	public void mostrarCatalogo() throws IOException {
		listadoPlantillas();
		listaPlantilla.setVisible(true);
	}

	public void listadoPlantillas() {

		List<PlantillaDocumento> plantillas = servicioPlantilla
				.buscarPlantillasActivas();
		listaPlantilla.setModel(new ListModelList<PlantillaDocumento>(
				plantillas));
	}

	@Listen("onDoubleClick = #listaPlantilla")
	public void seleccion() {
		PlantillaDocumento selected = listaPlantilla.getSelectedItem()
				.getValue();
		id = selected.getId();
		txtDescripcionPlantilla.setValue(selected.getDescripcion());
		cmbEstadoVigencia.setValue(selected.getEstadoVigencia());
		txtVersion.setValue(selected.getVersion());
		listaPlantilla.setVisible(false);
	}
}
