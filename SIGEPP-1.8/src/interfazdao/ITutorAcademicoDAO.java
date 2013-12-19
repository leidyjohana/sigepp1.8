package interfazdao;

import java.util.List;

import modelo.TutorAcademico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITutorAcademicoDAO extends
		JpaRepository<TutorAcademico, String> {

	@Query("Select t from TutorAcademico t where t.estadoEliminacion='true'")
	public List<TutorAcademico> buscarTutoresActivos();

	public List<TutorAcademico> findByCedulaStartingWithOrNombre1StartingWithOrApellido1StartingWithOrSexoStartingWith(
			String parte1, String parte2, String parte3, String parte4);

}
