package co.edu.usbcali.wimbledon.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "juez", schema = "public")
public class Juez implements java.io.Serializable {
    @NotNull
    private Integer juezId;
    @NotNull
    private Persona persona;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String estado;
    private Set<JuezTorneo> juezTorneos = new HashSet<JuezTorneo>(0);
    private Set<Partido> partidos = new HashSet<Partido>(0);

    public Juez() {
    }

    public Juez(Integer juezId, String estado, Set<JuezTorneo> juezTorneos,
        Set<Partido> partidos, Persona persona) {
        this.juezId = juezId;
        this.persona = persona;
        this.estado = estado;
        this.juezTorneos = juezTorneos;
        this.partidos = partidos;
    }

    @Id
    @Column(name = "juez_id", unique = true, nullable = false)
    public Integer getJuezId() {
        return this.juezId;
    }

    public void setJuezId(Integer juezId) {
        this.juezId = juezId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "persona_id")
    public Persona getPersona() {
        return this.persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    @Column(name = "estado", nullable = false)
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "juez")
    public Set<JuezTorneo> getJuezTorneos() {
        return this.juezTorneos;
    }

    public void setJuezTorneos(Set<JuezTorneo> juezTorneos) {
        this.juezTorneos = juezTorneos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "juez")
    public Set<Partido> getPartidos() {
        return this.partidos;
    }

    public void setPartidos(Set<Partido> partidos) {
        this.partidos = partidos;
    }
}
