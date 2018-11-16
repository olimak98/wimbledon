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
@Table(name = "pais", schema = "public")
public class Pais implements java.io.Serializable {
    private Integer paisId;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String codigo;
    @NotNull
    @NotEmpty
    @Size(max = 225)
    private String nombre;
    private Set<Persona> personas = new HashSet<Persona>(0);

    public Pais() {
    }

    public Pais(Integer paisId, String codigo, String nombre,
        Set<Persona> personas) {
        this.paisId = paisId;
        this.codigo = codigo;
        this.nombre = nombre;
        this.personas = personas;
    }

    @Id
    @Column(name = "pais_id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getPaisId() {
        return this.paisId;
    }

    public void setPaisId(Integer paisId) {
        this.paisId = paisId;
    }

    @Column(name = "codigo", nullable = false)
    public String getCodigo() {
        return this.codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Column(name = "nombre", nullable = false)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pais")
    public Set<Persona> getPersonas() {
        return this.personas;
    }

    public void setPersonas(Set<Persona> personas) {
        this.personas = personas;
    }
}
