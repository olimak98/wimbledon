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
@Table(name = "juez_torneo", schema = "public")
public class JuezTorneo implements java.io.Serializable {
    @NotNull
    private Integer juezTorneoId;
    @NotNull
    private Juez juez;
    @NotNull
    private Torneo torneo;

    public JuezTorneo() {
    }

    public JuezTorneo(Integer juezTorneoId, Juez juez, Torneo torneo) {
        this.juezTorneoId = juezTorneoId;
        this.juez = juez;
        this.torneo = torneo;
    }

    @Id
    @Column(name = "juez_torneo_id", unique = true, nullable = false)
    public Integer getJuezTorneoId() {
        return this.juezTorneoId;
    }

    public void setJuezTorneoId(Integer juezTorneoId) {
        this.juezTorneoId = juezTorneoId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "juez_id")
    public Juez getJuez() {
        return this.juez;
    }

    public void setJuez(Juez juez) {
        this.juez = juez;
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
