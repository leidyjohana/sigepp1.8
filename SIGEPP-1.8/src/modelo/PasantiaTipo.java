package modelo;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Set;

/**
* 
* Autor: Ysolmery Maiorano
* Revisado por: Fernando Rivero
* Version: 1.0
* Fecha Creacion: 23/11/2013
* 
* ----------------------------
* HISTORIAL DE MODIFICACIONES
* ----------------------------
* 
* 
*/

@Entity
@Table(name = "pasantia_tipo")
public class PasantiaTipo {
	
	@GeneratedValue
	@Id
	@Column(name = "pasantia_tipo_id", nullable = false)
	private long id;
	
	@Column(name = "descripcion", length = 100)
	private String descripcion;
	
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pasantiaTipo", fetch = FetchType.LAZY)
	private Set<ProgramaPasantiaTipo> tiposPasantia;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pasantiaTipo", fetch = FetchType.LAZY)
	private Set<Pasantia> pasantias;

	public PasantiaTipo(long id, String descripcion, String observacion,
			String usuario, Date fechaAuditoria, String horaAuditoria,
			boolean estadoEliminacion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.observacion = observacion;
		this.usuario = usuario;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
		this.estadoEliminacion = estadoEliminacion;
	}

	public PasantiaTipo() {
	
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public Set<ProgramaPasantiaTipo> getTiposPasantia() {
		return tiposPasantia;
	}

	public void setTiposPasantia(Set<ProgramaPasantiaTipo> tiposPasantia) {
		this.tiposPasantia = tiposPasantia;
	}

	public Set<Pasantia> getPasantias() {
		return pasantias;
	}

	public void setPasantias(Set<Pasantia> pasantias) {
		this.pasantias = pasantias;
	}
	
	

	
}
