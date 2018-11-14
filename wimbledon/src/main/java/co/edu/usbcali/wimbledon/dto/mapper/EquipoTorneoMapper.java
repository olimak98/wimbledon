package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.EquipoTorneo;
import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.modelo.control.IEquipoLogic;
import co.edu.usbcali.wimbledon.modelo.control.ITorneoLogic;
import co.edu.usbcali.wimbledon.modelo.dto.EquipoTorneoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class EquipoTorneoMapper implements IEquipoTorneoMapper {
    private static final Logger log = LoggerFactory.getLogger(EquipoTorneoMapper.class);

    /**
    * Logic injected by Spring that manages Equipo entities
    *
    */
    @Autowired
    IEquipoLogic logicEquipo1;

    /**
    * Logic injected by Spring that manages Torneo entities
    *
    */
    @Autowired
    ITorneoLogic logicTorneo2;

    @Transactional(readOnly = true)
    public EquipoTorneoDTO equipoTorneoToEquipoTorneoDTO(
        EquipoTorneo equipoTorneo) throws Exception {
        try {
            EquipoTorneoDTO equipoTorneoDTO = new EquipoTorneoDTO();

            equipoTorneoDTO.setEquipoTorneoId(equipoTorneo.getEquipoTorneoId());
            equipoTorneoDTO.setEquipoId_Equipo((equipoTorneo.getEquipo()
                                                            .getEquipoId() != null)
                ? equipoTorneo.getEquipo().getEquipoId() : null);
            equipoTorneoDTO.setTorneoId_Torneo((equipoTorneo.getTorneo()
                                                            .getTorneoId() != null)
                ? equipoTorneo.getTorneo().getTorneoId() : null);

            return equipoTorneoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public EquipoTorneo equipoTorneoDTOToEquipoTorneo(
        EquipoTorneoDTO equipoTorneoDTO) throws Exception {
        try {
            EquipoTorneo equipoTorneo = new EquipoTorneo();

            equipoTorneo.setEquipoTorneoId(equipoTorneoDTO.getEquipoTorneoId());

            Equipo equipo = new Equipo();

            if (equipoTorneoDTO.getEquipoId_Equipo() != null) {
                equipo = logicEquipo1.getEquipo(equipoTorneoDTO.getEquipoId_Equipo());
            }

            if (equipo != null) {
                equipoTorneo.setEquipo(equipo);
            }

            Torneo torneo = new Torneo();

            if (equipoTorneoDTO.getTorneoId_Torneo() != null) {
                torneo = logicTorneo2.getTorneo(equipoTorneoDTO.getTorneoId_Torneo());
            }

            if (torneo != null) {
                equipoTorneo.setTorneo(torneo);
            }

            return equipoTorneo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<EquipoTorneoDTO> listEquipoTorneoToListEquipoTorneoDTO(
        List<EquipoTorneo> listEquipoTorneo) throws Exception {
        try {
            List<EquipoTorneoDTO> equipoTorneoDTOs = new ArrayList<EquipoTorneoDTO>();

            for (EquipoTorneo equipoTorneo : listEquipoTorneo) {
                EquipoTorneoDTO equipoTorneoDTO = equipoTorneoToEquipoTorneoDTO(equipoTorneo);

                equipoTorneoDTOs.add(equipoTorneoDTO);
            }

            return equipoTorneoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<EquipoTorneo> listEquipoTorneoDTOToListEquipoTorneo(
        List<EquipoTorneoDTO> listEquipoTorneoDTO) throws Exception {
        try {
            List<EquipoTorneo> listEquipoTorneo = new ArrayList<EquipoTorneo>();

            for (EquipoTorneoDTO equipoTorneoDTO : listEquipoTorneoDTO) {
                EquipoTorneo equipoTorneo = equipoTorneoDTOToEquipoTorneo(equipoTorneoDTO);

                listEquipoTorneo.add(equipoTorneo);
            }

            return listEquipoTorneo;
        } catch (Exception e) {
            throw e;
        }
    }
}
