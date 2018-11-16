package co.edu.usbcali.wimbledon.dataaccess.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.wimbledon.dataaccess.api.JpaDaoImpl;
import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.Partido;


/**
 * A data access object (DAO) providing persistence and search support for
 * Partido entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Partido
 */
@Scope("singleton")
@Repository("PartidoDAO")
public class PartidoDAO extends JpaDaoImpl<Partido, Integer>
    implements IPartidoDAO {
    private static final Logger log = LoggerFactory.getLogger(PartidoDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IPartidoDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IPartidoDAO) ctx.getBean("PartidoDAO");
    }

	@Override
	public List<Partido> listarPendientes() throws Exception {
		String jpql= "Select par from Partido par where par.estado='P'";
		List<Partido> partidos = entityManager.createQuery(jpql).getResultList();
		for (Partido partido : partidos) {
			Hibernate.initialize(partido.getRonda().getTorneo());
		}
		return partidos;
	}
}
