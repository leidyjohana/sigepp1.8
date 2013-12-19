package modelo;

import javax.persistence.CascadeType;
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
@Table(name = "empresa_oferta")
public class EmpresaOferta {
	
	@GeneratedValue
	@Id
	@Column(name = "oferta_id", nullable = false)
	private long id;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "empresa_id", referencedColumnName = "empresa_id")
	private Empresa empresa;
	
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	@JoinColumn(name = "area_conocimiento_id", referencedColumnName = "area_conocimiento_id")
	private AreaConocimiento areaConocimiento;
	
	@Column(name = "descripcion", length = 500)
	private String descripcion;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@Column(name = "estado_oferta", length = 20)
	private String estadoOferta;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_validez_inicio")
	private Date fechaValidezInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_validez_fin")
	private Date fechaValidezFin;
	
	@Column(name = "ruta_archivo1", length = 500)
	private String rutaArchivo1;
	
	@Column(name = "ruta_archivo2", length = 500)
	private String rutaArchivo2;
	
	@Column(name = "ruta_archivo3", length = 500)
	private String rutaArchivo3;
	
	@Column(name = "cantidad_ofertada")
	private int cantidadOfertada;
	
	@Column(name = "cantidad_comprometida")
	private int cantidadComprometida;
	
	@Column(name = "cantidad_disponible")
	private int cantidadDisponible;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_registro")
	private Date fechaRegistro;
	
	@Column(name = "hora_registro", length = 15)
	private String horaRegistro;
	
	@Column(name = "usuario_id", length = 20)
	private String usuario;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_auditoria")
	private Date fechaAuditoria;
	
	@Column(name = "hora_auditoria", length = 15)
	private String horaAuditoria;
	
	@Column(name = "estado_eliminacion")
	private boolean estadoEliminacion;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "ofertaEmpresa", fetch = FetchType.LAZY)
	private Set<PasantiaSolicitud> solicitudes;

	public EmpresaOferta(long id, AreaConocimiento areaConocimiento,
			Empresa empresa, String descripcion, int cantidad,
			String estadoOferta, Date fechaValidezInicio, Date fechaValidezFin,
			String rutaArchivo1, String rutaArchivo2, String rutaArchivo3,
			int cantidadOfertada, int cantidadComprometida,
			int cantidadDisponible, Date fechaRegistro, String horaRegistro,
			String usuario, Date fechaAuditoria, String horaAuditoria,
			boolean estadoEliminacion) {
		super();
		this.id = id;
		this.areaConocimiento = areaConocimiento;
		this.empresa = empresa;
		this.descripcion = descripcion;
		this.cantidad = cantidad;
		this.estadoOferta = estadoOferta;
		this.fechaValidezInicio = fechaValidezInicio;
		this.fechaValidezFin = fechaValidezFin;
		this.rutaArchivo1 = rutaArchivo1;
		this.rutaArchivo2 = rutaArchivo2;
		this.rutaArchivo3 = rutaArchivo3;
		this.cantidadOfertada = cantidadOfertada;
		this.cantidadComprometida = cantidadComprometida;
		this.cantidadDisponible = cantidadDisponible;
		this.fechaRegistro = fechaRegistro;
		this.horaRegistro = horaRegistro;
		this.usuario = usuario;
		this.fechaAuditoria = fechaAuditoria;
		this.horaAuditoria = horaAuditoria;
		this.estadoEliminacion = estadoEliminacion;
	}

	public EmpresaOferta() {
		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public AreaConocimiento getAreaConocimiento() {
		return areaConocimiento;
	}

	public void setAreaConocimiento(AreaConocimiento areaConocimiento) {
		this.areaConocimiento = areaConocimiento;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getEstadoOferta() {
		return estadoOferta;
	}

	public void setEstadoOferta(String estadoOferta) {
		this.estadoOferta = estadoOferta;
	}

	public Date getFechaValidezInicio() {
		return fechaValidezInicio;
	}

	public void setFechaValidezInicio(Date fechaValidezInicio) {
		this.fechaValidezInicio = fechaValidezInicio;
	}

	public Date getFechaValidezFin() {
		return fechaValidezFin;
	}

	public void setFechaValidezFin(Date fechaValidezFin) {
		this.fechaValidezFin = fechaValidezFin;
	}

	public String getRutaArchivo1() {
		return rutaArchivo1;
	}

	public void setRutaArchivo1(String rutaArchivo1) {
		this.rutaArchivo1 = rutaArchivo1;
	}

	public String getRutaArchivo2() {
		return rutaArchivo2;
	}

	public void setRutaArchivo2(String rutaArchivo2) {
		this.rutaArchivo2 = rutaArchivo2;
	}

	public String getRutaArchivo3() {
		return rutaArchivo3;
	}

	public void setRutaArchivo3(String rutaArchivo3) {
		this.rutaArchivo3 = rutaArchivo3;
	}

	public int getCantidadOfertada() {
		return cantidadOfertada;
	}

	public void setCantidadOfertada(int cantidadOfertada) {
		this.cantidadOfertada = cantidadOfertada;
	}

	public int getCantidadComprometida() {
		return cantidadComprometida;
	}

	public void setCantidadComprometida(int cantidadComprometida) {
		this.cantidadComprometida = cantidadComprometida;
	}

	public int getCantidadDisponible() {
		return cantidadDisponible;
	}

	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public Date getFechaRegistro() {
		return fechaRegistro;
	}

	public void setFechaRegistro(Date fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getHoraRegistro() {
		return horaRegistro;
	}

	public void setHoraRegistro(String horaRegistro) {
		this.horaRegistro = horaRegistro;
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

	public Set<PasantiaSolicitud> getSolicitudes() {
		return solicitudes;
	}

	public void setSolicitudes(Set<PasantiaSolicitud> solicitudes) {
		this.solicitudes = solicitudes;
	}
	

}
