package interfazdao;

import java.util.List;

import modelo.LapsoActividad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ILapsoActividadDAO extends JpaRepository<LapsoActividad, String> {

	@Query("select al from LapsoActividad al where al.estadoEliminacion='true'")
	public List<LapsoActividad> buscarActividadesLapsosActivas();
	
	@Query("select p from LapsoActividad p where p.id=?1")
	public LapsoActividad findOne(long id);
	
	public LapsoActividad findByNombre(String nombre);
	
	public List<LapsoActividad> findByNombreStartingWith(String parte1);
}
