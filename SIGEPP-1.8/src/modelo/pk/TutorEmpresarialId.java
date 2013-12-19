package modelo.pk;

import java.io.Serializable;



import modelo.Empresa;

public class TutorEmpresarialId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5722873518863657148L;
	private String cedula;
	private Empresa empresa;
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
}
