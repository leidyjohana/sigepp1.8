package servicio;

import interfazdao.ILapsoActividadDAO;

import java.util.List;

import modelo.LapsoActividad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SLapsoActividad {

	@Autowired
	private ILapsoActividadDAO actividadlapsoDAO;

	public void guardar(LapsoActividad actividadLapso) {
		actividadlapsoDAO.save(actividadLapso);
	}

	public LapsoActividad buscarLapsoActividad(long id) {
		return actividadlapsoDAO.findOne(id);
	}

	public List<LapsoActividad> buscarActividadesLapsoActivas() {
		List<LapsoActividad> actividadLapso;
		actividadLapso = actividadlapsoDAO.buscarActividadesLapsosActivas();
		return actividadLapso;
	}

	public LapsoActividad buscarPorNombreActividadLapso(String nombre) {
		LapsoActividad actividadLapso;
		actividadLapso = actividadlapsoDAO.findByNombre(nombre);
		return actividadLapso;
	}

	public List<LapsoActividad> buscarCualquierCampoContiene(String parte) {
		return actividadlapsoDAO.findByNombreStartingWith(parte);
	}
}
