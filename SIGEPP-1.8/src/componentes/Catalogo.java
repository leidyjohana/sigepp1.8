package componentes;

import java.util.List;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.event.InputEvent;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.Comboitem;
import org.zkoss.zul.Hbox;
import org.zkoss.zul.Label;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listhead;
import org.zkoss.zul.Listheader;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

/**
* 
* Autor: Michell Lobo
* Revisado por: Michell Lobo
* Version: 1.0
* Fecha Creacion: 08/12/2013
* 
* ----------------------------
* HISTORIAL DE MODIFICACIONES
* ----------------------------
* 
* 
*/

//Por hacer:
//	- Que busque solo los activos
//	- Que no le importe si son mayusculas o minusculas

public abstract class Catalogo<Clase> extends Window {

	Listbox lsbCatalogo;

	public Catalogo(final Component cGenerico, List<Clase> lista,
			String... campos) {
		super("Catálogo", "2", true);
		this.setId("cmpCatalogo");
		setWidth("50%");
		crearLista(lista, campos);
		lsbCatalogo.addEventListener(Events.ON_SELECT,
				new EventListener<Event>() {

					@Override
					public void onEvent(Event arg0) throws Exception {
						Events.postEvent(cGenerico, new Event("onSeleccion"));
					}
				});
	}

	public void crearLista(List<Clase> lista, String[] campos) {
		Hbox hbxBusqueda = new Hbox();
		final Label lblBuscar = new Label();
		final Textbox txtBuscar = new Textbox();
		lblBuscar.setZclass("etiqueta");
		lblBuscar.setValue("Buscar:");
		txtBuscar.addEventListener(Events.ON_CHANGING, new EventListener<InputEvent>() {
			@Override
			public void onEvent(InputEvent e) throws Exception {
				List<Clase> listaNueva = buscar(e.getValue());
				lsbCatalogo.setModel(new ListModelList<Clase>(listaNueva));
			}
		});
		lsbCatalogo = new Listbox();
		Listhead lhdEncabezado = new Listhead();
		for (int i = 0; i < campos.length; i++) {
			lhdEncabezado.appendChild(new Listheader(campos[i]));
		}
		lsbCatalogo.appendChild(lhdEncabezado);
		lhdEncabezado.setVisible(true);
		lsbCatalogo.setModel(new ListModelList<Clase>(lista));
		lsbCatalogo.setItemRenderer(new ListitemRenderer<Clase>() {

			@Override
			public void render(Listitem fila, Clase objeto, int arg2)
					throws Exception {
				fila.setValue(objeto);
				String[] registros = crearRegistros(objeto);
				for (int i = 0; i < registros.length; i++) {
					Listcell celda = new Listcell(registros[i]);
					celda.setParent(fila);
				}
			}
		});
		this.appendChild(hbxBusqueda);
		hbxBusqueda.appendChild(lblBuscar);
		hbxBusqueda.appendChild(txtBuscar);
		this.appendChild(lsbCatalogo);
	}

	protected abstract List<Clase> buscar(String valor);

	protected abstract String[] crearRegistros(Clase objeto);

	public Clase objetoSeleccionadoDelCatalogo() {
		return lsbCatalogo.getSelectedItem().getValue();
	}
}