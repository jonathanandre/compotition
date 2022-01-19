package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Competition;
import fr.solutec.entities.CreationPari;
import fr.solutec.repository.CompetitionRepository;
import fr.solutec.repository.CreationPariRepository;

@RestController
@CrossOrigin("*")

public class CreationPariRest {

	@Autowired
	private CreationPariRepository creationpariRepos;
	@Autowired
	private CompetitionRepository competitionRepos;

	// retourne toutes les créations de paris de la bdd
	@GetMapping("creationpari")
	public Iterable<CreationPari> getAllCreationPari() {
		return creationpariRepos.findAll();
	}

	// retourne toutes les créations de paris de la bdd
	@GetMapping("creationpari/{id}")
	public Iterable<CreationPari> getCreationPariOfCompetition(@PathVariable Long id) {
		Optional<Competition> c = competitionRepos.findById(id);
		if (c.isPresent()) {
			return creationpariRepos.findByCompetition(c.get());
		} else {
			return null;
		}
	}

	// ajouter une création de pari
	@PostMapping("creationpari")
	public CreationPari ajouterCreationPari(@RequestBody CreationPari c) {
		return creationpariRepos.save(c);
	}

	// enlever création de pari
	@DeleteMapping("creationpari/{id}")
	public boolean enleverCreationPari(@PathVariable Long id) {
		Optional<CreationPari> c = creationpariRepos.findById(id);
		if (c.isPresent()) {
			creationpariRepos.deleteById(id);
			return true;
		} else {
			return false;
		}
	}
}
