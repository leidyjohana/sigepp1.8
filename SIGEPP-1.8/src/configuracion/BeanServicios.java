package configuracion;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import servicio.SLapsoActividad;
import servicio.SAreaAcademica;
import servicio.SAreaConocimiento;
import servicio.SAreaTutorAcademico;
import servicio.SDepartamento;
import servicio.SEmpresa;
import servicio.SEstudiante;
import servicio.SMotivo;
import servicio.SPasantiaPaso;
import servicio.SPlantillaDocumento;
import servicio.SPrograma;
import servicio.SRecaudo;
import servicio.SSeguimientoActividad;
import servicio.SPasantiaTipo;
import servicio.STutorEmpresarial;

import servicio.STutorAcademico;


public class BeanServicios implements ApplicationContextAware {

	private static ApplicationContext applicationContext = new ClassPathXmlApplicationContext(
			"/META-INF/ContextoAplicacion.xml");

	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		BeanServicios.applicationContext = applicationContext;
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static STutorEmpresarial getSTutorEmpresarial() {
		return applicationContext.getBean(STutorEmpresarial.class);
	}
	
	public static SEmpresa getSEmpresa() {
		return applicationContext.getBean(SEmpresa.class);
	}
	
	public static SDepartamento getSDepartamento() {
		return applicationContext.getBean(SDepartamento.class);
	}
	public static STutorAcademico getSTutorAcademico() {
		return applicationContext.getBean(STutorAcademico.class);
	}
	public static SAreaAcademica getSAreaAcademica() {
		return applicationContext.getBean(SAreaAcademica.class);
	}

	public static SAreaConocimiento getSAreaConocimiento() {
		return applicationContext.getBean(SAreaConocimiento.class);
	}
	public static SAreaTutorAcademico getSAreaTutorAcademico() {
		return applicationContext.getBean(SAreaTutorAcademico.class);
	}
	public static SPrograma getSPrograma() {
		return applicationContext.getBean(SPrograma.class);
	}
	public static SEstudiante getSEstudiante() {
		return applicationContext.getBean(SEstudiante.class);
	}
	public static SPasantiaTipo getSPasantiaTipo() {
		return applicationContext.getBean(SPasantiaTipo.class);
	}
	public static SSeguimientoActividad getSSeguimientoActividad() {
		return applicationContext.getBean(SSeguimientoActividad.class);
	}
	public static SMotivo getSMotivo() {
		return applicationContext.getBean(SMotivo.class);
	}
	public static SPasantiaPaso getSPasantiaPaso() {
		return applicationContext.getBean(SPasantiaPaso.class);
	}
	public static SPlantillaDocumento getSPlantillaDocumento() {
		return applicationContext.getBean(SPlantillaDocumento.class);
	}
	public static SRecaudo getSRecaudo() {
		return applicationContext.getBean(SRecaudo.class);
	}
	public static SLapsoActividad getSLapsoActividad() {
		return applicationContext.getBean(SLapsoActividad.class);
	}
}
