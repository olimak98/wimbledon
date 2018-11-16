package co.edu.usbcali.wimbledon.presentation.backingBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.modelo.dto.EquipoDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;

@ManagedBean
@ViewScoped
public class RegistroEquipoATorneoController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	private String nombre;
	
	private Equipo equipo;
	private List<Torneo> torneos;
	

	@PostConstruct
	private void init() {
		try {
			
		} catch (Exception e) {
		}
	}
	
	public void action_inscribirEquipo(Torneo torneo) {
		
	}
	
    public boolean action_validarRegistro(){
    	boolean isValid = true;

    	try {
			if (nombre == null || nombre.trim().equals("")) {
				isValid = false;
			}

			return isValid;
		} catch (Exception e) {
			throw e;
		}
    }

	public void action_buscarEquipo(){
    	try {
    		torneos = new ArrayList<Torneo>();
			if(action_validarRegistro()){
				equipo = businessDelegatorView.buscar(nombre);
				if(equipo == null) {
				}
				else {
					//Buscar torneos disponibles.
					torneos =  businessDelegatorView.listarActivos();
				}
			}
		} catch (Exception e) {
		}
    }

	public void addPoint(EquipoDTO equipo) {
		try {
			
		} catch (Exception e) {
		}
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public List<Torneo> getTorneos() {
		return torneos;
	}

	public void setTorneos(List<Torneo> torneos) {
		this.torneos = torneos;
	}
	
	
}
