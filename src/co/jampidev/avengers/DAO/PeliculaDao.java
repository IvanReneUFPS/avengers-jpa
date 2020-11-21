package co.jampidev.avengers.DAO;

import co.jampidev.avengers.model.Pelicula;
import co.jampidev.avengers.util.Conexion;

public class PeliculaDao extends Conexion<Pelicula> implements GenericDao<Pelicula> {

	public PeliculaDao() {
		super(Pelicula.class);
	}

}
