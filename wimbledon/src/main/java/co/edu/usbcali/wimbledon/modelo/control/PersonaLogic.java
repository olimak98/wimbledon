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
import co.edu.usbcali.wimbledon.dataaccess.dao.IJuezDAO;
import co.edu.usbcali.wimbledon.dataaccess.dao.IJugadorDAO;
import co.edu.usbcali.wimbledon.dataaccess.dao.IPersonaDAO;
import co.edu.usbcali.wimbledon.dto.mapper.IPersonaMapper;
import co.edu.usbcali.wimbledon.exceptions.ZMessManager;
import co.edu.usbcali.wimbledon.modelo.Director;
import co.edu.usbcali.wimbledon.modelo.Juez;
import co.edu.usbcali.wimbledon.modelo.Jugador;
import co.edu.usbcali.wimbledon.modelo.Persona;
import co.edu.usbcali.wimbledon.modelo.dto.PersonaDTO;
import co.edu.usbcali.wimbledon.utilities.Utilities;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("PersonaLogic")
public class PersonaLogic implements IPersonaLogic {
    private static final Logger log = LoggerFactory.getLogger(PersonaLogic.class);

    /**
     * DAO injected by Spring that manages Persona entities
     *
     */
    @Autowired
    private IPersonaDAO personaDAO;
    @Autowired
    private IPersonaMapper personaMapper;
    @Autowired
    private Validator validator;

    /**
    * DAO injected by Spring that manages Director entities
    *
    */
    @Autowired
    private IDirectorDAO directorDAO;

    /**
    * DAO injected by Spring that manages Juez entities
    *
    */
    @Autowired
    private IJuezDAO juezDAO;

    /**
    * DAO injected by Spring that manages Jugador entities
    *
    */
    @Autowired
    private IJugadorDAO jugadorDAO;

    /**
    * Logic injected by Spring that manages Pais entities
    *
    */
    @Autowired
    IPaisLogic logicPais1;

    public void validatePersona(Persona persona) throws Exception {
        try {
            Set<ConstraintViolation<Persona>> constraintViolations = validator.validate(persona);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Persona> constraintViolation : constraintViolations) {
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
    public List<Persona> getPersona() throws Exception {
        log.debug("finding all Persona instances");

        List<Persona> list = new ArrayList<Persona>();

        try {
            list = personaDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Persona failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Persona");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void savePersona(Persona entity) throws Exception {
        log.debug("saving Persona instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Persona");
            }

            validatePersona(entity);

            personaDAO.save(entity);
            log.debug("save Persona successful");
        } catch (Exception e) {
            log.error("save Persona failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deletePersona(Persona entity) throws Exception {
        log.debug("deleting Persona instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Persona");
        }

        if (entity.getPersonaId() == null) {
            throw new ZMessManager().new EmptyFieldException("personaId");
        }

        List<Director> directors = null;
        List<Juez> juezs = null;
        List<Jugador> jugadors = null;

        try {
            directors = directorDAO.findByProperty("persona.personaId",
                    entity.getPersonaId());

            if (Utilities.validationsList(directors) == true) {
                throw new ZMessManager().new DeletingException("directors");
            }

            juezs = juezDAO.findByProperty("persona.personaId",
                    entity.getPersonaId());

            if (Utilities.validationsList(juezs) == true) {
                throw new ZMessManager().new DeletingException("juezs");
            }

            jugadors = jugadorDAO.findByProperty("persona.personaId",
                    entity.getPersonaId());

            if (Utilities.validationsList(jugadors) == true) {
                throw new ZMessManager().new DeletingException("jugadors");
            }

            personaDAO.deleteById(entity.getPersonaId());
            log.debug("delete Persona successful");
        } catch (Exception e) {
            log.error("delete Persona failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updatePersona(Persona entity) throws Exception {
        log.debug("updating Persona instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Persona");
            }

            validatePersona(entity);

            personaDAO.update(entity);

            log.debug("update Persona successful");
        } catch (Exception e) {
            log.error("update Persona failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<PersonaDTO> getDataPersona() throws Exception {
        try {
            List<Persona> persona = personaDAO.findAll();

            List<PersonaDTO> personaDTO = new ArrayList<PersonaDTO>();

            for (Persona personaTmp : persona) {
                PersonaDTO personaDTO2 = personaMapper.personaToPersonaDTO(personaTmp);
                personaDTO.add(personaDTO2);
            }

            return personaDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Persona getPersona(Integer personaId) throws Exception {
        log.debug("getting Persona instance");

        Persona entity = null;

        try {
            entity = personaDAO.findById(personaId);
        } catch (Exception e) {
            log.error("get Persona failed", e);
            throw new ZMessManager().new FindingException("Persona");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Persona> findPagePersona(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Persona> entity = null;

        try {
            entity = personaDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Persona Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberPersona() throws Exception {
        Long entity = null;

        try {
            entity = personaDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Persona Count");
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
    public List<Persona> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Persona> list = new ArrayList<Persona>();
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
            list = personaDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
