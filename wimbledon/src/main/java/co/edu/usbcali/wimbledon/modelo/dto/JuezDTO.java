package co.edu.usbcali.wimbledon.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class JuezDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(JuezDTO.class);
    private String estado;
    private Integer juezId;
    private Integer personaId_Persona;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Integer getJuezId() {
        return juezId;
    }

    public void setJuezId(Integer juezId) {
        this.juezId = juezId;
    }

    public Integer getPersonaId_Persona() {
        return personaId_Persona;
    }

    public void setPersonaId_Persona(Integer personaId_Persona) {
        this.personaId_Persona = personaId_Persona;
    }
}
