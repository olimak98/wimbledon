package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.JugadorEquipo;
import co.edu.usbcali.wimbledon.modelo.dto.JugadorEquipoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IJugadorEquipoMapper {
    public JugadorEquipoDTO jugadorEquipoToJugadorEquipoDTO(
        JugadorEquipo jugadorEquipo) throws Exception;

    public JugadorEquipo jugadorEquipoDTOToJugadorEquipo(
        JugadorEquipoDTO jugadorEquipoDTO) throws Exception;

    public List<JugadorEquipoDTO> listJugadorEquipoToListJugadorEquipoDTO(
        List<JugadorEquipo> jugadorEquipos) throws Exception;

    public List<JugadorEquipo> listJugadorEquipoDTOToListJugadorEquipo(
        List<JugadorEquipoDTO> jugadorEquipoDTOs) throws Exception;
}
