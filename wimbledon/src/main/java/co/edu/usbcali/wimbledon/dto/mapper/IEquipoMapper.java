package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.dto.EquipoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IEquipoMapper {
    public EquipoDTO equipoToEquipoDTO(Equipo equipo) throws Exception;

    public Equipo equipoDTOToEquipo(EquipoDTO equipoDTO)
        throws Exception;

    public List<EquipoDTO> listEquipoToListEquipoDTO(List<Equipo> equipos)
        throws Exception;

    public List<Equipo> listEquipoDTOToListEquipo(List<EquipoDTO> equipoDTOs)
        throws Exception;
}
