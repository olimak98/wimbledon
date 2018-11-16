package co.edu.usbcali.wimbledon.dataaccess.dao;

import java.util.Date;
import java.util.List;

import co.edu.usbcali.wimbledon.dataaccess.api.Dao;
import co.edu.usbcali.wimbledon.modelo.Cancha;


/**
* Interface for   CanchaDAO.
*
*/
public interface ICanchaDAO extends Dao<Cancha, Integer> {
	
	public List<Cancha> buscarDisponibles() throws Exception;

}
