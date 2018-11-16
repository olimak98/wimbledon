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
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "director", schema = "public")
public class Director implements java.io.Serializable {
    private Integer directorId;
    @NotNull
    private Persona persona;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String estado;
    private Set<Torneo> torneos = new HashSet<Torneo>(0);

    public Director() {
    }

    public Director(Integer directorId, String estado, Persona persona,
        Set<Torneo> torneos) {
        this.directorId = directorId;
        this.persona = persona;
        this.estado = estado;
        this.torneos = torneos;
    }

    @Id
    @Column(name = "director_id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getDirectorId() {
        return this.directorId;
    }

    public void setDirectorId(Integer directorId) {
        this.directorId = directorId;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "director")
    public Set<Torneo> getTorneos() {
        return this.torneos;
    }

    public void setTorneos(Set<Torneo> torneos) {
        this.torneos = torneos;
    }
}
