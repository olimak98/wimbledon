package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wimbledon.modelo.Cancha;
import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.Juez;
import co.edu.usbcali.wimbledon.modelo.Partido;
import co.edu.usbcali.wimbledon.modelo.Ronda;
import co.edu.usbcali.wimbledon.modelo.control.ICanchaLogic;
import co.edu.usbcali.wimbledon.modelo.control.IEquipoLogic;
import co.edu.usbcali.wimbledon.modelo.control.IJuezLogic;
import co.edu.usbcali.wimbledon.modelo.control.IRondaLogic;
import co.edu.usbcali.wimbledon.modelo.dto.PartidoDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class PartidoMapper implements IPartidoMapper {
    private static final Logger log = LoggerFactory.getLogger(PartidoMapper.class);

    /**
    * Logic injected by Spring that manages Cancha entities
    *
    */
    @Autowired
    ICanchaLogic logicCancha1;

    /**
    * Logic injected by Spring that manages Equipo entities
    *
    */
    @Autowired
    IEquipoLogic logicEquipo;

    /**
    * Logic injected by Spring that manages Juez entities
    *
    */
    @Autowired
    IJuezLogic logicJuez5;

    /**
    * Logic injected by Spring that manages Ronda entities
    *
    */
    @Autowired
    IRondaLogic logicRonda6;

    @Transactional(readOnly = true)
    public PartidoDTO partidoToPartidoDTO(Partido partido)
        throws Exception {
        try {
            PartidoDTO partidoDTO = new PartidoDTO();

            partidoDTO.setPartidoId(partido.getPartidoId());
            partidoDTO.setDuracion((partido.getDuracion() != null)
                ? partido.getDuracion() : null);
            partidoDTO.setEstado((partido.getEstado() != null)
                ? partido.getEstado() : null);
            partidoDTO.setFecha(partido.getFecha());
            partidoDTO.setNumeroEncuentro((partido.getNumeroEncuentro() != null)
                ? partido.getNumeroEncuentro() : null);
            partidoDTO.setPuntuacion((partido.getPuntuacion() != null)
                ? partido.getPuntuacion() : null);
            partidoDTO.setCanchaId_Cancha((partido.getCancha().getCanchaId() != null)
                ? partido.getCancha().getCanchaId() : null);
            partidoDTO.setEquipoId_Equipo1((partido.getEquipoByEquipo1Id().getEquipoId() != null)
                ? partido.getEquipoByEquipo1Id().getEquipoId() : null);
            partidoDTO.setEquipoId_Equipo2((partido.getEquipoByEquipo2Id().getEquipoId() != null)
                    ? partido.getEquipoByEquipo2Id().getEquipoId() : null);
            partidoDTO.setEquipoId_EquipoGanador((partido.getEquipoByEquipoGanadorId().getEquipoId() != null)
                    ? partido.getEquipoByEquipoGanadorId().getEquipoId() : null);
            partidoDTO.setJuezId_Juez((partido.getJuez().getJuezId() != null)
                ? partido.getJuez().getJuezId() : null);
            partidoDTO.setRondaId_Ronda((partido.getRonda().getRondaId() != null)
                ? partido.getRonda().getRondaId() : null);

            return partidoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Partido partidoDTOToPartido(PartidoDTO partidoDTO)
        throws Exception {
        try {
            Partido partido = new Partido();

            partido.setPartidoId(partidoDTO.getPartidoId());
            partido.setDuracion((partidoDTO.getDuracion() != null)
                ? partidoDTO.getDuracion() : null);
            partido.setEstado((partidoDTO.getEstado() != null)
                ? partidoDTO.getEstado() : null);
            partido.setFecha(partidoDTO.getFecha());
            partido.setNumeroEncuentro((partidoDTO.getNumeroEncuentro() != null)
                ? partidoDTO.getNumeroEncuentro() : null);
            partido.setPuntuacion((partidoDTO.getPuntuacion() != null)
                ? partidoDTO.getPuntuacion() : null);

            Cancha cancha = new Cancha();

            if (partidoDTO.getCanchaId_Cancha() != null) {
                cancha = logicCancha1.getCancha(partidoDTO.getCanchaId_Cancha());
            }

            if (cancha != null) {
                partido.setCancha(cancha);
            }

            Equipo equipo1 = new Equipo();

            if (partidoDTO.getEquipoId_Equipo1() != null) {
                equipo1 = logicEquipo.getEquipo(partidoDTO.getEquipoId_Equipo1());
            }

            if (equipo1 != null) {
                partido.setEquipoByEquipo1Id(equipo1);
            }
            
            Equipo equipo2 = new Equipo();

            if (partidoDTO.getEquipoId_Equipo2() != null) {
                equipo2 = logicEquipo.getEquipo(partidoDTO.getEquipoId_Equipo2());
            }

            if (equipo2 != null) {
                partido.setEquipoByEquipo2Id(equipo2);
            }
            
            Equipo equipoGanador = new Equipo();

            if (partidoDTO.getEquipoId_EquipoGanador() != null) {
                equipoGanador = logicEquipo.getEquipo(partidoDTO.getEquipoId_EquipoGanador());
            }

            if (equipoGanador != null) {
                partido.setEquipoByEquipoGanadorId(equipoGanador);
            }

            Juez juez = new Juez();

            if (partidoDTO.getJuezId_Juez() != null) {
                juez = logicJuez5.getJuez(partidoDTO.getJuezId_Juez());
            }

            if (juez != null) {
                partido.setJuez(juez);
            }

            Ronda ronda = new Ronda();

            if (partidoDTO.getRondaId_Ronda() != null) {
                ronda = logicRonda6.getRonda(partidoDTO.getRondaId_Ronda());
            }

            if (ronda != null) {
                partido.setRonda(ronda);
            }

            return partido;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PartidoDTO> listPartidoToListPartidoDTO(
        List<Partido> listPartido) throws Exception {
        try {
            List<PartidoDTO> partidoDTOs = new ArrayList<PartidoDTO>();

            for (Partido partido : listPartido) {
                PartidoDTO partidoDTO = partidoToPartidoDTO(partido);

                partidoDTOs.add(partidoDTO);
            }

            return partidoDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Partido> listPartidoDTOToListPartido(
        List<PartidoDTO> listPartidoDTO) throws Exception {
        try {
            List<Partido> listPartido = new ArrayList<Partido>();

            for (PartidoDTO partidoDTO : listPartidoDTO) {
                Partido partido = partidoDTOToPartido(partidoDTO);

                listPartido.add(partido);
            }

            return listPartido;
        } catch (Exception e) {
            throw e;
        }
    }
}
