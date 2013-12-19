package servicio;

import interfazdao.IPasantiaTipoDAO;

import java.util.List;

import modelo.PasantiaTipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SPasantiaTipo {

	@Autowired
	private IPasantiaTipoDAO tipoPasantiaDAO;

	public void guardar(PasantiaTipo tipoPasantia) {
		tipoPasantiaDAO.save(tipoPasantia);

	}

	public List<PasantiaTipo> buscarTipoPasantiasActivos() {
		List<PasantiaTipo> tipoPasantias;
		tipoPasantias = tipoPasantiaDAO.buscarTipoPasantiasActivos();
		return tipoPasantias;
	}

	public PasantiaTipo buscarPorDescripcionTipoPasantia(String descripcion) {
		PasantiaTipo tipo;
		tipo = tipoPasantiaDAO.findByDescripcion(descripcion);
		return tipo;

	}

	public PasantiaTipo buscarTipoPasantia(long id) {
		return tipoPasantiaDAO.findOne(id);
	}

	public List<PasantiaTipo> buscarCualquierCampoContiene(String parte) {
		return tipoPasantiaDAO
				.findByDescripcionStartingWithOrObservacionStartingWith(parte,
						parte);
	}
	// public void ProgramaFalse(long id){
	// programaDAO.EliminarPrograma(id);
	//
	// }
}
