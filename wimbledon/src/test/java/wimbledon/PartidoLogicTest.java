package wimbledon;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wimbledon.dto.mapper.IEquipoMapper;
import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.Jugador;
import co.edu.usbcali.wimbledon.modelo.Partido;
import co.edu.usbcali.wimbledon.modelo.Persona;
import co.edu.usbcali.wimbledon.modelo.Set;
import co.edu.usbcali.wimbledon.modelo.control.IEquipoLogic;
import co.edu.usbcali.wimbledon.modelo.control.IJugadorLogic;
import co.edu.usbcali.wimbledon.modelo.control.IPartidoLogic;
import co.edu.usbcali.wimbledon.modelo.control.ISetLogic;
import co.edu.usbcali.wimbledon.modelo.dto.EquipoDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class PartidoLogicTest {
	private static final Logger log = LoggerFactory.getLogger(PartidoLogicTest.class);
	
	@Autowired
	IEquipoLogic equipoLogic;
	
	@Autowired
	IEquipoMapper equipoMapper;
	
	@Autowired
	IPartidoLogic partidoLogic;
	
	@Autowired
	ISetLogic setLogic;
	
	@Test
	@Transactional(readOnly=false, propagation=Propagation.REQUIRED, rollbackFor=Exception.class)
	public void asignarPunto(){
		try {
			Equipo equipo1 = equipoLogic.getEquipo(1);
			Equipo equipo2 = equipoLogic.getEquipo(2);
			
			EquipoDTO equipo1DTO = equipoMapper.equipoToEquipoDTO(equipo1);
			EquipoDTO equipo2DTO = equipoMapper.equipoToEquipoDTO(equipo2);
			
			Set set = setLogic.getSet(1);
			
			equipo1DTO.setPuntos("40");
			equipo2DTO.setPuntos("Adv");
			
			List<EquipoDTO> equipos = partidoLogic.darPunto(equipo1DTO, equipo2DTO, set);
			equipo1DTO = equipos.get(0);
			equipo2DTO = equipos.get(1);
			
			log.info(equipo1DTO.getPuntos());
			log.info(equipo2DTO.getPuntos());
			
		} catch (Exception e) {
			fail(e.getMessage());
		}
	}


}
