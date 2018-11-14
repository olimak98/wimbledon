package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wimbledon.modelo.Director;
import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.modelo.control.IDirectorLogic;
import co.edu.usbcali.wimbledon.modelo.dto.TorneoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class TorneoMapper implements ITorneoMapper {
    private static final Logger log = LoggerFactory.getLogger(TorneoMapper.class);

    /**
    * Logic injected by Spring that manages Director entities
    *
    */
    @Autowired
    IDirectorLogic logicDirector1;

    @Transactional(readOnly = true)
    public TorneoDTO torneoToTorneoDTO(Torneo torneo) throws Exception {
        try {
            TorneoDTO torneoDTO = new TorneoDTO();

            torneoDTO.setTorneoId(torneo.getTorneoId());
            torneoDTO.setCupos((torneo.getCupos() != null) ? torneo.getCupos()
                                                           : null);
            torneoDTO.setCuposDisponibles((torneo.getCuposDisponibles() != null)
                ? torneo.getCuposDisponibles() : null);
            torneoDTO.setDraw((torneo.getDraw() != null) ? torneo.getDraw() : null);
            torneoDTO.setEstado((torneo.getEstado() != null)
                ? torneo.getEstado() : null);
            torneoDTO.setFechaInicio(torneo.getFechaInicio());
            torneoDTO.setNombre((torneo.getNombre() != null)
                ? torneo.getNombre() : null);
            torneoDTO.setDirectorId_Director((torneo.getDirector()
                                                    .getDirectorId() != null)
                ? torneo.getDirector().getDirectorId() : null);

            return torneoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Torneo torneoDTOToTorneo(TorneoDTO torneoDTO)
        throws Exception {
        try {
            Torneo torneo = new Torneo();

            torneo.setTorneoId(torneoDTO.getTorneoId());
            torneo.setCupos((torneoDTO.getCupos() != null)
                ? torneoDTO.getCupos() : null);
            torneo.setCuposDisponibles((torneoDTO.getCuposDisponibles() != null)
                ? torneoDTO.getCuposDisponibles() : null);
            torneo.setDraw((torneoDTO.getDraw() != null) ? torneoDTO.getDraw()
                                                         : null);
            torneo.setEstado((torneoDTO.getEstado() != null)
                ? torneoDTO.getEstado() : null);
            torneo.setFechaInicio(torneoDTO.getFechaInicio());
            torneo.setNombre((torneoDTO.getNombre() != null)
                ? torneoDTO.getNombre() : null);

            Director director = new Director();

            if (torneoDTO.getDirectorId_Director() != null) {
                director = logicDirector1.getDirector(torneoDTO.getDirectorId_Director());
            }

            if (director != null) {
                torneo.setDirector(director);
            }

            return torneo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<TorneoDTO> listTorneoToListTorneoDTO(List<Torneo> listTorneo)
        throws Exception {
        try {
            List<TorneoDTO> torneoDTOs = new ArrayList<TorneoDTO>();

            for (Torneo torneo : listTorneo) {
                TorneoDTO torneoDTO = torneoToTorneoDTO(torneo);

                torneoDTOs.add(torneoDTO);
            }

            return torneoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Torneo> listTorneoDTOToListTorneo(List<TorneoDTO> listTorneoDTO)
        throws Exception {
        try {
            List<Torneo> listTorneo = new ArrayList<Torneo>();

            for (TorneoDTO torneoDTO : listTorneoDTO) {
                Torneo torneo = torneoDTOToTorneo(torneoDTO);

                listTorneo.add(torneo);
            }

            return listTorneo;
        } catch (Exception e) {
            throw e;
        }
    }
}
