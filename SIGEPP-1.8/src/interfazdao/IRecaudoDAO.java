package interfazdao;

import java.util.List;


import modelo.Recaudo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IRecaudoDAO  extends JpaRepository<Recaudo, Long> {

	@Query("Select r from Recaudo r where r.estadoEliminacion='true'")
	public List<Recaudo> buscarRecaudosActivos();

	public Recaudo findByDescripcion(String descripcion);

}

