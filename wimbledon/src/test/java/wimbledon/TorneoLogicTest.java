package wimbledon;

import static org.junit.Assert.*;

import java.util.Date;
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

import co.edu.usbcali.wimbledon.dataaccess.dao.IDirectorDAO;
import co.edu.usbcali.wimbledon.modelo.Director;
import co.edu.usbcali.wimbledon.modelo.Pais;
import co.edu.usbcali.wimbledon.modelo.Persona;
import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.modelo.control.IDirectorLogic;
import co.edu.usbcali.wimbledon.modelo.control.ITorneoLogic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class TorneoLogicTest {
	
	private final static Logger log = LoggerFactory.getLogger(TorneoLogicTest.class);
	
	@Autowired
	private ITorneoLogic torneoLogic;
	
	@Autowired
	private IDirectorLogic directorLogic;
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void atest() {
		
		Persona persona = new Persona();
		persona.setFechaNacimiento(new Date());
		persona.setIdentificacion("1144097420");
		persona.setNombreCompleto("Jorge García");
		Pais pais = new Pais();
		pais.setCodigo("57");
		pais.setNombre("Colombia");
		persona.setPais(pais);
		persona.setTipoIdentificacion("Cedula");
		
		Director director = new Director();
		director.setEstado("Activo");
		director.setPersona(persona);
		
		try {
			directorLogic.saveDirector(director);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void test() {
		try {
			List<Torneo> torneos = torneoLogic.getTorneo();
			if(torneos.isEmpty()) {
				Torneo torneo = new Torneo();
				torneo.setCupos(32);
				torneo.setCuposDisponibles(32);
				//torneo.setDirector();
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
