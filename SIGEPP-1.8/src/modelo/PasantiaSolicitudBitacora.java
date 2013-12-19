package modelo;

import java.util.Date;

import javax.persistence.*;
/**
* 
* Autor: Luis Devides
* Revisado por: Fernando Rivero
* Version: 1.0
* Fecha Creacion: 26/11/2013
* 
* ----------------------------
* HISTORIAL DE MODIFICACIONES
* ----------------------------
* 
*/
@Entity
@Table(name="pasantia_solicitud_bitacora")
public class PasantiaSolicitudBitacora {

		
	@GeneratedValue
	@Id
	@Column(name="pasantia_solicitud_bitacora_id")
	private long id;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "solicitud_id", referencedColumnName = "solicitud_id")
	private PasantiaSolicitud solicitudPasantia;
		
	@Column(name="estado_solicitud")
	private String estadoSolicitud;
	
	@Temporal(TemporalType.DATE)
	@Column(name="fecha_cambio_estado")
	private Date fechaCambioEstado;
	
	@Column(name="hora_cambio_estado")
	private Date horaCambioEstado;

	public PasantiaSolicitudBitacora(long id, PasantiaSolicitud solicitudPasantia,
			String estadoSolicitud, Date fechaCambioEstado,
			Date horaCambioEstado) {
		super();
		this.id = id;
		this.solicitudPasantia = solicitudPasantia;
		this.estadoSolicitud = estadoSolicitud;
		this.fechaCambioEstado = fechaCambioEstado;
		this.horaCambioEstado = horaCambioEstado;
	}
	

	public PasantiaSolicitudBitacora() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public PasantiaSolicitud getSolicitud() {
		return solicitudPasantia;
	}

	public void setSolicitud(PasantiaSolicitud solicitud) {
		this.solicitudPasantia = solicitud;
	}

	public String getEstadoSolicitud() {
		return estadoSolicitud;
	}

	public void setEstadoSolicitud(String estadoSolicitud) {
		this.estadoSolicitud = estadoSolicitud;
	}

	public Date getFechaCambioEstado() {
		return fechaCambioEstado;
	}

	public void setFechaCambioEstado(Date fechaCambioEstado) {
		this.fechaCambioEstado = fechaCambioEstado;
	}

	public Date getHoraCambioEstado() {
		return horaCambioEstado;
	}

	public void setHoraCambioEstado(Date horaCambioEstado) {
		this.horaCambioEstado = horaCambioEstado;
	}

	

}
