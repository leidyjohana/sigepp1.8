package modelo.pk;


import java.io.Serializable;

import modelo.Pasantia;
import modelo.Recaudo;


/**
* 
* Autor: Fernando Rivero
* Revisado por: Fernando Rivero
* Version: 1.0
* Fecha Creacion: 16/12/2013
* 
* ----------------------------
* HISTORIAL DE MODIFICACIONES
* ----------------------------
* 
* 
* 
*/

public class PasantiaRecaudoId implements Serializable  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5979440017867484682L;
	private Pasantia pasantia;
	private Recaudo recaudo;
	public Pasantia getPasantia() {
		return pasantia;
	}
	public void setPasantia(Pasantia pasantia) {
		this.pasantia = pasantia;
	}
	public Recaudo getRecaudo() {
		return recaudo;
	}
	public void setRecaudo(Recaudo recaudo) {
		this.recaudo = recaudo;
	}
}
