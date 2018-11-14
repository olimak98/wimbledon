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
import co.edu.usbcali.wimbledon.modelo.Persona;
import co.edu.usbcali.wimbledon.modelo.control.IPersonaLogic;
import co.edu.usbcali.wimbledon.modelo.dto.JuezDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class JuezMapper implements IJuezMapper {
    private static final Logger log = LoggerFactory.getLogger(JuezMapper.class);

    /**
    * Logic injected by Spring that manages Persona entities
    *
    */
    @Autowired
    IPersonaLogic logicPersona1;

    @Transactional(readOnly = true)
    public JuezDTO juezToJuezDTO(Juez juez) throws Exception {
        try {
            JuezDTO juezDTO = new JuezDTO();

            juezDTO.setJuezId(juez.getJuezId());
            juezDTO.setEstado((juez.getEstado() != null) ? juez.getEstado() : null);
            juezDTO.setPersonaId_Persona((juez.getPersona().getPersonaId() != null)
                ? juez.getPersona().getPersonaId() : null);

            return juezDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Juez juezDTOToJuez(JuezDTO juezDTO) throws Exception {
        try {
            Juez juez = new Juez();

            juez.setJuezId(juezDTO.getJuezId());
            juez.setEstado((juezDTO.getEstado() != null) ? juezDTO.getEstado()
                                                         : null);

            Persona persona = new Persona();

            if (juezDTO.getPersonaId_Persona() != null) {
                persona = logicPersona1.getPersona(juezDTO.getPersonaId_Persona());
            }

            if (persona != null) {
                juez.setPersona(persona);
            }

            return juez;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<JuezDTO> listJuezToListJuezDTO(List<Juez> listJuez)
        throws Exception {
        try {
            List<JuezDTO> juezDTOs = new ArrayList<JuezDTO>();

            for (Juez juez : listJuez) {
                JuezDTO juezDTO = juezToJuezDTO(juez);

                juezDTOs.add(juezDTO);
            }

            return juezDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Juez> listJuezDTOToListJuez(List<JuezDTO> listJuezDTO)
        throws Exception {
        try {
            List<Juez> listJuez = new ArrayList<Juez>();

            for (JuezDTO juezDTO : listJuezDTO) {
                Juez juez = juezDTOToJuez(juezDTO);

                listJuez.add(juez);
            }

            return listJuez;
        } catch (Exception e) {
            throw e;
        }
    }
}
