package co.edu.usbcali.wimbledon.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class JuezTorneoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(JuezTorneoDTO.class);
    private Integer juezTorneoId;
    private Integer juezId_Juez;
    private Integer torneoId_Torneo;

    public Integer getJuezTorneoId() {
        return juezTorneoId;
    }

    public void setJuezTorneoId(Integer juezTorneoId) {
        this.juezTorneoId = juezTorneoId;
    }

    public Integer getJuezId_Juez() {
        return juezId_Juez;
    }

    public void setJuezId_Juez(Integer juezId_Juez) {
        this.juezId_Juez = juezId_Juez;
    }

    public Integer getTorneoId_Torneo() {
        return torneoId_Torneo;
    }

    public void setTorneoId_Torneo(Integer torneoId_Torneo) {
        this.torneoId_Torneo = torneoId_Torneo;
    }
}
