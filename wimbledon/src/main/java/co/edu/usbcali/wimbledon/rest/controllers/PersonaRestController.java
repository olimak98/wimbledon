package co.edu.usbcali.wimbledon.rest.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.wimbledon.dto.mapper.IPersonaMapper;
import co.edu.usbcali.wimbledon.modelo.Persona;
import co.edu.usbcali.wimbledon.modelo.dto.PersonaDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;


@RestController
@RequestMapping("/persona")
public class PersonaRestController {
    private static final Logger log = LoggerFactory.getLogger(PersonaRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IPersonaMapper personaMapper;

    @PostMapping(value = "/savePersona")
    public void savePersona(@RequestBody
    PersonaDTO personaDTO) throws Exception {
        try {
            Persona persona = personaMapper.personaDTOToPersona(personaDTO);

            businessDelegatorView.savePersona(persona);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deletePersona/{personaId}")
    public void deletePersona(@PathVariable("personaId")
    Integer personaId) throws Exception {
        try {
            Persona persona = businessDelegatorView.getPersona(personaId);

            businessDelegatorView.deletePersona(persona);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updatePersona/")
    public void updatePersona(@RequestBody
    PersonaDTO personaDTO) throws Exception {
        try {
            Persona persona = personaMapper.personaDTOToPersona(personaDTO);

            businessDelegatorView.updatePersona(persona);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataPersona")
    public List<PersonaDTO> getDataPersona() throws Exception {
        try {
            return businessDelegatorView.getDataPersona();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getPersona/{personaId}")
    public PersonaDTO getPersona(@PathVariable("personaId")
    Integer personaId) throws Exception {
        try {
            Persona persona = businessDelegatorView.getPersona(personaId);

            return personaMapper.personaToPersonaDTO(persona);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
