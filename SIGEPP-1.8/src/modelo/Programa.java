package modelo;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


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
@Table(name = "programa")
public class Programa {
	
	@GeneratedValue
	@Id
	@Column(name = "programa_id", nullable = false)
	private long id;
	
	@Column(name = "nombre", length = 100)
	private String nombre;
	
	@Column(name = "descripcion", length = 500)
	private String descripcion;
	
	@Column(name = "telefono", length = 50)
	private String telefono;
	
	@Column(name = "permite_varias_pas")
	private boolean permiteVariasPasantias;
	
	@Column(name = "cantidad_sugerida_tutorar")
	private int cantidadSugTutorar;
	
	@Column(name = "usuario_id", length = 20)
	private String usuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;
	
	@Column(name = "estado_eliminacion")
	private boolean estadoEliminacion;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "programa", fetch = FetchType.LAZY)
	private Set<Estudiante> estudiantes;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "programa", fetch = FetchType.LAZY)
	private Set<ProgramaPasantiaTipo> tiposPasantia;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "programa", fetch = FetchType.LAZY)
	private Set<PasantiaLapso> lapsosPasantias;
	
	@ManyToMany
	@JoinTable(name="programa_departamento",
	     joinColumns={@JoinColumn(name="programa_id")},
	     inverseJoinColumns={@JoinColumn(name="departamento_id")})
	     private Set<Departamento> departamentos;

	public Programa(long id, String nombre, String descripcion,
			String telefono, boolean permiteVariasPasantias,
			int cantidadSugTutorar, String usuario, Date fechaAuditoria,
			String horaAuditoria, boolean estadoEliminacion,
			Set<Departamento> departamentos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.telefono = telefono;
		this.permiteVariasPasantias = permiteVariasPasantias;
		this.cantidadSugTutorar = cantidadSugTutorar;
		this.usuario = usuario;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
		this.estadoEliminacion = estadoEliminacion;
		this.departamentos = departamentos;
	}

	public Programa() {

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

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public boolean isPermiteVariasPasantias() {
		return permiteVariasPasantias;
	}

	public void setPermiteVariasPasantias(boolean permiteVariasPasantias) {
		this.permiteVariasPasantias = permiteVariasPasantias;
	}

	public int getCantidadSugTutorar() {
		return cantidadSugTutorar;
	}

	public void setCantidadSugTutorar(int cantidadSugTutorar) {
		this.cantidadSugTutorar = cantidadSugTutorar;
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

	public Set<Estudiante> getEstudiantes() {
		return estudiantes;
	}

	public void setEstudiantes(Set<Estudiante> estudiantes) {
		this.estudiantes = estudiantes;
	}

	public Set<ProgramaPasantiaTipo> getTiposPasantia() {
		return tiposPasantia;
	}

	public void setTiposPasantia(Set<ProgramaPasantiaTipo> tiposPasantia) {
		this.tiposPasantia = tiposPasantia;
	}

	public Set<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(Set<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public Set<PasantiaLapso> getLapsosPasantias() {
		return lapsosPasantias;
	}

	public void setLapsosPasantias(Set<PasantiaLapso> lapsosPasantias) {
		this.lapsosPasantias = lapsosPasantias;
	}

	
}
