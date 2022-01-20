package fr.solutec.rest;

import java.util.Date;
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

	@GetMapping("competition/competition/{id}")
	public List<Participe> getParticipationByCompetition(@PathVariable Long id) {
		return participeRepos.findByCompetitionId(id);
	}

	// Avec id compétition et login utilisateur
	@GetMapping("competition/{id}/participation/utilisateur/{login}")
	public Optional<Participe> getUniqueParticiaption(@PathVariable Long id, @PathVariable String login) {
		return participeRepos.findByCompetitionIdAndUtilisateurLogin(id, login);
	}

	// Avec id compétition et login utilisateur
	@DeleteMapping("competition/{id}/participation/supprimer/{login}")
	public boolean deleteParticipation(@PathVariable Long id, @PathVariable String login) {
		Optional<Participe> p = participeRepos.findByCompetitionIdAndUtilisateurLogin(id, login);
		if (p.isPresent()) {
			participeRepos.delete(p.get());
			return true;
		} else {
			return false;
		}
	}

	// Tous les participants d'une compétition
	@GetMapping("competition/{id}/participants")
	public List<Participe> getParticipantsCompetition(@PathVariable Long id) {
		return participeRepos.findByCompetitionId(id);
	}

	// Avec id compétition et login utilisateur
	@GetMapping("competition/{id}/participation/utilisateur/boolean/{login}")
	public boolean getBooleanUniqueParticiaption(@PathVariable Long id, @PathVariable String login) {
		Optional<Participe> p = participeRepos.findByCompetitionIdAndUtilisateurLogin(id, login);
		if (p.isPresent()) {
			return true;
		} else {
			return false;
		}
	}

	@GetMapping("utilisateur/competition-passees/informations/{login}")
	public List<Participe> getUtilisateurCompetitionPassees(@PathVariable String login) {
		Date d = new Date();
		return participeRepos.findByUtilisateurLoginAndCompetitionDateFinBefore(login, d);
	}

	@GetMapping("utilisateur/competition-en-cours/informations/{login}")
	public List<Participe> getUtilisateurCompetitionEnCours(@PathVariable String login) {
		Date d = new Date();
		return participeRepos
				.findByUtilisateurLoginAndCompetitionDateDebutBeforeAndCompetitionDateFinIsNullOrCompetitionDateDebutBeforeAndCompetitionDateFinAfter(
						login, d, d, d);
	}

	@GetMapping("utilisateur/competition-a-venir/informations/{login}")
	public List<Participe> getUtilisateurCompetitionAVenir(@PathVariable String login) {
		Date d = new Date();
		return participeRepos.findByUtilisateurLoginAndCompetitionDateDebutAfter(login, d);
	}

}
