package modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import modelo.pk.ProgramaPasantiaTipoId;

/**
* 
* Autor: Ysolmery Maiorano
* Revisado por: Fernando Rivero
* Version: 1.0
* Fecha: 21/11/2013
* 
*/

@Entity
@Table(name = "programa_pasantia_tipo")
@IdClass(ProgramaPasantiaTipoId.class)
public class ProgramaPasantiaTipo {
	
	@Id
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "pasantia_tipo_id", referencedColumnName = "pasantia_tipo_id")
	private PasantiaTipo pasantiaTipo;
	
	@Id
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "programa_id", referencedColumnName = "programa_id")
	private Programa programa;
	
	@Column(name = "descripcion", length = 500)
	private String descripcion;
	
	@Column(name = "semestre_aprobado")
	private int semestre;
	
	@Column(name = "creditos_aprobados")
	private int creditos;
	
	@Column(name = "usuario_id", length = 20)
	private String usuario;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;

	public ProgramaPasantiaTipo( PasantiaTipo pasantiaTipo,
			Programa programa, String descripcion, int semestre, int creditos,
			String usuario, Date fechaAuditoria, String horaAuditoria) {
		super();
		this.pasantiaTipo = pasantiaTipo;
		this.programa = programa;
		this.descripcion = descripcion;
		this.semestre = semestre;
		this.creditos = creditos;
		this.usuario = usuario;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
	}

	public ProgramaPasantiaTipo() {
		
	}


	

	public Programa getPrograma() {
		return programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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

	public PasantiaTipo getPasantiaTipo() {
		return pasantiaTipo;
	}

	public void setPasantiaTipo(PasantiaTipo pasantiaTipo) {
		this.pasantiaTipo = pasantiaTipo;
	}
		
	
}
