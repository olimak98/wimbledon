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
@Table(name = "set", schema = "public")
public class Set implements java.io.Serializable {
    @NotNull
    private Integer setId;
    @NotNull
    private Equipo equipoByEquipo1Id;
    @NotNull
    private Equipo equipoByEquipo2Id;
    @NotNull
    private Partido partido;
    private Integer puntosEquipo1;
    private Integer puntosEquipo2;

    public Set() {
    }

    public Set(Integer setId, Equipo equipoByEquipo1Id,
        Equipo equipoByEquipo2Id, Partido partido, Integer puntosEquipo1,
        Integer puntosEquipo2) {
        this.setId = setId;
        this.equipoByEquipo1Id = equipoByEquipo1Id;
        this.equipoByEquipo2Id = equipoByEquipo2Id;
        this.partido = partido;
        this.puntosEquipo1 = puntosEquipo1;
        this.puntosEquipo2 = puntosEquipo2;
    }

    @Id
    @Column(name = "set_id", unique = true, nullable = false)
    public Integer getSetId() {
        return this.setId;
    }

    public void setSetId(Integer setId) {
        this.setId = setId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id")
    public Equipo getEquipoByEquipo1Id() {
        return this.equipoByEquipo1Id;
    }

    public void setEquipoByEquipo1Id(Equipo equipoByEquipo1Id) {
        this.equipoByEquipo1Id = equipoByEquipo1Id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id")
    public Equipo getEquipoByEquipo2Id() {
        return this.equipoByEquipo2Id;
    }

    public void setEquipoByEquipo2Id(Equipo equipoByEquipo2Id) {
        this.equipoByEquipo2Id = equipoByEquipo2Id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "partido_id")
    public Partido getPartido() {
        return this.partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    @Column(name = "puntos_equipo1")
    public Integer getPuntosEquipo1() {
        return this.puntosEquipo1;
    }

    public void setPuntosEquipo1(Integer puntosEquipo1) {
        this.puntosEquipo1 = puntosEquipo1;
    }

    @Column(name = "puntos_equipo2")
    public Integer getPuntosEquipo2() {
        return this.puntosEquipo2;
    }

    public void setPuntosEquipo2(Integer puntosEquipo2) {
        this.puntosEquipo2 = puntosEquipo2;
    }
}
