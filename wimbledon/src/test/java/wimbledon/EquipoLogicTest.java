package wimbledon;

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

import co.edu.usbcali.wimbledon.modelo.Cancha;
import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.EquipoTorneo;
import co.edu.usbcali.wimbledon.modelo.Partido;
import co.edu.usbcali.wimbledon.modelo.ReservaCancha;
import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.modelo.control.ICanchaLogic;
import co.edu.usbcali.wimbledon.modelo.control.IEquipoLogic;
import co.edu.usbcali.wimbledon.modelo.control.IEquipoTorneoLogic;
import co.edu.usbcali.wimbledon.modelo.control.IPartidoLogic;
import co.edu.usbcali.wimbledon.modelo.control.ITorneoLogic;
import co.edu.usbcali.wimbledon.modelo.dto.TorneoDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
@Rollback(false)
public class EquipoLogicTest {

	private final static Logger log=LoggerFactory.getLogger(EquipoLogicTest.class);
	
	@Autowired
	private ITorneoLogic torneoLogic;
	
	@Autowired
	private IEquipoLogic equipoLogic;
	
	@Autowired
	private IEquipoTorneoLogic equipoTorneoLogic;
	
	@Autowired
	private IPartidoLogic partidoLogic;
	
	@Autowired
	private ICanchaLogic canchaLogic;
	
	@Test
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, noRollbackFor=Exception.class)
	public void atest()throws Exception {	
		
		List<Torneo> torneos= torneoLogic.listarActivos();
		for (Torneo torneoDTO : torneos) {
			log.info("El nombre del país es: " + torneoDTO.getNombre() );
			log.info("El nombre del departamento es: " + torneoDTO.getCupos());
		}
	}
	
	@Test
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, noRollbackFor=Exception.class)
	public void btest()throws Exception {	
		
		Equipo equipo= equipoLogic.buscar("Alejo");
			log.info("El nombre del país es: " + equipo.getNombre() );
			log.info("El nombre del departamento es: " + equipo.getEstado());
	}
	
	@Test
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, noRollbackFor=Exception.class)
	public void ctest()throws Exception {	
		
		EquipoTorneo equipoTorneo = new EquipoTorneo();
		Equipo equipo = equipoLogic.getEquipo(1);
		Torneo torneo = torneoLogic.getTorneo(1);
		equipoTorneo.setEquipo(equipo);		
		equipoTorneo.setTorneo(torneo);
		
		//torneoLogic.inscribirEquipo(equipoTorneo);
	}
	
	@Test
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, noRollbackFor=Exception.class)
	public void dtest()throws Exception {	
		List<Partido> partidoPen= partidoLogic.listarPendientes();
		for (Partido partidoDTO : partidoPen) {
			log.info("El nombre del país es: " + partidoDTO.getPuntuacion());
			log.info("El nombre del departamento es: " + partidoDTO.getEstado());
		}
	}
	
	@Test
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED, noRollbackFor=Exception.class)
	public void etest()throws Exception {	
		Date fecha = new Date();
		
		ReservaCancha reservaCancha = new ReservaCancha();
		Cancha cancha = canchaLogic.getCancha(1);
		Partido partido = partidoLogic.getPartido(1);
		reservaCancha.setCancha(cancha);		
		reservaCancha.setPartido(partido);
		reservaCancha.setFecha(fecha);
		
		canchaLogic.asignarCancha(reservaCancha);
	}
}