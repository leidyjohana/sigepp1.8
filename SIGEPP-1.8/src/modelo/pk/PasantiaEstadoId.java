package modelo.pk;


import java.io.Serializable;

import modelo.Pasantia;
import modelo.PasantiaPaso;


public class PasantiaEstadoId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3233488012082509066L;
	private Pasantia pasantia;
	private PasantiaPaso pasantiaPaso;
	
	public Pasantia getPasantia() {
		return pasantia;
	}
	public void setPasantia(Pasantia pasantia) {
		this.pasantia = pasantia;
	}
	public PasantiaPaso getPasantiaPaso() {
		return pasantiaPaso;
	}
	public void setPasantiaPaso(PasantiaPaso pasantiaPaso) {
		this.pasantiaPaso = pasantiaPaso;
	}
}
