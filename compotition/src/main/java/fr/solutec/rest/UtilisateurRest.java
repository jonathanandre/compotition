package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Utilisateur;
import fr.solutec.repository.UtilisateurRepository;

@RestController
@CrossOrigin("*")
public class UtilisateurRest {
	@Autowired
	private UtilisateurRepository utilisateurRepos;

	@PostMapping("connexion")
	public Optional<Utilisateur> connexion(@RequestBody Utilisateur u) {
		return utilisateurRepos.findByLoginAndMdp(u.getLogin(), u.getMdp());
	}

	@PostMapping("inscription")
	public Utilisateur inscription(@RequestBody Utilisateur u) throws Exception {
		return utilisateurRepos.save(u);
	}

}
