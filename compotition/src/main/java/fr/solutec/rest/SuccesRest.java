package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Succes;
import fr.solutec.repository.SuccesRepository;

@RestController
@CrossOrigin("*")
public class SuccesRest {
	@Autowired
	private SuccesRepository succesRepos;

	@GetMapping("succes/all")
	public Iterable<Succes> getAllSucces() {
		return succesRepos.findAll();
	}

	@GetMapping("succes/by-id/{id}")
	public Optional<Succes> getSuccesById(@PathVariable Long id) {
		return succesRepos.findById(id);
	}

	@GetMapping("succes/by-libelle/{libelle}")
	public Optional<Succes> getSuccesByLibelle(@PathVariable String libelle) {
		return succesRepos.findByLibelle(libelle);
	}

	@PostMapping("succes/ajouter")
	public Succes ajouterUnSucces(@RequestBody Succes s) {
		return succesRepos.save(s);
	}

	@PutMapping("succes/modifier")
	public Succes modifierUnSucces(@RequestBody Succes s) {
		return succesRepos.save(s);
	}

	@DeleteMapping("succes/{libelle}/supprimer")
	public boolean deleteSucces(@PathVariable String libelle) {
		Optional<Succes> s = succesRepos.findByLibelle(libelle);
		if (s.isPresent()) {
			succesRepos.delete(s.get());
			return true;
		} else {
			return false;
		}
	}

}
