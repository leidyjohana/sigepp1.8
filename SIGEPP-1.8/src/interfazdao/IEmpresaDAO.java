package interfazdao;

import java.util.List;

import modelo.Empresa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IEmpresaDAO  extends JpaRepository<Empresa, String> {

	@Query("Select e from Empresa e where e.estadoEliminacion='true'")
	public List<Empresa> buscarEmpresasActivas();

	public Empresa findByNombre(String nombre);
	
	public List<Empresa> findByRifStartingWithOrNombreStartingWithOrDireccion1StartingWithOrTelefono1StartingWithOrCorreoElectronico1StartingWith(String parte1, String parte2, String parte3, String parte4, String parte5);
}

