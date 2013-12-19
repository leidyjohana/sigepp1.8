package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Set;

/**
* 
* Autor: Ysolmery Maiorano
* Revisado por: Fernando Rivero
* Version: 1.1
* Fecha Creacion: 21/11/2013
* 
* ----------------------------
* HISTORIAL DE MODIFICACIONES
* ----------------------------
* 
* ------------------------------------------------------------------------------------
* Autor: Fernando Rivero
* Fecha: 26/11/2013
* Version: 1.1
* Descripcion: Se cambio el tipo de dato del atributo nacionalidad de Char a String
* ------------------------------------------------------------------------------------
*
*/

@Entity
@Table(name = "tutor_academico")
public class TutorAcademico {

	@Id
	@Column(name = "tutor_academico_id", nullable = false, length = 8)
	private String cedula;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "area_academica_id", referencedColumnName = "area_academica_id")
	private AreaAcademica areaAcademica;
	
	@Column(name = "nacionalidad", length = 1)
	private String nacionalidad;

	@Column(name = "primer_nombre", length = 100)
	private String nombre1;

	@Column(name = "segundo_nombre", length = 100)
	private String nombre2;

	@Column(name = "primer_apellido", length = 100)
	private String apellido1;

	@Column(name = "segundo_apellido", length = 100)
	private String apellido2;

	@Column(name = "sexo", length = 10)
	private String sexo;

	@Column(name = "residencia", length = 500)
	private String residencia;

	@Column(name = "correo_electronico", length = 50)
	private String correo;

	@Column(name = "telefono1", length = 50)
	private String telefono1;

	@Column(name = "telefono2", length = 50)
	private String telefono2;
	
	@Column(name = "usuario_id", length = 20)
	private String usuario;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;
	
	@Column(name = "estado_eliminacion")
	private boolean estadoEliminacion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tutorAcademico", fetch = FetchType.LAZY)
	private Set<AreaTutorAcademico> areasDeTutor;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tutorAcademico", fetch = FetchType.LAZY)
	private Set<Pasantia> pasantias;
	
	public TutorAcademico(String cedula, AreaAcademica areaAcademica,
			String nacionalidad, String nombre1, String nombre2,
			String apellido1, String apellido2, String sexo, String residencia,
			String correo, String telefono1, String telefono2,
			boolean estadoEliminacion, String usuario, Date fechaAuditoria,
			String horaAuditoria) {
		super();
		this.cedula = cedula;
		this.areaAcademica = areaAcademica;
		this.nacionalidad = nacionalidad;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.sexo = sexo;
		this.residencia = residencia;
		this.correo = correo;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.estadoEliminacion = estadoEliminacion;
		this.usuario = usuario;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
	}

	public TutorAcademico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public AreaAcademica getAreaAcademica() {
		return areaAcademica;
	}

	public void setAreaAcademica(AreaAcademica areaAcademica) {
		this.areaAcademica = areaAcademica;
	}

	public String getNacionalidad() {
		return nacionalidad;
	}

	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getResidencia() {
		return residencia;
	}

	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono1() {
		return telefono1;
	}

	public void setTelefono1(String telefono1) {
		this.telefono1 = telefono1;
	}

	public String getTelefono2() {
		return telefono2;
	}

	public void setTelefono2(String telefono2) {
		this.telefono2 = telefono2;
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

	public Set<Pasantia> getPasantias() {
		return pasantias;
	}

	public void setPasantias(Set<Pasantia> pasantias) {
		this.pasantias = pasantias;
	}

	
	
}
