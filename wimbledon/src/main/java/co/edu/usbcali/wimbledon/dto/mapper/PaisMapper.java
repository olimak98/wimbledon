package co.edu.usbcali.wimbledon.dto.mapper;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wimbledon.modelo.Pais;
import co.edu.usbcali.wimbledon.modelo.dto.PaisDTO;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Component
@Scope("singleton")
public class PaisMapper implements IPaisMapper {
    private static final Logger log = LoggerFactory.getLogger(PaisMapper.class);

    @Transactional(readOnly = true)
    public PaisDTO paisToPaisDTO(Pais pais) throws Exception {
        try {
            PaisDTO paisDTO = new PaisDTO();

            paisDTO.setPaisId(pais.getPaisId());
            paisDTO.setCodigo((pais.getCodigo() != null) ? pais.getCodigo() : null);
            paisDTO.setNombre((pais.getNombre() != null) ? pais.getNombre() : null);

            return paisDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Pais paisDTOToPais(PaisDTO paisDTO) throws Exception {
        try {
            Pais pais = new Pais();

            pais.setPaisId(paisDTO.getPaisId());
            pais.setCodigo((paisDTO.getCodigo() != null) ? paisDTO.getCodigo()
                                                         : null);
            pais.setNombre((paisDTO.getNombre() != null) ? paisDTO.getNombre()
                                                         : null);

            return pais;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<PaisDTO> listPaisToListPaisDTO(List<Pais> listPais)
        throws Exception {
        try {
            List<PaisDTO> paisDTOs = new ArrayList<PaisDTO>();

            for (Pais pais : listPais) {
                PaisDTO paisDTO = paisToPaisDTO(pais);

                paisDTOs.add(paisDTO);
            }

            return paisDTOs;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Pais> listPaisDTOToListPais(List<PaisDTO> listPaisDTO)
        throws Exception {
        try {
            List<Pais> listPais = new ArrayList<Pais>();

            for (PaisDTO paisDTO : listPaisDTO) {
                Pais pais = paisDTOToPais(paisDTO);

                listPais.add(pais);
            }

            return listPais;
        } catch (Exception e) {
            throw e;
        }
    }
}
