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
import co.edu.usbcali.wimbledon.modelo.Persona;
import co.edu.usbcali.wimbledon.modelo.control.IPersonaLogic;
import co.edu.usbcali.wimbledon.modelo.dto.DirectorDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class DirectorMapper implements IDirectorMapper {
    private static final Logger log = LoggerFactory.getLogger(DirectorMapper.class);

    /**
    * Logic injected by Spring that manages Persona entities
    *
    */
    @Autowired
    IPersonaLogic logicPersona1;

    @Transactional(readOnly = true)
    public DirectorDTO directorToDirectorDTO(Director director)
        throws Exception {
        try {
            DirectorDTO directorDTO = new DirectorDTO();

            directorDTO.setDirectorId(director.getDirectorId());
            directorDTO.setEstado((director.getEstado() != null)
                ? director.getEstado() : null);
            directorDTO.setPersonaId_Persona((director.getPersona()
                                                      .getPersonaId() != null)
                ? director.getPersona().getPersonaId() : null);

            return directorDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Director directorDTOToDirector(DirectorDTO directorDTO)
        throws Exception {
        try {
            Director director = new Director();

            director.setDirectorId(directorDTO.getDirectorId());
            director.setEstado((directorDTO.getEstado() != null)
                ? directorDTO.getEstado() : null);

            Persona persona = new Persona();

            if (directorDTO.getPersonaId_Persona() != null) {
                persona = logicPersona1.getPersona(directorDTO.getPersonaId_Persona());
            }

            if (persona != null) {
                director.setPersona(persona);
            }

            return director;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<DirectorDTO> listDirectorToListDirectorDTO(
        List<Director> listDirector) throws Exception {
        try {
            List<DirectorDTO> directorDTOs = new ArrayList<DirectorDTO>();

            for (Director director : listDirector) {
                DirectorDTO directorDTO = directorToDirectorDTO(director);

                directorDTOs.add(directorDTO);
            }

            return directorDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Director> listDirectorDTOToListDirector(
        List<DirectorDTO> listDirectorDTO) throws Exception {
        try {
            List<Director> listDirector = new ArrayList<Director>();

            for (DirectorDTO directorDTO : listDirectorDTO) {
                Director director = directorDTOToDirector(directorDTO);

                listDirector.add(director);
            }

            return listDirector;
        } catch (Exception e) {
            throw e;
        }
    }
}
