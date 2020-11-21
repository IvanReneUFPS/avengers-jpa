package co.jampidev.avengers.DAO;

import co.jampidev.avengers.model.Heroe;
import co.jampidev.avengers.util.Conexion;

public class HeroeDao extends Conexion<Heroe> implements GenericDao<Heroe> {

	public HeroeDao() {
		super(Heroe.class);
	}

}
