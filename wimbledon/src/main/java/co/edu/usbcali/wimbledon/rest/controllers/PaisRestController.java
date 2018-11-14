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

import co.edu.usbcali.wimbledon.dto.mapper.IPaisMapper;
import co.edu.usbcali.wimbledon.modelo.Pais;
import co.edu.usbcali.wimbledon.modelo.dto.PaisDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;


@RestController
@RequestMapping("/pais")
public class PaisRestController {
    private static final Logger log = LoggerFactory.getLogger(PaisRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IPaisMapper paisMapper;

    @PostMapping(value = "/savePais")
    public void savePais(@RequestBody
    PaisDTO paisDTO) throws Exception {
        try {
            Pais pais = paisMapper.paisDTOToPais(paisDTO);

            businessDelegatorView.savePais(pais);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deletePais/{paisId}")
    public void deletePais(@PathVariable("paisId")
    Integer paisId) throws Exception {
        try {
            Pais pais = businessDelegatorView.getPais(paisId);

            businessDelegatorView.deletePais(pais);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updatePais/")
    public void updatePais(@RequestBody
    PaisDTO paisDTO) throws Exception {
        try {
            Pais pais = paisMapper.paisDTOToPais(paisDTO);

            businessDelegatorView.updatePais(pais);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataPais")
    public List<PaisDTO> getDataPais() throws Exception {
        try {
            return businessDelegatorView.getDataPais();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getPais/{paisId}")
    public PaisDTO getPais(@PathVariable("paisId")
    Integer paisId) throws Exception {
        try {
            Pais pais = businessDelegatorView.getPais(paisId);

            return paisMapper.paisToPaisDTO(pais);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
