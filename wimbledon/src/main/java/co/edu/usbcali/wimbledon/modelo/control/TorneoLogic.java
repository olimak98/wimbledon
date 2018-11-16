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

import com.hazelcast.client.util.RandomLB;

import co.edu.usbcali.wimbledon.dataaccess.dao.IEquipoTorneoDAO;
import co.edu.usbcali.wimbledon.dataaccess.dao.IJuezTorneoDAO;
import co.edu.usbcali.wimbledon.dataaccess.dao.IRondaDAO;
import co.edu.usbcali.wimbledon.dataaccess.dao.ITorneoDAO;
import co.edu.usbcali.wimbledon.dto.mapper.ITorneoMapper;
import co.edu.usbcali.wimbledon.exceptions.ZMessManager;
import co.edu.usbcali.wimbledon.modelo.EquipoTorneo;
import co.edu.usbcali.wimbledon.modelo.JuezTorneo;
import co.edu.usbcali.wimbledon.modelo.Jugador;
import co.edu.usbcali.wimbledon.modelo.JugadorEquipo;
import co.edu.usbcali.wimbledon.modelo.Ronda;
import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.modelo.dto.TorneoDTO;
import co.edu.usbcali.wimbledon.utilities.Utilities;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("TorneoLogic")
public class TorneoLogic implements ITorneoLogic {
    private static final Logger log = LoggerFactory.getLogger(TorneoLogic.class);

    /**
     * DAO injected by Spring that manages Torneo entities
     *
     */
    @Autowired
    private ITorneoDAO torneoDAO;
    @Autowired
    private ITorneoMapper torneoMapper;
    @Autowired
    private Validator validator;

    /**
    * DAO injected by Spring that manages EquipoTorneo entities
    *
    */
    @Autowired
    private IEquipoTorneoDAO equipoTorneoDAO;

    /**
    * DAO injected by Spring that manages JuezTorneo entities
    *
    */
    @Autowired
    private IJuezTorneoDAO juezTorneoDAO;

    /**
    * DAO injected by Spring that manages Ronda entities
    *
    */
    @Autowired
    private IRondaDAO rondaDAO;

    /**
    * Logic injected by Spring that manages Director entities
    *
    */
    @Autowired
    IDirectorLogic logicDirector1;

    public void validateTorneo(Torneo torneo) throws Exception {
        try {
            Set<ConstraintViolation<Torneo>> constraintViolations = validator.validate(torneo);

            if (constraintViolations.size() > 0) {
                StringBuilder strMessage = new StringBuilder();

                for (ConstraintViolation<Torneo> constraintViolation : constraintViolations) {
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
    
    public void generateDrawTemplate(Torneo torneo) {    	
    	Set<EquipoTorneo> equipos = torneo.getEquipoTorneos();
    	int[] rankings = null;
    	for (EquipoTorneo equipoTorneo : equipos) {
			Set<JugadorEquipo> jugadores = equipoTorneo.getEquipo().getJugadorEquipos();
			rankings = new int[jugadores.size()];			
		}
		sort(rankings, rankings);
		
		
    	
    }
    
    public void sort(int[] inputArr, int array[]) {
        
        if (inputArr == null || inputArr.length == 0) {
            return;
        } 
        quickSort(0, inputArr.length - 1, array);
    }
 
    private void quickSort(int lowerIndex, int higherIndex, int array[]) {
         
        int i = lowerIndex;
        int j = higherIndex;
        // calculate pivot number, I am taking pivot as middle index number
        int pivot = array[lowerIndex+(higherIndex-lowerIndex)/2];
        // Divide into two arrays
        while (i <= j) {
            /**
             * In each iteration, we will identify a number from left side which 
             * is greater then the pivot value, and also we will identify a number 
             * from right side which is less then the pivot value. Once the search 
             * is done, then we exchange both numbers.
             */
            while (array[i] < pivot) {
                i++;
            }
            while (array[j] > pivot) {
                j--;
            }
            if (i <= j) {
                exchangeNumbers(i, j, array);
                //move index to next position on both sides
                i++;
                j--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < j)
            quickSort(lowerIndex, j, array);
        if (i < higherIndex)
            quickSort(i, higherIndex, array);
    }
 
    private void exchangeNumbers(int i, int j, int array[]) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Transactional(readOnly = true)
    public List<Torneo> getTorneo() throws Exception {
        log.debug("finding all Torneo instances");

        List<Torneo> list = new ArrayList<Torneo>();

        try {
            list = torneoDAO.findAll();
        } catch (Exception e) {
            log.error("finding all Torneo failed", e);
            throw new ZMessManager().new GettingException(ZMessManager.ALL +
                "Torneo");
        } finally {
        }

        return list;
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void saveTorneo(Torneo entity) throws Exception {
        log.debug("saving Torneo instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Torneo");
            }

            validateTorneo(entity);

            if (getTorneo(entity.getTorneoId()) != null) {
                throw new ZMessManager(ZMessManager.ENTITY_WITHSAMEKEY);
            }

            torneoDAO.save(entity);
            log.debug("save Torneo successful");
        } catch (Exception e) {
            log.error("save Torneo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void deleteTorneo(Torneo entity) throws Exception {
        log.debug("deleting Torneo instance");

        if (entity == null) {
            throw new ZMessManager().new NullEntityExcepcion("Torneo");
        }

        if (entity.getTorneoId() == null) {
            throw new ZMessManager().new EmptyFieldException("torneoId");
        }

        List<EquipoTorneo> equipoTorneos = null;
        List<JuezTorneo> juezTorneos = null;
        List<Ronda> rondas = null;

        try {
            equipoTorneos = equipoTorneoDAO.findByProperty("torneo.torneoId",
                    entity.getTorneoId());

            if (Utilities.validationsList(equipoTorneos) == true) {
                throw new ZMessManager().new DeletingException("equipoTorneos");
            }

            juezTorneos = juezTorneoDAO.findByProperty("torneo.torneoId",
                    entity.getTorneoId());

            if (Utilities.validationsList(juezTorneos) == true) {
                throw new ZMessManager().new DeletingException("juezTorneos");
            }

            rondas = rondaDAO.findByProperty("torneo.torneoId",
                    entity.getTorneoId());

            if (Utilities.validationsList(rondas) == true) {
                throw new ZMessManager().new DeletingException("rondas");
            }

            torneoDAO.deleteById(entity.getTorneoId());
            log.debug("delete Torneo successful");
        } catch (Exception e) {
            log.error("delete Torneo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public void updateTorneo(Torneo entity) throws Exception {
        log.debug("updating Torneo instance");

        try {
            if (entity == null) {
                throw new ZMessManager().new NullEntityExcepcion("Torneo");
            }

            validateTorneo(entity);

            torneoDAO.update(entity);

            log.debug("update Torneo successful");
        } catch (Exception e) {
            log.error("update Torneo failed", e);
            throw e;
        } finally {
        }
    }

    @Transactional(readOnly = true)
    public List<TorneoDTO> getDataTorneo() throws Exception {
        try {
            List<Torneo> torneo = torneoDAO.findAll();

            List<TorneoDTO> torneoDTO = new ArrayList<TorneoDTO>();

            for (Torneo torneoTmp : torneo) {
                TorneoDTO torneoDTO2 = torneoMapper.torneoToTorneoDTO(torneoTmp);
                torneoDTO.add(torneoDTO2);
            }

            return torneoDTO;
        } catch (Exception e) {
            throw e;
        }
    }

    @Transactional(readOnly = true)
    public Torneo getTorneo(Integer torneoId) throws Exception {
        log.debug("getting Torneo instance");

        Torneo entity = null;

        try {
            entity = torneoDAO.findById(torneoId);
        } catch (Exception e) {
            log.error("get Torneo failed", e);
            throw new ZMessManager().new FindingException("Torneo");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public List<Torneo> findPageTorneo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        List<Torneo> entity = null;

        try {
            entity = torneoDAO.findPage(sortColumnName, sortAscending,
                    startRow, maxResults);
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Torneo Count");
        } finally {
        }

        return entity;
    }

    @Transactional(readOnly = true)
    public Long findTotalNumberTorneo() throws Exception {
        Long entity = null;

        try {
            entity = torneoDAO.count();
        } catch (Exception e) {
            throw new ZMessManager().new FindingException("Torneo Count");
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
    public List<Torneo> findByCriteria(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        List<Torneo> list = new ArrayList<Torneo>();
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
            list = torneoDAO.findByCriteria(where);
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        } finally {
        }

        return list;
    }
}
