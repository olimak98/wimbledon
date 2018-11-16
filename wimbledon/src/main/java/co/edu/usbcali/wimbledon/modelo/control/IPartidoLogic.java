package co.edu.usbcali.wimbledon.modelo.control;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.Partido;
import co.edu.usbcali.wimbledon.modelo.Set;
import co.edu.usbcali.wimbledon.modelo.dto.EquipoDTO;
import co.edu.usbcali.wimbledon.modelo.dto.PartidoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IPartidoLogic {
    public List<Partido> getPartido() throws Exception;

    /**
         * Save an new Partido entity
         */
    public void savePartido(Partido entity) throws Exception;

    /**
         * Delete an existing Partido entity
         *
         */
    public void deletePartido(Partido entity) throws Exception;

    /**
        * Update an existing Partido entity
        *
        */
    public void updatePartido(Partido entity) throws Exception;

    /**
         * Load an existing Partido entity
         *
         */
    public Partido getPartido(Integer partidoId) throws Exception;

    public List<Partido> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Partido> findPagePartido(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPartido() throws Exception;

    public List<PartidoDTO> getDataPartido() throws Exception;

    public void validatePartido(Partido partido) throws Exception;

	public List<EquipoDTO> darPunto(EquipoDTO equipoGanador, EquipoDTO equipoPerdedor, Partido partido) throws Exception;
	
	public List<Partido> listarPendientes() throws Exception;
}
