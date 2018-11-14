package co.edu.usbcali.wimbledon.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "reserva_cancha", schema = "public")
public class ReservaCancha implements java.io.Serializable {
    @NotNull
    private Integer reservaCanchaId;
    @NotNull
    private Cancha cancha;
    @NotNull
    private Partido partido;
    private Date fecha;

    public ReservaCancha() {
    }

    public ReservaCancha(Integer reservaCanchaId, Cancha cancha, Date fecha,
        Partido partido) {
        this.reservaCanchaId = reservaCanchaId;
        this.cancha = cancha;
        this.partido = partido;
        this.fecha = fecha;
    }

    @Id
    @Column(name = "reserva_cancha_id", unique = true, nullable = false)
    public Integer getReservaCanchaId() {
        return this.reservaCanchaId;
    }

    public void setReservaCanchaId(Integer reservaCanchaId) {
        this.reservaCanchaId = reservaCanchaId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cancha_id")
    public Cancha getCancha() {
        return this.cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partido_id")
    public Partido getPartido() {
        return this.partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    @Column(name = "fecha")
    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
