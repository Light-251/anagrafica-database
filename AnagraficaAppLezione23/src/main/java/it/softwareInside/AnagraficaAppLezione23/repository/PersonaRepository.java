package it.softwareInside.AnagraficaAppLezione23.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.softwareInside.AnagraficaAppLezione23.models.Persona;

public interface PersonaRepository extends CrudRepository<Persona, String> {

    @Query(value = "SELECT SUM(eta) FROM PERSONA", nativeQuery = true)
    int sommaEta();

    @Query(value = "SELECT * FROM Persona WHERE eta >= 25", nativeQuery = true)
    List<Persona> getAllPersoneMaggioridi25();

    @Query(value = "SELECT * FROM Persona WHERE eta >= ?1", nativeQuery = true) // ?1 -> prende il primo parametro nella firma del metodo
    List<Persona> getAllPersoneMaggiori(int etaPersona);

    @Query(value = "SELECT * FROM Persona WHERE eta >= :etaPersona", nativeQuery = true) // :etaPersona -> prende il parametro chiamato etaPersona alla riga sotto
    List<Persona> getAllPersoneMaggiori2(@Param("etaPersona") int etaPersona);

}
