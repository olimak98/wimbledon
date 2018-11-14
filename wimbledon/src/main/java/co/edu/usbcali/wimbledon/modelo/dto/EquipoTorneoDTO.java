package co.edu.usbcali.wimbledon.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class EquipoTorneoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EquipoTorneoDTO.class);
    private Integer equipoTorneoId;
    private Integer equipoId_Equipo;
    private Integer torneoId_Torneo;

    public Integer getEquipoTorneoId() {
        return equipoTorneoId;
    }

    public void setEquipoTorneoId(Integer equipoTorneoId) {
        this.equipoTorneoId = equipoTorneoId;
    }

    public Integer getEquipoId_Equipo() {
        return equipoId_Equipo;
    }

    public void setEquipoId_Equipo(Integer equipoId_Equipo) {
        this.equipoId_Equipo = equipoId_Equipo;
    }

    public Integer getTorneoId_Torneo() {
        return torneoId_Torneo;
    }

    public void setTorneoId_Torneo(Integer torneoId_Torneo) {
        this.torneoId_Torneo = torneoId_Torneo;
    }
}
