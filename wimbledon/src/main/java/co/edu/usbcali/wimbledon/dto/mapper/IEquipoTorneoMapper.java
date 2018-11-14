package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.EquipoTorneo;
import co.edu.usbcali.wimbledon.modelo.dto.EquipoTorneoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IEquipoTorneoMapper {
    public EquipoTorneoDTO equipoTorneoToEquipoTorneoDTO(
        EquipoTorneo equipoTorneo) throws Exception;

    public EquipoTorneo equipoTorneoDTOToEquipoTorneo(
        EquipoTorneoDTO equipoTorneoDTO) throws Exception;

    public List<EquipoTorneoDTO> listEquipoTorneoToListEquipoTorneoDTO(
        List<EquipoTorneo> equipoTorneos) throws Exception;

    public List<EquipoTorneo> listEquipoTorneoDTOToListEquipoTorneo(
        List<EquipoTorneoDTO> equipoTorneoDTOs) throws Exception;
}
