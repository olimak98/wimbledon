package co.edu.usbcali.wimbledon.modelo.control;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.JugadorEquipo;
import co.edu.usbcali.wimbledon.modelo.dto.JugadorEquipoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IJugadorEquipoLogic {
    public List<JugadorEquipo> getJugadorEquipo() throws Exception;

    /**
         * Save an new JugadorEquipo entity
         */
    public void saveJugadorEquipo(JugadorEquipo entity)
        throws Exception;

    /**
         * Delete an existing JugadorEquipo entity
         *
         */
    public void deleteJugadorEquipo(JugadorEquipo entity)
        throws Exception;

    /**
        * Update an existing JugadorEquipo entity
        *
        */
    public void updateJugadorEquipo(JugadorEquipo entity)
        throws Exception;

    /**
         * Load an existing JugadorEquipo entity
         *
         */
    public JugadorEquipo getJugadorEquipo(Integer jugadorEquipoId)
        throws Exception;

    public List<JugadorEquipo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<JugadorEquipo> findPageJugadorEquipo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberJugadorEquipo() throws Exception;

    public List<JugadorEquipoDTO> getDataJugadorEquipo()
        throws Exception;

    public void validateJugadorEquipo(JugadorEquipo jugadorEquipo)
        throws Exception;
}
