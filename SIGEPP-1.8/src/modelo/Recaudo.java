package modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
* 
* Autor: Mariangel Santeliz
* Revisado por: Fernando Rivero
* Version: 1.0
* Fecha Creacion: 26/11/2013
* 
* ----------------------------
* HISTORIAL DE MODIFICACIONES
* ----------------------------
* 
* 
*/

@Entity
@Table(name = "recaudo")
public class Recaudo {
	
	@GeneratedValue
	@Id
	@Column(name = "recaudo_id", nullable = false)
	private long id;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "plantilla_documento_id", referencedColumnName = "plantilla_documento_id")
	private PlantillaDocumento plantillaDocumento;
	
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

	
	
	

	public Recaudo(long id, PlantillaDocumento plantillaDocumento,
			String descripcion, String usuario, Date fechaAuditoria,
			String horaAuditoria, boolean estadoEliminacion) {
		super();
		this.id = id;
		this.plantillaDocumento = plantillaDocumento;
		this.descripcion = descripcion;
		this.usuario = usuario;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
		this.estadoEliminacion = estadoEliminacion;
	}

	public Recaudo() {
		// TODO Auto-generated constructor stub
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	
	public PlantillaDocumento getPlantillaDocumento() {
		return plantillaDocumento;
	}

	public void setPlantillaDocumento(PlantillaDocumento plantillaDocumento) {
		this.plantillaDocumento = plantillaDocumento;
	}

}
