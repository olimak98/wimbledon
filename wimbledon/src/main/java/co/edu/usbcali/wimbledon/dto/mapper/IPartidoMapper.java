package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Partido;
import co.edu.usbcali.wimbledon.modelo.dto.PartidoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IPartidoMapper {
    public PartidoDTO partidoToPartidoDTO(Partido partido)
        throws Exception;

    public Partido partidoDTOToPartido(PartidoDTO partidoDTO)
        throws Exception;

    public List<PartidoDTO> listPartidoToListPartidoDTO(List<Partido> partidos)
        throws Exception;

    public List<Partido> listPartidoDTOToListPartido(
        List<PartidoDTO> partidoDTOs) throws Exception;
}
