package co.edu.usbcali.wimbledon.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class JugadorEquipoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(JugadorEquipoDTO.class);
    private Integer jugadorEquipoId;
    private Integer equipoId_Equipo;
    private Integer jugadorId_Jugador;

    public Integer getJugadorEquipoId() {
        return jugadorEquipoId;
    }

    public void setJugadorEquipoId(Integer jugadorEquipoId) {
        this.jugadorEquipoId = jugadorEquipoId;
    }

    public Integer getEquipoId_Equipo() {
        return equipoId_Equipo;
    }

    public void setEquipoId_Equipo(Integer equipoId_Equipo) {
        this.equipoId_Equipo = equipoId_Equipo;
    }

    public Integer getJugadorId_Jugador() {
        return jugadorId_Jugador;
    }

    public void setJugadorId_Jugador(Integer jugadorId_Jugador) {
        this.jugadorId_Jugador = jugadorId_Jugador;
    }
}
