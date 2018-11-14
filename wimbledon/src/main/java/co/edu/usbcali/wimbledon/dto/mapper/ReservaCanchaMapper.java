package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wimbledon.modelo.Cancha;
import co.edu.usbcali.wimbledon.modelo.Partido;
import co.edu.usbcali.wimbledon.modelo.ReservaCancha;
import co.edu.usbcali.wimbledon.modelo.control.ICanchaLogic;
import co.edu.usbcali.wimbledon.modelo.control.IPartidoLogic;
import co.edu.usbcali.wimbledon.modelo.dto.ReservaCanchaDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class ReservaCanchaMapper implements IReservaCanchaMapper {
    private static final Logger log = LoggerFactory.getLogger(ReservaCanchaMapper.class);

    /**
    * Logic injected by Spring that manages Cancha entities
    *
    */
    @Autowired
    ICanchaLogic logicCancha1;

    /**
    * Logic injected by Spring that manages Partido entities
    *
    */
    @Autowired
    IPartidoLogic logicPartido2;

    @Transactional(readOnly = true)
    public ReservaCanchaDTO reservaCanchaToReservaCanchaDTO(
        ReservaCancha reservaCancha) throws Exception {
        try {
            ReservaCanchaDTO reservaCanchaDTO = new ReservaCanchaDTO();

            reservaCanchaDTO.setReservaCanchaId(reservaCancha.getReservaCanchaId());
            reservaCanchaDTO.setFecha(reservaCancha.getFecha());
            reservaCanchaDTO.setCanchaId_Cancha((reservaCancha.getCancha()
                                                              .getCanchaId() != null)
                ? reservaCancha.getCancha().getCanchaId() : null);
            reservaCanchaDTO.setPartidoId_Partido((reservaCancha.getPartido()
                                                                .getPartidoId() != null)
                ? reservaCancha.getPartido().getPartidoId() : null);

            return reservaCanchaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public ReservaCancha reservaCanchaDTOToReservaCancha(
        ReservaCanchaDTO reservaCanchaDTO) throws Exception {
        try {
            ReservaCancha reservaCancha = new ReservaCancha();

            reservaCancha.setReservaCanchaId(reservaCanchaDTO.getReservaCanchaId());
            reservaCancha.setFecha(reservaCanchaDTO.getFecha());

            Cancha cancha = new Cancha();

            if (reservaCanchaDTO.getCanchaId_Cancha() != null) {
                cancha = logicCancha1.getCancha(reservaCanchaDTO.getCanchaId_Cancha());
            }

            if (cancha != null) {
                reservaCancha.setCancha(cancha);
            }

            Partido partido = new Partido();

            if (reservaCanchaDTO.getPartidoId_Partido() != null) {
                partido = logicPartido2.getPartido(reservaCanchaDTO.getPartidoId_Partido());
            }

            if (partido != null) {
                reservaCancha.setPartido(partido);
            }

            return reservaCancha;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ReservaCanchaDTO> listReservaCanchaToListReservaCanchaDTO(
        List<ReservaCancha> listReservaCancha) throws Exception {
        try {
            List<ReservaCanchaDTO> reservaCanchaDTOs = new ArrayList<ReservaCanchaDTO>();

            for (ReservaCancha reservaCancha : listReservaCancha) {
                ReservaCanchaDTO reservaCanchaDTO = reservaCanchaToReservaCanchaDTO(reservaCancha);

                reservaCanchaDTOs.add(reservaCanchaDTO);
            }

            return reservaCanchaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<ReservaCancha> listReservaCanchaDTOToListReservaCancha(
        List<ReservaCanchaDTO> listReservaCanchaDTO) throws Exception {
        try {
            List<ReservaCancha> listReservaCancha = new ArrayList<ReservaCancha>();

            for (ReservaCanchaDTO reservaCanchaDTO : listReservaCanchaDTO) {
                ReservaCancha reservaCancha = reservaCanchaDTOToReservaCancha(reservaCanchaDTO);

                listReservaCancha.add(reservaCancha);
            }

            return listReservaCancha;
        } catch (Exception e) {
            throw e;
        }
    }
}
