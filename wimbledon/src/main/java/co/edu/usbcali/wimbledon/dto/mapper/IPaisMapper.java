package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Pais;
import co.edu.usbcali.wimbledon.modelo.dto.PaisDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IPaisMapper {
    public PaisDTO paisToPaisDTO(Pais pais) throws Exception;

    public Pais paisDTOToPais(PaisDTO paisDTO) throws Exception;

    public List<PaisDTO> listPaisToListPaisDTO(List<Pais> paiss)
        throws Exception;

    public List<Pais> listPaisDTOToListPais(List<PaisDTO> paisDTOs)
        throws Exception;
}
