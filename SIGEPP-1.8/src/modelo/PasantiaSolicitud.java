package modelo;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Set;




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
@Table(name = "pasantia_solicitud")
public class PasantiaSolicitud {
	
	@GeneratedValue
	@Id
	@Column(name = "solicitud_id", nullable = false)
	private long id;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "estudiante_id", referencedColumnName = "estudiante_id")
	private Estudiante estudiante;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "oferta_id", referencedColumnName = "oferta_id")
	private EmpresaOferta ofertaEmpresa;
	
	@Column(name = "observacion", length = 500)
	private String observacion;
	
	@Column(name = "estado_solicitud", length = 100)
	private String estadoSolicitud;
	
	@Column(name = "usuario_id", length = 20)
	private String usuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;
	
	@Column(name = "estado_eliminacion")
	private boolean estadoEliminacion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "solicitudPasantia", fetch = FetchType.LAZY)
	private Set<PasantiaSolicitudBitacora> bitacoras;

	public PasantiaSolicitud(long id, Estudiante estudiante,
			String observacion, String estadoSolicitud, String usuario,
			Date fechaAuditoria, String horaAuditoria,
			boolean estadoEliminacion, Set<PasantiaSolicitudBitacora> bitacoras) {
		super();
		this.id = id;
		this.estudiante = estudiante;
		this.observacion = observacion;
		this.estadoSolicitud = estadoSolicitud;
		this.usuario = usuario;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
		this.estadoEliminacion = estadoEliminacion;
		this.bitacoras = bitacoras;
	}

	public PasantiaSolicitud() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
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

	public Set<PasantiaSolicitudBitacora> getBitacoras() {
		return bitacoras;
	}

	public void setBitacoras(Set<PasantiaSolicitudBitacora> bitacoras) {
		this.bitacoras = bitacoras;
	}

	public EmpresaOferta getOferta() {
		return ofertaEmpresa;
	}

	public void setOferta(EmpresaOferta ofertaEmpresa) {
		this.ofertaEmpresa = ofertaEmpresa;
	}
	
	
	
	

	
	
}
