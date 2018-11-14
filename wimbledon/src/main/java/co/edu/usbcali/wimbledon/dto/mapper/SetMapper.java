package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.Partido;
import co.edu.usbcali.wimbledon.modelo.Set;
import co.edu.usbcali.wimbledon.modelo.control.IEquipoLogic;
import co.edu.usbcali.wimbledon.modelo.control.IPartidoLogic;
import co.edu.usbcali.wimbledon.modelo.dto.SetDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class SetMapper implements ISetMapper {
    private static final Logger log = LoggerFactory.getLogger(SetMapper.class);

    /**
    * Logic injected by Spring that manages Equipo entities
    *
    */
    @Autowired
    IEquipoLogic logicEquipo;

    /**
    * Logic injected by Spring that manages Partido entities
    *
    */
    @Autowired
    IPartidoLogic logicPartido3;

    @Transactional(readOnly = true)
    public SetDTO setToSetDTO(Set set) throws Exception {
        try {
            SetDTO setDTO = new SetDTO();

            setDTO.setSetId(set.getSetId());
            setDTO.setPuntosEquipo1((set.getPuntosEquipo1() != null)
                ? set.getPuntosEquipo1() : null);
            setDTO.setPuntosEquipo2((set.getPuntosEquipo2() != null)
                ? set.getPuntosEquipo2() : null);
            setDTO.setEquipoId_Equipo1((set.getEquipoByEquipo1Id().getEquipoId() != null)
                ? set.getEquipoByEquipo1Id().getEquipoId() : null);
            setDTO.setEquipoId_Equipo2((set.getEquipoByEquipo2Id().getEquipoId() != null)
                    ? set.getEquipoByEquipo2Id().getEquipoId() : null);
            setDTO.setPartidoId_Partido((set.getPartido().getPartidoId() != null)
                ? set.getPartido().getPartidoId() : null);

            return setDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Set setDTOToSet(SetDTO setDTO) throws Exception {
        try {
            Set set = new Set();

            set.setSetId(setDTO.getSetId());
            set.setPuntosEquipo1((setDTO.getPuntosEquipo1() != null)
                ? setDTO.getPuntosEquipo1() : null);
            set.setPuntosEquipo2((setDTO.getPuntosEquipo2() != null)
                ? setDTO.getPuntosEquipo2() : null);

            Equipo equipo1 = new Equipo();

            if (setDTO.getEquipoId_Equipo1() != null) {
                equipo1 = logicEquipo.getEquipo(setDTO.getEquipoId_Equipo1());
            }

            if (equipo1 != null) {
                set.setEquipoByEquipo1Id(equipo1);
            }
            
            Equipo equipo2 = new Equipo();

            if (setDTO.getEquipoId_Equipo2() != null) {
                equipo2 = logicEquipo.getEquipo(setDTO.getEquipoId_Equipo2());
            }

            if (equipo2 != null) {
                set.setEquipoByEquipo1Id(equipo2);
            }

            Partido partido = new Partido();

            if (setDTO.getPartidoId_Partido() != null) {
                partido = logicPartido3.getPartido(setDTO.getPartidoId_Partido());
            }

            if (partido != null) {
                set.setPartido(partido);
            }

            return set;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<SetDTO> listSetToListSetDTO(List<Set> listSet)
        throws Exception {
        try {
            List<SetDTO> setDTOs = new ArrayList<SetDTO>();

            for (Set set : listSet) {
                SetDTO setDTO = setToSetDTO(set);

                setDTOs.add(setDTO);
            }

            return setDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Set> listSetDTOToListSet(List<SetDTO> listSetDTO)
        throws Exception {
        try {
            List<Set> listSet = new ArrayList<Set>();

            for (SetDTO setDTO : listSetDTO) {
                Set set = setDTOToSet(setDTO);

                listSet.add(set);
            }

            return listSet;
        } catch (Exception e) {
            throw e;
        }
    }
}
