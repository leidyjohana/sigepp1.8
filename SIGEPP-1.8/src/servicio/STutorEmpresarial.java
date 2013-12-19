package servicio;

import interfazdao.ITutorEmpresarialDAO;

import java.util.List;

import modelo.TutorEmpresarial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class STutorEmpresarial {

	@Autowired
	private ITutorEmpresarialDAO tutorEmpresarialDAO;

	public void guardar(TutorEmpresarial tutorEmpresarial){
		tutorEmpresarialDAO.save(tutorEmpresarial);
	}
	public List<TutorEmpresarial> buscarTutoresActivos()
	{
		List<TutorEmpresarial> tutores;
		tutores = tutorEmpresarialDAO.buscarTutoresActivos();
		return tutores;
	}
	
	public TutorEmpresarial consultar(String cedula){
		
		return tutorEmpresarialDAO.findOne(cedula);	
	}
	public TutorEmpresarial buscarTutorEmpresarial(String cedula){
		return tutorEmpresarialDAO.findOne(cedula);
	}
	
	public List<TutorEmpresarial> buscarCualquierCampoContiene(String parte) {
		return tutorEmpresarialDAO.findByCedulaStartingWithOrNombre1StartingWithOrApellido1StartingWithOrCorreoStartingWithOrTelefono1StartingWith(parte, parte, parte, parte, parte);
	}
}
