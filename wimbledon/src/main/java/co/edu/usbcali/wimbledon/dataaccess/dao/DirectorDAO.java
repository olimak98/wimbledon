package co.edu.usbcali.wimbledon.dataaccess.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.usbcali.wimbledon.dataaccess.api.JpaDaoImpl;
import co.edu.usbcali.wimbledon.modelo.Director;


/**
 * A data access object (DAO) providing persistence and search support for
 * Director entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Director
 */
@Scope("singleton")
@Repository("DirectorDAO")
public class DirectorDAO extends JpaDaoImpl<Director, Integer>
    implements IDirectorDAO {
    private static final Logger log = LoggerFactory.getLogger(DirectorDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IDirectorDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IDirectorDAO) ctx.getBean("DirectorDAO");
    }
}
