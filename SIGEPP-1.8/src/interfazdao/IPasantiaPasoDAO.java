package interfazdao;

import java.util.List;

import modelo.PasantiaPaso;
import modelo.Departamento;
import modelo.Estudiante;
import modelo.Programa;
import modelo.Recaudo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IPasantiaPasoDAO  extends JpaRepository<PasantiaPaso, Long> {
	
	@Query("select d from PasantiaPaso d where d.estadoEliminacion='true'")
	public List<PasantiaPaso> buscarPasantiaPasosActivos();

	public PasantiaPaso findByDescripcion(String descripcion);
	
    }
