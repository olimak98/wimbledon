package co.edu.usbcali.wimbledon.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class RondaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(RondaDTO.class);
    private Integer numero;
    private Integer premio;
    private Integer puntosAtp;
    private Integer rondaId;
    private Integer torneoId_Torneo;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Integer getPremio() {
        return premio;
    }

    public void setPremio(Integer premio) {
        this.premio = premio;
    }

    public Integer getPuntosAtp() {
        return puntosAtp;
    }

    public void setPuntosAtp(Integer puntosAtp) {
        this.puntosAtp = puntosAtp;
    }

    public Integer getRondaId() {
        return rondaId;
    }

    public void setRondaId(Integer rondaId) {
        this.rondaId = rondaId;
    }

    public Integer getTorneoId_Torneo() {
        return torneoId_Torneo;
    }

    public void setTorneoId_Torneo(Integer torneoId_Torneo) {
        this.torneoId_Torneo = torneoId_Torneo;
    }
}
