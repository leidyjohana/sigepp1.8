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
* Autor: Ysolmery Maiorano
* Revisado por: Fernando Rivero
* Version: 1.0
* Fecha: 21/11/2013
* 
*/

@Entity
@Table(name = "area_conocimiento")
public class AreaConocimiento {
	
	@GeneratedValue
	@Id
	@Column(name = "area_conocimiento_id", nullable = false)
	private long id;
	
	@Column(name = "nombre", length = 100)
	private String nombre;
	
	@Column(name = "descripcion", length = 500)
	private String descripcion;
	
	@Column(name = "usuario_id", length = 20)
	private String usuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;
	
	@Column(name = "estado_eliminacion")
	private boolean estadoEliminacion;

	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "areaConocimiento", fetch = FetchType.LAZY)
	private Set<AreaTutorAcademico> areasDeTutor;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "areaConocimiento", fetch = FetchType.LAZY)
	private Set<EmpresaOferta> ofertas ;


	public AreaConocimiento(long id, String nombre, String descripcion,
			String usuario, Date fechaAuditoria, String horaAuditoria,
			boolean estadoEliminacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
		this.estadoEliminacion = estadoEliminacion;
	}

	public AreaConocimiento() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Set<AreaTutorAcademico> getAreasDeTutor() {
		return areasDeTutor;
	}

	public void setAreasDeTutor(Set<AreaTutorAcademico> areasDeTutor) {
		this.areasDeTutor = areasDeTutor;
	}

	public Set<EmpresaOferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(Set<EmpresaOferta> ofertas) {
		this.ofertas = ofertas;
	}

	
}
