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
import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.dto.EquipoDTO;


/**
 * A data access object (DAO) providing persistence and search support for
 * Equipo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 *
 * @see lidis.Equipo
 */
@Scope("singleton")
@Repository("EquipoDAO")
public class EquipoDAO extends JpaDaoImpl<Equipo, Integer> implements IEquipoDAO {
    private static final Logger log = LoggerFactory.getLogger(EquipoDAO.class);
    @PersistenceContext
    private EntityManager entityManager;

    public static IEquipoDAO getFromApplicationContext(ApplicationContext ctx) {
        return (IEquipoDAO) ctx.getBean("EquipoDAO");
    }
    
    @Override
	public Equipo buscar(String nombreEquipo) throws Exception {
    	String jpql= "Select equi from Equipo equi where equi.nombre=:nombre";
		Equipo equipo = (Equipo) entityManager.createQuery(jpql).setParameter("nombre", nombreEquipo).getSingleResult();
		return equipo;
    }
}
