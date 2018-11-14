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

import co.edu.usbcali.wimbledon.dto.mapper.ITorneoMapper;
import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.modelo.dto.TorneoDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;


@RestController
@RequestMapping("/torneo")
public class TorneoRestController {
    private static final Logger log = LoggerFactory.getLogger(TorneoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ITorneoMapper torneoMapper;

    @PostMapping(value = "/saveTorneo")
    public void saveTorneo(@RequestBody
    TorneoDTO torneoDTO) throws Exception {
        try {
            Torneo torneo = torneoMapper.torneoDTOToTorneo(torneoDTO);

            businessDelegatorView.saveTorneo(torneo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteTorneo/{torneoId}")
    public void deleteTorneo(@PathVariable("torneoId")
    Integer torneoId) throws Exception {
        try {
            Torneo torneo = businessDelegatorView.getTorneo(torneoId);

            businessDelegatorView.deleteTorneo(torneo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateTorneo/")
    public void updateTorneo(@RequestBody
    TorneoDTO torneoDTO) throws Exception {
        try {
            Torneo torneo = torneoMapper.torneoDTOToTorneo(torneoDTO);

            businessDelegatorView.updateTorneo(torneo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataTorneo")
    public List<TorneoDTO> getDataTorneo() throws Exception {
        try {
            return businessDelegatorView.getDataTorneo();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getTorneo/{torneoId}")
    public TorneoDTO getTorneo(@PathVariable("torneoId")
    Integer torneoId) throws Exception {
        try {
            Torneo torneo = businessDelegatorView.getTorneo(torneoId);

            return torneoMapper.torneoToTorneoDTO(torneo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
