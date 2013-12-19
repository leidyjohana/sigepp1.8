package componentes;

import java.awt.Color;

import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Messagebox;
import configuracion.BeanServicios;
import javax.swing.*;

public abstract class BotoneraMaestros extends Hbox {


	public BotoneraMaestros() {
		super();
		Button btnGuardar = new Button();
		Button btnEliminar = new Button();
		Button btnLimpiar = new Button();
		Button btnSalir = new Button();
		this.appendChild(btnGuardar);
		this.appendChild(btnEliminar);
		this.appendChild(btnLimpiar);
		this.appendChild(btnSalir);
		this.setStyle("width:100% ; height: 2em;  background: #FF7925");
	    btnGuardar.setSrc("/public/imagenes/iconos/botoneraEstandar/Guardar.png"); 
	    btnEliminar.setSrc("/public/imagenes/iconos/botoneraEstandar/Eliminar.png");
	    btnLimpiar.setSrc("/public/imagenes/iconos/botoneraEstandar/Limpiar.png");
	    btnSalir.setSrc("/public/imagenes/iconos/botoneraEstandar/Salir.png");
	    btnGuardar.setTooltiptext("Guardar");
	    btnEliminar.setTooltiptext("Eliminar");
	    btnLimpiar.setTooltiptext("Limpiar");
	    btnSalir.setTooltiptext("Salir");
	    btnGuardar.setStyle("background: #FFFFFF; border-bottom: double #001F83; width:4em ; height: 4em");
	    btnEliminar.setStyle("background: #FFFFFF; width:4em ; height: 4em");
	    btnLimpiar.setStyle("background: #FFFFFF; width:4em ; height: 4em");
	    btnSalir.setStyle("background: #FFFFFF; width:4em ; height: 4em");
	    btnGuardar.addEventListener(Events.ON_CLICK,
				new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {
						guardar();
					}
				});
		btnEliminar.addEventListener(Events.ON_CLICK,
				new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {
						eliminar();
					}
				});
		btnLimpiar.addEventListener(Events.ON_CLICK,
				new EventListener<Event>() {
					@Override
					public void onEvent(Event arg0) throws Exception {
						limpiar();
					}
				});
		btnSalir.addEventListener(Events.ON_CLICK, new EventListener<Event>() {
			@Override
			public void onEvent(Event arg0) throws Exception {
				salir();
			}
		});
	}

	public abstract void guardar();

	public abstract void limpiar();

	public abstract void salir();

	public abstract void eliminar();
}