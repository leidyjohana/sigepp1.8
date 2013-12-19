package interfazdao;

import java.util.List;

import modelo.AreaAcademica;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAreaAcademicaDAO  extends JpaRepository<AreaAcademica, Long> {

	@Query("select a from AreaAcademica a where a.estadoEliminacion='true'")
	public List<AreaAcademica> buscarAreasActivas();

	public AreaAcademica findByNombre(String nombre);
	
	public List<AreaAcademica> findByNombreStartingWithOrDescripcionStartingWith(String parte1, String parte2);
}
