package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.JuezTorneo;
import co.edu.usbcali.wimbledon.modelo.dto.JuezTorneoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IJuezTorneoMapper {
    public JuezTorneoDTO juezTorneoToJuezTorneoDTO(JuezTorneo juezTorneo)
        throws Exception;

    public JuezTorneo juezTorneoDTOToJuezTorneo(JuezTorneoDTO juezTorneoDTO)
        throws Exception;

    public List<JuezTorneoDTO> listJuezTorneoToListJuezTorneoDTO(
        List<JuezTorneo> juezTorneos) throws Exception;

    public List<JuezTorneo> listJuezTorneoDTOToListJuezTorneo(
        List<JuezTorneoDTO> juezTorneoDTOs) throws Exception;
}
