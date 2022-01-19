package fr.solutec.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	@GetMapping("competition/participation/{login}")
	public List<Participe> getInformationsParticipationByLogin(@PathVariable String login) {
		return participeRepos.findByUtilisateurLogin(login);
	}

	// Avec id compétition et login utilisateur
	@GetMapping("competition/{id}/participation/utilisateur/{login}")
	public Optional<Participe> getUniqueParticiaption(@PathVariable Long id, @PathVariable String login) {
		return participeRepos.findByCompetitionIdAndUtilisateurLogin(id, login);
	}

	// Avec id compétition et login utilisateur
	@DeleteMapping("competition/{id}/participation/supprimer/{login}")
	public boolean deleteUtilisateur(@PathVariable Long id, @PathVariable String login) {
		Optional<Participe> p = participeRepos.findByCompetitionIdAndUtilisateurLogin(id, login);
		if (p.isPresent()) {
			participeRepos.delete(p.get());
			return true;
		} else {
			return false;
		}
	}

}
