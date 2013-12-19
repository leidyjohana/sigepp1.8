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
import modelo.pk.PasantiaRecaudoId;

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
@Table(name = "pasantia_recaudo")
@IdClass(PasantiaRecaudoId.class)
public class PasantiaRecaudo {
	
	
	@Id
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "pasantia_id", referencedColumnName = "pasantia_id")
	private Pasantia pasantia;
	
	@Id
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "recaudo_id", referencedColumnName = "recaudo_id")
	private Recaudo recaudo;
	
	
	@Column(name = "ruta_archivo1", length = 500)
	private String rutaArchivo1;
	
	@Column(name = "ruta_archivo2", length = 500)
	private String rutaArchivo2;
	
	@Column(name = "ruta_archivo3", length = 500)
	private String rutaArchivo3;
	
	@Column(name = "usuario_id", length = 20)
	private String usuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;
	
}
