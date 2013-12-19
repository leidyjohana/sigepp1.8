package interfazdao;

import java.util.List;

import modelo.PasantiaTipo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPasantiaTipoDAO  extends JpaRepository<PasantiaTipo, String> {
	
	@Query("select pt from PasantiaTipo pt where pt.estadoEliminacion='true'")
	public List<PasantiaTipo> buscarTipoPasantiasActivos();

	public PasantiaTipo findByDescripcion(String nombre);

	@Query("select pt from PasantiaTipo pt where pt.id=?1")
	public PasantiaTipo findOne(long id);
	
	public List<PasantiaTipo> findByDescripcionStartingWithOrObservacionStartingWith(String parte1, String parte2);

//    @Query("update  Programa set estadoEliminacion='false' where programa_id=?1")
//	public void EliminarPrograma(long id);

    }
