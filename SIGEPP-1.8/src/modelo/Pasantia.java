package modelo;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
* 
* Autor: Fernando Rivero
* Revisado por: Fernando Rivero
* Version: 1.0
* Fecha Creacion: 16/12/2013
* 
* ----------------------------
* HISTORIAL DE MODIFICACIONES
* ----------------------------
* 
* 
*/

@Entity
@Table(name = "pasantia")
public class Pasantia {
	
	@GeneratedValue
	@Id
	@Column(name = "pasantia_id", nullable = false)
	private long id;
	
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "tutor_academico_id", referencedColumnName = "tutor_academico_id")
	private TutorAcademico tutorAcademico;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "motivo_id", referencedColumnName = "motivo_id")
	private Motivo motivo;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "pasantia_lapso_id", referencedColumnName = "pasantia_lapso_id")
	private PasantiaLapso pasantiaLapso;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "pasantia_tipo_id", referencedColumnName = "pasantia_tipo_id")
	private PasantiaTipo pasantiaTipo;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "tutor_empresarial_id", referencedColumnName = "tutor_empresarial_id")
	private TutorEmpresarial tutorEmpresarial;
	
	@OneToOne(fetch=FetchType.LAZY,optional=false)
	private PasantiaSolicitud pasantiaSolicitud;
	
	@Column(name = "descripcion", length = 500)
	private String descripcion;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio")
	private Date fechaInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin")
	private Date fechaFin;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_registro")
	private Date fechaRegistro;
	
	@Column(name = "nota_tutor_emp")
	private int notaTutorEmpresarial;
	
	@Column(name = "nota_tutor_aca")
	private int notaTutorAcad;
	
	@Column(name = "nota_final")
	private int notaFinal;
	
	@Column(name = "observacion", length = 500)
	private String observacion;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;
	
	@Column(name = "estado_eliminacion")
	private boolean estadoEliminacion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pasantia", fetch = FetchType.LAZY)
	private Set<PasantiaActividad> pasantiaActividades ;
		
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pasantia", fetch = FetchType.LAZY)
	private Set<PasantiaRecaudo> recaudos ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pasantia", fetch = FetchType.LAZY)
	private Set<PasantiaEstado> pasantiaEstados ;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pasantia", fetch = FetchType.LAZY)
	private Set<PasantiaSeguimiento> pasantiaSeguimientos ;

	public Pasantia() {
		super();
	}

	public Pasantia(long id, TutorAcademico tutorAcademico, Motivo motivo,
			PasantiaLapso pasantiaLapso, PasantiaTipo pasantiaTipo,
			TutorEmpresarial tutorEmpresarial,
			PasantiaSolicitud pasantiaSolicitud, String descripcion,
			Date fechaInicio, Date fechaFin, Date fechaRegistro,
			int notaTutorEmpresarial, int notaTutorAcad, int notaFinal,
			String observacion, Date fechaAuditoria, String horaAuditoria,
			boolean estadoEliminacion) {
		super();
		this.id = id;
		this.tutorAcademico = tutorAcademico;
		this.motivo = motivo;
		this.pasantiaLapso = pasantiaLapso;
		this.pasantiaTipo = pasantiaTipo;
		this.tutorEmpresarial = tutorEmpresarial;
		this.pasantiaSolicitud = pasantiaSolicitud;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.fechaRegistro = fechaRegistro;
		this.notaTutorEmpresarial = notaTutorEmpresarial;
		this.notaTutorAcad = notaTutorAcad;
		this.notaFinal = notaFinal;
		this.observacion = observacion;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
		this.estadoEliminacion = estadoEliminacion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public TutorAcademico getTutorAcademico() {
		return tutorAcademico;
	}

	public void setTutorAcademico(TutorAcademico tutorAcademico) {
		this.tutorAcademico = tutorAcademico;
	}

	public Motivo getMotivo() {
		return motivo;
	}

	public void setMotivo(Motivo motivo) {
		this.motivo = motivo;
	}

	public PasantiaLapso getPasantiaLapso() {
		return pasantiaLapso;
	}

	public void setPasantiaLapso(PasantiaLapso pasantiaLapso) {
		this.pasantiaLapso = pasantiaLapso;
	}

	public PasantiaTipo getPasantiaTipo() {
		return pasantiaTipo;
	}

	public void setPasantiaTipo(PasantiaTipo pasantiaTipo) {
		this.pasantiaTipo = pasantiaTipo;
	}

	public TutorEmpresarial getTutorEmpresarial() {
		return tutorEmpresarial;
	}

	public void setTutorEmpresarial(TutorEmpresarial tutorEmpresarial) {
		this.tutorEmpresarial = tutorEmpresarial;
	}

	public PasantiaSolicitud getPasantiaSolicitud() {
		return pasantiaSolicitud;
	}

	public void setPasantiaSolicitud(PasantiaSolicitud pasantiaSolicitud) {
		this.pasantiaSolicitud = pasantiaSolicitud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public int getNotaTutorEmpresarial() {
		return notaTutorEmpresarial;
	}

	public void setNotaTutorEmpresarial(int notaTutorEmpresarial) {
		this.notaTutorEmpresarial = notaTutorEmpresarial;
	}

	public int getNotaTutorAcad() {
		return notaTutorAcad;
	}

	public void setNotaTutorAcad(int notaTutorAcad) {
		this.notaTutorAcad = notaTutorAcad;
	}

	public int getNotaFinal() {
		return notaFinal;
	}

	public void setNotaFinal(int notaFinal) {
		this.notaFinal = notaFinal;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
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

	public Set<PasantiaActividad> getPasantiaActividades() {
		return pasantiaActividades;
	}

	public void setPasantiaActividades(Set<PasantiaActividad> pasantiaActividades) {
		this.pasantiaActividades = pasantiaActividades;
	}

	

	

	public Set<PasantiaEstado> getPasantiaEstados() {
		return pasantiaEstados;
	}

	public void setPasantiaEstados(Set<PasantiaEstado> pasantiaEstados) {
		this.pasantiaEstados = pasantiaEstados;
	}

	public Set<PasantiaSeguimiento> getPasantiaSeguimientos() {
		return pasantiaSeguimientos;
	}

	public void setPasantiaSeguimientos(
			Set<PasantiaSeguimiento> pasantiaSeguimientos) {
		this.pasantiaSeguimientos = pasantiaSeguimientos;
	}

	public Set<PasantiaRecaudo> getRecaudos() {
		return recaudos;
	}

	public void setRecaudos(Set<PasantiaRecaudo> recaudos) {
		this.recaudos = recaudos;
	}


	
}
