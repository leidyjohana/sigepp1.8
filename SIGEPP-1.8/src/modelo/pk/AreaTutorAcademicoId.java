package modelo.pk;

import java.io.Serializable;

import modelo.AreaConocimiento;
import modelo.TutorAcademico;

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
* 
*/

public class AreaTutorAcademicoId implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6548397710050256671L;
	private AreaConocimiento areaConocimiento;
	private TutorAcademico tutorAcademico;
	
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
}
