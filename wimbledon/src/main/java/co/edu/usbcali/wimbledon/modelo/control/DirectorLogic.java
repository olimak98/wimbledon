package co.edu.usbcali.wimbledon.modelo.control;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import co.edu.usbcali.wimbledon.dataaccess.dao.IDirectorDAO;
import co.edu.usbcali.wimbledon.dataaccess.dao.ITorneoDAO;
import co.edu.usbcali.wimbledon.dto.mapper.IDirectorMapper;
import co.edu.usbcali.wimbledon.exceptions.ZMessManager;
import co.edu.usbcali.wimbledon.modelo.Director;
import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.modelo.dto.DirectorDTO;
import co.edu.usbcali.wimbledon.utilities.Utilities;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("DirectorLogic")
public class DirectorLogic implements IDirectorLogic {
    private static final Logger log = LoggerFactory.getLogger(DirectorLogic.class);

    /**
     * DAO injected by Spring that manages Director entities
     *
     */
    @Autowired
    private IDirectorDAO directorDAO;
    @Autowired
    private IDirectorMapper directorMapper;
    @Autowired
    private Validator validator;

    /**
    * DAO injected by Spring that manages Torneo entities
    *
    */
    @Autowired
    private ITorneoDAO torneoDAO;

    /**
    * Logic injected by Spring that manages Persona entities
    *
    */
    @Autowired
    IPersonaLogic logicPersona1;

    public void validateDirector(Director director) throws Exception {
        try {
            Set<ConstraintViolation<Director>> constraintViolations = validator.validate(director);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Director> constraintViolation : constraintViolations) {
                    strMessage.append(constraintViolation.getPropertyPath()
                                                         .toString());
                    strMessage.append(" - ");
                    strMessage.append(constraintViolation.getMessage());
                    strMessage.append(". \n");
                }

                throw new Exception(strMessage.toString());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public List<Director> getDirector() throws Exception {
        log.debug("finding all Director instances");

        List<Director> list = new ArrayList<Director>();

        try {
            list = directorDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Director failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Director");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveDirector(Director entity) throws Exception {
        log.debug("saving Director instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Director");
            }

            validateDirector(entity);

            if (getDirector(entity.getDirectorId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            directorDAO.save(entity);
            log.debug("save Director successful");
        } catch (Exception e) {
            log.error("save Director failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteDirector(Director entity) throws Exception {
        log.debug("deleting Director instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Director");
        }

        if (entity.getDirectorId() == null) {
            throw new ZMessManager().new EmptyFieldException("directorId");
        }

        List<Torneo> torneos = null;

        try {
            torneos = torneoDAO.findByProperty("director.directorId",
                    entity.getDirectorId());

            if (Utilities.validationsList(torneos) == true) {
                throw new ZMessManager().new DeletingException("torneos");
            }

            directorDAO.deleteById(entity.getDirectorId());
            log.debug("delete Director successful");
        } catch (Exception e) {
            log.error("delete Director failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateDirector(Director entity) throws Exception {
        log.debug("updating Director instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Director");
            }

            validateDirector(entity);

            directorDAO.update(entity);

            log.debug("update Director successful");
        } catch (Exception e) {
            log.error("update Director failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<DirectorDTO> getDataDirector() throws Exception {
        try {
            List<Director> director = directorDAO.findAll();

            List<DirectorDTO> directorDTO = new ArrayList<DirectorDTO>();

            for (Director directorTmp : director) {
                DirectorDTO directorDTO2 = directorMapper.directorToDirectorDTO(directorTmp);
                directorDTO.add(directorDTO2);
            }

            return directorDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Director getDirector(Integer directorId) throws Exception {
        log.debug("getting Director instance");

        Director entity = null;

        try {
            entity = directorDAO.findById(directorId);
        } catch (Exception e) {
            log.error("get Director failed", e);
            throw new ZMessManager().new FindingException("Director");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Director> findPageDirector(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Director> entity = null;

        try {
            entity = directorDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Director Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberDirector() throws Exception {
        Long entity = null;

        try {
            entity = directorDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Director Count");
        } finally {
        }

        return entity;
    }

    /**
    *
    * @param varibles
    *            este arreglo debera tener:
    *
    * [0] = String variable = (String) varibles[i]; representa como se llama la
    * variable en el pojo
    *
    * [1] = Boolean booVariable = (Boolean) varibles[i + 1]; representa si el
    * valor necesita o no ''(comillas simples)usado para campos de tipo string
    *
    * [2] = Object value = varibles[i + 2]; representa el valor que se va a
    * buscar en la BD
    *
    * [3] = String comparator = (String) varibles[i + 3]; representa que tipo
    * de busqueda voy a hacer.., ejemplo: where nombre=william o where nombre<>william,
        * en este campo iria el tipo de comparador que quiero si es = o <>
            *
            * Se itera de 4 en 4..., entonces 4 registros del arreglo representan 1
            * busqueda en un campo, si se ponen mas pues el continuara buscando en lo
            * que se le ingresen en los otros 4
            *
            *
            * @param variablesBetween
            *
            * la diferencia son estas dos posiciones
            *
            * [0] = String variable = (String) varibles[j]; la variable ne la BD que va
            * a ser buscada en un rango
            *
            * [1] = Object value = varibles[j + 1]; valor 1 para buscar en un rango
            *
            * [2] = Object value2 = varibles[j + 2]; valor 2 para buscar en un rango
            * ejempolo: a > 1 and a < 5 --> 1 seria value y 5 seria value2
                *
                * [3] = String comparator1 = (String) varibles[j + 3]; comparador 1
                * ejemplo: a comparator1 1 and a < 5
                    *
                    * [4] = String comparator2 = (String) varibles[j + 4]; comparador 2
                    * ejemplo: a comparador1>1  and a comparador2<5  (el original: a > 1 and a <
                            * 5) *
                            * @param variablesBetweenDates(en
                            *            este caso solo para mysql)
                            *  [0] = String variable = (String) varibles[k]; el nombre de la variable que hace referencia a
                            *            una fecha
                            *
                            * [1] = Object object1 = varibles[k + 2]; fecha 1 a comparar(deben ser
                            * dates)
                            *
                            * [2] = Object object2 = varibles[k + 3]; fecha 2 a comparar(deben ser
                            * dates)
                            *
                            * esto hace un between entre las dos fechas.
                            *
                            * @return lista con los objetos que se necesiten
                            * @throws Exception
                            */
    @Transactional(readOnly = true)
    public List<Director> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Director> list = new ArrayList<Director>();
        String where = new String();
        String tempWhere = new String();

        if (variables != null) {
            for (int i = 0; i < variables.length; i++) {
                if ((variables[i] != null) && (variables[i + 1] != null) &&
                        (variables[i + 2] != null) &&
                        (variables[i + 3] != null)) {
                    String variable = (String) variables[i];
                    Boolean booVariable = (Boolean) variables[i + 1];
                    Object value = variables[i + 2];
                    String comparator = (String) variables[i + 3];

                    if (booVariable.booleanValue()) {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " \'" +
                            value + "\' )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " \'" + value + "\' )");
                    } else {
                        tempWhere = (tempWhere.length() == 0)
                            ? ("(model." + variable + " " + comparator + " " +
                            value + " )")
                            : (tempWhere + " AND (model." + variable + " " +
                            comparator + " " + value + " )");
                    }
                }

                i = i + 3;
            }
        }

        if (variablesBetween != null) {
            for (int j = 0; j < variablesBetween.length; j++) {
                if ((variablesBetween[j] != null) &&
                        (variablesBetween[j + 1] != null) &&
                        (variablesBetween[j + 2] != null) &&
                        (variablesBetween[j + 3] != null) &&
                        (variablesBetween[j + 4] != null)) {
                    String variable = (String) variablesBetween[j];
                    Object value = variablesBetween[j + 1];
                    Object value2 = variablesBetween[j + 2];
                    String comparator1 = (String) variablesBetween[j + 3];
                    String comparator2 = (String) variablesBetween[j + 4];
                    tempWhere = (tempWhere.length() == 0)
                        ? ("(" + value + " " + comparator1 + " " + variable +
                        " and " + variable + " " + comparator2 + " " + value2 +
                        " )")
                        : (tempWhere + " AND (" + value + " " + comparator1 +
                        " " + variable + " and " + variable + " " +
                        comparator2 + " " + value2 + " )");
                }

                j = j + 4;
            }
        }

        if (variablesBetweenDates != null) {
            for (int k = 0; k < variablesBetweenDates.length; k++) {
                if ((variablesBetweenDates[k] != null) &&
                        (variablesBetweenDates[k + 1] != null) &&
                        (variablesBetweenDates[k + 2] != null)) {
                    String variable = (String) variablesBetweenDates[k];
                    Object object1 = variablesBetweenDates[k + 1];
                    Object object2 = variablesBetweenDates[k + 2];
                    String value = null;
                    String value2 = null;

                    try {
                        Date date1 = (Date) object1;
                        Date date2 = (Date) object2;
                        value = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date1);
                        value2 = Utilities.formatDateWithoutTimeInAStringForBetweenWhere(date2);
                    } catch (Exception e) {
                        list = null;
                        throw e;
                    }

                    tempWhere = (tempWhere.length() == 0)
                        ? ("(model." + variable + " between " + value +
                        " and " + value2 + ")")
                        : (tempWhere + " AND (model." + variable + " between " +
                        value + " and " + value2 + ")");
                }

                k = k + 2;
            }
        }

        if (tempWhere.length() == 0) {
            where = null;
        } else {
            where = "(" + tempWhere + ")";
        }

        try {
            list = directorDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
