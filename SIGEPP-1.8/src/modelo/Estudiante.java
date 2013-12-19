package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


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
* ----------------------------
* Autor: Fernando Rivero
* Fecha: 26/11/2013
* Descripcion: Se cambia el tipo de datos del atributo nacionalidad del tipo Char a tipo String
* ----------------------------
* 
*/

@Entity
@Table(name = "estudiante")
public class Estudiante {
	
	@Id
	@Column(name = "estudiante_id", nullable = false, length = 8)
	private String cedula;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "programa_id", referencedColumnName = "programa_id")
	private Programa programa;
	
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

	@Column(name = "estado_civil", length = 50)
	private String edoCivil;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")
	private Date fechaNacimiento;
	
	@Column(name = "residencia", length = 500)
	private String residencia;
	
	@Column(name = "correo_electronico", length = 50)
	private String correo;
	
	@Column(name = "telefono1", length = 50)
	private String telefono1;
	
	@Column(name = "telefono2", length = 50)
	private String telefono2;
	
//	@Lob
//	@Column(name = "foto")
//	private byte[] foto;
	
	@Column(name = "promedio")
	private float promedio;
	
	@Column(name = "semestre_aprobado")
	private int semestre;
	
	@Column(name = "creditos_aprobados")
	private int creditos;

	@Column(name = "servicio_comunitario")
	private Boolean servicioComunitario;
	
	@Column(name = "estado_estudiante", length = 20)
	private String estadoEstudiante;
	
	@Column(name = "usuario_id", length = 20)
	private String usuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;
	
	@Column(name = "estado_eliminacion")
	private boolean estadoEliminacion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "estudiante", fetch = FetchType.LAZY)
	private Set<PasantiaSolicitud> solicitudes;


	public Estudiante(String cedula, Programa programa, String nacionalidad,
			String nombre1, String nombre2, String apellido1, String apellido2,
			String sexo, String edoCivil, Date fechaNacimiento,
			String residencia, String correo, String telefono1,
			String telefono2, float promedio, int semestre, int creditos,
			Boolean servicioComunitario, String estadoEstudiante,
			String usuario, Date fechaAuditoria, String horaAuditoria,
			boolean estadoEliminacion) {
		super();
		this.cedula = cedula;
		this.programa = programa;
		this.nacionalidad = nacionalidad;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.sexo = sexo;
		this.edoCivil = edoCivil;
		this.fechaNacimiento = fechaNacimiento;
		this.residencia = residencia;
		this.correo = correo;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.promedio = promedio;
		this.semestre = semestre;
		this.creditos = creditos;
		this.servicioComunitario = servicioComunitario;
		this.estadoEstudiante = estadoEstudiante;
		this.usuario = usuario;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
		this.estadoEliminacion = estadoEliminacion;
	}

	public Estudiante() {
		super();
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
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

	public String getEdoCivil() {
		return edoCivil;
	}

	public void setEdoCivil(String edoCivil) {
		this.edoCivil = edoCivil;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
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

	public float getPromedio() {
		return promedio;
	}

	public void setPromedio(float promedio) {
		this.promedio = promedio;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	public Boolean getServicioComunitario() {
		return servicioComunitario;
	}

	public void setServicioComunitario(Boolean servicioComunitario) {
		this.servicioComunitario = servicioComunitario;
	}

	public String getEstadoEstudiante() {
		return estadoEstudiante;
	}

	public void setEstadoEstudiante(String estadoEstudiante) {
		this.estadoEstudiante = estadoEstudiante;
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
	
	public Set<PasantiaSolicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(Set<PasantiaSolicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}


}
