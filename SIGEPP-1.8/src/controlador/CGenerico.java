package controlador;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;

/**
* 
* Autor: Michell Lobo
* Revisado por: Ysolmery Maiorano
* Version: 1.0
* Fecha Creacion: 01/12/2013
* 
* ----------------------------
* HISTORIAL DE MODIFICACIONES
* ----------------------------
* 
*/

public abstract class CGenerico extends SelectorComposer<Component>{
	
	
	@Override
	public void doAfterCompose(Component comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		inicializar();
	}
	abstract void inicializar();
}
