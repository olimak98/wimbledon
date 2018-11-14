package co.edu.usbcali.wimbledon.modelo.dto;

import java.io.Serializable;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class PartidoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(PartidoDTO.class);
    private Integer duracion;
    private String estado;
    private Date fecha;
    private Integer numeroEncuentro;
    private Integer partidoId;
    private String puntuacion;
    private Integer canchaId_Cancha;
    private Integer equipoId_Equipo1;
    private Integer equipoId_Equipo2;
    private Integer equipoId_EquipoGanador;
    private Integer juezId_Juez;
    private Integer rondaId_Ronda;

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getNumeroEncuentro() {
        return numeroEncuentro;
    }

    public void setNumeroEncuentro(Integer numeroEncuentro) {
        this.numeroEncuentro = numeroEncuentro;
    }

    public Integer getPartidoId() {
        return partidoId;
    }

    public void setPartidoId(Integer partidoId) {
        this.partidoId = partidoId;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Integer getCanchaId_Cancha() {
        return canchaId_Cancha;
    }

    public void setCanchaId_Cancha(Integer canchaId_Cancha) {
        this.canchaId_Cancha = canchaId_Cancha;
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

    public Integer getEquipoId_EquipoGanador() {
        return equipoId_EquipoGanador;
    }

    public void setEquipoId_EquipoGanador(Integer equipoId_EquipoGanador) {
        this.equipoId_EquipoGanador = equipoId_EquipoGanador;
    }

    public Integer getJuezId_Juez() {
        return juezId_Juez;
    }

    public void setJuezId_Juez(Integer juezId_Juez) {
        this.juezId_Juez = juezId_Juez;
    }

    public Integer getRondaId_Ronda() {
        return rondaId_Ronda;
    }

    public void setRondaId_Ronda(Integer rondaId_Ronda) {
        this.rondaId_Ronda = rondaId_Ronda;
    }
}
