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
public class TorneoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(TorneoDTO.class);
    private Integer cupos;
    private Integer cuposDisponibles;
    private String draw;
    private String estado;
    private Date fechaInicio;
    private String nombre;
    private Integer torneoId;
    private Integer directorId_Director;

    public Integer getCupos() {
        return cupos;
    }

    public void setCupos(Integer cupos) {
        this.cupos = cupos;
    }

    public Integer getCuposDisponibles() {
        return cuposDisponibles;
    }

    public void setCuposDisponibles(Integer cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getTorneoId() {
        return torneoId;
    }

    public void setTorneoId(Integer torneoId) {
        this.torneoId = torneoId;
    }

    public Integer getDirectorId_Director() {
        return directorId_Director;
    }

    public void setDirectorId_Director(Integer directorId_Director) {
        this.directorId_Director = directorId_Director;
    }
}
