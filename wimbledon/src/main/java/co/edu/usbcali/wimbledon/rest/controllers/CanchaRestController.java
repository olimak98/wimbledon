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

import co.edu.usbcali.wimbledon.dto.mapper.ICanchaMapper;
import co.edu.usbcali.wimbledon.modelo.Cancha;
import co.edu.usbcali.wimbledon.modelo.dto.CanchaDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;


@RestController
@RequestMapping("/cancha")
public class CanchaRestController {
    private static final Logger log = LoggerFactory.getLogger(CanchaRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ICanchaMapper canchaMapper;

    @PostMapping(value = "/saveCancha")
    public void saveCancha(@RequestBody
    CanchaDTO canchaDTO) throws Exception {
        try {
            Cancha cancha = canchaMapper.canchaDTOToCancha(canchaDTO);

            businessDelegatorView.saveCancha(cancha);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteCancha/{canchaId}")
    public void deleteCancha(@PathVariable("canchaId")
    Integer canchaId) throws Exception {
        try {
            Cancha cancha = businessDelegatorView.getCancha(canchaId);

            businessDelegatorView.deleteCancha(cancha);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateCancha/")
    public void updateCancha(@RequestBody
    CanchaDTO canchaDTO) throws Exception {
        try {
            Cancha cancha = canchaMapper.canchaDTOToCancha(canchaDTO);

            businessDelegatorView.updateCancha(cancha);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataCancha")
    public List<CanchaDTO> getDataCancha() throws Exception {
        try {
            return businessDelegatorView.getDataCancha();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getCancha/{canchaId}")
    public CanchaDTO getCancha(@PathVariable("canchaId")
    Integer canchaId) throws Exception {
        try {
            Cancha cancha = businessDelegatorView.getCancha(canchaId);

            return canchaMapper.canchaToCanchaDTO(cancha);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
