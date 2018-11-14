package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.modelo.dto.TorneoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ITorneoMapper {
    public TorneoDTO torneoToTorneoDTO(Torneo torneo) throws Exception;

    public Torneo torneoDTOToTorneo(TorneoDTO torneoDTO)
        throws Exception;

    public List<TorneoDTO> listTorneoToListTorneoDTO(List<Torneo> torneos)
        throws Exception;

    public List<Torneo> listTorneoDTOToListTorneo(List<TorneoDTO> torneoDTOs)
        throws Exception;
}
