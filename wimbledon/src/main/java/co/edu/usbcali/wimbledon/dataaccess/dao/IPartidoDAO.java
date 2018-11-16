package co.edu.usbcali.wimbledon.dataaccess.dao;

import java.util.List;

import co.edu.usbcali.wimbledon.dataaccess.api.Dao;
import co.edu.usbcali.wimbledon.modelo.Partido;


/**
* Interface for   PartidoDAO.
*
*/
public interface IPartidoDAO extends Dao<Partido, Integer> {
	
	public List<Partido> listarPendientes() throws Exception;

}
