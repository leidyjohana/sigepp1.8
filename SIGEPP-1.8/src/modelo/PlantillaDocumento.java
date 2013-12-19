package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Set;
import javax.persistence.OneToMany;

/**
* 
* Autor: Ana Garay
* Revisado por: 
* Version: 1.0
* Fecha Creacion: 26/11/2013
* 
* ----------------------------
* HISTORIAL DE MODIFICACIONES
* ----------------------------
* 
* 
*/
@Entity
@Table(name = "plantilla_documento")
public class PlantillaDocumento {

	@GeneratedValue
	@Id
	@Column(name = "plantilla_documento_id", nullable = false)
	private long id;
	
	@Column(name = "descripcion", length = 500)
	private String descripcion;
	
	@Column(name = "estado_vigencia", length = 20)
	private String estadoVigencia;
	
	@Column(name = "version", length = 10)
	private String version;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_creacion")
	private Date fechaCreacion;
	
	@Column(name = "usuario_id", length = 20)
	private String usuarioId;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "plantillaDocumento", fetch = FetchType.LAZY)
	private Set<Recaudo> recaudos;

	public PlantillaDocumento(long id, String descripcion,
			String estadoVigencia, String version, Date fechaCreacion,
			String usuarioId, Date fechaAuditoria, String horaAuditoria) 
	{
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.estadoVigencia = estadoVigencia;
		this.version = version;
		this.fechaCreacion = fechaCreacion;
		this.usuarioId = usuarioId;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
	}
	

	public PlantillaDocumento() {
		super();
		// TODO Auto-generated constructor stub
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


	public String getEstadoVigencia() {
		return estadoVigencia;
	}


	public void setEstadoVigencia(String estadoVigencia) {
		this.estadoVigencia = estadoVigencia;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	public String getUsuarioId() {
		return usuarioId;
	}


	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
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


	public Set<Recaudo> getRecaudos() {
		return recaudos;
	}


	public void setRecaudos(Set<Recaudo> recaudos) {
		this.recaudos = recaudos;
	}
	
	
	
	
}
