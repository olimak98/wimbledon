package co.edu.usbcali.wimbledon.modelo.control;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Jugador;
import co.edu.usbcali.wimbledon.modelo.dto.JugadorDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IJugadorLogic {
    public List<Jugador> getJugador() throws Exception;

    /**
         * Save an new Jugador entity
         */
    public void saveJugador(Jugador entity) throws Exception;

    /**
         * Delete an existing Jugador entity
         *
         */
    public void deleteJugador(Jugador entity) throws Exception;

    /**
        * Update an existing Jugador entity
        *
        */
    public void updateJugador(Jugador entity) throws Exception;

    /**
         * Load an existing Jugador entity
         *
         */
    public Jugador getJugador(Integer jugadorId) throws Exception;

    public List<Jugador> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Jugador> findPageJugador(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberJugador() throws Exception;

    public List<JugadorDTO> getDataJugador() throws Exception;

    public void validateJugador(Jugador jugador) throws Exception;
}
