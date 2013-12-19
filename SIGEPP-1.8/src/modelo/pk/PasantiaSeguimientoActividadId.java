package modelo.pk;

import java.io.Serializable;

import modelo.PasantiaSeguimiento;
import modelo.SeguimientoActividad;

public class PasantiaSeguimientoActividadId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2571946819053792131L;
	private PasantiaSeguimiento pasantiaSeguimiento;
	private SeguimientoActividad seguimientoActividad;
	
	public PasantiaSeguimiento getPasantiaSeguimiento() {
		return pasantiaSeguimiento;
	}
	public void setPasantiaSeguimiento(PasantiaSeguimiento pasantiaSeguimiento) {
		this.pasantiaSeguimiento = pasantiaSeguimiento;
	}
	public SeguimientoActividad getSeguimientoActividad() {
		return seguimientoActividad;
	}
	public void setSeguimientoActividad(SeguimientoActividad seguimientoActividad) {
		this.seguimientoActividad = seguimientoActividad;
	}
}
