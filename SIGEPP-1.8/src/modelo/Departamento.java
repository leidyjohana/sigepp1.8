package modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
* 
* Autor: Ysolmery Maiorano
* Revisado por: Fernando Rivero
* Version: 1.0
* Fecha Creacion: 21/11/2013
* 
* ----------------------------
* HISTORIAL DE MODIFICACIONES
* ----------------------------
* 
* 
*/

@Entity
@Table(name = "departamento")
public class Departamento {

	@GeneratedValue
	@Id
	@Column(name = "departamento_id", nullable = false)
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento", fetch = FetchType.LAZY)
	private Set<AreaAcademica> areasAcademicas;
	
	@ManyToMany(mappedBy="departamentos")
	private Set<Programa> programas ;

	public Departamento(long id,  String nombre,
			String descripcion, String usuario, Date fechaAuditoria,
			String horaAuditoria, boolean estadoEliminacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
		this.estadoEliminacion = estadoEliminacion;
	}

	public Departamento() {

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

	public Set<AreaAcademica> getAreasAcademicas() {
		return areasAcademicas;
	}

	public void setAreasAcademicas(Set<AreaAcademica> areasAcademicas) {
		this.areasAcademicas = areasAcademicas;
	}

	public Set<Programa> getProgramas() {
		return programas;
	}

	public void setProgramas(Set<Programa> programas) {
		this.programas = programas;
	}
	
	

	
}
