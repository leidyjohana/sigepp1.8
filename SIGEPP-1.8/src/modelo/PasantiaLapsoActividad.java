package modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import modelo.pk.PasantiaLapsoActividadId;

import java.util.Date;



/**
* 
* Autor: Fernando Rivero
* Revisado por: Fernando Rivero
* Version: 1.0
* Fecha Creacion: 02/12/2013
* 
* ----------------------------
* HISTORIAL DE MODIFICACIONES
* ----------------------------
* 
* 
*/

@Entity
@Table(name = "pasantia_lapso_actividad")
@IdClass(PasantiaLapsoActividadId.class)
public class PasantiaLapsoActividad {
	

	@Id
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "pasantia_lapso_id", referencedColumnName = "pasantia_lapso_id")
	private PasantiaLapso lapsoPasantia;
	
	@Id
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "lapso_actividad_id", referencedColumnName = "lapso_actividad_id")
	private LapsoActividad actividadLapso;
	
	@Column(name = "semana_academica")
	private int semanaAcademica;
	
	@Column(name = "semana_administrativa")
	private int semanaAdministrativa;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin")
	private Date fechaFin;
	
	@Column(name = "observacion", length = 500)
	private String observacion;
	
	@Column(name = "usuario_id", length = 20)
	private String usuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;
	
	@Column(name = "estado_eliminacion")
	private boolean estadoEliminacion;

	public PasantiaLapsoActividad(long id, PasantiaLapso lapsoPasantia,
			LapsoActividad actividadLapso, int semanaAcademica,
			int semanaAdministrativa, Date fechaInicio, Date fechaFin,
			String observacion, String usuario, Date fechaAuditoria,
			String horaAuditoria, boolean estadoEliminacion) {
		super();
		this.lapsoPasantia = lapsoPasantia;
		this.actividadLapso = actividadLapso;
		this.semanaAcademica = semanaAcademica;
		this.semanaAdministrativa = semanaAdministrativa;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.observacion = observacion;
		this.usuario = usuario;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
		this.estadoEliminacion = estadoEliminacion;
	}

	public PasantiaLapsoActividad() {
	
	}



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

	public int getSemanaAcademica() {
		return semanaAcademica;
	}

	public void setSemanaAcademica(int semanaAcademica) {
		this.semanaAcademica = semanaAcademica;
	}

	public int getSemanaAdministrativa() {
		return semanaAdministrativa;
	}

	public void setSemanaAdministrativa(int semanaAdministrativa) {
		this.semanaAdministrativa = semanaAdministrativa;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Date getFechaAuditoria() {
		return fechaAuditoria;
	}

	public void setFechaAuditoria(Date fechaAuditoria) {
		this.fechaAuditoria = fechaAuditoria;
	}

	public String getHoraAuditoria() {
		return horaAuditoria;
	}

	public void setHoraAuditoria(String horaAuditoria) {
		this.horaAuditoria = horaAuditoria;
	}

	public boolean isEstadoEliminacion() {
		return estadoEliminacion;
	}

	public void setEstadoEliminacion(boolean estadoEliminacion) {
		this.estadoEliminacion = estadoEliminacion;
	}
	
	
}
