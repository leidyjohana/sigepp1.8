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
@Table(name ="empresa")
public class Empresa {

	@Id
	@Column(name = "empresa_id", nullable = false, length = 50)
	private String rif;
	
	@Column(name = "nombre", length = 100)
	private String nombre;
	
	@Column(name = "direccion1", length = 500)
	private String direccion1;
	
	@Column(name = "direccion2", length = 500)
	private String direccion2;
	
	@Column(name = "telefono1", length = 50)
	private String telefono1;
	
	@Column(name = "telefono2", length = 50)
	private String telefono2;
	
	@Column(name = "correo_electronico1", length = 50)
	private String correoElectronico1;
	
	@Column(name = "correo_electronico2", length = 50)
	private String correoElectronico2;
	
	@Column(name = "persona_contacto", length = 100)
	private String personaContacto;
	
	@Column(name = "usuario_id", length = 20)
	private String usuario;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;
	
	@Column(name = "estado_eliminacion")
	private boolean estadoEliminacion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
	private Set<TutorEmpresarial> tutoresEmpresariales;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.LAZY)
	private Set<EmpresaOferta> ofertas;

	public Empresa(String rif, String nombre, String direccion1,
			String direccion2, String telefono1, String telefono2,
			String correo1, String correo2, String personaContacto,
			Date fechaAuditoria, String horaAuditoria, String usuario, boolean estadoEliminacion) {
		super();
		this.rif = rif;
		this.nombre = nombre;
		this.direccion1 = direccion1;
		this.direccion2 = direccion2;
		this.telefono1 = telefono1;
		this.telefono2 = telefono2;
		this.correoElectronico1 = correo1;
		this.correoElectronico2 = correo2;
		this.personaContacto = personaContacto;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
		this.usuario = usuario;
		this.estadoEliminacion = estadoEliminacion;
	}

	public Empresa() {
		// TODO Auto-generated constructor stub
	}

	public String getRif() {
		return rif;
	}

	public void setRif(String rif) {
		this.rif = rif;
	}
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion1() {
		return direccion1;
	}

	public void setDireccion1(String direccion1) {
		this.direccion1 = direccion1;
	}

	public String getDireccion2() {
		return direccion2;
	}

	public void setDireccion2(String direccion2) {
		this.direccion2 = direccion2;
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

	public String getCorreoElectronico1() {
		return correoElectronico1;
	}

	public void setCorreoElectronico1(String correoElectronico1) {
		this.correoElectronico1 = correoElectronico1;
	}

	public String getCorreoElectronico2() {
		return correoElectronico2;
	}

	public void setCorreoElectronico2(String correoElectronico2) {
		this.correoElectronico2 = correoElectronico2;
	}

	public String getPersonaContacto() {
		return personaContacto;
	}

	public void setPersonaContacto(String personaContacto) {
		this.personaContacto = personaContacto;
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
//
//	@OneToMany(mappedBy = "empresa")
//	public Set<TutorEmpresarial> getTutorEmpresarial() {
//		return tutorEmpresarial;
//	}
//
//	public void setTutorEmpresarial(Set<TutorEmpresarial> tutorEmpresarial) {
//		this.tutorEmpresarial = tutorEmpresarial;
//	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public boolean isEstadoEliminacion() {
		return estadoEliminacion;
	}

	public void setEstadoEliminacion(boolean estadoEliminacion) {
		this.estadoEliminacion = estadoEliminacion;
	}

	public Set<TutorEmpresarial> getTutoresEmpresariales() {
		return tutoresEmpresariales;
	}

	public void setTutoresEmpresariales(Set<TutorEmpresarial> tutoresEmpresariales) {
		this.tutoresEmpresariales = tutoresEmpresariales;
	}

	public Set<EmpresaOferta> getOfertas() {
		return ofertas;
	}

	public void setOfertas(Set<EmpresaOferta> ofertas) {
		this.ofertas = ofertas;
	}

}
