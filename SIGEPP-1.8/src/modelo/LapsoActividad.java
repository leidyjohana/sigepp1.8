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
* Autor: Fernando Rivero
* Revisado por: Fernando Rivero
* Version: 1.0
* Fecha Creacion: 02/12/2013
* 
* ----------------------------
* HISTORIAL DE MODIFICACIONES
* ----------------------------
* 
* 
*/

@Entity
@Table(name = "lapso_actividad")
public class LapsoActividad {
	
	@GeneratedValue
	@Id
	@Column(name = "lapso_actividad_id", nullable = false)
	private long id;
	
	@Column(name = "descripcion", length = 500)
	private String nombre;
	
	@Column(name = "usuario_id", length = 20)
	private String usuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;
	
	@Column(name = "estado_eliminacion")
	private boolean estadoEliminacion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "actividadLapso", fetch = FetchType.LAZY)
	private Set<PasantiaLapsoActividad> cronogramas ;

	public LapsoActividad(long id, String nombre, String usuario,
			Date fechaAuditoria, String horaAuditoria, boolean estadoEliminacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.usuario = usuario;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
		this.estadoEliminacion = estadoEliminacion;
	}

	public LapsoActividad() {

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

	public Set<PasantiaLapsoActividad> getCronogramas() {
		return cronogramas;
	}

	public void setCronogramas(Set<PasantiaLapsoActividad> cronogramas) {
		this.cronogramas = cronogramas;
	}
	
}
