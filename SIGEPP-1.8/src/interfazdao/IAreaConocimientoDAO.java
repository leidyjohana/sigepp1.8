package interfazdao;

import java.util.List;


import modelo.AreaConocimiento;
import modelo.Departamento;
import modelo.TutorAcademico;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAreaConocimientoDAO  extends JpaRepository<AreaConocimiento, Long> {

	@Query("select ac from AreaConocimiento ac where ac.estadoEliminacion='true'")
	public List<AreaConocimiento> buscarAreasActivas();
	
	public AreaConocimiento findByNombre(String nombre);
	
	public List<AreaConocimiento> findByNombreContainingOrDescripcionContaining(String parte1, String parte2);

	@Query("select ac from AreaConocimiento ac where ac.id not in (select acta.areaConocimiento from AreaTutorAcademico acta where acta.tutorAcademico =?1)")
	public List<AreaConocimiento> buscarAreasDisponiblesParaTutor(TutorAcademico tutorAcademico);
}
