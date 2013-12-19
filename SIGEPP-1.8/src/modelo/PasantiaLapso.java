package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Set;
import javax.persistence.OneToMany;


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
@Table(name = "pasantia_lapso")
public class PasantiaLapso {
	
	@GeneratedValue
	@Id
	@Column(name = "pasantia_lapso_id", nullable = false)
	private long id;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "programa_id", referencedColumnName = "programa_id")
	private Programa programa;
	
	@Column(name = "nombre", length = 100)
	private String nombre;
	
	@Column(name = "descripcion", length = 500)
	private String descripcion;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin")
	private Date fechaFin;
	
	@Column(name = "usuario_id", length = 20)
	private String usuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;
	
	@Column(name = "estado_eliminacion")
	private boolean estadoEliminacion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "lapsoPasantia", fetch = FetchType.LAZY)
	private Set<PasantiaLapsoActividad> cronogramasAcademicos;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pasantiaLapso", fetch = FetchType.LAZY)
	private Set<Pasantia> pasantias;
	
	public PasantiaLapso(long id, Programa programa, String nombre,
			String descripcion, Date fechaInicio, Date fechaFin,
			String usuario, Date fechaAuditoria, String horaAuditoria,
			boolean estadoEliminacion) {
		super();
		this.id = id;
		this.programa = programa;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.usuario = usuario;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
		this.estadoEliminacion = estadoEliminacion;
	}
	
	

	public PasantiaLapso() {
		
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Set<PasantiaLapsoActividad> getCronogramasAcademicos() {
		return cronogramasAcademicos;
	}

	public void setCronogramasAcademicos(
			Set<PasantiaLapsoActividad> cronogramasAcademicos) {
		this.cronogramasAcademicos = cronogramasAcademicos;
	}



	public Set<Pasantia> getPasantias() {
		return pasantias;
	}



	public void setPasantias(Set<Pasantia> pasantias) {
		this.pasantias = pasantias;
	}
	
	
	
}
