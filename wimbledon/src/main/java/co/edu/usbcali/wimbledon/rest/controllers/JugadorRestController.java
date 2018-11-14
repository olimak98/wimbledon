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

import co.edu.usbcali.wimbledon.dto.mapper.IJugadorMapper;
import co.edu.usbcali.wimbledon.modelo.Jugador;
import co.edu.usbcali.wimbledon.modelo.dto.JugadorDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;


@RestController
@RequestMapping("/jugador")
public class JugadorRestController {
    private static final Logger log = LoggerFactory.getLogger(JugadorRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IJugadorMapper jugadorMapper;

    @PostMapping(value = "/saveJugador")
    public void saveJugador(@RequestBody
    JugadorDTO jugadorDTO) throws Exception {
        try {
            Jugador jugador = jugadorMapper.jugadorDTOToJugador(jugadorDTO);

            businessDelegatorView.saveJugador(jugador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteJugador/{jugadorId}")
    public void deleteJugador(@PathVariable("jugadorId")
    Integer jugadorId) throws Exception {
        try {
            Jugador jugador = businessDelegatorView.getJugador(jugadorId);

            businessDelegatorView.deleteJugador(jugador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateJugador/")
    public void updateJugador(@RequestBody
    JugadorDTO jugadorDTO) throws Exception {
        try {
            Jugador jugador = jugadorMapper.jugadorDTOToJugador(jugadorDTO);

            businessDelegatorView.updateJugador(jugador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataJugador")
    public List<JugadorDTO> getDataJugador() throws Exception {
        try {
            return businessDelegatorView.getDataJugador();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getJugador/{jugadorId}")
    public JugadorDTO getJugador(@PathVariable("jugadorId")
    Integer jugadorId) throws Exception {
        try {
            Jugador jugador = businessDelegatorView.getJugador(jugadorId);

            return jugadorMapper.jugadorToJugadorDTO(jugador);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
