package co.edu.usbcali.wimbledon.modelo;

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
@Table(name = "equipo_torneo", schema = "public")
public class EquipoTorneo implements java.io.Serializable {
    @NotNull
    private Integer equipoTorneoId;
    @NotNull
    private Equipo equipo;
    @NotNull
    private Torneo torneo;

    public EquipoTorneo() {
    }

    public EquipoTorneo(Integer equipoTorneoId, Equipo equipo, Torneo torneo) {
        this.equipoTorneoId = equipoTorneoId;
        this.equipo = equipo;
        this.torneo = torneo;
    }

    @Id
    @Column(name = "equipo_torneo_id", unique = true, nullable = false)
    public Integer getEquipoTorneoId() {
        return this.equipoTorneoId;
    }

    public void setEquipoTorneoId(Integer equipoTorneoId) {
        this.equipoTorneoId = equipoTorneoId;
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
    @JoinColumn(name = "torneo_id")
    public Torneo getTorneo() {
        return this.torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }
}
