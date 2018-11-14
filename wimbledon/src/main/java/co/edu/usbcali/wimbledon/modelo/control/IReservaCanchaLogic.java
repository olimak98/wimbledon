package co.edu.usbcali.wimbledon.modelo.control;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.ReservaCancha;
import co.edu.usbcali.wimbledon.modelo.dto.ReservaCanchaDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IReservaCanchaLogic {
    public List<ReservaCancha> getReservaCancha() throws Exception;

    /**
         * Save an new ReservaCancha entity
         */
    public void saveReservaCancha(ReservaCancha entity)
        throws Exception;

    /**
         * Delete an existing ReservaCancha entity
         *
         */
    public void deleteReservaCancha(ReservaCancha entity)
        throws Exception;

    /**
        * Update an existing ReservaCancha entity
        *
        */
    public void updateReservaCancha(ReservaCancha entity)
        throws Exception;

    /**
         * Load an existing ReservaCancha entity
         *
         */
    public ReservaCancha getReservaCancha(Integer reservaCanchaId)
        throws Exception;

    public List<ReservaCancha> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<ReservaCancha> findPageReservaCancha(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberReservaCancha() throws Exception;

    public List<ReservaCanchaDTO> getDataReservaCancha()
        throws Exception;

    public void validateReservaCancha(ReservaCancha reservaCancha)
        throws Exception;
}
