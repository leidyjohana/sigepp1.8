package modelo.pk;



import java.io.Serializable;

import modelo.LapsoActividad;
import modelo.PasantiaLapso;

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

public class PasantiaLapsoActividadId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8878975726240105278L;
	private PasantiaLapso lapsoPasantia;
	private LapsoActividad actividadLapso;
	
	public PasantiaLapso getLapsoPasantia() {
		return lapsoPasantia;
	}
	public void setLapsoPasantia(PasantiaLapso lapsoPasantia) {
		this.lapsoPasantia = lapsoPasantia;
	}
	public LapsoActividad getActividadLapso() {
		return actividadLapso;
	}
	public void setActividadLapso(LapsoActividad actividadLapso) {
		this.actividadLapso = actividadLapso;
	}
}
