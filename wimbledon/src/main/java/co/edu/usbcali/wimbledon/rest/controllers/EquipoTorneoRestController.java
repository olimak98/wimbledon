package co.edu.usbcali.wimbledon.rest.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.usbcali.wimbledon.dto.mapper.IEquipoTorneoMapper;
import co.edu.usbcali.wimbledon.modelo.EquipoTorneo;
import co.edu.usbcali.wimbledon.modelo.dto.EquipoTorneoDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;


@RestController
@RequestMapping("/equipoTorneo")
public class EquipoTorneoRestController {
    private static final Logger log = LoggerFactory.getLogger(EquipoTorneoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IEquipoTorneoMapper equipoTorneoMapper;

    @PostMapping(value = "/saveEquipoTorneo")
    public void saveEquipoTorneo(@RequestBody
    EquipoTorneoDTO equipoTorneoDTO) throws Exception {
        try {
            EquipoTorneo equipoTorneo = equipoTorneoMapper.equipoTorneoDTOToEquipoTorneo(equipoTorneoDTO);

            businessDelegatorView.saveEquipoTorneo(equipoTorneo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteEquipoTorneo/{equipoTorneoId}")
    public void deleteEquipoTorneo(
        @PathVariable("equipoTorneoId")
    Integer equipoTorneoId) throws Exception {
        try {
            EquipoTorneo equipoTorneo = businessDelegatorView.getEquipoTorneo(equipoTorneoId);

            businessDelegatorView.deleteEquipoTorneo(equipoTorneo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateEquipoTorneo/")
    public void updateEquipoTorneo(@RequestBody
    EquipoTorneoDTO equipoTorneoDTO) throws Exception {
        try {
            EquipoTorneo equipoTorneo = equipoTorneoMapper.equipoTorneoDTOToEquipoTorneo(equipoTorneoDTO);

            businessDelegatorView.updateEquipoTorneo(equipoTorneo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataEquipoTorneo")
    public List<EquipoTorneoDTO> getDataEquipoTorneo()
        throws Exception {
        try {
            return businessDelegatorView.getDataEquipoTorneo();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getEquipoTorneo/{equipoTorneoId}")
    public EquipoTorneoDTO getEquipoTorneo(
        @PathVariable("equipoTorneoId")
    Integer equipoTorneoId) throws Exception {
        try {
            EquipoTorneo equipoTorneo = businessDelegatorView.getEquipoTorneo(equipoTorneoId);

            return equipoTorneoMapper.equipoTorneoToEquipoTorneoDTO(equipoTorneo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
