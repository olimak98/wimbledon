package co.edu.usbcali.wimbledon.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "equipo", schema = "public")
public class Equipo implements java.io.Serializable {
    @NotNull
    private Integer equipoId;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String estado;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String nombre;
    private Set<EquipoTorneo> equipoTorneos = new HashSet<EquipoTorneo>(0);
    private Set<JugadorEquipo> jugadorEquipos = new HashSet<JugadorEquipo>(0);
    private Set<Partido> partidosForEquipo1Id = new HashSet<Partido>(0);
    private Set<Partido> partidosForEquipo2Id = new HashSet<Partido>(0);
    private Set<Partido> partidosForEquipoGanadorId = new HashSet<Partido>(0);
    private Set<co.edu.usbcali.wimbledon.modelo.Set> setsForEquipo1Id = new HashSet<co.edu.usbcali.wimbledon.modelo.Set>(0);
    private Set<co.edu.usbcali.wimbledon.modelo.Set> setsForEquipo2Id = new HashSet<co.edu.usbcali.wimbledon.modelo.Set>(0);

    public Equipo() {
    }

    public Equipo(Integer equipoId, Set<EquipoTorneo> equipoTorneos,
        String estado, Set<JugadorEquipo> jugadorEquipos, String nombre,
        Set<Partido> partidosForEquipo1Id, Set<Partido> partidosForEquipo2Id,
        Set<Partido> partidosForEquipoGanadorId, Set<co.edu.usbcali.wimbledon.modelo.Set> setsForEquipo1Id,
        Set<co.edu.usbcali.wimbledon.modelo.Set> setsForEquipo2Id) {
        this.equipoId = equipoId;
        this.estado = estado;
        this.nombre = nombre;
        this.equipoTorneos = equipoTorneos;
        this.jugadorEquipos = jugadorEquipos;
        this.partidosForEquipo1Id = partidosForEquipo1Id;
        this.partidosForEquipo2Id = partidosForEquipo2Id;
        this.partidosForEquipoGanadorId = partidosForEquipoGanadorId;
        this.setsForEquipo1Id = setsForEquipo1Id;
        this.setsForEquipo2Id = setsForEquipo2Id;
    }

    @Id
    @Column(name = "equipo_id", unique = true, nullable = false)
    public Integer getEquipoId() {
        return this.equipoId;
    }

    public void setEquipoId(Integer equipoId) {
        this.equipoId = equipoId;
    }

    @Column(name = "estado", nullable = false)
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
    public Set<EquipoTorneo> getEquipoTorneos() {
        return this.equipoTorneos;
    }

    public void setEquipoTorneos(Set<EquipoTorneo> equipoTorneos) {
        this.equipoTorneos = equipoTorneos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
    public Set<JugadorEquipo> getJugadorEquipos() {
        return this.jugadorEquipos;
    }

    public void setJugadorEquipos(Set<JugadorEquipo> jugadorEquipos) {
        this.jugadorEquipos = jugadorEquipos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
    public Set<Partido> getPartidosForEquipo1Id() {
        return this.partidosForEquipo1Id;
    }

    public void setPartidosForEquipo1Id(Set<Partido> partidosForEquipo1Id) {
        this.partidosForEquipo1Id = partidosForEquipo1Id;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
    public Set<Partido> getPartidosForEquipo2Id() {
        return this.partidosForEquipo2Id;
    }

    public void setPartidosForEquipo2Id(Set<Partido> partidosForEquipo2Id) {
        this.partidosForEquipo2Id = partidosForEquipo2Id;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
    public Set<Partido> getPartidosForEquipoGanadorId() {
        return this.partidosForEquipoGanadorId;
    }

    public void setPartidosForEquipoGanadorId(
        Set<Partido> partidosForEquipoGanadorId) {
        this.partidosForEquipoGanadorId = partidosForEquipoGanadorId;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
    public Set<co.edu.usbcali.wimbledon.modelo.Set> getSetsForEquipo1Id() {
        return this.setsForEquipo1Id;
    }

    public void setSetsForEquipo1Id(Set<co.edu.usbcali.wimbledon.modelo.Set> setsForEquipo1Id) {
        this.setsForEquipo1Id = setsForEquipo1Id;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipo")
    public Set<co.edu.usbcali.wimbledon.modelo.Set> getSetsForEquipo2Id() {
        return this.setsForEquipo2Id;
    }

    public void setSetsForEquipo2Id(Set<co.edu.usbcali.wimbledon.modelo.Set> setsForEquipo2Id) {
        this.setsForEquipo2Id = setsForEquipo2Id;
    }
}
