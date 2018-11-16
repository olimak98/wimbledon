package co.edu.usbcali.wimbledon.presentation.backingBeans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import co.edu.usbcali.wimbledon.modelo.Cancha;
import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.EquipoTorneo;
import co.edu.usbcali.wimbledon.modelo.Partido;
import co.edu.usbcali.wimbledon.modelo.ReservaCancha;
import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.modelo.dto.EquipoDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.wimbledon.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class AsignarCanchaPartidoController implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	
	private List<Partido> partidos;
	private List<Cancha> canchas;
	
	private Partido partidoSelected;

	@PostConstruct
	private void init() {
		try {
			partidos = businessDelegatorView.listarPendientes();
		} catch (Exception e) {
		}
	}
	
	public void action_buscarCanchas(Partido partido){
		if(partido == null){
			
		}
		else{
			try{
				canchas = businessDelegatorView.buscarDisponibles();
				partidoSelected = partido;
			} catch(Exception e){
			
			}
		}
	}
	
	public void action_asignarCancha(Cancha cancha) {
	
		try {
			ReservaCancha reservaCancha = new ReservaCancha();
			reservaCancha.setCancha(cancha);
			reservaCancha.setFecha(partidoSelected.getFecha());
			reservaCancha.setPartido(partidoSelected);
			businessDelegatorView.asignarCancha(reservaCancha);
			FacesUtils.addInfoMessage("El partido que ha seleccionado se le ha asignado la cancha: " + cancha.getNombre());
		} catch (Exception e) {
		}
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public List<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(List<Partido> partidos) {
		this.partidos = partidos;
	}
	
	public List<Cancha> getCanchas() {
		return canchas;
	}

	public void setCanchas(List<Cancha> canchas) {
		this.canchas = canchas;
	}

}
