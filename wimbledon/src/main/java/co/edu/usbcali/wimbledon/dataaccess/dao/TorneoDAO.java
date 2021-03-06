package co.edu.usbcali.wimbledon.dataaccess.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.wimbledon.dataaccess.api.JpaDaoImpl;
import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.modelo.dto.EquipoDTO;
import co.edu.usbcali.wimbledon.modelo.dto.TorneoDTO;


/**
 * A data access object (DAO) providing persistence and search support for
 * Torneo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Torneo
 */
@Scope("singleton")
@Repository("TorneoDAO")
public class TorneoDAO extends JpaDaoImpl<Torneo, Integer> implements ITorneoDAO {
    private static final Logger log = LoggerFactory.getLogger(TorneoDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static ITorneoDAO getFromApplicationContext(ApplicationContext ctx) {
        return (ITorneoDAO) ctx.getBean("TorneoDAO");
    }
    
    @Override
	public List<Torneo> listarActivos() throws Exception {
    	
    	String jpql= "Select tor from Torneo tor where tor.cuposDisponibles > 0 and tor.estado='A'";
		List<Torneo> torneo = entityManager.createQuery(jpql).getResultList();
		return torneo;
    }
}
