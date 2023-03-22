package it.softwareInside.AnagraficaAppLezione23.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import it.softwareInside.AnagraficaAppLezione23.models.Persona;
import it.softwareInside.AnagraficaAppLezione23.services.PersonaService;

@RequestMapping("/api/") // tutte le rotte cominceranno con /api/ => ES: localhost:8080/api/add-persona
@RestController
public class PersonaRestController {

	@Autowired
	PersonaService personaService;

	@PostMapping("/add-persona")
	public String addPersona(@RequestBody Persona persona) {
		if (personaService.addPersona(persona))
			return persona + " Aggiunto al DB";
		return "Non ho aggiunto: " + persona;
	}

	@PostMapping("/update-persona")
	public boolean updatePersona(@RequestBody Persona persona) {
		return personaService.addPersona(persona);
	}

	@DeleteMapping("/delete-by-id")
	public Persona deletePersona(@RequestParam(value = "id") String id) {
		return personaService.deletePersona(id);
	}

	@DeleteMapping("/delete-all")
	public String deleteAllPersona() {
		if (personaService.deleteAll())
			return "Ho rimosso tutte le persone dal DB";
		return "Qualcosa è andato storto";
	}

	@GetMapping("/get-persona-by-id")
	public Persona getPersona(@RequestParam String id) {
		return personaService.getPersonaById(id);
	}

	@GetMapping("/all-persona")
	public Iterable<Persona> getAllPersona() {
		return personaService.getAllPersona();
	}

	@GetMapping("/persona-over")
	public Iterable<Persona> getPersonaOver() {
		return personaService.getPersonaOver();
	}

	@GetMapping("/all-query")
	public List<Persona> getAllPersonaQuery(@RequestParam("eta") int eta) {
		return personaService.getAllPersoneMaggioriDiEta(eta);
	}
}
