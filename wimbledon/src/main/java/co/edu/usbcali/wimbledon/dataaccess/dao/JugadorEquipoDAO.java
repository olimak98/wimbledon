package co.edu.usbcali.wimbledon.dataaccess.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.wimbledon.dataaccess.api.JpaDaoImpl;
import co.edu.usbcali.wimbledon.modelo.JugadorEquipo;


/**
 * A data access object (DAO) providing persistence and search support for
 * JugadorEquipo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.JugadorEquipo
 */
@Scope("singleton")
@Repository("JugadorEquipoDAO")
public class JugadorEquipoDAO extends JpaDaoImpl<JugadorEquipo, Integer>
    implements IJugadorEquipoDAO {
    private static final Logger log = LoggerFactory.getLogger(JugadorEquipoDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IJugadorEquipoDAO getFromApplicationContext(
        ApplicationContext ctx) {
        return (IJugadorEquipoDAO) ctx.getBean("JugadorEquipoDAO");
    }
}
