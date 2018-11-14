package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.List;

import co.edu.usbcali.wimbledon.modelo.Director;
import co.edu.usbcali.wimbledon.modelo.dto.DirectorDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IDirectorMapper {
    public DirectorDTO directorToDirectorDTO(Director director)
        throws Exception;

    public Director directorDTOToDirector(DirectorDTO directorDTO)
        throws Exception;

    public List<DirectorDTO> listDirectorToListDirectorDTO(
        List<Director> directors) throws Exception;

    public List<Director> listDirectorDTOToListDirector(
        List<DirectorDTO> directorDTOs) throws Exception;
}
