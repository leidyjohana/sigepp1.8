package servicio;

import interfazdao.IPlantillaDocumentoDAO;

import java.util.List;

import modelo.PlantillaDocumento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SPlantillaDocumento  {

	@Autowired
	private IPlantillaDocumentoDAO plantillaDocumentoDAO;

	public void guardar(PlantillaDocumento plantillaDocumento){
		plantillaDocumentoDAO.save(plantillaDocumento);
	}
	public List<PlantillaDocumento> buscarPlantillasActivas()
	{
		List<PlantillaDocumento> plantillasDocumento;
		plantillasDocumento = plantillaDocumentoDAO.buscarPlantillasActivas();
		return plantillasDocumento;
	}
	public PlantillaDocumento buscarPorDescripcionPlantilla(String descripcion){
		PlantillaDocumento plantillaDocumento;
		plantillaDocumento = plantillaDocumentoDAO.findByDescripcion(descripcion);
		return plantillaDocumento;	
	}
	
	public PlantillaDocumento consultar(long id){
		return plantillaDocumentoDAO.findOne(id);	
	}
	
	public PlantillaDocumento buscarPlantillaDocumento(long id){
		return plantillaDocumentoDAO.findOne(id);
	}

}

