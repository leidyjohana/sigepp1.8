package servicio;

import java.util.List;


import interfazdao.IProgramaDAO;

import modelo.Programa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SPrograma {
	
	@Autowired
	private IProgramaDAO programaDAO;

	public void guardar(Programa programa){
		programaDAO.save(programa);
	}
	public List<Programa> buscarProgramasActivos(){
		List<Programa> programas;
		programas = programaDAO.buscarProgramasActivos();
		return programas;
	}
	public Programa buscarPorNombrePrograma(String nombre){
		Programa programa;
		programa = programaDAO.findByNombre(nombre);
		return programa;	
	}
	public Programa buscarPrograma(long id){
		return programaDAO.findOne(id);
	}
	public long buscarUltimoId()
	{
	long id=programaDAO.buscarUltimoId();
		return id;
	}
	public List<Programa> buscarCualquierCampoContiene(String parte){
		return programaDAO.findByNombreStartingWithOrDescripcionStartingWithOrTelefonoStartingWith(parte, parte, parte);
	}
}
