package modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
*/

@Entity
@Table(name = "pasantia_actividad")
public class PasantiaActividad {
	
	@Id
	@Column(name = "actividad_id", nullable = false)
	private long id;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "pasantia_id", referencedColumnName = "pasantia_id")
	private Pasantia pasantia;
	
	@Column(name = "descripcion", length = 500)
	private String descripcion;
		
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio_estimada")
	private Date fechaInicioEstimada;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin_estimada")
	private Date fechaFinEstimada;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin_real")
	private Date fechaFinReal;
	
	@Column(name = "estado_actividad", length = 20)
	private String estadoActividad;
	
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

	public PasantiaActividad() {
		super();
	}

	public PasantiaActividad(long id, Pasantia pasantia, String descripcion,
			Date fechaInicioEstimada, Date fechaFinEstimada, Date fechaFinReal,
			String estadoActividad, String observacion, String usuario,
			Date fechaAuditoria, String horaAuditoria, boolean estadoEliminacion) {
		super();
		this.id = id;
		this.pasantia = pasantia;
		this.descripcion = descripcion;
		this.fechaInicioEstimada = fechaInicioEstimada;
		this.fechaFinEstimada = fechaFinEstimada;
		this.fechaFinReal = fechaFinReal;
		this.estadoActividad = estadoActividad;
		this.observacion = observacion;
		this.usuario = usuario;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
		this.estadoEliminacion = estadoEliminacion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Pasantia getPasantia() {
		return pasantia;
	}

	public void setPasantia(Pasantia pasantia) {
		this.pasantia = pasantia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicioEstimada() {
		return fechaInicioEstimada;
	}

	public void setFechaInicioEstimada(Date fechaInicioEstimada) {
		this.fechaInicioEstimada = fechaInicioEstimada;
	}

	public Date getFechaFinEstimada() {
		return fechaFinEstimada;
	}

	public void setFechaFinEstimada(Date fechaFinEstimada) {
		this.fechaFinEstimada = fechaFinEstimada;
	}

	public Date getFechaFinReal() {
		return fechaFinReal;
	}

	public void setFechaFinReal(Date fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}

	public String getEstadoActividad() {
		return estadoActividad;
	}

	public void setEstadoActividad(String estadoActividad) {
		this.estadoActividad = estadoActividad;
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
