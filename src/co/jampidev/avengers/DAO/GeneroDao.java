package co.jampidev.avengers.DAO;

import co.jampidev.avengers.model.Genero;
import co.jampidev.avengers.util.Conexion;

public class GeneroDao extends Conexion<Genero> implements GenericDao<Genero> {

	public GeneroDao() {
		super(Genero.class);
	}

}