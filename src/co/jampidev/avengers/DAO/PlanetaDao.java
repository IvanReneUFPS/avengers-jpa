package co.jampidev.avengers.DAO;

import co.jampidev.avengers.model.Planeta;
import co.jampidev.avengers.util.Conexion;

public class PlanetaDao extends Conexion<Planeta> implements GenericDao<Planeta> {

	public PlanetaDao() {
		super(Planeta.class);
	}

}
