package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.Jugador;
import co.edu.usbcali.wimbledon.modelo.JugadorEquipo;
import co.edu.usbcali.wimbledon.modelo.control.IEquipoLogic;
import co.edu.usbcali.wimbledon.modelo.control.IJugadorLogic;
import co.edu.usbcali.wimbledon.modelo.dto.JugadorEquipoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class JugadorEquipoMapper implements IJugadorEquipoMapper {
    private static final Logger log = LoggerFactory.getLogger(JugadorEquipoMapper.class);

    /**
    * Logic injected by Spring that manages Equipo entities
    *
    */
    @Autowired
    IEquipoLogic logicEquipo1;

    /**
    * Logic injected by Spring that manages Jugador entities
    *
    */
    @Autowired
    IJugadorLogic logicJugador2;

    @Transactional(readOnly = true)
    public JugadorEquipoDTO jugadorEquipoToJugadorEquipoDTO(
        JugadorEquipo jugadorEquipo) throws Exception {
        try {
            JugadorEquipoDTO jugadorEquipoDTO = new JugadorEquipoDTO();

            jugadorEquipoDTO.setJugadorEquipoId(jugadorEquipo.getJugadorEquipoId());
            jugadorEquipoDTO.setEquipoId_Equipo((jugadorEquipo.getEquipo()
                                                              .getEquipoId() != null)
                ? jugadorEquipo.getEquipo().getEquipoId() : null);
            jugadorEquipoDTO.setJugadorId_Jugador((jugadorEquipo.getJugador()
                                                                .getJugadorId() != null)
                ? jugadorEquipo.getJugador().getJugadorId() : null);

            return jugadorEquipoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public JugadorEquipo jugadorEquipoDTOToJugadorEquipo(
        JugadorEquipoDTO jugadorEquipoDTO) throws Exception {
        try {
            JugadorEquipo jugadorEquipo = new JugadorEquipo();

            jugadorEquipo.setJugadorEquipoId(jugadorEquipoDTO.getJugadorEquipoId());

            Equipo equipo = new Equipo();

            if (jugadorEquipoDTO.getEquipoId_Equipo() != null) {
                equipo = logicEquipo1.getEquipo(jugadorEquipoDTO.getEquipoId_Equipo());
            }

            if (equipo != null) {
                jugadorEquipo.setEquipo(equipo);
            }

            Jugador jugador = new Jugador();

            if (jugadorEquipoDTO.getJugadorId_Jugador() != null) {
                jugador = logicJugador2.getJugador(jugadorEquipoDTO.getJugadorId_Jugador());
            }

            if (jugador != null) {
                jugadorEquipo.setJugador(jugador);
            }

            return jugadorEquipo;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<JugadorEquipoDTO> listJugadorEquipoToListJugadorEquipoDTO(
        List<JugadorEquipo> listJugadorEquipo) throws Exception {
        try {
            List<JugadorEquipoDTO> jugadorEquipoDTOs = new ArrayList<JugadorEquipoDTO>();

            for (JugadorEquipo jugadorEquipo : listJugadorEquipo) {
                JugadorEquipoDTO jugadorEquipoDTO = jugadorEquipoToJugadorEquipoDTO(jugadorEquipo);

                jugadorEquipoDTOs.add(jugadorEquipoDTO);
            }

            return jugadorEquipoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<JugadorEquipo> listJugadorEquipoDTOToListJugadorEquipo(
        List<JugadorEquipoDTO> listJugadorEquipoDTO) throws Exception {
        try {
            List<JugadorEquipo> listJugadorEquipo = new ArrayList<JugadorEquipo>();

            for (JugadorEquipoDTO jugadorEquipoDTO : listJugadorEquipoDTO) {
                JugadorEquipo jugadorEquipo = jugadorEquipoDTOToJugadorEquipo(jugadorEquipoDTO);

                listJugadorEquipo.add(jugadorEquipo);
            }

            return listJugadorEquipo;
        } catch (Exception e) {
            throw e;
        }
    }
}
