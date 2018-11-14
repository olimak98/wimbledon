package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Cancha;
import co.edu.usbcali.wimbledon.modelo.dto.CanchaDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ICanchaMapper {
    public CanchaDTO canchaToCanchaDTO(Cancha cancha) throws Exception;

    public Cancha canchaDTOToCancha(CanchaDTO canchaDTO)
        throws Exception;

    public List<CanchaDTO> listCanchaToListCanchaDTO(List<Cancha> canchas)
        throws Exception;

    public List<Cancha> listCanchaDTOToListCancha(List<CanchaDTO> canchaDTOs)
        throws Exception;
}
