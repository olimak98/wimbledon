package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Set;
import co.edu.usbcali.wimbledon.modelo.dto.SetDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface ISetMapper {
    public SetDTO setToSetDTO(Set set) throws Exception;

    public Set setDTOToSet(SetDTO setDTO) throws Exception;

    public List<SetDTO> listSetToListSetDTO(List<Set> sets)
        throws Exception;

    public List<Set> listSetDTOToListSet(List<SetDTO> setDTOs)
        throws Exception;
}
