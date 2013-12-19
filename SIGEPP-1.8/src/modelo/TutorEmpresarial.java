package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
import java.util.Set;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import modelo.pk.AreaTutorAcademicoId;
import modelo.pk.TutorEmpresarialId;


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
* ----------------------------
* Autor: Fernando Rivero
* Fecha: 26/11/2013
* Descripcion: Se cambia el tipo de datos del atributo nacionalidad del tipo Char a tipo String
* ----------------------------
*
*
*/

@Entity
@Table(name = "tutor_empresarial")
public class TutorEmpresarial {

	@Id
	@Column(name = "tutor_empresarial_id", nullable = false, length = 8)
	private String cedula;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id")
	private Empresa empresa;
	
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
	
	@Column(name = "correo_electronico", length = 50)
	private String correo;
	
	@Column(name = "telefono1", length = 50)
	private String telefono1;
	
	@Column(name = "telefono2", length = 50)
	private String telefono2;
	
	@Column(name = "departamento", length = 50)
	private String departamento;
	
	@Column(name = "cargo", length = 50)
	private String cargo;
	
	@Column(name = "usuario_id", length = 20)
	private String usuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;
	
	@Column(name = "estado_eliminacion")
	private boolean estadoEliminacion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "tutorEmpresarial", fetch = FetchType.LAZY)
	private Set<Pasantia> pasantias;
	

	public TutorEmpresarial(String cedula, Empresa empresa, String nacionalidad,
			String nombre1, String nombre2, String apellido1, String apellido2,
			String sexo, String correo, String telefono1, String telefono2,
			String departamento, String cargo, String usuario,
			Date fechaAuditoria, String horaAuditoria, boolean estadoEliminacion) {
		super();
		this.cedula = cedula;
		this.empresa = empresa;
		this.nacionalidad = nacionalidad;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.sexo = sexo;
		this.correo = correo;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.departamento = departamento;
		this.cargo = cargo;
		this.usuario = usuario;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
		this.estadoEliminacion = estadoEliminacion;
	}

	public TutorEmpresarial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
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

	public Set<Pasantia> getPasantias() {
		return pasantias;
	}

	public void setPasantias(Set<Pasantia> pasantias) {
		this.pasantias = pasantias;
	}

	

}
