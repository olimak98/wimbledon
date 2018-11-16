package co.edu.usbcali.wimbledon.presentation.businessDelegate;

import java.util.List;

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
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
public interface IBusinessDelegatorView {
    public List<Cancha> getCancha() throws Exception;

    public void saveCancha(Cancha entity) throws Exception;

    public void deleteCancha(Cancha entity) throws Exception;

    public void updateCancha(Cancha entity) throws Exception;

    public Cancha getCancha(Integer canchaId) throws Exception;

    public List<Cancha> findByCriteriaInCancha(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Cancha> findPageCancha(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberCancha() throws Exception;

    public List<CanchaDTO> getDataCancha() throws Exception;

    public void validateCancha(Cancha cancha) throws Exception;

    public List<Director> getDirector() throws Exception;

    public void saveDirector(Director entity) throws Exception;

    public void deleteDirector(Director entity) throws Exception;

    public void updateDirector(Director entity) throws Exception;

    public Director getDirector(Integer directorId) throws Exception;

    public List<Director> findByCriteriaInDirector(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Director> findPageDirector(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberDirector() throws Exception;

    public List<DirectorDTO> getDataDirector() throws Exception;

    public void validateDirector(Director director) throws Exception;

    public List<Equipo> getEquipo() throws Exception;

    public void saveEquipo(Equipo entity) throws Exception;

    public void deleteEquipo(Equipo entity) throws Exception;

    public void updateEquipo(Equipo entity) throws Exception;

    public Equipo getEquipo(Integer equipoId) throws Exception;

    public List<Equipo> findByCriteriaInEquipo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Equipo> findPageEquipo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEquipo() throws Exception;

    public List<EquipoDTO> getDataEquipo() throws Exception;

    public void validateEquipo(Equipo equipo) throws Exception;

    public List<EquipoTorneo> getEquipoTorneo() throws Exception;

    public void saveEquipoTorneo(EquipoTorneo entity) throws Exception;

    public void deleteEquipoTorneo(EquipoTorneo entity)
        throws Exception;

    public void updateEquipoTorneo(EquipoTorneo entity)
        throws Exception;

    public EquipoTorneo getEquipoTorneo(Integer equipoTorneoId)
        throws Exception;

    public List<EquipoTorneo> findByCriteriaInEquipoTorneo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<EquipoTorneo> findPageEquipoTorneo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberEquipoTorneo() throws Exception;

    public List<EquipoTorneoDTO> getDataEquipoTorneo()
        throws Exception;

    public void validateEquipoTorneo(EquipoTorneo equipoTorneo)
        throws Exception;

    public List<Juez> getJuez() throws Exception;

    public void saveJuez(Juez entity) throws Exception;

    public void deleteJuez(Juez entity) throws Exception;

    public void updateJuez(Juez entity) throws Exception;

    public Juez getJuez(Integer juezId) throws Exception;

    public List<Juez> findByCriteriaInJuez(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Juez> findPageJuez(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberJuez() throws Exception;

    public List<JuezDTO> getDataJuez() throws Exception;

    public void validateJuez(Juez juez) throws Exception;

    public List<JuezTorneo> getJuezTorneo() throws Exception;

    public void saveJuezTorneo(JuezTorneo entity) throws Exception;

    public void deleteJuezTorneo(JuezTorneo entity) throws Exception;

    public void updateJuezTorneo(JuezTorneo entity) throws Exception;

    public JuezTorneo getJuezTorneo(Integer juezTorneoId)
        throws Exception;

    public List<JuezTorneo> findByCriteriaInJuezTorneo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<JuezTorneo> findPageJuezTorneo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberJuezTorneo() throws Exception;

    public List<JuezTorneoDTO> getDataJuezTorneo() throws Exception;

    public void validateJuezTorneo(JuezTorneo juezTorneo)
        throws Exception;

    public List<Jugador> getJugador() throws Exception;

    public void saveJugador(Jugador entity) throws Exception;

    public void deleteJugador(Jugador entity) throws Exception;

    public void updateJugador(Jugador entity) throws Exception;

    public Jugador getJugador(Integer jugadorId) throws Exception;

    public List<Jugador> findByCriteriaInJugador(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Jugador> findPageJugador(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberJugador() throws Exception;

    public List<JugadorDTO> getDataJugador() throws Exception;

    public void validateJugador(Jugador jugador) throws Exception;

    public List<JugadorEquipo> getJugadorEquipo() throws Exception;

    public void saveJugadorEquipo(JugadorEquipo entity)
        throws Exception;

    public void deleteJugadorEquipo(JugadorEquipo entity)
        throws Exception;

    public void updateJugadorEquipo(JugadorEquipo entity)
        throws Exception;

    public JugadorEquipo getJugadorEquipo(Integer jugadorEquipoId)
        throws Exception;

    public List<JugadorEquipo> findByCriteriaInJugadorEquipo(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<JugadorEquipo> findPageJugadorEquipo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberJugadorEquipo() throws Exception;

    public List<JugadorEquipoDTO> getDataJugadorEquipo()
        throws Exception;

    public void validateJugadorEquipo(JugadorEquipo jugadorEquipo)
        throws Exception;

    public List<Pais> getPais() throws Exception;

    public void savePais(Pais entity) throws Exception;

    public void deletePais(Pais entity) throws Exception;

    public void updatePais(Pais entity) throws Exception;

    public Pais getPais(Integer paisId) throws Exception;

    public List<Pais> findByCriteriaInPais(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Pais> findPagePais(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPais() throws Exception;

    public List<PaisDTO> getDataPais() throws Exception;

    public void validatePais(Pais pais) throws Exception;

    public List<Partido> getPartido() throws Exception;

    public void savePartido(Partido entity) throws Exception;

    public void deletePartido(Partido entity) throws Exception;

    public void updatePartido(Partido entity) throws Exception;

    public Partido getPartido(Integer partidoId) throws Exception;

    public List<Partido> findByCriteriaInPartido(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Partido> findPagePartido(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPartido() throws Exception;

    public List<PartidoDTO> getDataPartido() throws Exception;

    public void validatePartido(Partido partido) throws Exception;

    public List<Persona> getPersona() throws Exception;

    public void savePersona(Persona entity) throws Exception;

    public void deletePersona(Persona entity) throws Exception;

    public void updatePersona(Persona entity) throws Exception;

    public Persona getPersona(Integer personaId) throws Exception;

    public List<Persona> findByCriteriaInPersona(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Persona> findPagePersona(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberPersona() throws Exception;

    public List<PersonaDTO> getDataPersona() throws Exception;

    public void validatePersona(Persona persona) throws Exception;

    public List<ReservaCancha> getReservaCancha() throws Exception;

    public void saveReservaCancha(ReservaCancha entity)
        throws Exception;

    public void deleteReservaCancha(ReservaCancha entity)
        throws Exception;

    public void updateReservaCancha(ReservaCancha entity)
        throws Exception;

    public ReservaCancha getReservaCancha(Integer reservaCanchaId)
        throws Exception;

    public List<ReservaCancha> findByCriteriaInReservaCancha(
        Object[] variables, Object[] variablesBetween,
        Object[] variablesBetweenDates) throws Exception;

    public List<ReservaCancha> findPageReservaCancha(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberReservaCancha() throws Exception;

    public List<ReservaCanchaDTO> getDataReservaCancha()
        throws Exception;

    public void validateReservaCancha(ReservaCancha reservaCancha)
        throws Exception;

    public List<Ronda> getRonda() throws Exception;

    public void saveRonda(Ronda entity) throws Exception;

    public void deleteRonda(Ronda entity) throws Exception;

    public void updateRonda(Ronda entity) throws Exception;

    public Ronda getRonda(Integer rondaId) throws Exception;

    public List<Ronda> findByCriteriaInRonda(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Ronda> findPageRonda(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberRonda() throws Exception;

    public List<RondaDTO> getDataRonda() throws Exception;

    public void validateRonda(Ronda ronda) throws Exception;

    public List<Set> getSet() throws Exception;

    public void saveSet(Set entity) throws Exception;

    public void deleteSet(Set entity) throws Exception;

    public void updateSet(Set entity) throws Exception;

    public Set getSet(Integer setId) throws Exception;

    public List<Set> findByCriteriaInSet(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Set> findPageSet(String sortColumnName, boolean sortAscending,
        int startRow, int maxResults) throws Exception;

    public Long findTotalNumberSet() throws Exception;

    public List<SetDTO> getDataSet() throws Exception;

    public void validateSet(Set set) throws Exception;

    public List<Torneo> getTorneo() throws Exception;

    public void saveTorneo(Torneo entity) throws Exception;

    public void deleteTorneo(Torneo entity) throws Exception;

    public void updateTorneo(Torneo entity) throws Exception;

    public Torneo getTorneo(Integer torneoId) throws Exception;

    public List<Torneo> findByCriteriaInTorneo(Object[] variables,
        Object[] variablesBetween, Object[] variablesBetweenDates)
        throws Exception;

    public List<Torneo> findPageTorneo(String sortColumnName,
        boolean sortAscending, int startRow, int maxResults)
        throws Exception;

    public Long findTotalNumberTorneo() throws Exception;

    public List<TorneoDTO> getDataTorneo() throws Exception;

    public void validateTorneo(Torneo torneo) throws Exception;
    
    public Equipo buscar(String nombreEquipo) throws Exception;
    
    public List<Torneo> listarActivos() throws Exception;
    
    public void inscribirEquipo(EquipoTorneo equipoTorneo) throws Exception;
    
    public List<Partido> listarPendientes() throws Exception;
    
    public void asignarCancha(ReservaCancha reservaCancha) throws Exception;

	public EquipoDTO getEquipoDTOByPartido(Integer equipoId, Integer partido) throws Exception;

	public List<EquipoDTO> darPunto(EquipoDTO equipo, EquipoDTO equipoDTO, Partido partido) throws Exception;
	
	public List<Cancha> buscarDisponibles()throws Exception;
}
