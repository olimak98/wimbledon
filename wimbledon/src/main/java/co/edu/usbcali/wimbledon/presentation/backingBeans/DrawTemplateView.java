package co.edu.usbcali.wimbledon.presentation.backingBeans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.Partido;
import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;
import co.edu.usbcali.wimbledon.utilities.FacesUtils;

@ManagedBean
@ViewScoped
public class DrawTemplateView{

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;
	
	private Torneo torneo;
	private List<Equipo[]> encuentros;

	@PostConstruct
	private void init() {
		try {
			torneo = businessDelegatorView.getTorneo(3);
		} catch (Exception e) {
		}
	}
	
	public void createAction() {
		try {
			if(encuentros == null) {
				encuentros = businessDelegatorView.generateDrawTemplate(torneo);				
			}else {
				FacesUtils.addErrorMessage("Ya fue creado el draw template");
			}
		} catch (Exception e) {
			FacesUtils.addErrorMessage(e.getMessage());
		}
		
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

	public Torneo getTorneo() {
		return torneo;
	}

	public void setTorneo(Torneo torneo) {
		this.torneo = torneo;
	}

	public List<Equipo[]> getEncuentros() {
		return encuentros;
	}

	public void setEncuentros(List<Equipo[]> encuentros) {
		this.encuentros = encuentros;
	}
}
