package co.edu.usbcali.wimbledon.modelo.control;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Set;
import co.edu.usbcali.wimbledon.modelo.dto.SetDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ISetLogic {
    public List<Set> getSet() throws Exception;

    /**
         * Save an new Set entity
         */
    public void saveSet(Set entity) throws Exception;

    /**
         * Delete an existing Set entity
         *
         */
    public void deleteSet(Set entity) throws Exception;

    /**
        * Update an existing Set entity
        *
        */
    public void updateSet(Set entity) throws Exception;

    /**
         * Load an existing Set entity
         *
         */
    public Set getSet(Integer setId) throws Exception;

    public List<Set> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Set> findPageSet(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception;

    public Long findTotalNumberSet() throws Exception;

    public List<SetDTO> getDataSet() throws Exception;

    public void validateSet(Set set) throws Exception;
}
