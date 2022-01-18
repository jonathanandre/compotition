package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Duel;
import fr.solutec.repository.DuelRepository;

@RestController
@CrossOrigin("*")
public class DuelRest {
	@Autowired
	private DuelRepository duelRepos;

	@PostMapping("duel/creer")
	public Duel creerDuel(@RequestBody Duel d) {
		return duelRepos.save(d);
	}

	@GetMapping("duel/informations/{login}")
	public List<Duel> getDuelsByLogin(@PathVariable String login) {
		return duelRepos.findByAdversaire1LoginOrAdversaire2Login(login, login);
	}

	@PutMapping("duel/informations/modifier")
	public Duel setInformationsDuel(@RequestBody Duel d) {
		return duelRepos.save(d);
	}

	@GetMapping("competition/duels/{id}")
	public List<Duel> getDuelsByLogin(@PathVariable Long id) {
		return duelRepos.findByCompetitionId(id);
	}

	// Accéder aux duels d'une compétition entre deux utilisateurs
	@GetMapping("competition/{id}/duels/{login}/{login2}")
	public List<Duel> getDuelByCompetitionAndAdversaires(@PathVariable Long id, @PathVariable String login,
			@PathVariable String login2) {
		return duelRepos.findByCompetitionIdAndAdversaire1LoginAndAdversaire2Login(id, login, login2);
	}

	// Accéder aux duels d'un utilisateur dans une compétition
	@GetMapping("competition/{id}/duels-liste/{login}/{login2}")
	public List<Duel> getDuelByCompetitionAndUtilisateur(@PathVariable Long id, @PathVariable String login,
			@PathVariable String login2) {
		return duelRepos.findByCompetitionIdAndAdversaire1LoginOrAdversaire2Login(id, login, login2);
	}

	@GetMapping("duel/natif")
	public List<Object> lesDuels() {
		return duelRepos.retourDuel();

	}

}
