package servicio;

import java.util.List;

import interfazdao.IRecaudoDAO;

import modelo.Recaudo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SRecaudo  {

	@Autowired
	private IRecaudoDAO recaudoDAO;

	public void guardar(Recaudo recaudo){
		recaudoDAO.save(recaudo);
	}
	public List<Recaudo> buscarRecadudosActivos()
	{
		List<Recaudo> recaudos;
		recaudos = recaudoDAO.buscarRecaudosActivos();
		return recaudos;
	}
	public Recaudo buscarPorDescripcionRecaudo(String descripcion){
		Recaudo recaudo;
		recaudo = recaudoDAO.findByDescripcion(descripcion);
		return recaudo;	
	}
	
	public Recaudo consultar(long id){
		return recaudoDAO.findOne(id);	
	}
	
	public Recaudo buscarRecaudo(long id){
		return recaudoDAO.findOne(id);
	}

}

