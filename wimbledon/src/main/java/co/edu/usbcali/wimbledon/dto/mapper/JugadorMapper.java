package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wimbledon.modelo.Jugador;
import co.edu.usbcali.wimbledon.modelo.Persona;
import co.edu.usbcali.wimbledon.modelo.control.IPersonaLogic;
import co.edu.usbcali.wimbledon.modelo.dto.JugadorDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class JugadorMapper implements IJugadorMapper {
    private static final Logger log = LoggerFactory.getLogger(JugadorMapper.class);

    /**
    * Logic injected by Spring that manages Persona entities
    *
    */
    @Autowired
    IPersonaLogic logicPersona1;

    @Transactional(readOnly = true)
    public JugadorDTO jugadorToJugadorDTO(Jugador jugador)
        throws Exception {
        try {
            JugadorDTO jugadorDTO = new JugadorDTO();

            jugadorDTO.setJugadorId(jugador.getJugadorId());
            jugadorDTO.setRanking((jugador.getRanking() != null)
                ? jugador.getRanking() : null);
            jugadorDTO.setPersonaId_Persona((jugador.getPersona().getPersonaId() != null)
                ? jugador.getPersona().getPersonaId() : null);

            return jugadorDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Jugador jugadorDTOToJugador(JugadorDTO jugadorDTO)
        throws Exception {
        try {
            Jugador jugador = new Jugador();

            jugador.setJugadorId(jugadorDTO.getJugadorId());
            jugador.setRanking((jugadorDTO.getRanking() != null)
                ? jugadorDTO.getRanking() : null);

            Persona persona = new Persona();

            if (jugadorDTO.getPersonaId_Persona() != null) {
                persona = logicPersona1.getPersona(jugadorDTO.getPersonaId_Persona());
            }

            if (persona != null) {
                jugador.setPersona(persona);
            }

            return jugador;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<JugadorDTO> listJugadorToListJugadorDTO(
        List<Jugador> listJugador) throws Exception {
        try {
            List<JugadorDTO> jugadorDTOs = new ArrayList<JugadorDTO>();

            for (Jugador jugador : listJugador) {
                JugadorDTO jugadorDTO = jugadorToJugadorDTO(jugador);

                jugadorDTOs.add(jugadorDTO);
            }

            return jugadorDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Jugador> listJugadorDTOToListJugador(
        List<JugadorDTO> listJugadorDTO) throws Exception {
        try {
            List<Jugador> listJugador = new ArrayList<Jugador>();

            for (JugadorDTO jugadorDTO : listJugadorDTO) {
                Jugador jugador = jugadorDTOToJugador(jugadorDTO);

                listJugador.add(jugador);
            }

            return listJugador;
        } catch (Exception e) {
            throw e;
        }
    }
}
