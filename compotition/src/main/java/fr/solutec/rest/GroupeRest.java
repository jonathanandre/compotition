package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

}
