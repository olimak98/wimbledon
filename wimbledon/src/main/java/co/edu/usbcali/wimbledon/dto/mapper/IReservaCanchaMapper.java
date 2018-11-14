package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.ReservaCancha;
import co.edu.usbcali.wimbledon.modelo.dto.ReservaCanchaDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IReservaCanchaMapper {
    public ReservaCanchaDTO reservaCanchaToReservaCanchaDTO(
        ReservaCancha reservaCancha) throws Exception;

    public ReservaCancha reservaCanchaDTOToReservaCancha(
        ReservaCanchaDTO reservaCanchaDTO) throws Exception;

    public List<ReservaCanchaDTO> listReservaCanchaToListReservaCanchaDTO(
        List<ReservaCancha> reservaCanchas) throws Exception;

    public List<ReservaCancha> listReservaCanchaDTOToListReservaCancha(
        List<ReservaCanchaDTO> reservaCanchaDTOs) throws Exception;
}
