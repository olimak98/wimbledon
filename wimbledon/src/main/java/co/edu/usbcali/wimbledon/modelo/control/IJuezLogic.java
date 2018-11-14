package co.edu.usbcali.wimbledon.modelo.control;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Juez;
import co.edu.usbcali.wimbledon.modelo.dto.JuezDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IJuezLogic {
    public List<Juez> getJuez() throws Exception;

    /**
         * Save an new Juez entity
         */
    public void saveJuez(Juez entity) throws Exception;

    /**
         * Delete an existing Juez entity
         *
         */
    public void deleteJuez(Juez entity) throws Exception;

    /**
        * Update an existing Juez entity
        *
        */
    public void updateJuez(Juez entity) throws Exception;

    /**
         * Load an existing Juez entity
         *
         */
    public Juez getJuez(Integer juezId) throws Exception;

    public List<Juez> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Juez> findPageJuez(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberJuez() throws Exception;

    public List<JuezDTO> getDataJuez() throws Exception;

    public void validateJuez(Juez juez) throws Exception;
}
