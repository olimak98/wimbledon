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

import co.edu.usbcali.wimbledon.dto.mapper.IJuezMapper;
import co.edu.usbcali.wimbledon.modelo.Juez;
import co.edu.usbcali.wimbledon.modelo.dto.JuezDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;


@RestController
@RequestMapping("/juez")
public class JuezRestController {
    private static final Logger log = LoggerFactory.getLogger(JuezRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IJuezMapper juezMapper;

    @PostMapping(value = "/saveJuez")
    public void saveJuez(@RequestBody
    JuezDTO juezDTO) throws Exception {
        try {
            Juez juez = juezMapper.juezDTOToJuez(juezDTO);

            businessDelegatorView.saveJuez(juez);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteJuez/{juezId}")
    public void deleteJuez(@PathVariable("juezId")
    Integer juezId) throws Exception {
        try {
            Juez juez = businessDelegatorView.getJuez(juezId);

            businessDelegatorView.deleteJuez(juez);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateJuez/")
    public void updateJuez(@RequestBody
    JuezDTO juezDTO) throws Exception {
        try {
            Juez juez = juezMapper.juezDTOToJuez(juezDTO);

            businessDelegatorView.updateJuez(juez);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataJuez")
    public List<JuezDTO> getDataJuez() throws Exception {
        try {
            return businessDelegatorView.getDataJuez();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getJuez/{juezId}")
    public JuezDTO getJuez(@PathVariable("juezId")
    Integer juezId) throws Exception {
        try {
            Juez juez = businessDelegatorView.getJuez(juezId);

            return juezMapper.juezToJuezDTO(juez);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
