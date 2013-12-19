
package interfazdao;

import java.util.List;

import modelo.AreaAcademica;
import modelo.SeguimientoActividad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ISeguimientoActividadDAO  extends JpaRepository<SeguimientoActividad, Long> {

	@Query("select s from SeguimientoActividad s where s.estadoEliminacion='true'")
	
	public List<SeguimientoActividad> buscarSeguimientoActividadActivos();
	
	public List<SeguimientoActividad> findByDescripcionStartingWithOrFactorStartingWith(String parte1, String parte2);
}

