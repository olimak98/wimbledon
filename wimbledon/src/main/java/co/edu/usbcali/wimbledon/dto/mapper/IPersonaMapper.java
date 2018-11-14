package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Persona;
import co.edu.usbcali.wimbledon.modelo.dto.PersonaDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IPersonaMapper {
    public PersonaDTO personaToPersonaDTO(Persona persona)
        throws Exception;

    public Persona personaDTOToPersona(PersonaDTO personaDTO)
        throws Exception;

    public List<PersonaDTO> listPersonaToListPersonaDTO(List<Persona> personas)
        throws Exception;

    public List<Persona> listPersonaDTOToListPersona(
        List<PersonaDTO> personaDTOs) throws Exception;
}
