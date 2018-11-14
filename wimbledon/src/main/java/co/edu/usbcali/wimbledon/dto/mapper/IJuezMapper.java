package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Juez;
import co.edu.usbcali.wimbledon.modelo.dto.JuezDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IJuezMapper {
    public JuezDTO juezToJuezDTO(Juez juez) throws Exception;

    public Juez juezDTOToJuez(JuezDTO juezDTO) throws Exception;

    public List<JuezDTO> listJuezToListJuezDTO(List<Juez> juezs)
        throws Exception;

    public List<Juez> listJuezDTOToListJuez(List<JuezDTO> juezDTOs)
        throws Exception;
}
