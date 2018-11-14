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

import co.edu.usbcali.wimbledon.dto.mapper.IReservaCanchaMapper;
import co.edu.usbcali.wimbledon.modelo.ReservaCancha;
import co.edu.usbcali.wimbledon.modelo.dto.ReservaCanchaDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;


@RestController
@RequestMapping("/reservaCancha")
public class ReservaCanchaRestController {
    private static final Logger log = LoggerFactory.getLogger(ReservaCanchaRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IReservaCanchaMapper reservaCanchaMapper;

    @PostMapping(value = "/saveReservaCancha")
    public void saveReservaCancha(@RequestBody
    ReservaCanchaDTO reservaCanchaDTO) throws Exception {
        try {
            ReservaCancha reservaCancha = reservaCanchaMapper.reservaCanchaDTOToReservaCancha(reservaCanchaDTO);

            businessDelegatorView.saveReservaCancha(reservaCancha);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteReservaCancha/{reservaCanchaId}")
    public void deleteReservaCancha(
        @PathVariable("reservaCanchaId")
    Integer reservaCanchaId) throws Exception {
        try {
            ReservaCancha reservaCancha = businessDelegatorView.getReservaCancha(reservaCanchaId);

            businessDelegatorView.deleteReservaCancha(reservaCancha);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateReservaCancha/")
    public void updateReservaCancha(
        @RequestBody
    ReservaCanchaDTO reservaCanchaDTO) throws Exception {
        try {
            ReservaCancha reservaCancha = reservaCanchaMapper.reservaCanchaDTOToReservaCancha(reservaCanchaDTO);

            businessDelegatorView.updateReservaCancha(reservaCancha);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataReservaCancha")
    public List<ReservaCanchaDTO> getDataReservaCancha()
        throws Exception {
        try {
            return businessDelegatorView.getDataReservaCancha();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getReservaCancha/{reservaCanchaId}")
    public ReservaCanchaDTO getReservaCancha(
        @PathVariable("reservaCanchaId")
    Integer reservaCanchaId) throws Exception {
        try {
            ReservaCancha reservaCancha = businessDelegatorView.getReservaCancha(reservaCanchaId);

            return reservaCanchaMapper.reservaCanchaToReservaCanchaDTO(reservaCancha);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
