package co.edu.usbcali.wimbledon.dataaccess.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.wimbledon.dataaccess.api.JpaDaoImpl;
import co.edu.usbcali.wimbledon.modelo.EquipoTorneo;


/**
 * A data access object (DAO) providing persistence and search support for
 * EquipoTorneo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.EquipoTorneo
 */
@Scope("singleton")
@Repository("EquipoTorneoDAO")
public class EquipoTorneoDAO extends JpaDaoImpl<EquipoTorneo, Integer>
    implements IEquipoTorneoDAO {
    private static final Logger log = LoggerFactory.getLogger(EquipoTorneoDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IEquipoTorneoDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IEquipoTorneoDAO) ctx.getBean("EquipoTorneoDAO");
    }
}
