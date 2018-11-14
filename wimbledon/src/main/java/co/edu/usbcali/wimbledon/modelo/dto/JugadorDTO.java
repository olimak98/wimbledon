package co.edu.usbcali.wimbledon.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class JugadorDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(JugadorDTO.class);
    private Integer jugadorId;
    private Integer ranking;
    private Integer personaId_Persona;

    public Integer getJugadorId() {
        return jugadorId;
    }

    public void setJugadorId(Integer jugadorId) {
        this.jugadorId = jugadorId;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public Integer getPersonaId_Persona() {
        return personaId_Persona;
    }

    public void setPersonaId_Persona(Integer personaId_Persona) {
        this.personaId_Persona = personaId_Persona;
    }
}
