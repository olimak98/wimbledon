package co.edu.usbcali.wimbledon.dataaccess.dao;

import java.util.List;

import co.edu.usbcali.wimbledon.dataaccess.api.Dao;
import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.modelo.dto.TorneoDTO;


/**
* Interface for   TorneoDAO.
*
*/
public interface ITorneoDAO extends Dao<Torneo, Integer> {
	
	public List<TorneoDTO> listarActivos() throws Exception;
}
