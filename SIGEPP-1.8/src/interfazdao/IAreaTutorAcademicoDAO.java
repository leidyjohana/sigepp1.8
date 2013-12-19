
package interfazdao;

import java.util.List;

import modelo.AreaConocimiento;
import modelo.AreaTutorAcademico;
import modelo.TutorAcademico;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IAreaTutorAcademicoDAO  extends JpaRepository<AreaTutorAcademico, String> {

		@Query("Select a from AreaTutorAcademico a")
		public List<AreaTutorAcademico> buscarAreasTutoresActivos();

		@Query("select acta from AreaTutorAcademico acta where acta.tutorAcademico =?1)")
     	public List<AreaTutorAcademico> buscarAreasSegunTutor(TutorAcademico tutorAcademico);



	}
