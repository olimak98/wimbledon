package co.edu.usbcali.wimbledon.modelo.dto;

import java.io.Serializable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public class EquipoDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(EquipoDTO.class);
    private Integer equipoId;
    private String estado;
    private String nombre;
    
    private String puntos;
    private Integer set1;
    private Integer set2;
    private Integer set3;

    public Integer getEquipoId() {
        return equipoId;
    }

    public void setEquipoId(Integer equipoId) {
        this.equipoId = equipoId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

	public String getPuntos() {
		return puntos;
	}

	public void setPuntos(String puntos) {
		this.puntos = puntos;
	}

	public Integer getSet1() {
		return set1;
	}

	public void setSet1(Integer set1) {
		this.set1 = set1;
	}

	public Integer getSet2() {
		return set2;
	}

	public void setSet2(Integer set2) {
		this.set2 = set2;
	}

	public Integer getSet3() {
		return set3;
	}

	public void setSet3(Integer set3) {
		this.set3 = set3;
	}
	
	
}
