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

import co.edu.usbcali.wimbledon.dto.mapper.ISetMapper;
import co.edu.usbcali.wimbledon.modelo.Set;
import co.edu.usbcali.wimbledon.modelo.dto.SetDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;


@RestController
@RequestMapping("/set")
public class SetRestController {
    private static final Logger log = LoggerFactory.getLogger(SetRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private ISetMapper setMapper;

    @PostMapping(value = "/saveSet")
    public void saveSet(@RequestBody
    SetDTO setDTO) throws Exception {
        try {
            Set set = setMapper.setDTOToSet(setDTO);

            businessDelegatorView.saveSet(set);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteSet/{setId}")
    public void deleteSet(@PathVariable("setId")
    Integer setId) throws Exception {
        try {
            Set set = businessDelegatorView.getSet(setId);

            businessDelegatorView.deleteSet(set);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateSet/")
    public void updateSet(@RequestBody
    SetDTO setDTO) throws Exception {
        try {
            Set set = setMapper.setDTOToSet(setDTO);

            businessDelegatorView.updateSet(set);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataSet")
    public List<SetDTO> getDataSet() throws Exception {
        try {
            return businessDelegatorView.getDataSet();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getSet/{setId}")
    public SetDTO getSet(@PathVariable("setId")
    Integer setId) throws Exception {
        try {
            Set set = businessDelegatorView.getSet(setId);

            return setMapper.setToSetDTO(set);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
