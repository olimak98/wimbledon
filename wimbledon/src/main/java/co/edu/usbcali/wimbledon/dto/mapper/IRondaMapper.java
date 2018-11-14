package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Ronda;
import co.edu.usbcali.wimbledon.modelo.dto.RondaDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IRondaMapper {
    public RondaDTO rondaToRondaDTO(Ronda ronda) throws Exception;

    public Ronda rondaDTOToRonda(RondaDTO rondaDTO) throws Exception;

    public List<RondaDTO> listRondaToListRondaDTO(List<Ronda> rondas)
        throws Exception;

    public List<Ronda> listRondaDTOToListRonda(List<RondaDTO> rondaDTOs)
        throws Exception;
}
