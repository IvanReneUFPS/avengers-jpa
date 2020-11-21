package co.jampidev.avengers.DAO;

import co.jampidev.avengers.model.Estado;
import co.jampidev.avengers.util.Conexion;

public class EstadoDao extends Conexion<Estado> implements GenericDao<Estado> {

	public EstadoDao() {
		super(Estado.class);
	}

}