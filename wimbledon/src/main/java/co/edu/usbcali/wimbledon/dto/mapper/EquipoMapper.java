package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.dto.EquipoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class EquipoMapper implements IEquipoMapper {
    private static final Logger log = LoggerFactory.getLogger(EquipoMapper.class);

    @Transactional(readOnly = true)
    public EquipoDTO equipoToEquipoDTO(Equipo equipo) throws Exception {
        try {
            EquipoDTO equipoDTO = new EquipoDTO();

            equipoDTO.setEquipoId(equipo.getEquipoId());
            equipoDTO.setEstado((equipo.getEstado() != null)
                ? equipo.getEstado() : null);
            equipoDTO.setNombre((equipo.getNombre() != null)
                ? equipo.getNombre() : null);

            return equipoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Equipo equipoDTOToEquipo(EquipoDTO equipoDTO)
        throws Exception {
        try {
            Equipo equipo = new Equipo();

            equipo.setEquipoId(equipoDTO.getEquipoId());
            equipo.setEstado((equipoDTO.getEstado() != null)
                ? equipoDTO.getEstado() : null);
            equipo.setNombre((equipoDTO.getNombre() != null)
                ? equipoDTO.getNombre() : null);

            return equipo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<EquipoDTO> listEquipoToListEquipoDTO(List<Equipo> listEquipo)
        throws Exception {
        try {
            List<EquipoDTO> equipoDTOs = new ArrayList<EquipoDTO>();

            for (Equipo equipo : listEquipo) {
                EquipoDTO equipoDTO = equipoToEquipoDTO(equipo);

                equipoDTOs.add(equipoDTO);
            }

            return equipoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Equipo> listEquipoDTOToListEquipo(List<EquipoDTO> listEquipoDTO)
        throws Exception {
        try {
            List<Equipo> listEquipo = new ArrayList<Equipo>();

            for (EquipoDTO equipoDTO : listEquipoDTO) {
                Equipo equipo = equipoDTOToEquipo(equipoDTO);

                listEquipo.add(equipo);
            }

            return listEquipo;
        } catch (Exception e) {
            throw e;
        }
    }
}
