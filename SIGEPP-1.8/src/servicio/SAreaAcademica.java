package servicio;

import java.util.List;

import interfazdao.IAreaAcademicaDAO;

import modelo.AreaAcademica;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SAreaAcademica {

	@Autowired
	private IAreaAcademicaDAO areaAcademicaDAO;

	public void guardar(AreaAcademica areaAcademica) {
		areaAcademicaDAO.save(areaAcademica);
	}

	public AreaAcademica buscarAreaAcademica(long id) {
		return areaAcademicaDAO.findOne(id);
	}

	public List<AreaAcademica> buscarAreasActivas() {
		List<AreaAcademica> areaAcademica;
		areaAcademica = areaAcademicaDAO.buscarAreasActivas();
		return areaAcademica;
	}

	public AreaAcademica buscarPorNombreAreaAcademica(String nombre) {
		AreaAcademica areaAcademica;
		areaAcademica = areaAcademicaDAO.findByNombre(nombre);
		return areaAcademica;
	}

	public List<AreaAcademica> buscarCualquierCampoContiene(String parte) {
		return areaAcademicaDAO.findByNombreStartingWithOrDescripcionStartingWith(parte, parte);
	}
}
