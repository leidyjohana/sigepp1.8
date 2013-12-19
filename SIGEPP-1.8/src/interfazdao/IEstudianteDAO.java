package interfazdao;

import java.util.List;

import modelo.Estudiante;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEstudianteDAO  extends JpaRepository<Estudiante, String> {

	@Query("Select e from Estudiante e where e.estadoEliminacion='true'")
	public List<Estudiante> buscarEstudiantesActivos();

	public List<Estudiante> findByCedulaStartingWithOrNombre1StartingWithOrApellido1StartingWithOrSexoStartingWith(
			String parte1, String parte2, String parte3, String parte4);
}
