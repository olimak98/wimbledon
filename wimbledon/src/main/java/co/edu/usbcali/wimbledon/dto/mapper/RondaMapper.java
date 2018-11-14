package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wimbledon.modelo.Ronda;
import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.modelo.control.ITorneoLogic;
import co.edu.usbcali.wimbledon.modelo.dto.RondaDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class RondaMapper implements IRondaMapper {
    private static final Logger log = LoggerFactory.getLogger(RondaMapper.class);

    /**
    * Logic injected by Spring that manages Torneo entities
    *
    */
    @Autowired
    ITorneoLogic logicTorneo1;

    @Transactional(readOnly = true)
    public RondaDTO rondaToRondaDTO(Ronda ronda) throws Exception {
        try {
            RondaDTO rondaDTO = new RondaDTO();

            rondaDTO.setRondaId(ronda.getRondaId());
            rondaDTO.setNumero((ronda.getNumero() != null) ? ronda.getNumero()
                                                           : null);
            rondaDTO.setPremio((ronda.getPremio() != null) ? ronda.getPremio()
                                                           : null);
            rondaDTO.setPuntosAtp((ronda.getPuntosAtp() != null)
                ? ronda.getPuntosAtp() : null);
            rondaDTO.setTorneoId_Torneo((ronda.getTorneo().getTorneoId() != null)
                ? ronda.getTorneo().getTorneoId() : null);

            return rondaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Ronda rondaDTOToRonda(RondaDTO rondaDTO) throws Exception {
        try {
            Ronda ronda = new Ronda();

            ronda.setRondaId(rondaDTO.getRondaId());
            ronda.setNumero((rondaDTO.getNumero() != null)
                ? rondaDTO.getNumero() : null);
            ronda.setPremio((rondaDTO.getPremio() != null)
                ? rondaDTO.getPremio() : null);
            ronda.setPuntosAtp((rondaDTO.getPuntosAtp() != null)
                ? rondaDTO.getPuntosAtp() : null);

            Torneo torneo = new Torneo();

            if (rondaDTO.getTorneoId_Torneo() != null) {
                torneo = logicTorneo1.getTorneo(rondaDTO.getTorneoId_Torneo());
            }

            if (torneo != null) {
                ronda.setTorneo(torneo);
            }

            return ronda;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<RondaDTO> listRondaToListRondaDTO(List<Ronda> listRonda)
        throws Exception {
        try {
            List<RondaDTO> rondaDTOs = new ArrayList<RondaDTO>();

            for (Ronda ronda : listRonda) {
                RondaDTO rondaDTO = rondaToRondaDTO(ronda);

                rondaDTOs.add(rondaDTO);
            }

            return rondaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Ronda> listRondaDTOToListRonda(List<RondaDTO> listRondaDTO)
        throws Exception {
        try {
            List<Ronda> listRonda = new ArrayList<Ronda>();

            for (RondaDTO rondaDTO : listRondaDTO) {
                Ronda ronda = rondaDTOToRonda(rondaDTO);

                listRonda.add(ronda);
            }

            return listRonda;
        } catch (Exception e) {
            throw e;
        }
    }
}
