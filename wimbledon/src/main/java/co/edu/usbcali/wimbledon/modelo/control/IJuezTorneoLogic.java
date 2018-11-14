package co.edu.usbcali.wimbledon.modelo.control;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.JuezTorneo;
import co.edu.usbcali.wimbledon.modelo.dto.JuezTorneoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IJuezTorneoLogic {
    public List<JuezTorneo> getJuezTorneo() throws Exception;

    /**
         * Save an new JuezTorneo entity
         */
    public void saveJuezTorneo(JuezTorneo entity) throws Exception;

    /**
         * Delete an existing JuezTorneo entity
         *
         */
    public void deleteJuezTorneo(JuezTorneo entity) throws Exception;

    /**
        * Update an existing JuezTorneo entity
        *
        */
    public void updateJuezTorneo(JuezTorneo entity) throws Exception;

    /**
         * Load an existing JuezTorneo entity
         *
         */
    public JuezTorneo getJuezTorneo(Integer juezTorneoId)
        throws Exception;

    public List<JuezTorneo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<JuezTorneo> findPageJuezTorneo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberJuezTorneo() throws Exception;

    public List<JuezTorneoDTO> getDataJuezTorneo() throws Exception;

    public void validateJuezTorneo(JuezTorneo juezTorneo)
        throws Exception;
}
