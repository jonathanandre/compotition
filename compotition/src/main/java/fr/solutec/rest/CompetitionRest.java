package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

	@PostMapping("competition/creercompetition")
	public Competition creerCompetition(@RequestBody Competition c) {
		return competitionRepos.save(c);
	}

	@GetMapping("competition/informationscompetition/{id}")
	public Optional<Competition> getInformationsCompetitionById(@PathVariable Long id) {
		return competitionRepos.findById(id);
	}

	@PutMapping("competition/informationscompetition/modifier")
	public Competition setInformationsCompetition(@RequestBody Competition c) {
		return competitionRepos.save(c);
	}
}
