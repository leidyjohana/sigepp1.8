package modelo.pk;


import java.io.Serializable;

import modelo.PasantiaTipo;
import modelo.Programa;


public class ProgramaPasantiaTipoId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6703270191003055906L;
	private PasantiaTipo pasantiaTipo;
	private Programa programa;
	
	public PasantiaTipo getPasantiaTipo() {
		return pasantiaTipo;
	}
	public void setPasantiaTipo(PasantiaTipo pasantiaTipo) {
		this.pasantiaTipo = pasantiaTipo;
	}
	public Programa getPrograma() {
		return programa;
	}
	public void setPrograma(Programa programa) {
		this.programa = programa;
	}
}
