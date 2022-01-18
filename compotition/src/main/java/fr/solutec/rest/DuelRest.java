package fr.solutec.rest;

import java.util.List;
import java.util.Optional;

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

	@GetMapping("duel/informations/{id}")
	public Optional<Duel> getInformationsDuelById(@PathVariable Long id) {
		return duelRepos.findById(id);
	}

	@PutMapping("duel/informations/modifier")
	public Duel setInformationsDuel(@RequestBody Duel d) {
		return duelRepos.save(d);
	}
	
	@GetMapping("duel/natif")
	public List<Object> lesDuels(){
		return duelRepos.retourDuel();
	}
}
