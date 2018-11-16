package co.edu.usbcali.wimbledon.modelo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "cancha", schema = "public")
public class Cancha implements java.io.Serializable {
    private Integer canchaId;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String dimensiones;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String estado;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String nombre;
    @NotNull
    @NotEmpty
    @Size(max = 1)
    private String tipo;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String ubicacion;
    private Set<Partido> partidos = new HashSet<Partido>(0);
    private Set<ReservaCancha> reservaCanchas = new HashSet<ReservaCancha>(0);

    public Cancha() {
    }

    public Cancha(Integer canchaId, String dimensiones, String estado,
        String nombre, Set<Partido> partidos,
        Set<ReservaCancha> reservaCanchas, String tipo, String ubicacion) {
        this.canchaId = canchaId;
        this.dimensiones = dimensiones;
        this.estado = estado;
        this.nombre = nombre;
        this.tipo = tipo;
        this.ubicacion = ubicacion;
        this.partidos = partidos;
        this.reservaCanchas = reservaCanchas;
    }

    @Id
    @Column(name = "cancha_id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getCanchaId() {
        return this.canchaId;
    }

    public void setCanchaId(Integer canchaId) {
        this.canchaId = canchaId;
    }

    @Column(name = "dimensiones", nullable = false)
    public String getDimensiones() {
        return this.dimensiones;
    }

    public void setDimensiones(String dimensiones) {
        this.dimensiones = dimensiones;
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

    @Column(name = "tipo", nullable = false)
    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Column(name = "ubicacion", nullable = false)
    public String getUbicacion() {
        return this.ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cancha")
    public Set<Partido> getPartidos() {
        return this.partidos;
    }

    public void setPartidos(Set<Partido> partidos) {
        this.partidos = partidos;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "cancha")
    public Set<ReservaCancha> getReservaCanchas() {
        return this.reservaCanchas;
    }

    public void setReservaCanchas(Set<ReservaCancha> reservaCanchas) {
        this.reservaCanchas = reservaCanchas;
    }
}
