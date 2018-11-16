package wimbledon;
import java.util.Date;
import java.util.List;
import java.util.Set;

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

import com.google.common.collect.Lists;

import co.edu.usbcali.wimbledon.modelo.Director;
import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.EquipoTorneo;
import co.edu.usbcali.wimbledon.modelo.Jugador;
import co.edu.usbcali.wimbledon.modelo.JugadorEquipo;
import co.edu.usbcali.wimbledon.modelo.Pais;
import co.edu.usbcali.wimbledon.modelo.Persona;
import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.modelo.control.IDirectorLogic;
import co.edu.usbcali.wimbledon.modelo.control.IEquipoLogic;
import co.edu.usbcali.wimbledon.modelo.control.IEquipoTorneoLogic;
import co.edu.usbcali.wimbledon.modelo.control.IJugadorEquipoLogic;
import co.edu.usbcali.wimbledon.modelo.control.IJugadorLogic;
import co.edu.usbcali.wimbledon.modelo.control.IPaisLogic;
import co.edu.usbcali.wimbledon.modelo.control.IPersonaLogic;
import co.edu.usbcali.wimbledon.modelo.control.ITorneoLogic;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Rollback(false)
public class TorneoLogicTest {
	
	private final static Logger log = LoggerFactory.getLogger(TorneoLogicTest.class);
	
	@Autowired
	private ITorneoLogic torneoLogic;
	
	@Autowired
	private IDirectorLogic directorLogic;
	
	@Autowired
	private IPersonaLogic personaLogic;
	
	@Autowired
	private IPaisLogic paisLogic;
	
	@Autowired
	private IJugadorLogic jugadorLogic;
	
	@Autowired
	private IEquipoLogic equipoLogic;
	
	@Autowired
	private IEquipoTorneoLogic equipoTorneoLogic;
	
	@Autowired
	private IJugadorEquipoLogic jugadorEquipoLogic;


	
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
		director.setEstado("A");
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
	public void btest() {
		try {
			Persona persona = new Persona();
			persona.setFechaNacimiento(new Date());
			persona.setIdentificacion("78569547");
			persona.setNombreCompleto("Máximo Puerta");
			persona.setPais(paisLogic.getPais(1));
			persona.setTipoIdentificacion("Cedula");
			
			personaLogic.savePersona(persona);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void ctest() {
		try {
			Director director = new Director();
			director.setEstado("A");
			director.setPersona(personaLogic.getPersona(2));
			
			directorLogic.saveDirector(director);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void dtest() {
		try {
			Jugador jugador = new Jugador();
			jugador.setPersona(personaLogic.getPersona(9));
			jugador.setRanking(35);
			jugadorLogic.saveJugador(jugador);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void etest() {
		try {
			
			Equipo equipo = new Equipo();
			equipo.setNombre("Sebastián Bejarano");
			equipo.setEstado("A");
			
			equipoLogic.saveEquipo(equipo);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void ftest() {
		try {
			Torneo torneo = new Torneo();
			torneo.setCupos(8);
			torneo.setCuposDisponibles(0);
			torneo.setDirector(directorLogic.getDirector(1));
			torneo.setDraw("Vacio");
			torneo.setEstado("C");
			torneo.setFechaInicio(new Date());
			torneo.setNombre("Wimbledon Mix");
			
			torneoLogic.saveTorneo(torneo);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional(readOnly=false,propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void gtest() {
		try {
			
			torneoLogic.generateDrawTemplate(torneoLogic.getTorneo(3));
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional(readOnly=true)
	public void htest() {
		try {
			
			Torneo t = torneoLogic.getTorneo(3);
			
			Set<EquipoTorneo> equipos = t.getEquipoTorneos();
			for (EquipoTorneo equipoTorneo : equipos) {
				Equipo e = equipoLogic.getEquipo(equipoTorneo.getEquipo().getEquipoId());
				Set<JugadorEquipo> jugadores = e.getJugadorEquipos();
				for (JugadorEquipo jugador : jugadores) {
					Jugador j = jugadorLogic.getJugador(jugador.getJugadorEquipoId());
					log.info(j.getRanking() + "Rank");
				}
			
			}
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	@Test
	@Transactional(readOnly=true)
	public void itest() {
		try {
			
			torneoLogic.generateDrawTemplate(torneoLogic.getTorneo(3));
			
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	

}
