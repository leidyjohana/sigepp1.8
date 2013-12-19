package interfazdao;

import java.util.List;

import modelo.Departamento;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IDepartamentoDAO  extends JpaRepository<Departamento, String> {
	
	@Query("select d from Departamento d where d.estadoEliminacion='true'")
	public List<Departamento> buscarDepartamenosActivos();

	public Departamento findByNombre(String nombre);

	public List<Departamento> findByNombreStartingWithOrDescripcionStartingWith(String parte1, String parte2);
    
	@Query("select d from Departamento d where d.id=?1")
	public Departamento findOne(long id);
	
//    @Query("update  Programa set estadoEliminacion='false' where programa_id=?1")
//	public void EliminarPrograma(long id);

    }
