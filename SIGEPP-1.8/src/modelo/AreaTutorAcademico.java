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
import modelo.pk.AreaTutorAcademicoId;

/**
* 
* Autor: Ysolmery Maiorano
* Revisado por: Fernando Rivero
* Version: 1.0
* Fecha: 21/11/2013
* 
* * ----------------------------
* HISTORIAL DE MODIFICACIONES
* ----------------------------
* 
* * ----------------------------
* Autor: Fernando Rivero
* Fecha: 16/12/2013
* Descripcion: Se cambia la forma de generar el ID por un composite
* ----------------------------
* 
*/


@Entity
@Table(name = "area_cono_tutor_acad")
@IdClass(AreaTutorAcademicoId.class)
public class AreaTutorAcademico {
	
		
	@Id
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "area_conocimiento_id", referencedColumnName = "area_conocimiento_id")
	private AreaConocimiento areaConocimiento;
	
	@Id
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "tutor_academico_id", referencedColumnName = "tutor_academico_id")
	private TutorAcademico tutorAcademico;
	
	@Column(name = "cantidad_max_tutorar")
	private int tutoriados;
	
	@Column(name = "usuario_id", length = 20)
	private String usuario;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;
	
	
	public AreaTutorAcademico( AreaConocimiento areaConocimiento,
			TutorAcademico tutorAcademico, int tutoriados, String usuario,
			Date fechaAuditoria, String horaAuditoria) {
		super();
		
		this.areaConocimiento = areaConocimiento;
		this.tutorAcademico = tutorAcademico;
		this.tutoriados = tutoriados;
		this.usuario = usuario;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
	}

	public AreaTutorAcademico() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AreaConocimiento getAreaConocimiento() {
		return areaConocimiento;
	}

	public void setAreaConocimiento(AreaConocimiento areaConocimiento) {
		this.areaConocimiento = areaConocimiento;
	}

	public TutorAcademico getTutorAcademico() {
		return tutorAcademico;
	}

	public void setTutorAcademico(TutorAcademico tutorAcademico) {
		this.tutorAcademico = tutorAcademico;
	}

	public int getTutoriados() {
		return tutoriados;
	}

	public void setTutoriados(int tutoriados) {
		this.tutoriados = tutoriados;
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

	
}
