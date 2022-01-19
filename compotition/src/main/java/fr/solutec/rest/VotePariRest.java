package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.VotePari;
import fr.solutec.repository.VotePariRepository;

@RestController
@CrossOrigin("*")

public class VotePariRest {
	@Autowired
	private VotePariRepository votepariRepos;

	// retourne tous les paris de la bdd
	@GetMapping("votepari")
	public Iterable<VotePari> getAllVotePari() {
		return votepariRepos.findAll();
	}

}
