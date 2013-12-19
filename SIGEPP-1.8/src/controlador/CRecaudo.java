package controlador;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import modelo.PlantillaDocumento;
import modelo.Recaudo;

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
import servicio.SRecaudo;

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
* FALTA INTEGRAR EL CATALOGO
*/

@Controller
public class CRecaudo extends CGenerico {
	
	@Wire
	private Button btnBuscarRecaudo;
	@Wire
	private Textbox txtDescripcionRecaudo;
	@Wire
	private Div botoneraEstandar;
	@Wire
	private Div catalogoRecaudo;
	@Wire
	private Listbox listaRecaudo;
	@Wire
	private Combobox cmbPlantilla;
	private long id;
	SRecaudo servicioRecaudo =BeanServicios.getSRecaudo();
	SPlantillaDocumento servicioPlantillaDocumento =BeanServicios.getSPlantillaDocumento();
	
	public CRecaudo() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	void inicializar() {
		id=0;
		listadoRecaudos();
		comboPlantilla();
		listaRecaudo.setVisible(false);
		final Calendar calendario = Calendar.getInstance();
		BotoneraMaestros botonera = new BotoneraMaestros() {

				@Override
				public void guardar() {
					String descripcion = txtDescripcionRecaudo.getValue();
					boolean estado=true;
					String horaAuditoria = String.valueOf(calendario
							.get(Calendar.HOUR_OF_DAY))
							+ ":"
							+ String.valueOf(calendario.get(Calendar.MINUTE))
							+ ":"
							+ String.valueOf(calendario.get(Calendar.SECOND));
					java.util.Date fecha = new Date();
					
					String nombrePlantilla = cmbPlantilla.getValue();
					PlantillaDocumento plantillaDocumento = servicioPlantillaDocumento.buscarPorDescripcionPlantilla(nombrePlantilla);
					Recaudo nuevoRecaudo = new Recaudo(id,plantillaDocumento, descripcion,descripcion, fecha, horaAuditoria,true);
					servicioRecaudo.guardar(nuevoRecaudo);
					Messagebox.show("Se Guardo Exitosamente"); 
					limpiar();
				}

				@Listen("onClick = #botonlimpiar")
				public void limpiar() {
					txtDescripcionRecaudo.setValue("");
					cmbPlantilla.setValue("");
					id=0;
				}

			@Override
			public void salir() {
				//
			}
			
				@Override
				public void eliminar() {
					Recaudo recaudo = servicioRecaudo.buscarRecaudo(id);
					recaudo.setEstadoEliminacion(false);
					servicioRecaudo.guardar(recaudo);
					limpiar();
					listadoRecaudos();
					Messagebox.show("Se Elimino Exitosamente");
				}
		};
		botoneraEstandar.appendChild(botonera);
	}
	
	@Listen("onClick = #btnBuscarRecaudo")
	public void mostrarCatalogo() throws IOException {
		listadoRecaudos();
		listaRecaudo.setVisible(true);
	}
	
	public void listadoRecaudos() {
		List<Recaudo> recaudos = servicioRecaudo.buscarRecadudosActivos();
		listaRecaudo.setModel(new ListModelList<Recaudo>(recaudos));
	}
	
	public void comboPlantilla() {
		List<PlantillaDocumento> plantillas = servicioPlantillaDocumento.buscarPlantillasActivas();
		cmbPlantilla.setModel(new ListModelList<PlantillaDocumento>(plantillas));
	}
	
	@Listen("onDoubleClick = #listaRecaudo")
	public void seleccion(){
		Recaudo recaudo = listaRecaudo.getSelectedItem().getValue();
		id=recaudo.getId();
		txtDescripcionRecaudo.setValue(recaudo.getDescripcion());
		cmbPlantilla.setValue(recaudo.getPlantillaDocumento().getDescripcion());
		listaRecaudo.setVisible(false);
	}
}