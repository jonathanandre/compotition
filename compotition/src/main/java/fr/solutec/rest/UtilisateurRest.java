package fr.solutec.rest;

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

	@GetMapping("utilisateur/amitie/{login}")
	public Optional<Utilisateur> getInformationsUtilisateurByLogin(@PathVariable String login) {
		return utilisateurRepos.findByLogin(login);
	}

	@GetMapping("utilisateur/amitie2/{email}")
	public Optional<Utilisateur> getInformationsUtilisateurByEmail(@PathVariable String email) {
		return utilisateurRepos.findByLogin(email);
	}

	@GetMapping("utilisateur/all")
	public Iterable<Utilisateur> getAllUtilisateurs() {
		return utilisateurRepos.findAll();
	}

	@DeleteMapping("utilisateur/supprimer/{login}")
	public boolean deleteUtilisateur(@PathVariable String login) {
		Optional<Utilisateur> u = utilisateurRepos.findByLogin(login);
		if (u.isPresent()) {
			utilisateurRepos.delete(u.get());
			return true;
		} else {
			return false;
		}
	}

	@GetMapping("utilisateur/classement-global")
	public List<Utilisateur> getAllUtilisateursClassementGlobal() {
		return utilisateurRepos.findAllByOrderByPointsGlobalDesc();
	}

	@GetMapping("utilisateur/classement-pari")
	public List<Utilisateur> getAllUtilisateursClassementPari() {
		return utilisateurRepos.findAllByOrderByPointsPariDesc();
	}

}
