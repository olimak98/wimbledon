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

import co.edu.usbcali.wimbledon.dto.mapper.IRondaMapper;
import co.edu.usbcali.wimbledon.modelo.Ronda;
import co.edu.usbcali.wimbledon.modelo.dto.RondaDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;


@RestController
@RequestMapping("/ronda")
public class RondaRestController {
    private static final Logger log = LoggerFactory.getLogger(RondaRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IRondaMapper rondaMapper;

    @PostMapping(value = "/saveRonda")
    public void saveRonda(@RequestBody
    RondaDTO rondaDTO) throws Exception {
        try {
            Ronda ronda = rondaMapper.rondaDTOToRonda(rondaDTO);

            businessDelegatorView.saveRonda(ronda);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteRonda/{rondaId}")
    public void deleteRonda(@PathVariable("rondaId")
    Integer rondaId) throws Exception {
        try {
            Ronda ronda = businessDelegatorView.getRonda(rondaId);

            businessDelegatorView.deleteRonda(ronda);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateRonda/")
    public void updateRonda(@RequestBody
    RondaDTO rondaDTO) throws Exception {
        try {
            Ronda ronda = rondaMapper.rondaDTOToRonda(rondaDTO);

            businessDelegatorView.updateRonda(ronda);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataRonda")
    public List<RondaDTO> getDataRonda() throws Exception {
        try {
            return businessDelegatorView.getDataRonda();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getRonda/{rondaId}")
    public RondaDTO getRonda(@PathVariable("rondaId")
    Integer rondaId) throws Exception {
        try {
            Ronda ronda = businessDelegatorView.getRonda(rondaId);

            return rondaMapper.rondaToRondaDTO(ronda);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
