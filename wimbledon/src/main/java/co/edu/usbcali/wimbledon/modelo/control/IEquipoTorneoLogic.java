package co.edu.usbcali.wimbledon.modelo.control;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.EquipoTorneo;
import co.edu.usbcali.wimbledon.modelo.dto.EquipoTorneoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IEquipoTorneoLogic {
    public List<EquipoTorneo> getEquipoTorneo() throws Exception;

    /**
         * Save an new EquipoTorneo entity
         */
    public void saveEquipoTorneo(EquipoTorneo entity) throws Exception;

    /**
         * Delete an existing EquipoTorneo entity
         *
         */
    public void deleteEquipoTorneo(EquipoTorneo entity)
        throws Exception;

    /**
        * Update an existing EquipoTorneo entity
        *
        */
    public void updateEquipoTorneo(EquipoTorneo entity)
        throws Exception;

    /**
         * Load an existing EquipoTorneo entity
         *
         */
    public EquipoTorneo getEquipoTorneo(Integer equipoTorneoId)
        throws Exception;

    public List<EquipoTorneo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<EquipoTorneo> findPageEquipoTorneo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEquipoTorneo() throws Exception;

    public List<EquipoTorneoDTO> getDataEquipoTorneo()
        throws Exception;

    public void validateEquipoTorneo(EquipoTorneo equipoTorneo)
        throws Exception;
}
