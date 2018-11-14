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
public class ReservaCanchaDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ReservaCanchaDTO.class);
    private Date fecha;
    private Integer reservaCanchaId;
    private Integer canchaId_Cancha;
    private Integer partidoId_Partido;

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getReservaCanchaId() {
        return reservaCanchaId;
    }

    public void setReservaCanchaId(Integer reservaCanchaId) {
        this.reservaCanchaId = reservaCanchaId;
    }

    public Integer getCanchaId_Cancha() {
        return canchaId_Cancha;
    }

    public void setCanchaId_Cancha(Integer canchaId_Cancha) {
        this.canchaId_Cancha = canchaId_Cancha;
    }

    public Integer getPartidoId_Partido() {
        return partidoId_Partido;
    }

    public void setPartidoId_Partido(Integer partidoId_Partido) {
        this.partidoId_Partido = partidoId_Partido;
    }
}
