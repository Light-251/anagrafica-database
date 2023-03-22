package it.softwareInside.AnagraficaAppLezione23.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import it.softwareInside.AnagraficaAppLezione23.models.Persona;
import it.softwareInside.AnagraficaAppLezione23.repository.PersonaRepository;
import jakarta.validation.Valid;

@Service
public class PersonaService {

	@Autowired
	PersonaRepository personaRepository;

	/**
	 * Aggiunge una persona al DB
	 * 
	 * @param persona
	 * @return
	 */
	public boolean addPersona(@Valid Persona persona) {
		try {
			personaRepository.save(persona);
			return true;
		} catch (Exception e) {
			System.err.println("Non posso aggiungere " + persona + " " + e);
			return false;
		}
	}

	/**
	 * Ritorna una persona presente nel DB
	 * specificando l'id
	 * 
	 * @param id
	 * @return
	 */
	public Persona getPersonaById(String id) {
		try {
			return personaRepository.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Rimuove una persona dal DB e ritorna l'oggetto rimosso
	 * 
	 * @param id
	 * @return
	 */
	public Persona deletePersona(String id) {
		try {
			Persona personaRemoved = getPersonaById(id);
			personaRepository.deleteById(id);
			return personaRemoved;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Rimuove tutte le persone dal DB
	 * 
	 * @return
	 */
	public boolean deleteAll() {
		try {
			personaRepository.deleteAll();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Ritorna tutte le persone nel DB
	 * 
	 * @return
	 */
	public Iterable<Persona> getAllPersona() {
		return personaRepository.findAll();
	}

	/**
	 * Ritorna la lista di persone maggiori di 25 anni
	 * 
	 * @return
	 */
	public Iterable<Persona> getPersonaOver() {
		Iterable<Persona> persone = getAllPersona();
		ArrayList<Persona> personeOver = new ArrayList<>();
		for (Persona persona : persone)
			if (persona.getEta() >= 25)
				personeOver.add(persona);

		return personeOver;

	}

	/**
	 * Ritorna le persone con età maggiore a quella indicata
	 * usando una query personalizzata nel PersonaRepository
	 * 
	 * @param eta
	 * @return
	 */
	public List<Persona> getAllPersoneMaggioriDiEta(int eta) {
		return personaRepository.getAllPersoneMaggiori(eta);
	}
}
