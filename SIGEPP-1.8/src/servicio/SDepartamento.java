package servicio;

import interfazdao.IDepartamentoDAO;

import java.util.List;

import modelo.Departamento;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SDepartamento {

	@Autowired
	private IDepartamentoDAO departamentoDAO;

	public void guardar(Departamento departamento) {
		departamentoDAO.save(departamento);
	}

	public List<Departamento> buscarDepartamentosActivos() {
		List<Departamento> departamentos;
		departamentos = departamentoDAO.buscarDepartamenosActivos();
		return departamentos;
	}

	public Departamento buscarPorNombreDepartamento(String nombre) {
		Departamento departamento;
		departamento = departamentoDAO.findByNombre(nombre);
		return departamento;
	}

	public Departamento buscarDepartamento(long id) {
		return departamentoDAO.findOne(id);
	}

	public List<Departamento> buscarCualquierCampoContiene(String parte) {
		return departamentoDAO.findByNombreStartingWithOrDescripcionStartingWith(parte,
				parte);
	}
	// public void ProgramaFalse(long id){
	// programaDAO.EliminarPrograma(id);
	//
	// }
}
