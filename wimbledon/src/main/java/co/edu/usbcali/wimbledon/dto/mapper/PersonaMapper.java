package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wimbledon.modelo.Pais;
import co.edu.usbcali.wimbledon.modelo.Persona;
import co.edu.usbcali.wimbledon.modelo.control.IPaisLogic;
import co.edu.usbcali.wimbledon.modelo.dto.PersonaDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class PersonaMapper implements IPersonaMapper {
    private static final Logger log = LoggerFactory.getLogger(PersonaMapper.class);

    /**
    * Logic injected by Spring that manages Pais entities
    *
    */
    @Autowired
    IPaisLogic logicPais1;

    @Transactional(readOnly = true)
    public PersonaDTO personaToPersonaDTO(Persona persona)
        throws Exception {
        try {
            PersonaDTO personaDTO = new PersonaDTO();

            personaDTO.setPersonaId(persona.getPersonaId());
            personaDTO.setFechaNacimiento(persona.getFechaNacimiento());
            personaDTO.setIdentificacion((persona.getIdentificacion() != null)
                ? persona.getIdentificacion() : null);
            personaDTO.setNombreCompleto((persona.getNombreCompleto() != null)
                ? persona.getNombreCompleto() : null);
            personaDTO.setTipoIdentificacion((persona.getTipoIdentificacion() != null)
                ? persona.getTipoIdentificacion() : null);
            personaDTO.setPaisId_Pais((persona.getPais().getPaisId() != null)
                ? persona.getPais().getPaisId() : null);

            return personaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Persona personaDTOToPersona(PersonaDTO personaDTO)
        throws Exception {
        try {
            Persona persona = new Persona();

            persona.setPersonaId(personaDTO.getPersonaId());
            persona.setFechaNacimiento(personaDTO.getFechaNacimiento());
            persona.setIdentificacion((personaDTO.getIdentificacion() != null)
                ? personaDTO.getIdentificacion() : null);
            persona.setNombreCompleto((personaDTO.getNombreCompleto() != null)
                ? personaDTO.getNombreCompleto() : null);
            persona.setTipoIdentificacion((personaDTO.getTipoIdentificacion() != null)
                ? personaDTO.getTipoIdentificacion() : null);

            Pais pais = new Pais();

            if (personaDTO.getPaisId_Pais() != null) {
                pais = logicPais1.getPais(personaDTO.getPaisId_Pais());
            }

            if (pais != null) {
                persona.setPais(pais);
            }

            return persona;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PersonaDTO> listPersonaToListPersonaDTO(
        List<Persona> listPersona) throws Exception {
        try {
            List<PersonaDTO> personaDTOs = new ArrayList<PersonaDTO>();

            for (Persona persona : listPersona) {
                PersonaDTO personaDTO = personaToPersonaDTO(persona);

                personaDTOs.add(personaDTO);
            }

            return personaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Persona> listPersonaDTOToListPersona(
        List<PersonaDTO> listPersonaDTO) throws Exception {
        try {
            List<Persona> listPersona = new ArrayList<Persona>();

            for (PersonaDTO personaDTO : listPersonaDTO) {
                Persona persona = personaDTOToPersona(personaDTO);

                listPersona.add(persona);
            }

            return listPersona;
        } catch (Exception e) {
            throw e;
        }
    }
}
