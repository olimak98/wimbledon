package co.edu.usbcali.wimbledon.modelo;

import java.util.Date;
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
@Table(name = "persona", schema = "public")
public class Persona implements java.io.Serializable {
    private Integer personaId;
    @NotNull
    private Pais pais;
    @NotNull
    private Date fechaNacimiento;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String identificacion;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String nombreCompleto;
    @NotNull
    @NotEmpty
    @Size(max = 225)
    private String tipoIdentificacion;
    private Set<Director> directors = new HashSet<Director>(0);
    private Set<Juez> juezs = new HashSet<Juez>(0);
    private Set<Jugador> jugadors = new HashSet<Jugador>(0);

    public Persona() {
    }

    public Persona(Integer personaId, Set<Director> directors,
        Date fechaNacimiento, String identificacion, Set<Juez> juezs,
        Set<Jugador> jugadors, String nombreCompleto, Pais pais,
        String tipoIdentificacion) {
        this.personaId = personaId;
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
        this.identificacion = identificacion;
        this.nombreCompleto = nombreCompleto;
        this.tipoIdentificacion = tipoIdentificacion;
        this.directors = directors;
        this.juezs = juezs;
        this.jugadors = jugadors;
    }

    @Id
    @Column(name = "persona_id", unique = true)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getPersonaId() {
        return this.personaId;
    }

    public void setPersonaId(Integer personaId) {
        this.personaId = personaId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pais_id")
    public Pais getPais() {
        return this.pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    @Column(name = "fecha_nacimiento", nullable = false)
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Column(name = "identificacion", nullable = false)
    public String getIdentificacion() {
        return this.identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    @Column(name = "nombre_completo", nullable = false)
    public String getNombreCompleto() {
        return this.nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    @Column(name = "tipo_identificacion", nullable = false)
    public String getTipoIdentificacion() {
        return this.tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
    public Set<Director> getDirectors() {
        return this.directors;
    }

    public void setDirectors(Set<Director> directors) {
        this.directors = directors;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
    public Set<Juez> getJuezs() {
        return this.juezs;
    }

    public void setJuezs(Set<Juez> juezs) {
        this.juezs = juezs;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "persona")
    public Set<Jugador> getJugadors() {
        return this.jugadors;
    }

    public void setJugadors(Set<Jugador> jugadors) {
        this.jugadors = jugadors;
    }
}
