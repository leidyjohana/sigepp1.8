package servicio;

import java.util.List;

import interfazdao.IPasantiaPasoDAO;
import interfazdao.IDepartamentoDAO;
import interfazdao.IProgramaDAO;

import modelo.PasantiaPaso;
import modelo.Departamento;
import modelo.Programa;
import modelo.Recaudo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SPasantiaPaso {
	
	@Autowired
	private IPasantiaPasoDAO pasantiaPasoDAO;

	public void guardar(PasantiaPaso pasantiaPaso){
		pasantiaPasoDAO.save(pasantiaPaso);
	}
	public List<PasantiaPaso> buscarPasantiaPasosActivos(){
		List<PasantiaPaso> pasantiaPasos;
		pasantiaPasos = pasantiaPasoDAO.buscarPasantiaPasosActivos();
		return pasantiaPasos;
	}
	
	
	public PasantiaPaso  buscarPorDescripcionPasantiaPaso(String descripcion){
		PasantiaPaso pasantiaPaso;
		pasantiaPaso = pasantiaPasoDAO.findByDescripcion(descripcion);
		return pasantiaPaso;
	}
	
	public PasantiaPaso buscarPasantiaPaso(long id){
		return pasantiaPasoDAO.findOne(id);
	}
}
