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
@Table(name = "partido", schema = "public")
public class Partido implements java.io.Serializable {
    private Integer partidoId;
    @NotNull
    private Cancha cancha;
    @NotNull
    private Equipo equipoByEquipo1Id;
    @NotNull
    private Equipo equipoByEquipo2Id;
    @NotNull
    private Equipo equipoByEquipoGanadorId;
    @NotNull
    private Juez juez;
    @NotNull
    private Ronda ronda;
    private Integer duracion;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String estado;
    private Date fecha;
    private Integer numeroEncuentro;
    private String puntuacion;
    private Set<ReservaCancha> reservaCanchas = new HashSet<ReservaCancha>(0);
    private Set<co.edu.usbcali.wimbledon.modelo.Set> sets = new HashSet<co.edu.usbcali.wimbledon.modelo.Set>(0);

    public Partido() {
    }

    public Partido(Integer partidoId, Cancha cancha, Integer duracion,
        Equipo equipoByEquipo1Id, Equipo equipoByEquipo2Id,
        Equipo equipoByEquipoGanadorId, String estado, Date fecha, Juez juez,
        Integer numeroEncuentro, String puntuacion,
        Set<ReservaCancha> reservaCanchas, Ronda ronda, Set<co.edu.usbcali.wimbledon.modelo.Set> sets) {
        this.partidoId = partidoId;
        this.cancha = cancha;
        this.equipoByEquipo1Id = equipoByEquipo1Id;
        this.equipoByEquipo2Id = equipoByEquipo2Id;
        this.equipoByEquipoGanadorId = equipoByEquipoGanadorId;
        this.juez = juez;
        this.ronda = ronda;
        this.duracion = duracion;
        this.estado = estado;
        this.fecha = fecha;
        this.numeroEncuentro = numeroEncuentro;
        this.puntuacion = puntuacion;
        this.reservaCanchas = reservaCanchas;
        this.sets = sets;
    }

    @Id
    @Column(name = "partido_id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getPartidoId() {
        return this.partidoId;
    }

    public void setPartidoId(Integer partidoId) {
        this.partidoId = partidoId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cancha_id")
    public Cancha getCancha() {
        return this.cancha;
    }

    public void setCancha(Cancha cancha) {
        this.cancha = cancha;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo1_id")
    public Equipo getEquipoByEquipo1Id() {
        return this.equipoByEquipo1Id;
    }

    public void setEquipoByEquipo1Id(Equipo equipoByEquipo1Id) {
        this.equipoByEquipo1Id = equipoByEquipo1Id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo2_id")
    public Equipo getEquipoByEquipo2Id() {
        return this.equipoByEquipo2Id;
    }

    public void setEquipoByEquipo2Id(Equipo equipoByEquipo2Id) {
        this.equipoByEquipo2Id = equipoByEquipo2Id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_ganador_id")
    public Equipo getEquipoByEquipoGanadorId() {
        return this.equipoByEquipoGanadorId;
    }

    public void setEquipoByEquipoGanadorId(Equipo equipoByEquipoGanadorId) {
        this.equipoByEquipoGanadorId = equipoByEquipoGanadorId;
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
    @JoinColumn(name = "ronda_id")
    public Ronda getRonda() {
        return this.ronda;
    }

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    @Column(name = "duracion")
    public Integer getDuracion() {
        return this.duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    @Column(name = "estado", nullable = false)
    public String getEstado() {
        return this.estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Column(name = "fecha")
    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Column(name = "numero_encuentro")
    public Integer getNumeroEncuentro() {
        return this.numeroEncuentro;
    }

    public void setNumeroEncuentro(Integer numeroEncuentro) {
        this.numeroEncuentro = numeroEncuentro;
    }

    @Column(name = "puntuacion")
    public String getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "partido")
    public Set<ReservaCancha> getReservaCanchas() {
        return this.reservaCanchas;
    }

    public void setReservaCanchas(Set<ReservaCancha> reservaCanchas) {
        this.reservaCanchas = reservaCanchas;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "partido")
    public Set<co.edu.usbcali.wimbledon.modelo.Set> getSets() {
        return this.sets;
    }

    public void setSets(Set<co.edu.usbcali.wimbledon.modelo.Set> sets) {
        this.sets = sets;
    }
}
