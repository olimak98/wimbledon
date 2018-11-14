package co.edu.usbcali.wimbledon.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class SetDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(SetDTO.class);
    private Integer puntosEquipo1;
    private Integer puntosEquipo2;
    private Integer setId;
    private Integer equipoId_Equipo1;
    private Integer equipoId_Equipo2;
    private Integer partidoId_Partido;

    public Integer getPuntosEquipo1() {
        return puntosEquipo1;
    }

    public void setPuntosEquipo1(Integer puntosEquipo1) {
        this.puntosEquipo1 = puntosEquipo1;
    }

    public Integer getPuntosEquipo2() {
        return puntosEquipo2;
    }

    public void setPuntosEquipo2(Integer puntosEquipo2) {
        this.puntosEquipo2 = puntosEquipo2;
    }

    public Integer getSetId() {
        return setId;
    }

    public void setSetId(Integer setId) {
        this.setId = setId;
    }

    public Integer getEquipoId_Equipo1() {
        return equipoId_Equipo1;
    }

    public void setEquipoId_Equipo1(Integer equipoId_Equipo1) {
        this.equipoId_Equipo1 = equipoId_Equipo1;
    }

    public Integer getEquipoId_Equipo2() {
        return equipoId_Equipo2;
    }

    public void setEquipoId_Equipo2(Integer equipoId_Equipo2) {
        this.equipoId_Equipo2 = equipoId_Equipo2;
    }

    public Integer getPartidoId_Partido() {
        return partidoId_Partido;
    }

    public void setPartidoId_Partido(Integer partidoId_Partido) {
        this.partidoId_Partido = partidoId_Partido;
    }
}
