package co.edu.usbcali.wimbledon.modelo.control;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.modelo.dto.TorneoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ITorneoLogic {
    public List<Torneo> getTorneo() throws Exception;

    /**
         * Save an new Torneo entity
         */
    public void saveTorneo(Torneo entity) throws Exception;

    /**
         * Delete an existing Torneo entity
         *
         */
    public void deleteTorneo(Torneo entity) throws Exception;

    /**
        * Update an existing Torneo entity
        *
        */
    public void updateTorneo(Torneo entity) throws Exception;

    /**
         * Load an existing Torneo entity
         *
         */
    public Torneo getTorneo(Integer torneoId) throws Exception;

    public List<Torneo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Torneo> findPageTorneo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTorneo() throws Exception;

    public List<TorneoDTO> getDataTorneo() throws Exception;

    public void validateTorneo(Torneo torneo) throws Exception;
}
