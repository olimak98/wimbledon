package co.edu.usbcali.wimbledon.dataaccess.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.wimbledon.dataaccess.api.JpaDaoImpl;
import co.edu.usbcali.wimbledon.modelo.Ronda;


/**
 * A data access object (DAO) providing persistence and search support for
 * Ronda entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Ronda
 */
@Scope("singleton")
@Repository("RondaDAO")
public class RondaDAO extends JpaDaoImpl<Ronda, Integer> implements IRondaDAO {
    private static final Logger log = LoggerFactory.getLogger(RondaDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IRondaDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IRondaDAO) ctx.getBean("RondaDAO");
    }
}
