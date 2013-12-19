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
import modelo.pk.PasantiaEstadoId;

/**
* 
* Autor: Fernando Rivero
* Revisado por: Fernando Rivero
* Version: 1.0
* Fecha: 16/12/2013
* 
* * ----------------------------
* HISTORIAL DE MODIFICACIONES
* ----------------------------
*  
*/


@Entity
@Table(name = "pasantia_estado")
@IdClass(PasantiaEstadoId.class)
public class PasantiaEstado {
	
	@Id
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "pasantia_id", referencedColumnName = "pasantia_id")
	private Pasantia pasantia;
	
	@Id
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "pasantia_paso_id", referencedColumnName = "pasantia_paso_id")
	private PasantiaPaso pasantiaPaso;
	
	@Column(name = "estado_paso", length = 20)
	private String estadoPaso;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_inicio")
	private Date fecha_inicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_fin")
	private Date fecha_fin;
	
	@Column(name = "usuario_id", length = 20)
	private String usuario;

	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;
	
}