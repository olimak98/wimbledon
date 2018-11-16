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
@Table(name = "ronda", schema = "public")
public class Ronda implements java.io.Serializable {
    private Integer rondaId;
    @NotNull
    private Torneo torneo;
    private Integer numero;
    private Integer premio;
    private Integer puntosAtp;
    private Set<Partido> partidos = new HashSet<Partido>(0);

    public Ronda() {
    }

    public Ronda(Integer rondaId, Integer numero, Set<Partido> partidos,
        Integer premio, Integer puntosAtp, Torneo torneo) {
        this.rondaId = rondaId;
        this.torneo = torneo;
        this.numero = numero;
        this.premio = premio;
        this.puntosAtp = puntosAtp;
        this.partidos = partidos;
    }

    @Id
    @Column(name = "ronda_id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getRondaId() {
        return this.rondaId;
    }

    public void setRondaId(Integer rondaId) {
        this.rondaId = rondaId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "torneo_id")
    public Torneo getTorneo() {
        return this.torneo;
    }

    public void setTorneo(Torneo torneo) {
        this.torneo = torneo;
    }

    @Column(name = "numero")
    public Integer getNumero() {
        return this.numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    @Column(name = "premio")
    public Integer getPremio() {
        return this.premio;
    }

    public void setPremio(Integer premio) {
        this.premio = premio;
    }

    @Column(name = "puntos_atp")
    public Integer getPuntosAtp() {
        return this.puntosAtp;
    }

    public void setPuntosAtp(Integer puntosAtp) {
        this.puntosAtp = puntosAtp;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "ronda")
    public Set<Partido> getPartidos() {
        return this.partidos;
    }

    public void setPartidos(Set<Partido> partidos) {
        this.partidos = partidos;
    }
}
