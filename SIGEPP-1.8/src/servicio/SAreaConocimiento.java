package servicio;

import java.util.List;

import interfazdao.IAreaConocimientoDAO;

import modelo.AreaConocimiento;
import modelo.Departamento;
import modelo.TutorAcademico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SAreaConocimiento {

	@Autowired
	private IAreaConocimientoDAO areaConocimientoDAO;

	public void guardar(AreaConocimiento areaConocimiento) {
		areaConocimientoDAO.save(areaConocimiento);
	}

	public AreaConocimiento buscarAreaConocimiento(long id) {
		return areaConocimientoDAO.findOne(id);
	}

	public List<AreaConocimiento> buscarAreasActivas() {
		List<AreaConocimiento> areaConocimiento;
		areaConocimiento = areaConocimientoDAO.buscarAreasActivas();
		return areaConocimiento;
	}
	public List<AreaConocimiento> buscarAreasDisponiblesParaTutor(TutorAcademico tutorAcademico) {
		List<AreaConocimiento> areaConocimiento;
		areaConocimiento = areaConocimientoDAO.buscarAreasDisponiblesParaTutor(tutorAcademico);
		return areaConocimiento;
	}
	public AreaConocimiento buscarPorNombreAreaConocimiento(String nombre) {
		AreaConocimiento areaConocimiento;
		areaConocimiento = areaConocimientoDAO.findByNombre(nombre);
		return areaConocimiento;
	}

	public List<AreaConocimiento> buscarCualquierCampoContiene(String parte) {
		return areaConocimientoDAO.findByNombreContainingOrDescripcionContaining(
				parte, parte);
	}

}
