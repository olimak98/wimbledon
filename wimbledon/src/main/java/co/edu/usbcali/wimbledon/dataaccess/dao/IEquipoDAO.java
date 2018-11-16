package co.edu.usbcali.wimbledon.dataaccess.dao;

import co.edu.usbcali.wimbledon.dataaccess.api.Dao;
import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.dto.EquipoDTO;


/**
* Interface for   EquipoDAO.
*
*/
public interface IEquipoDAO extends Dao<Equipo, Integer> {
	
	public EquipoDTO buscar(String nombreEquipo) throws Exception;
}
