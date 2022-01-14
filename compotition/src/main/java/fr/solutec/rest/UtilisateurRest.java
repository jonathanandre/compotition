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

import fr.solutec.entities.Utilisateur;
import fr.solutec.repository.UtilisateurRepository;

@RestController
@CrossOrigin("*")
public class UtilisateurRest {
	@Autowired
	private UtilisateurRepository utilisateurRepos;

	@PostMapping("utilisateur/connexion")
	public Optional<Utilisateur> connexion(@RequestBody Utilisateur u) {
		return utilisateurRepos.findByLoginAndMdp(u.getLogin(), u.getMdp());
	}

	@PostMapping("utilisateur/inscription")
	public Utilisateur inscription(@RequestBody Utilisateur u) {
		return utilisateurRepos.save(u);
	}

	@GetMapping("utilisateur/informations/{id}")
	public Optional<Utilisateur> getInformationsUtilisateurById(@PathVariable Long id) {
		return utilisateurRepos.findById(id);
	}

	@PutMapping("utilisateur/informations/modifier")
	public Utilisateur setInformationsUtilisateur(@RequestBody Utilisateur u) {
		return utilisateurRepos.save(u);
	}

}
