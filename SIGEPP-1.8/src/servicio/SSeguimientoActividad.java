package servicio;

import interfazdao.ISeguimientoActividadDAO;

import java.util.List;

import modelo.SeguimientoActividad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SSeguimientoActividad {

	@Autowired
	private ISeguimientoActividadDAO seguimientoActividadDAO;


	public void guardar(SeguimientoActividad actividad){
		seguimientoActividadDAO.save(actividad);
	}


	public List<SeguimientoActividad> buscarSeguimientoActividadActivos() {
		// TODO Auto-generated method stub
		List<SeguimientoActividad> actividad;
		actividad = seguimientoActividadDAO.buscarSeguimientoActividadActivos();
		return actividad;
	}
	
		
	public SeguimientoActividad buscarSeguimientoActividad(long id) {
		// TODO Auto-generated method stub
		return seguimientoActividadDAO.findOne(id);
	}
	
	public List<SeguimientoActividad> buscarCualquierCampoContiene(String parte) {
		return seguimientoActividadDAO.findByDescripcionStartingWithOrFactorStartingWith(parte, parte);
	}
}
