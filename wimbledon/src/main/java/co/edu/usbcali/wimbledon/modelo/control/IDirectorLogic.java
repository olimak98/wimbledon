package co.edu.usbcali.wimbledon.modelo.control;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Director;
import co.edu.usbcali.wimbledon.modelo.dto.DirectorDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IDirectorLogic {
    public List<Director> getDirector() throws Exception;

    /**
         * Save an new Director entity
         */
    public void saveDirector(Director entity) throws Exception;

    /**
         * Delete an existing Director entity
         *
         */
    public void deleteDirector(Director entity) throws Exception;

    /**
        * Update an existing Director entity
        *
        */
    public void updateDirector(Director entity) throws Exception;

    /**
         * Load an existing Director entity
         *
         */
    public Director getDirector(Integer directorId) throws Exception;

    public List<Director> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Director> findPageDirector(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberDirector() throws Exception;

    public List<DirectorDTO> getDataDirector() throws Exception;

    public void validateDirector(Director director) throws Exception;
}
