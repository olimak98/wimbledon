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

import co.edu.usbcali.wimbledon.dto.mapper.IDirectorMapper;
import co.edu.usbcali.wimbledon.modelo.Director;
import co.edu.usbcali.wimbledon.modelo.dto.DirectorDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;


@RestController
@RequestMapping("/director")
public class DirectorRestController {
    private static final Logger log = LoggerFactory.getLogger(DirectorRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IDirectorMapper directorMapper;

    @PostMapping(value = "/saveDirector")
    public void saveDirector(@RequestBody
    DirectorDTO directorDTO) throws Exception {
        try {
            Director director = directorMapper.directorDTOToDirector(directorDTO);

            businessDelegatorView.saveDirector(director);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteDirector/{directorId}")
    public void deleteDirector(@PathVariable("directorId")
    Integer directorId) throws Exception {
        try {
            Director director = businessDelegatorView.getDirector(directorId);

            businessDelegatorView.deleteDirector(director);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateDirector/")
    public void updateDirector(@RequestBody
    DirectorDTO directorDTO) throws Exception {
        try {
            Director director = directorMapper.directorDTOToDirector(directorDTO);

            businessDelegatorView.updateDirector(director);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataDirector")
    public List<DirectorDTO> getDataDirector() throws Exception {
        try {
            return businessDelegatorView.getDataDirector();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDirector/{directorId}")
    public DirectorDTO getDirector(
        @PathVariable("directorId")
    Integer directorId) throws Exception {
        try {
            Director director = businessDelegatorView.getDirector(directorId);

            return directorMapper.directorToDirectorDTO(director);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
