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

import fr.solutec.entities.Groupe;
import fr.solutec.repository.GroupeRepository;

@RestController
@CrossOrigin("*")
public class GroupeRest {
	@Autowired
	private GroupeRepository groupeRepos;

	@PostMapping("groupes/creer")
	public Groupe creerGroupe(@RequestBody Groupe g) {
		return groupeRepos.save(g);
	}

	@PutMapping("groupes/informations/modifier")
	public Groupe modifierInformationsGroupe(@RequestBody Groupe g) {
		return groupeRepos.save(g);
	}

	@GetMapping("groupes/all")
	public Iterable<Groupe> getAllGroupe() {
		return groupeRepos.findAll();
	}

	@DeleteMapping("groupes/supprimer/{id}")
	public boolean supprimerGroupe(@PathVariable Long id) {
		Optional<Groupe> g = groupeRepos.findById(id);
		if (g.isPresent()) {
			groupeRepos.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
