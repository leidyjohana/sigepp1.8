package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import modelo.pk.PasantiaSeguimientoActividadId;

/**
* 
* Autor: Fernando Rivero
* Revisado por: Fernando Rivero
* Version: 1.0
* Fecha: 21/11/2013
* 
* * ----------------------------
* HISTORIAL DE MODIFICACIONES
* ----------------------------
* 
* * ----------------------------
* Autor: Fernando Rivero
* Fecha: 16/12/2013
* Descripcion: Se cambia la forma de generar el ID por un composite
* ----------------------------
* 
*/

@Entity
@Table(name = "pasantia_seguimiento_actividad")
@IdClass(PasantiaSeguimientoActividadId.class)
public class PasantiaSeguimientoActividad {
	
	@Id
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "pasantia_seguimiento_id", referencedColumnName = "pasantia_seguimiento_id")
	private PasantiaSeguimiento pasantiaSeguimiento;
	
	@Id
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "seguimiento_actividad_id", referencedColumnName = "seguimiento_actividad_id")
	private SeguimientoActividad seguimientoActividad;
	
	@Column(name = "linea")
	private int linea;
	
	@Column(name = "calificacion")
	private int calificacion;

	public PasantiaSeguimientoActividad() {
		super();
	}

	public PasantiaSeguimientoActividad(
			PasantiaSeguimiento pasantiaSeguimiento,
			SeguimientoActividad seguimientoActividad, int linea,
			int calificacion) {
		super();
		this.pasantiaSeguimiento = pasantiaSeguimiento;
		this.seguimientoActividad = seguimientoActividad;
		this.linea = linea;
		this.calificacion = calificacion;
	}
	
	

}
