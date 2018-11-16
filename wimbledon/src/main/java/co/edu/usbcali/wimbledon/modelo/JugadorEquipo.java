package co.edu.usbcali.wimbledon.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "jugador_equipo", schema = "public")
public class JugadorEquipo implements java.io.Serializable {
    private Integer jugadorEquipoId;
    @NotNull
    private Equipo equipo;
    @NotNull
    private Jugador jugador;

    public JugadorEquipo() {
    }

    public JugadorEquipo(Integer jugadorEquipoId, Equipo equipo, Jugador jugador) {
        this.jugadorEquipoId = jugadorEquipoId;
        this.equipo = equipo;
        this.jugador = jugador;
    }

    @Id
    @Column(name = "jugador_equipo_id", unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getJugadorEquipoId() {
        return this.jugadorEquipoId;
    }

    public void setJugadorEquipoId(Integer jugadorEquipoId) {
        this.jugadorEquipoId = jugadorEquipoId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id")
    public Equipo getEquipo() {
        return this.equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "jugador_id")
    public Jugador getJugador() {
        return this.jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }
}
