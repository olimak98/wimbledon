package co.edu.usbcali.wimbledon.modelo.control;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Cancha;
import co.edu.usbcali.wimbledon.modelo.ReservaCancha;
import co.edu.usbcali.wimbledon.modelo.dto.CanchaDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ICanchaLogic {
    public List<Cancha> getCancha() throws Exception;

    /**
         * Save an new Cancha entity
         */
    public void saveCancha(Cancha entity) throws Exception;

    /**
         * Delete an existing Cancha entity
         *
         */
    public void deleteCancha(Cancha entity) throws Exception;

    /**
        * Update an existing Cancha entity
        *
        */
    public void updateCancha(Cancha entity) throws Exception;

    /**
         * Load an existing Cancha entity
         *
         */
    public Cancha getCancha(Integer canchaId) throws Exception;

    public List<Cancha> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Cancha> findPageCancha(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCancha() throws Exception;

    public List<CanchaDTO> getDataCancha() throws Exception;

    public void validateCancha(Cancha cancha) throws Exception;
    
    public void asignarCancha(ReservaCancha reservaCancha)throws Exception;
    
    public List<Cancha> buscarDisponibles() throws Exception;
}
