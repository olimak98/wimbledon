package co.edu.usbcali.wimbledon.presentation.backingBeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;

import co.edu.usbcali.wimbledon.modelo.Partido;
import co.edu.usbcali.wimbledon.modelo.dto.EquipoDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;

@ManagedBean
@ViewScoped
public class PuntuarView {

	@ManagedProperty(value = "#{BusinessDelegatorView}")
	private IBusinessDelegatorView businessDelegatorView;

	private List<EquipoDTO> equipos;
	private Partido partido;

	@PostConstruct
	private void init() {
		try {
			partido = businessDelegatorView.getPartido(1);
		} catch (Exception e) {
		}
	}

	public List<EquipoDTO> getEquipos() {
		try {

			if (equipos == null) {
				equipos = new ArrayList<EquipoDTO>();
				equipos.add(businessDelegatorView.getEquipoDTOByPartido(partido.getEquipoByEquipo1Id().getEquipoId(),
						partido.getPartidoId()));
				equipos.add(businessDelegatorView.getEquipoDTOByPartido(partido.getEquipoByEquipo2Id().getEquipoId(),
						partido.getPartidoId()));
			}

		} catch (Exception e) {
		}
		return equipos;
	}

	public void addPoint(EquipoDTO equipo) {
		try {
			if (equipos.get(0).getEquipoId().equals(equipo.getEquipoId())) {
				equipos = businessDelegatorView.darPunto(equipo, equipos.get(1), partido);
			} else if (equipos.get(1).getEquipoId().equals(equipo.getEquipoId())) {
				equipos = businessDelegatorView.darPunto(equipo, equipos.get(0), partido);
			}
		} catch (Exception e) {
		}
	}

	public void setEquipos(List<EquipoDTO> equipos) {
		this.equipos = equipos;
	}

	public IBusinessDelegatorView getBusinessDelegatorView() {
		return businessDelegatorView;
	}

	public void setBusinessDelegatorView(IBusinessDelegatorView businessDelegatorView) {
		this.businessDelegatorView = businessDelegatorView;
	}

}
