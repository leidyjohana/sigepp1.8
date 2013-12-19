package interfazdao;
import java.util.List;

import modelo.Motivo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IMotivoDAO extends JpaRepository<Motivo, Long> {

	@Query("select m from Motivo m where m.estadoEliminacion='true'")
	public List<Motivo> buscarMotivosActivos();
	
	public List<Motivo> findByDescripcionStartingWith(String parte1);

}