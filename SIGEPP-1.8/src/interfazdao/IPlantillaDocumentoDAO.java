package interfazdao;

import java.util.List;


import modelo.PlantillaDocumento;
import modelo.Recaudo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPlantillaDocumentoDAO  extends JpaRepository<PlantillaDocumento, Long> {

	@Query("Select p from PlantillaDocumento p ")
	public List<PlantillaDocumento> buscarPlantillasActivas();

	public PlantillaDocumento findByDescripcion(String descripcion);

}

