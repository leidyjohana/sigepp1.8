package modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "pasantia_segumiento")
public class PasantiaSeguimiento {
	
	@Id
	@Column(name = "pasantia_seguimiento_id", nullable = false)
	private Long id;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "pasantia_id", referencedColumnName = "pasantia_id")
	private Pasantia pasantia;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_visita_planif")
	private Date fechaVisitaPlanif;
	
	@Column(name = "hora_visita_planif", length = 20)
	private String horaVisitaPlanif;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_registro")
	private Date fechaRegistro;
	
	@Column(name = "estado_seguimiento", length = 20)
	private String estadoSeguimiento;
	
	@Column(name = "observacion", length = 500)
	private String observacion;
	
	@Column(name = "ruta_archivo1", length = 500)
	private String rutaArchivo1;
	
	@Column(name = "ruta_archivo2", length = 500)
	private String rutaArchivo2;
	
	@Column(name = "ruta_archivo3", length = 500)
	private String rutaArchivo3;
	
	@Column(name = "usuario_id", length = 20)
	private String usuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pasantiaSeguimiento", fetch = FetchType.LAZY)
	private Set<PasantiaSeguimientoActividad> PasantiaSeguimientoActividades;

	public PasantiaSeguimiento() {
		super();
	}

	public PasantiaSeguimiento(Long id, Pasantia pasantia,
			Date fechaVisitaPlanif, String horaVisitaPlanif,
			Date fechaRegistro, String estadoSeguimiento, String observacion,
			String rutaArchivo1, String rutaArchivo2, String rutaArchivo3,
			String usuario, Date fechaAuditoria, String horaAuditoria) {
		super();
		this.id = id;
		this.pasantia = pasantia;
		this.fechaVisitaPlanif = fechaVisitaPlanif;
		this.horaVisitaPlanif = horaVisitaPlanif;
		this.fechaRegistro = fechaRegistro;
		this.estadoSeguimiento = estadoSeguimiento;
		this.observacion = observacion;
		this.rutaArchivo1 = rutaArchivo1;
		this.rutaArchivo2 = rutaArchivo2;
		this.rutaArchivo3 = rutaArchivo3;
		this.usuario = usuario;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pasantia getPasantia() {
		return pasantia;
	}

	public void setPasantia(Pasantia pasantia) {
		this.pasantia = pasantia;
	}

	public Date getFechaVisitaPlanif() {
		return fechaVisitaPlanif;
	}

	public void setFechaVisitaPlanif(Date fechaVisitaPlanif) {
		this.fechaVisitaPlanif = fechaVisitaPlanif;
	}

	public String getHoraVisitaPlanif() {
		return horaVisitaPlanif;
	}

	public void setHoraVisitaPlanif(String horaVisitaPlanif) {
		this.horaVisitaPlanif = horaVisitaPlanif;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getEstadoSeguimiento() {
		return estadoSeguimiento;
	}

	public void setEstadoSeguimiento(String estadoSeguimiento) {
		this.estadoSeguimiento = estadoSeguimiento;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getRutaArchivo1() {
		return rutaArchivo1;
	}

	public void setRutaArchivo1(String rutaArchivo1) {
		this.rutaArchivo1 = rutaArchivo1;
	}

	public String getRutaArchivo2() {
		return rutaArchivo2;
	}

	public void setRutaArchivo2(String rutaArchivo2) {
		this.rutaArchivo2 = rutaArchivo2;
	}

	public String getRutaArchivo3() {
		return rutaArchivo3;
	}

	public void setRutaArchivo3(String rutaArchivo3) {
		this.rutaArchivo3 = rutaArchivo3;
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

	public Set<PasantiaSeguimientoActividad> getPasantiaSeguimientoActividades() {
		return PasantiaSeguimientoActividades;
	}

	public void setPasantiaSeguimientoActividades(
			Set<PasantiaSeguimientoActividad> pasantiaSeguimientoActividades) {
		PasantiaSeguimientoActividades = pasantiaSeguimientoActividades;
	}
	
	

}
