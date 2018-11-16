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
@Table(name = "torneo", schema = "public")
public class Torneo implements java.io.Serializable {
    private Integer torneoId;
    @NotNull
    private Director director;
    @NotNull
    private Integer cupos;
    @NotNull
    private Integer cuposDisponibles;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String draw;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String estado;
    private Date fechaInicio;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String nombre;
    private Set<EquipoTorneo> equipoTorneos = new HashSet<EquipoTorneo>(0);
    private Set<JuezTorneo> juezTorneos = new HashSet<JuezTorneo>(0);
    private Set<Ronda> rondas = new HashSet<Ronda>(0);

    public Torneo() {
    }

    public Torneo(Integer torneoId, Integer cupos, Integer cuposDisponibles,
        Director director, String draw, Set<EquipoTorneo> equipoTorneos,
        String estado, Date fechaInicio, Set<JuezTorneo> juezTorneos,
        String nombre, Set<Ronda> rondas) {
        this.torneoId = torneoId;
        this.director = director;
        this.cupos = cupos;
        this.cuposDisponibles = cuposDisponibles;
        this.draw = draw;
        this.estado = estado;
        this.fechaInicio = fechaInicio;
        this.nombre = nombre;
        this.equipoTorneos = equipoTorneos;
        this.juezTorneos = juezTorneos;
        this.rondas = rondas;
    }

    @Id
    @Column(name = "torneo_id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getTorneoId() {
        return this.torneoId;
    }

    public void setTorneoId(Integer torneoId) {
        this.torneoId = torneoId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    public Director getDirector() {
        return this.director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    @Column(name = "cupos", nullable = false)
    public Integer getCupos() {
        return this.cupos;
    }

    public void setCupos(Integer cupos) {
        this.cupos = cupos;
    }

    @Column(name = "cupos_disponibles", nullable = false)
    public Integer getCuposDisponibles() {
        return this.cuposDisponibles;
    }

    public void setCuposDisponibles(Integer cuposDisponibles) {
        this.cuposDisponibles = cuposDisponibles;
    }

    @Column(name = "draw", nullable = false)
    public String getDraw() {
        return this.draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    @Column(name = "estado", nullable = false)
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(name = "fecha_inicio")
    public Date getFechaInicio() {
        return this.fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "torneo")
    public Set<EquipoTorneo> getEquipoTorneos() {
        return this.equipoTorneos;
    }

    public void setEquipoTorneos(Set<EquipoTorneo> equipoTorneos) {
        this.equipoTorneos = equipoTorneos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "torneo")
    public Set<JuezTorneo> getJuezTorneos() {
        return this.juezTorneos;
    }

    public void setJuezTorneos(Set<JuezTorneo> juezTorneos) {
        this.juezTorneos = juezTorneos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "torneo")
    public Set<Ronda> getRondas() {
        return this.rondas;
    }

    public void setRondas(Set<Ronda> rondas) {
        this.rondas = rondas;
    }
}
