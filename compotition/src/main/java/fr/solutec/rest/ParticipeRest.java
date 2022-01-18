package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Participe;
import fr.solutec.repository.ParticipeRepository;

@RestController
@CrossOrigin("*")
public class ParticipeRest {
	@Autowired
	private ParticipeRepository participeRepos;

	@GetMapping("competition/participation/all")
	public Iterable<Participe> getAllParticipant() {
		return participeRepos.findAll();
	}

	@PostMapping("competition/participation/ajouter")
	public Participe ajouterParticipation(@RequestBody Participe p) {
		return participeRepos.save(p);
	}

}
