package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Jugador;
import co.edu.usbcali.wimbledon.modelo.dto.JugadorDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IJugadorMapper {
    public JugadorDTO jugadorToJugadorDTO(Jugador jugador)
        throws Exception;

    public Jugador jugadorDTOToJugador(JugadorDTO jugadorDTO)
        throws Exception;

    public List<JugadorDTO> listJugadorToListJugadorDTO(List<Jugador> jugadors)
        throws Exception;

    public List<Jugador> listJugadorDTOToListJugador(
        List<JugadorDTO> jugadorDTOs) throws Exception;
}
