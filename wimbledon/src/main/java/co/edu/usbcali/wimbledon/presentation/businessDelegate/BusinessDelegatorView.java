package co.edu.usbcali.wimbledon.presentation.businessDelegate;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import co.edu.usbcali.wimbledon.modelo.Cancha;
import co.edu.usbcali.wimbledon.modelo.Director;
import co.edu.usbcali.wimbledon.modelo.Equipo;
import co.edu.usbcali.wimbledon.modelo.EquipoTorneo;
import co.edu.usbcali.wimbledon.modelo.Juez;
import co.edu.usbcali.wimbledon.modelo.JuezTorneo;
import co.edu.usbcali.wimbledon.modelo.Jugador;
import co.edu.usbcali.wimbledon.modelo.JugadorEquipo;
import co.edu.usbcali.wimbledon.modelo.Pais;
import co.edu.usbcali.wimbledon.modelo.Partido;
import co.edu.usbcali.wimbledon.modelo.Persona;
import co.edu.usbcali.wimbledon.modelo.ReservaCancha;
import co.edu.usbcali.wimbledon.modelo.Ronda;
import co.edu.usbcali.wimbledon.modelo.Set;
import co.edu.usbcali.wimbledon.modelo.Torneo;
import co.edu.usbcali.wimbledon.modelo.control.ICanchaLogic;
import co.edu.usbcali.wimbledon.modelo.control.IDirectorLogic;
import co.edu.usbcali.wimbledon.modelo.control.IEquipoLogic;
import co.edu.usbcali.wimbledon.modelo.control.IEquipoTorneoLogic;
import co.edu.usbcali.wimbledon.modelo.control.IJuezLogic;
import co.edu.usbcali.wimbledon.modelo.control.IJuezTorneoLogic;
import co.edu.usbcali.wimbledon.modelo.control.IJugadorEquipoLogic;
import co.edu.usbcali.wimbledon.modelo.control.IJugadorLogic;
import co.edu.usbcali.wimbledon.modelo.control.IPaisLogic;
import co.edu.usbcali.wimbledon.modelo.control.IPartidoLogic;
import co.edu.usbcali.wimbledon.modelo.control.IPersonaLogic;
import co.edu.usbcali.wimbledon.modelo.control.IReservaCanchaLogic;
import co.edu.usbcali.wimbledon.modelo.control.IRondaLogic;
import co.edu.usbcali.wimbledon.modelo.control.ISetLogic;
import co.edu.usbcali.wimbledon.modelo.control.ITorneoLogic;
import co.edu.usbcali.wimbledon.modelo.dto.CanchaDTO;
import co.edu.usbcali.wimbledon.modelo.dto.DirectorDTO;
import co.edu.usbcali.wimbledon.modelo.dto.EquipoDTO;
import co.edu.usbcali.wimbledon.modelo.dto.EquipoTorneoDTO;
import co.edu.usbcali.wimbledon.modelo.dto.JuezDTO;
import co.edu.usbcali.wimbledon.modelo.dto.JuezTorneoDTO;
import co.edu.usbcali.wimbledon.modelo.dto.JugadorDTO;
import co.edu.usbcali.wimbledon.modelo.dto.JugadorEquipoDTO;
import co.edu.usbcali.wimbledon.modelo.dto.PaisDTO;
import co.edu.usbcali.wimbledon.modelo.dto.PartidoDTO;
import co.edu.usbcali.wimbledon.modelo.dto.PersonaDTO;
import co.edu.usbcali.wimbledon.modelo.dto.ReservaCanchaDTO;
import co.edu.usbcali.wimbledon.modelo.dto.RondaDTO;
import co.edu.usbcali.wimbledon.modelo.dto.SetDTO;
import co.edu.usbcali.wimbledon.modelo.dto.TorneoDTO;

/**
* Use a Business Delegate to reduce coupling between presentation-tier clients and business services.
* The Business Delegate hides the underlying implementation details of the business service, such as lookup and access details of the EJB architecture.
*
* The Business Delegate acts as a client-side business abstraction; it provides an abstraction for, and thus hides,
* the implementation of the business services. Using a Business Delegate reduces the coupling between presentation-tier clients and
* the system's business services. Depending on the implementation strategy, the Business Delegate may shield clients from possible
* volatility in the implementation of the business service API. Potentially, this reduces the number of changes that must be made to the
* presentation-tier client code when the business service API or its underlying implementation changes.
*
* However, interface methods in the Business Delegate may still require modification if the underlying business service API changes.
* Admittedly, though, it is more likely that changes will be made to the business service rather than to the Business Delegate.
*
* Often, developers are skeptical when a design goal such as abstracting the business layer causes additional upfront work in return
* for future gains. However, using this pattern or its strategies results in only a small amount of additional upfront work and provides
* considerable benefits. The main benefit is hiding the details of the underlying service. For example, the client can become transparent
* to naming and lookup services. The Business Delegate also handles the exceptions from the business services, such as java.rmi.Remote
* exceptions, Java Messages Service (JMS) exceptions and so on. The Business Delegate may intercept such service level exceptions and
* generate application level exceptions instead. Application level exceptions are easier to handle by the clients, and may be user friendly.
* The Business Delegate may also transparently perform any retry or recovery operations necessary in the event of a service failure without
* exposing the client to the problem until it is determined that the problem is not resolvable. These gains present a compelling reason to
* use the pattern.
*
* Another benefit is that the delegate may cache results and references to remote business services. Caching can significantly improve performance,
* because it limits unnecessary and potentially costly round trips over the network.
*
* A Business Delegate uses a component called the Lookup Service. The Lookup Service is responsible for hiding the underlying implementation
* details of the business service lookup code. The Lookup Service may be written as part of the Delegate, but we recommend that it be
* implemented as a separate component, as outlined in the Service Locator pattern (See "Service Locator" on page 368.)
*
* When the Business Delegate is used with a Session Facade, typically there is a one-to-one relationship between the two.
* This one-to-one relationship exists because logic that might have been encapsulated in a Business Delegate relating to its interaction
* with multiple business services (creating a one-to-many relationship) will often be factored back into a Session Facade.
*
* Finally, it should be noted that this pattern could be used to reduce coupling between other tiers, not simply the presentation and the
* business tiers.
*
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Scope("singleton")
@Service("BusinessDelegatorView")
public class BusinessDelegatorView implements IBusinessDelegatorView {
    private static final Logger log = LoggerFactory.getLogger(BusinessDelegatorView.class);
    @Autowired
    private ICanchaLogic canchaLogic;
    @Autowired
    private IDirectorLogic directorLogic;
    @Autowired
    private IEquipoLogic equipoLogic;
    @Autowired
    private IEquipoTorneoLogic equipoTorneoLogic;
    @Autowired
    private IJuezLogic juezLogic;
    @Autowired
    private IJuezTorneoLogic juezTorneoLogic;
    @Autowired
    private IJugadorLogic jugadorLogic;
    @Autowired
    private IJugadorEquipoLogic jugadorEquipoLogic;
    @Autowired
    private IPaisLogic paisLogic;
    @Autowired
    private IPartidoLogic partidoLogic;
    @Autowired
    private IPersonaLogic personaLogic;
    @Autowired
    private IReservaCanchaLogic reservaCanchaLogic;
    @Autowired
    private IRondaLogic rondaLogic;
    @Autowired
    private ISetLogic setLogic;
    @Autowired
    private ITorneoLogic torneoLogic;

    public List<Cancha> getCancha() throws Exception {
        return canchaLogic.getCancha();
    }

    public void saveCancha(Cancha entity) throws Exception {
        canchaLogic.saveCancha(entity);
    }

    public void deleteCancha(Cancha entity) throws Exception {
        canchaLogic.deleteCancha(entity);
    }

    public void updateCancha(Cancha entity) throws Exception {
        canchaLogic.updateCancha(entity);
    }

    public Cancha getCancha(Integer canchaId) throws Exception {
        Cancha cancha = null;

        try {
            cancha = canchaLogic.getCancha(canchaId);
        } catch (Exception e) {
            throw e;
        }

        return cancha;
    }

    public List<Cancha> findByCriteriaInCancha(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return canchaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Cancha> findPageCancha(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return canchaLogic.findPageCancha(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberCancha() throws Exception {
        return canchaLogic.findTotalNumberCancha();
    }

    public List<CanchaDTO> getDataCancha() throws Exception {
        return canchaLogic.getDataCancha();
    }

    public void validateCancha(Cancha cancha) throws Exception {
        canchaLogic.validateCancha(cancha);
    }

    public List<Director> getDirector() throws Exception {
        return directorLogic.getDirector();
    }

    public void saveDirector(Director entity) throws Exception {
        directorLogic.saveDirector(entity);
    }

    public void deleteDirector(Director entity) throws Exception {
        directorLogic.deleteDirector(entity);
    }

    public void updateDirector(Director entity) throws Exception {
        directorLogic.updateDirector(entity);
    }

    public Director getDirector(Integer directorId) throws Exception {
        Director director = null;

        try {
            director = directorLogic.getDirector(directorId);
        } catch (Exception e) {
            throw e;
        }

        return director;
    }

    public List<Director> findByCriteriaInDirector(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return directorLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Director> findPageDirector(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return directorLogic.findPageDirector(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberDirector() throws Exception {
        return directorLogic.findTotalNumberDirector();
    }

    public List<DirectorDTO> getDataDirector() throws Exception {
        return directorLogic.getDataDirector();
    }

    public void validateDirector(Director director) throws Exception {
        directorLogic.validateDirector(director);
    }

    public List<Equipo> getEquipo() throws Exception {
        return equipoLogic.getEquipo();
    }

    public void saveEquipo(Equipo entity) throws Exception {
        equipoLogic.saveEquipo(entity);
    }

    public void deleteEquipo(Equipo entity) throws Exception {
        equipoLogic.deleteEquipo(entity);
    }

    public void updateEquipo(Equipo entity) throws Exception {
        equipoLogic.updateEquipo(entity);
    }

    public Equipo getEquipo(Integer equipoId) throws Exception {
        Equipo equipo = null;

        try {
            equipo = equipoLogic.getEquipo(equipoId);
        } catch (Exception e) {
            throw e;
        }

        return equipo;
    }

    public List<Equipo> findByCriteriaInEquipo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return equipoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Equipo> findPageEquipo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return equipoLogic.findPageEquipo(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberEquipo() throws Exception {
        return equipoLogic.findTotalNumberEquipo();
    }

    public List<EquipoDTO> getDataEquipo() throws Exception {
        return equipoLogic.getDataEquipo();
    }

    public void validateEquipo(Equipo equipo) throws Exception {
        equipoLogic.validateEquipo(equipo);
    }

    public List<EquipoTorneo> getEquipoTorneo() throws Exception {
        return equipoTorneoLogic.getEquipoTorneo();
    }

    public void saveEquipoTorneo(EquipoTorneo entity) throws Exception {
        equipoTorneoLogic.saveEquipoTorneo(entity);
    }

    public void deleteEquipoTorneo(EquipoTorneo entity)
        throws Exception {
        equipoTorneoLogic.deleteEquipoTorneo(entity);
    }

    public void updateEquipoTorneo(EquipoTorneo entity)
        throws Exception {
        equipoTorneoLogic.updateEquipoTorneo(entity);
    }

    public EquipoTorneo getEquipoTorneo(Integer equipoTorneoId)
        throws Exception {
        EquipoTorneo equipoTorneo = null;

        try {
            equipoTorneo = equipoTorneoLogic.getEquipoTorneo(equipoTorneoId);
        } catch (Exception e) {
            throw e;
        }

        return equipoTorneo;
    }

    public List<EquipoTorneo> findByCriteriaInEquipoTorneo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return equipoTorneoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<EquipoTorneo> findPageEquipoTorneo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return equipoTorneoLogic.findPageEquipoTorneo(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberEquipoTorneo() throws Exception {
        return equipoTorneoLogic.findTotalNumberEquipoTorneo();
    }

    public List<EquipoTorneoDTO> getDataEquipoTorneo()
        throws Exception {
        return equipoTorneoLogic.getDataEquipoTorneo();
    }

    public void validateEquipoTorneo(EquipoTorneo equipoTorneo)
        throws Exception {
        equipoTorneoLogic.validateEquipoTorneo(equipoTorneo);
    }

    public List<Juez> getJuez() throws Exception {
        return juezLogic.getJuez();
    }

    public void saveJuez(Juez entity) throws Exception {
        juezLogic.saveJuez(entity);
    }

    public void deleteJuez(Juez entity) throws Exception {
        juezLogic.deleteJuez(entity);
    }

    public void updateJuez(Juez entity) throws Exception {
        juezLogic.updateJuez(entity);
    }

    public Juez getJuez(Integer juezId) throws Exception {
        Juez juez = null;

        try {
            juez = juezLogic.getJuez(juezId);
        } catch (Exception e) {
            throw e;
        }

        return juez;
    }

    public List<Juez> findByCriteriaInJuez(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return juezLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Juez> findPageJuez(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return juezLogic.findPageJuez(sortColumnName, sortAscending, startRow,
            maxResults);
    }

    public Long findTotalNumberJuez() throws Exception {
        return juezLogic.findTotalNumberJuez();
    }

    public List<JuezDTO> getDataJuez() throws Exception {
        return juezLogic.getDataJuez();
    }

    public void validateJuez(Juez juez) throws Exception {
        juezLogic.validateJuez(juez);
    }

    public List<JuezTorneo> getJuezTorneo() throws Exception {
        return juezTorneoLogic.getJuezTorneo();
    }

    public void saveJuezTorneo(JuezTorneo entity) throws Exception {
        juezTorneoLogic.saveJuezTorneo(entity);
    }

    public void deleteJuezTorneo(JuezTorneo entity) throws Exception {
        juezTorneoLogic.deleteJuezTorneo(entity);
    }

    public void updateJuezTorneo(JuezTorneo entity) throws Exception {
        juezTorneoLogic.updateJuezTorneo(entity);
    }

    public JuezTorneo getJuezTorneo(Integer juezTorneoId)
        throws Exception {
        JuezTorneo juezTorneo = null;

        try {
            juezTorneo = juezTorneoLogic.getJuezTorneo(juezTorneoId);
        } catch (Exception e) {
            throw e;
        }

        return juezTorneo;
    }

    public List<JuezTorneo> findByCriteriaInJuezTorneo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return juezTorneoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<JuezTorneo> findPageJuezTorneo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return juezTorneoLogic.findPageJuezTorneo(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberJuezTorneo() throws Exception {
        return juezTorneoLogic.findTotalNumberJuezTorneo();
    }

    public List<JuezTorneoDTO> getDataJuezTorneo() throws Exception {
        return juezTorneoLogic.getDataJuezTorneo();
    }

    public void validateJuezTorneo(JuezTorneo juezTorneo)
        throws Exception {
        juezTorneoLogic.validateJuezTorneo(juezTorneo);
    }

    public List<Jugador> getJugador() throws Exception {
        return jugadorLogic.getJugador();
    }

    public void saveJugador(Jugador entity) throws Exception {
        jugadorLogic.saveJugador(entity);
    }

    public void deleteJugador(Jugador entity) throws Exception {
        jugadorLogic.deleteJugador(entity);
    }

    public void updateJugador(Jugador entity) throws Exception {
        jugadorLogic.updateJugador(entity);
    }

    public Jugador getJugador(Integer jugadorId) throws Exception {
        Jugador jugador = null;

        try {
            jugador = jugadorLogic.getJugador(jugadorId);
        } catch (Exception e) {
            throw e;
        }

        return jugador;
    }

    public List<Jugador> findByCriteriaInJugador(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return jugadorLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Jugador> findPageJugador(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return jugadorLogic.findPageJugador(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberJugador() throws Exception {
        return jugadorLogic.findTotalNumberJugador();
    }

    public List<JugadorDTO> getDataJugador() throws Exception {
        return jugadorLogic.getDataJugador();
    }

    public void validateJugador(Jugador jugador) throws Exception {
        jugadorLogic.validateJugador(jugador);
    }

    public List<JugadorEquipo> getJugadorEquipo() throws Exception {
        return jugadorEquipoLogic.getJugadorEquipo();
    }

    public void saveJugadorEquipo(JugadorEquipo entity)
        throws Exception {
        jugadorEquipoLogic.saveJugadorEquipo(entity);
    }

    public void deleteJugadorEquipo(JugadorEquipo entity)
        throws Exception {
        jugadorEquipoLogic.deleteJugadorEquipo(entity);
    }

    public void updateJugadorEquipo(JugadorEquipo entity)
        throws Exception {
        jugadorEquipoLogic.updateJugadorEquipo(entity);
    }

    public JugadorEquipo getJugadorEquipo(Integer jugadorEquipoId)
        throws Exception {
        JugadorEquipo jugadorEquipo = null;

        try {
            jugadorEquipo = jugadorEquipoLogic.getJugadorEquipo(jugadorEquipoId);
        } catch (Exception e) {
            throw e;
        }

        return jugadorEquipo;
    }

    public List<JugadorEquipo> findByCriteriaInJugadorEquipo(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return jugadorEquipoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<JugadorEquipo> findPageJugadorEquipo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return jugadorEquipoLogic.findPageJugadorEquipo(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberJugadorEquipo() throws Exception {
        return jugadorEquipoLogic.findTotalNumberJugadorEquipo();
    }

    public List<JugadorEquipoDTO> getDataJugadorEquipo()
        throws Exception {
        return jugadorEquipoLogic.getDataJugadorEquipo();
    }

    public void validateJugadorEquipo(JugadorEquipo jugadorEquipo)
        throws Exception {
        jugadorEquipoLogic.validateJugadorEquipo(jugadorEquipo);
    }

    public List<Pais> getPais() throws Exception {
        return paisLogic.getPais();
    }

    public void savePais(Pais entity) throws Exception {
        paisLogic.savePais(entity);
    }

    public void deletePais(Pais entity) throws Exception {
        paisLogic.deletePais(entity);
    }

    public void updatePais(Pais entity) throws Exception {
        paisLogic.updatePais(entity);
    }

    public Pais getPais(Integer paisId) throws Exception {
        Pais pais = null;

        try {
            pais = paisLogic.getPais(paisId);
        } catch (Exception e) {
            throw e;
        }

        return pais;
    }

    public List<Pais> findByCriteriaInPais(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return paisLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Pais> findPagePais(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return paisLogic.findPagePais(sortColumnName, sortAscending, startRow,
            maxResults);
    }

    public Long findTotalNumberPais() throws Exception {
        return paisLogic.findTotalNumberPais();
    }

    public List<PaisDTO> getDataPais() throws Exception {
        return paisLogic.getDataPais();
    }

    public void validatePais(Pais pais) throws Exception {
        paisLogic.validatePais(pais);
    }

    public List<Partido> getPartido() throws Exception {
        return partidoLogic.getPartido();
    }

    public void savePartido(Partido entity) throws Exception {
        partidoLogic.savePartido(entity);
    }

    public void deletePartido(Partido entity) throws Exception {
        partidoLogic.deletePartido(entity);
    }

    public void updatePartido(Partido entity) throws Exception {
        partidoLogic.updatePartido(entity);
    }

    public Partido getPartido(Integer partidoId) throws Exception {
        Partido partido = null;

        try {
            partido = partidoLogic.getPartido(partidoId);
        } catch (Exception e) {
            throw e;
        }

        return partido;
    }

    public List<Partido> findByCriteriaInPartido(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return partidoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Partido> findPagePartido(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return partidoLogic.findPagePartido(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberPartido() throws Exception {
        return partidoLogic.findTotalNumberPartido();
    }

    public List<PartidoDTO> getDataPartido() throws Exception {
        return partidoLogic.getDataPartido();
    }

    public void validatePartido(Partido partido) throws Exception {
        partidoLogic.validatePartido(partido);
    }

    public List<Persona> getPersona() throws Exception {
        return personaLogic.getPersona();
    }

    public void savePersona(Persona entity) throws Exception {
        personaLogic.savePersona(entity);
    }

    public void deletePersona(Persona entity) throws Exception {
        personaLogic.deletePersona(entity);
    }

    public void updatePersona(Persona entity) throws Exception {
        personaLogic.updatePersona(entity);
    }

    public Persona getPersona(Integer personaId) throws Exception {
        Persona persona = null;

        try {
            persona = personaLogic.getPersona(personaId);
        } catch (Exception e) {
            throw e;
        }

        return persona;
    }

    public List<Persona> findByCriteriaInPersona(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return personaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Persona> findPagePersona(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return personaLogic.findPagePersona(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberPersona() throws Exception {
        return personaLogic.findTotalNumberPersona();
    }

    public List<PersonaDTO> getDataPersona() throws Exception {
        return personaLogic.getDataPersona();
    }

    public void validatePersona(Persona persona) throws Exception {
        personaLogic.validatePersona(persona);
    }

    public List<ReservaCancha> getReservaCancha() throws Exception {
        return reservaCanchaLogic.getReservaCancha();
    }

    public void saveReservaCancha(ReservaCancha entity)
        throws Exception {
        reservaCanchaLogic.saveReservaCancha(entity);
    }

    public void deleteReservaCancha(ReservaCancha entity)
        throws Exception {
        reservaCanchaLogic.deleteReservaCancha(entity);
    }

    public void updateReservaCancha(ReservaCancha entity)
        throws Exception {
        reservaCanchaLogic.updateReservaCancha(entity);
    }

    public ReservaCancha getReservaCancha(Integer reservaCanchaId)
        throws Exception {
        ReservaCancha reservaCancha = null;

        try {
            reservaCancha = reservaCanchaLogic.getReservaCancha(reservaCanchaId);
        } catch (Exception e) {
            throw e;
        }

        return reservaCancha;
    }

    public List<ReservaCancha> findByCriteriaInReservaCancha(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception {
        return reservaCanchaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<ReservaCancha> findPageReservaCancha(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return reservaCanchaLogic.findPageReservaCancha(sortColumnName,
            sortAscending, startRow, maxResults);
    }

    public Long findTotalNumberReservaCancha() throws Exception {
        return reservaCanchaLogic.findTotalNumberReservaCancha();
    }

    public List<ReservaCanchaDTO> getDataReservaCancha()
        throws Exception {
        return reservaCanchaLogic.getDataReservaCancha();
    }

    public void validateReservaCancha(ReservaCancha reservaCancha)
        throws Exception {
        reservaCanchaLogic.validateReservaCancha(reservaCancha);
    }

    public List<Ronda> getRonda() throws Exception {
        return rondaLogic.getRonda();
    }

    public void saveRonda(Ronda entity) throws Exception {
        rondaLogic.saveRonda(entity);
    }

    public void deleteRonda(Ronda entity) throws Exception {
        rondaLogic.deleteRonda(entity);
    }

    public void updateRonda(Ronda entity) throws Exception {
        rondaLogic.updateRonda(entity);
    }

    public Ronda getRonda(Integer rondaId) throws Exception {
        Ronda ronda = null;

        try {
            ronda = rondaLogic.getRonda(rondaId);
        } catch (Exception e) {
            throw e;
        }

        return ronda;
    }

    public List<Ronda> findByCriteriaInRonda(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return rondaLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Ronda> findPageRonda(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return rondaLogic.findPageRonda(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberRonda() throws Exception {
        return rondaLogic.findTotalNumberRonda();
    }

    public List<RondaDTO> getDataRonda() throws Exception {
        return rondaLogic.getDataRonda();
    }

    public void validateRonda(Ronda ronda) throws Exception {
        rondaLogic.validateRonda(ronda);
    }

    public List<Set> getSet() throws Exception {
        return setLogic.getSet();
    }

    public void saveSet(Set entity) throws Exception {
        setLogic.saveSet(entity);
    }

    public void deleteSet(Set entity) throws Exception {
        setLogic.deleteSet(entity);
    }

    public void updateSet(Set entity) throws Exception {
        setLogic.updateSet(entity);
    }

    public Set getSet(Integer setId) throws Exception {
        Set set = null;

        try {
            set = setLogic.getSet(setId);
        } catch (Exception e) {
            throw e;
        }

        return set;
    }

    public List<Set> findByCriteriaInSet(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return setLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Set> findPageSet(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception {
        return setLogic.findPageSet(sortColumnName, sortAscending, startRow,
            maxResults);
    }

    public Long findTotalNumberSet() throws Exception {
        return setLogic.findTotalNumberSet();
    }

    public List<SetDTO> getDataSet() throws Exception {
        return setLogic.getDataSet();
    }

    public void validateSet(Set set) throws Exception {
        setLogic.validateSet(set);
    }

    public List<Torneo> getTorneo() throws Exception {
        return torneoLogic.getTorneo();
    }

    public void saveTorneo(Torneo entity) throws Exception {
        torneoLogic.saveTorneo(entity);
    }

    public void deleteTorneo(Torneo entity) throws Exception {
        torneoLogic.deleteTorneo(entity);
    }

    public void updateTorneo(Torneo entity) throws Exception {
        torneoLogic.updateTorneo(entity);
    }

    public Torneo getTorneo(Integer torneoId) throws Exception {
        Torneo torneo = null;

        try {
            torneo = torneoLogic.getTorneo(torneoId);
        } catch (Exception e) {
            throw e;
        }

        return torneo;
    }

    public List<Torneo> findByCriteriaInTorneo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception {
        return torneoLogic.findByCriteria(variables, variablesBetween,
            variablesBetweenDates);
    }

    public List<Torneo> findPageTorneo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception {
        return torneoLogic.findPageTorneo(sortColumnName, sortAscending,
            startRow, maxResults);
    }

    public Long findTotalNumberTorneo() throws Exception {
        return torneoLogic.findTotalNumberTorneo();
    }

    public List<TorneoDTO> getDataTorneo() throws Exception {
        return torneoLogic.getDataTorneo();
    }

    public void validateTorneo(Torneo torneo) throws Exception {
        torneoLogic.validateTorneo(torneo);
    }
    
    public Equipo buscar(String nombreEquipo) throws Exception{
    	return equipoLogic.buscar(nombreEquipo);
    }
    
    public List<Torneo> listarActivos() throws Exception{
    	return torneoLogic.listarActivos();
    }

	@Override
	public EquipoDTO getEquipoDTOByPartido(Integer equipoId, Integer partido) throws Exception {
		return equipoLogic.getEquipoDTOByPartido(equipoId, partido);
	}

	@Override
	public List<EquipoDTO> darPunto(EquipoDTO equipoGanador, EquipoDTO equipoPerdedor, Partido partido) throws Exception {
		return partidoLogic.darPunto(equipoGanador, equipoPerdedor, partido);
	}
    
    public void inscribirEquipo(EquipoTorneo equipoTorneo) throws Exception {
    	torneoLogic.inscribirEquipo(equipoTorneo);
    }
    
    public List<Partido> listarPendientes() throws Exception {
    	return partidoLogic.listarPendientes();
    }
    
    public void asignarCancha(ReservaCancha reservaCancha) throws Exception{
    	canchaLogic.asignarCancha(reservaCancha);
    }
    
    public List<Cancha> buscarDisponibles() throws Exception{
    	return canchaLogic.buscarDisponibles();
    }
} 
