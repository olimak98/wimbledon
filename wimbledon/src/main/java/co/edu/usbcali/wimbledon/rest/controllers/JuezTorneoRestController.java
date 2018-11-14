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

import co.edu.usbcali.wimbledon.dto.mapper.IJuezTorneoMapper;
import co.edu.usbcali.wimbledon.modelo.JuezTorneo;
import co.edu.usbcali.wimbledon.modelo.dto.JuezTorneoDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;


@RestController
@RequestMapping("/juezTorneo")
public class JuezTorneoRestController {
    private static final Logger log = LoggerFactory.getLogger(JuezTorneoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IJuezTorneoMapper juezTorneoMapper;

    @PostMapping(value = "/saveJuezTorneo")
    public void saveJuezTorneo(@RequestBody
    JuezTorneoDTO juezTorneoDTO) throws Exception {
        try {
            JuezTorneo juezTorneo = juezTorneoMapper.juezTorneoDTOToJuezTorneo(juezTorneoDTO);

            businessDelegatorView.saveJuezTorneo(juezTorneo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteJuezTorneo/{juezTorneoId}")
    public void deleteJuezTorneo(
        @PathVariable("juezTorneoId")
    Integer juezTorneoId) throws Exception {
        try {
            JuezTorneo juezTorneo = businessDelegatorView.getJuezTorneo(juezTorneoId);

            businessDelegatorView.deleteJuezTorneo(juezTorneo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateJuezTorneo/")
    public void updateJuezTorneo(@RequestBody
    JuezTorneoDTO juezTorneoDTO) throws Exception {
        try {
            JuezTorneo juezTorneo = juezTorneoMapper.juezTorneoDTOToJuezTorneo(juezTorneoDTO);

            businessDelegatorView.updateJuezTorneo(juezTorneo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataJuezTorneo")
    public List<JuezTorneoDTO> getDataJuezTorneo() throws Exception {
        try {
            return businessDelegatorView.getDataJuezTorneo();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getJuezTorneo/{juezTorneoId}")
    public JuezTorneoDTO getJuezTorneo(
        @PathVariable("juezTorneoId")
    Integer juezTorneoId) throws Exception {
        try {
            JuezTorneo juezTorneo = businessDelegatorView.getJuezTorneo(juezTorneoId);

            return juezTorneoMapper.juezTorneoToJuezTorneoDTO(juezTorneo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
