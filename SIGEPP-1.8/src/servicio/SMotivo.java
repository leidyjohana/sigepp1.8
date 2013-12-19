package servicio;

import interfazdao.IMotivoDAO;

import java.util.List;

import modelo.Motivo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SMotivo {

	@Autowired
	private IMotivoDAO motivoDAO;


	public void guardar(Motivo motivo){
		motivoDAO.save(motivo);
	}
	
	public List<Motivo> buscarMotivosActivos(){
		List<Motivo> motivo;
		motivo = motivoDAO.buscarMotivosActivos();
		return motivo;
	}
	
	public Motivo buscarMotivo(long id){
		return motivoDAO.findOne(id);
	}
	
	public List<Motivo> buscarCualquierCampoContiene(String parte) {
		return motivoDAO.findByDescripcionStartingWith(parte);
	}
	
}
