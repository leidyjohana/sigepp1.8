package controlador;

import java.util.Calendar;
import java.util.Date;
import java.util.List;


import modelo.PasantiaPaso;

import org.springframework.stereotype.Controller;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Div;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;

import servicio.SPasantiaPaso;

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
public class CPasantiaPaso extends CGenerico {
	
	@Wire
	private Textbox txtDescripcionPasantiaPaso;
	@Wire
	private Div botoneraEstandar;
	@Wire
	private Div catalogoPasantiaPaso;
	@Wire
	private Listbox listaPasantiaPaso;
	@Wire
	private Button btnBuscarPasantiaPaso;
	private long id;
	SPasantiaPaso servicioPasantiaPaso = BeanServicios.getSPasantiaPaso();
	
	public CPasantiaPaso() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	void inicializar() {
		listaPasantiaPaso.setVisible(false);
		id=0;
		final Calendar calendario = Calendar.getInstance();
		BotoneraMaestros botonera = new BotoneraMaestros() {

			@Override
			public void guardar() {
			    boolean estado=true; 
			    String horaAuditoria = String.valueOf(calendario.get(Calendar.HOUR_OF_DAY))+":"+String.valueOf(calendario.get(Calendar.MINUTE))+":"+String.valueOf(calendario.get(Calendar.SECOND));
				java.util.Date fecha = new Date();
			    String descripcionPasantiaPaso= txtDescripcionPasantiaPaso.getValue();
			    PasantiaPaso nuevoPasantiaPaso = new PasantiaPaso(id,descripcionPasantiaPaso,descripcionPasantiaPaso,fecha,horaAuditoria,estado);
			    servicioPasantiaPaso.guardar(nuevoPasantiaPaso);
			    Messagebox.show("Paso Guardado Satisfactoriamente");
			    limpiar();
			    id=0;
			}

			@Override
			public void limpiar() {
				txtDescripcionPasantiaPaso.setValue("");
				id=0;
			}

			@Override
			public void salir() {
				// 
			}

			@Override
			public void eliminar() {
				PasantiaPaso nuevoPasantiaPaso= servicioPasantiaPaso.buscarPasantiaPaso(id);
				nuevoPasantiaPaso.setEstadoEliminacion(false);
				servicioPasantiaPaso.guardar(nuevoPasantiaPaso);
				 Messagebox.show("Paso Eliminado Satisfactoriamente");
				limpiar();
			}
		};
		botoneraEstandar.appendChild(botonera);
	}
	
	@Listen("onClick = #btnBuscarPasantiaPaso")
	 public void mostrarCatalogo(){
		listaPasantiaPaso.setVisible(true);
		listadoPasantiaPaso();
	 }
	
	public void listadoPasantiaPaso() {
		List<PasantiaPaso> pasantiaPasos= servicioPasantiaPaso.buscarPasantiaPasosActivos();
		listaPasantiaPaso.setModel(new ListModelList<PasantiaPaso>(pasantiaPasos));
	}
	
	@Listen("onDoubleClick = #listaPasantiaPaso")
	public void seleccion() {
		PasantiaPaso selected= listaPasantiaPaso.getSelectedItem().getValue();
		id=selected.getId();
		txtDescripcionPasantiaPaso.setValue(selected.getDescripcion());
		listaPasantiaPaso.setVisible(false);
	}
}
