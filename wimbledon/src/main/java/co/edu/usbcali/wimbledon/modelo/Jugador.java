package co.edu.usbcali.wimbledon.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "jugador", schema = "public")
public class Jugador implements java.io.Serializable {
    private Integer jugadorId;
    @NotNull
    private Persona persona;
    @NotNull
    private Integer ranking;
    private Set<JugadorEquipo> jugadorEquipos = new HashSet<JugadorEquipo>(0);

    public Jugador() {
    }

    public Jugador(Integer jugadorId, Set<JugadorEquipo> jugadorEquipos,
        Persona persona, Integer ranking) {
        this.jugadorId = jugadorId;
        this.persona = persona;
        this.ranking = ranking;
        this.jugadorEquipos = jugadorEquipos;
    }

    @Id
    @Column(name = "jugador_id", unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getJugadorId() {
        return this.jugadorId;
    }

    public void setJugadorId(Integer jugadorId) {
        this.jugadorId = jugadorId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Column(name = "ranking", nullable = false)
    public Integer getRanking() {
        return this.ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "jugador")
    public Set<JugadorEquipo> getJugadorEquipos() {
        return this.jugadorEquipos;
    }

    public void setJugadorEquipos(Set<JugadorEquipo> jugadorEquipos) {
        this.jugadorEquipos = jugadorEquipos;
    }
}
