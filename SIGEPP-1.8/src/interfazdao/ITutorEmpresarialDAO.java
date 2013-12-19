package interfazdao;

import java.util.List;

import modelo.TutorEmpresarial;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ITutorEmpresarialDAO  extends JpaRepository<TutorEmpresarial, String> {

	@Query("Select t from TutorEmpresarial t where t.estadoEliminacion='true'")
	public List<TutorEmpresarial> buscarTutoresActivos();
	
	public List<TutorEmpresarial> findByCedulaStartingWithOrNombre1StartingWithOrApellido1StartingWithOrCorreoStartingWithOrTelefono1StartingWith(String parte1, String parte2, String parte3, String parte4, String parte5);
}