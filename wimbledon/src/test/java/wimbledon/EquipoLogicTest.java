package wimbledon;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import co.edu.usbcali.wimbledon.modelo.control.ITorneoLogic;
import co.edu.usbcali.wimbledon.modelo.dto.TorneoDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class EquipoLogicTest {

	private final static Logger log=LoggerFactory.getLogger(EquipoLogicTest.class);
	
	@Autowired
	private ITorneoLogic torneoLogic;
	
	@Test
	@Transactional(readOnly=true)
	public void atest()throws Exception {	
		
		List<TorneoDTO> torneos= torneoLogic.listarActivos();
		for (TorneoDTO torneoDTO : torneos) {
			log.info("El nombre del país es: " + torneoDTO.getNombre() );
			log.info("El nombre del departamento es: " + torneoDTO.getCupos());
		}
				
	}
	
	
}
