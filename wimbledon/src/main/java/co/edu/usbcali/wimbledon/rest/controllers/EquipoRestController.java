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

import co.edu.usbcali.wimbledon.dto.mapper.IEquipoMapper;
import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.dto.EquipoDTO;
import co.edu.usbcali.wimbledon.presentation.businessDelegate.IBusinessDelegatorView;


@RestController
@RequestMapping("/equipo")
public class EquipoRestController {
    private static final Logger log = LoggerFactory.getLogger(EquipoRestController.class);
    @Autowired
    private IBusinessDelegatorView businessDelegatorView;
    @Autowired
    private IEquipoMapper equipoMapper;

    @PostMapping(value = "/saveEquipo")
    public void saveEquipo(@RequestBody
    EquipoDTO equipoDTO) throws Exception {
        try {
            Equipo equipo = equipoMapper.equipoDTOToEquipo(equipoDTO);

            businessDelegatorView.saveEquipo(equipo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @DeleteMapping(value = "/deleteEquipo/{equipoId}")
    public void deleteEquipo(@PathVariable("equipoId")
    Integer equipoId) throws Exception {
        try {
            Equipo equipo = businessDelegatorView.getEquipo(equipoId);

            businessDelegatorView.deleteEquipo(equipo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @PutMapping(value = "/updateEquipo/")
    public void updateEquipo(@RequestBody
    EquipoDTO equipoDTO) throws Exception {
        try {
            Equipo equipo = equipoMapper.equipoDTOToEquipo(equipoDTO);

            businessDelegatorView.updateEquipo(equipo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getDataEquipo")
    public List<EquipoDTO> getDataEquipo() throws Exception {
        try {
            return businessDelegatorView.getDataEquipo();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw e;
        }
    }

    @GetMapping(value = "/getEquipo/{equipoId}")
    public EquipoDTO getEquipo(@PathVariable("equipoId")
    Integer equipoId) throws Exception {
        try {
            Equipo equipo = businessDelegatorView.getEquipo(equipoId);

            return equipoMapper.equipoToEquipoDTO(equipo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        return null;
    }
}
