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

import co.edu.usbcali.wimbledon.dto.mapper.IJugadorEquipoMapper;
import co.edu.usbcali.wimbledon.modelo.JugadorEquipo;
import co.edu.usbcali.wimbledon.modelo.dto.JugadorEquipoDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;


@RestController
@RequestMapping("/jugadorEquipo")
public class JugadorEquipoRestController {
    private static final Logger log = LoggerFactory.getLogger(JugadorEquipoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IJugadorEquipoMapper jugadorEquipoMapper;

    @PostMapping(value = "/saveJugadorEquipo")
    public void saveJugadorEquipo(@RequestBody
    JugadorEquipoDTO jugadorEquipoDTO) throws Exception {
        try {
            JugadorEquipo jugadorEquipo = jugadorEquipoMapper.jugadorEquipoDTOToJugadorEquipo(jugadorEquipoDTO);

            businessDelegatorView.saveJugadorEquipo(jugadorEquipo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteJugadorEquipo/{jugadorEquipoId}")
    public void deleteJugadorEquipo(
        @PathVariable("jugadorEquipoId")
    Integer jugadorEquipoId) throws Exception {
        try {
            JugadorEquipo jugadorEquipo = businessDelegatorView.getJugadorEquipo(jugadorEquipoId);

            businessDelegatorView.deleteJugadorEquipo(jugadorEquipo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateJugadorEquipo/")
    public void updateJugadorEquipo(
        @RequestBody
    JugadorEquipoDTO jugadorEquipoDTO) throws Exception {
        try {
            JugadorEquipo jugadorEquipo = jugadorEquipoMapper.jugadorEquipoDTOToJugadorEquipo(jugadorEquipoDTO);

            businessDelegatorView.updateJugadorEquipo(jugadorEquipo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataJugadorEquipo")
    public List<JugadorEquipoDTO> getDataJugadorEquipo()
        throws Exception {
        try {
            return businessDelegatorView.getDataJugadorEquipo();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getJugadorEquipo/{jugadorEquipoId}")
    public JugadorEquipoDTO getJugadorEquipo(
        @PathVariable("jugadorEquipoId")
    Integer jugadorEquipoId) throws Exception {
        try {
            JugadorEquipo jugadorEquipo = businessDelegatorView.getJugadorEquipo(jugadorEquipoId);

            return jugadorEquipoMapper.jugadorEquipoToJugadorEquipoDTO(jugadorEquipo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
