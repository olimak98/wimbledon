package co.edu.usbcali.wimbledon.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class DirectorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(DirectorDTO.class);
    private Integer directorId;
    private String estado;
    private Integer personaId_Persona;

    public Integer getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getPersonaId_Persona() {
        return personaId_Persona;
    }

    public void setPersonaId_Persona(Integer personaId_Persona) {
        this.personaId_Persona = personaId_Persona;
    }
}
