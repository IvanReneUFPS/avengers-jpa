package co.jampidev.avengers.DAO;

import co.jampidev.avengers.model.Clasificacion;
import co.jampidev.avengers.util.Conexion;

public class ClasificacionDao extends Conexion<Clasificacion> implements GenericDao<Clasificacion> {

	public ClasificacionDao() {
		super(Clasificacion.class);
	}

}
