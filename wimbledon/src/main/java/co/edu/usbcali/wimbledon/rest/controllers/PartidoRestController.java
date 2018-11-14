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

import co.edu.usbcali.wimbledon.dto.mapper.IPartidoMapper;
import co.edu.usbcali.wimbledon.modelo.Partido;
import co.edu.usbcali.wimbledon.modelo.dto.PartidoDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;


@RestController
@RequestMapping("/partido")
public class PartidoRestController {
    private static final Logger log = LoggerFactory.getLogger(PartidoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IPartidoMapper partidoMapper;

    @PostMapping(value = "/savePartido")
    public void savePartido(@RequestBody
    PartidoDTO partidoDTO) throws Exception {
        try {
            Partido partido = partidoMapper.partidoDTOToPartido(partidoDTO);

            businessDelegatorView.savePartido(partido);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deletePartido/{partidoId}")
    public void deletePartido(@PathVariable("partidoId")
    Integer partidoId) throws Exception {
        try {
            Partido partido = businessDelegatorView.getPartido(partidoId);

            businessDelegatorView.deletePartido(partido);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updatePartido/")
    public void updatePartido(@RequestBody
    PartidoDTO partidoDTO) throws Exception {
        try {
            Partido partido = partidoMapper.partidoDTOToPartido(partidoDTO);

            businessDelegatorView.updatePartido(partido);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataPartido")
    public List<PartidoDTO> getDataPartido() throws Exception {
        try {
            return businessDelegatorView.getDataPartido();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getPartido/{partidoId}")
    public PartidoDTO getPartido(@PathVariable("partidoId")
    Integer partidoId) throws Exception {
        try {
            Partido partido = businessDelegatorView.getPartido(partidoId);

            return partidoMapper.partidoToPartidoDTO(partido);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
