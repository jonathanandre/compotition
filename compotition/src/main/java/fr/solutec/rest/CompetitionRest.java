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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Competition;
import fr.solutec.repository.CompetitionRepository;

@RestController
@CrossOrigin("*")
public class CompetitionRest {
	@Autowired
	private CompetitionRepository competitionRepos;

	@GetMapping("competition/all")
	public Iterable<Competition> getAllCompetition() {
		return competitionRepos.findAll();
	}

	@PostMapping("competition/creer")
	public Competition creerCompetition(@RequestBody Competition c) {
		return competitionRepos.save(c);
	}

	@GetMapping("competition/informations/{id}")
	public Optional<Competition> getInformationsCompetitionById(@PathVariable Long id) {
		return competitionRepos.findById(id);
	}

	@PutMapping("competition/informations/modifier")
	public Competition setInformationsCompetition(@RequestBody Competition c) {
		return competitionRepos.save(c);
	}

	@GetMapping("groupe/competition/informations/{id}")
	public List<Competition> getCompetitionByGroupeId(@PathVariable Long id) {
		return competitionRepos.findByGroupeId(id);
	}

	@GetMapping("utilisateur/organisateur/competition/informations/{login}")
	public List<Competition> getCompetitionByOrganisateurLogin(@PathVariable String login) {
		return competitionRepos.findByOrganisateurLogin(login);
	}

	@GetMapping("competition/publique/pariable")
	public List<Competition> getCompetitionPubliquePariable() {
		return competitionRepos.findByPariAndGroupe(true, null);
	}

	@GetMapping("groupe/competition-en-cours/informations/{id}")
	public List<Competition> getCompetitionEnCours(@PathVariable Long id) {
		Date d = new Date();
		return competitionRepos.findByGroupeIdAndDateDebutBeforeAndDateFinIsNullOrDateDebutBeforeAndDateFinAfter(id, d,
				d, d);
	}

	@GetMapping("groupe/competition-passees/informations/{id}")
	public List<Competition> getCompetitionPassees(@PathVariable Long id) {
		Date d = new Date();
		return competitionRepos.findByGroupeIdAndDateFinBefore(id, d);
	}

	@GetMapping("groupe/competition-a-venir/informations/{id}")
	public List<Competition> getCompetitionAVenir(@PathVariable Long id) {
		Date d = new Date();
		return competitionRepos.findByGroupeIdAndDateDebutAfter(id, d);
	}

	// NE PAS UTILISER - DEPENDANTE D'AUTRE CONTRAINTES QUI EMPECHE LA SUPPRESSION -
	// VOIR PLUS TARD
	@DeleteMapping("competition/supprimer/{id}")
	public boolean deleteCompetition(@PathVariable Long id) {
		Optional<Competition> c = competitionRepos.findById(id);
		if (c.isPresent()) {
			competitionRepos.delete(c.get());
			return true;
		} else {
			return false;
		}
	}
}
