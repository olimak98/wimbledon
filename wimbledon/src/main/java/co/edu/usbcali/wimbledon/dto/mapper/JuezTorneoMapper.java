package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wimbledon.modelo.Juez;
import co.edu.usbcali.wimbledon.modelo.JuezTorneo;
import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.modelo.control.IJuezLogic;
import co.edu.usbcali.wimbledon.modelo.control.ITorneoLogic;
import co.edu.usbcali.wimbledon.modelo.dto.JuezTorneoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class JuezTorneoMapper implements IJuezTorneoMapper {
    private static final Logger log = LoggerFactory.getLogger(JuezTorneoMapper.class);

    /**
    * Logic injected by Spring that manages Juez entities
    *
    */
    @Autowired
    IJuezLogic logicJuez1;

    /**
    * Logic injected by Spring that manages Torneo entities
    *
    */
    @Autowired
    ITorneoLogic logicTorneo2;

    @Transactional(readOnly = true)
    public JuezTorneoDTO juezTorneoToJuezTorneoDTO(JuezTorneo juezTorneo)
        throws Exception {
        try {
            JuezTorneoDTO juezTorneoDTO = new JuezTorneoDTO();

            juezTorneoDTO.setJuezTorneoId(juezTorneo.getJuezTorneoId());
            juezTorneoDTO.setJuezId_Juez((juezTorneo.getJuez().getJuezId() != null)
                ? juezTorneo.getJuez().getJuezId() : null);
            juezTorneoDTO.setTorneoId_Torneo((juezTorneo.getTorneo()
                                                        .getTorneoId() != null)
                ? juezTorneo.getTorneo().getTorneoId() : null);

            return juezTorneoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public JuezTorneo juezTorneoDTOToJuezTorneo(JuezTorneoDTO juezTorneoDTO)
        throws Exception {
        try {
            JuezTorneo juezTorneo = new JuezTorneo();

            juezTorneo.setJuezTorneoId(juezTorneoDTO.getJuezTorneoId());

            Juez juez = new Juez();

            if (juezTorneoDTO.getJuezId_Juez() != null) {
                juez = logicJuez1.getJuez(juezTorneoDTO.getJuezId_Juez());
            }

            if (juez != null) {
                juezTorneo.setJuez(juez);
            }

            Torneo torneo = new Torneo();

            if (juezTorneoDTO.getTorneoId_Torneo() != null) {
                torneo = logicTorneo2.getTorneo(juezTorneoDTO.getTorneoId_Torneo());
            }

            if (torneo != null) {
                juezTorneo.setTorneo(torneo);
            }

            return juezTorneo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<JuezTorneoDTO> listJuezTorneoToListJuezTorneoDTO(
        List<JuezTorneo> listJuezTorneo) throws Exception {
        try {
            List<JuezTorneoDTO> juezTorneoDTOs = new ArrayList<JuezTorneoDTO>();

            for (JuezTorneo juezTorneo : listJuezTorneo) {
                JuezTorneoDTO juezTorneoDTO = juezTorneoToJuezTorneoDTO(juezTorneo);

                juezTorneoDTOs.add(juezTorneoDTO);
            }

            return juezTorneoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<JuezTorneo> listJuezTorneoDTOToListJuezTorneo(
        List<JuezTorneoDTO> listJuezTorneoDTO) throws Exception {
        try {
            List<JuezTorneo> listJuezTorneo = new ArrayList<JuezTorneo>();

            for (JuezTorneoDTO juezTorneoDTO : listJuezTorneoDTO) {
                JuezTorneo juezTorneo = juezTorneoDTOToJuezTorneo(juezTorneoDTO);

                listJuezTorneo.add(juezTorneo);
            }

            return listJuezTorneo;
        } catch (Exception e) {
            throw e;
        }
    }
}
