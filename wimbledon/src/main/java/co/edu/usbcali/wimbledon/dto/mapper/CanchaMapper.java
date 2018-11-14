package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wimbledon.modelo.Cancha;
import co.edu.usbcali.wimbledon.modelo.dto.CanchaDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class CanchaMapper implements ICanchaMapper {
    private static final Logger log = LoggerFactory.getLogger(CanchaMapper.class);

    @Transactional(readOnly = true)
    public CanchaDTO canchaToCanchaDTO(Cancha cancha) throws Exception {
        try {
            CanchaDTO canchaDTO = new CanchaDTO();

            canchaDTO.setCanchaId(cancha.getCanchaId());
            canchaDTO.setDimensiones((cancha.getDimensiones() != null)
                ? cancha.getDimensiones() : null);
            canchaDTO.setEstado((cancha.getEstado() != null)
                ? cancha.getEstado() : null);
            canchaDTO.setNombre((cancha.getNombre() != null)
                ? cancha.getNombre() : null);
            canchaDTO.setTipo((cancha.getTipo() != null) ? cancha.getTipo() : null);
            canchaDTO.setUbicacion((cancha.getUbicacion() != null)
                ? cancha.getUbicacion() : null);

            return canchaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Cancha canchaDTOToCancha(CanchaDTO canchaDTO)
        throws Exception {
        try {
            Cancha cancha = new Cancha();

            cancha.setCanchaId(canchaDTO.getCanchaId());
            cancha.setDimensiones((canchaDTO.getDimensiones() != null)
                ? canchaDTO.getDimensiones() : null);
            cancha.setEstado((canchaDTO.getEstado() != null)
                ? canchaDTO.getEstado() : null);
            cancha.setNombre((canchaDTO.getNombre() != null)
                ? canchaDTO.getNombre() : null);
            cancha.setTipo((canchaDTO.getTipo() != null) ? canchaDTO.getTipo()
                                                         : null);
            cancha.setUbicacion((canchaDTO.getUbicacion() != null)
                ? canchaDTO.getUbicacion() : null);

            return cancha;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<CanchaDTO> listCanchaToListCanchaDTO(List<Cancha> listCancha)
        throws Exception {
        try {
            List<CanchaDTO> canchaDTOs = new ArrayList<CanchaDTO>();

            for (Cancha cancha : listCancha) {
                CanchaDTO canchaDTO = canchaToCanchaDTO(cancha);

                canchaDTOs.add(canchaDTO);
            }

            return canchaDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Cancha> listCanchaDTOToListCancha(List<CanchaDTO> listCanchaDTO)
        throws Exception {
        try {
            List<Cancha> listCancha = new ArrayList<Cancha>();

            for (CanchaDTO canchaDTO : listCanchaDTO) {
                Cancha cancha = canchaDTOToCancha(canchaDTO);

                listCancha.add(cancha);
            }

            return listCancha;
        } catch (Exception e) {
            throw e;
        }
    }
}
