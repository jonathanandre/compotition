package fr.solutec.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.SuccesUtilisateur;
import fr.solutec.repository.SuccesUtilisateurRepository;

@RestController
@CrossOrigin("*")
public class SuccesUtilisateurRest {
	@Autowired
	private SuccesUtilisateurRepository succesUtilisateurRepos;

	@GetMapping("utilisateur/succes/all")
	public Iterable<SuccesUtilisateur> getAllSuccesUtilisateur() {
		return succesUtilisateurRepos.findAll();
	}

	@GetMapping("utilisateur/{login}/mes-succes")
	public Iterable<SuccesUtilisateur> avoirLesSuccesDUnUtilisateur(@PathVariable String login) {
		return succesUtilisateurRepos.findByUtilisateurLogin(login);
	}

	@GetMapping("succes/{libelle}")
	public Iterable<SuccesUtilisateur> avoirTousLesUtilisateursQuiOntDebloqueUnSucces(@PathVariable String libelle) {
		return succesUtilisateurRepos.findBySuccesLibelle(libelle);
	}

	@PostMapping("utilisateur/succes/ajouter")
	public SuccesUtilisateur avoirTousLesUtilisateursQuiOntDebloqueUnSucces(@RequestBody SuccesUtilisateur su) {
		return succesUtilisateurRepos.save(su);
	}

	@DeleteMapping("utilisateur/{login}/succes/{libelle}/supprimer")
	public boolean deleteSuccesUtilisateur(@PathVariable String login, @PathVariable String libelle) {
		Optional<SuccesUtilisateur> su = succesUtilisateurRepos.findByUtilisateurLoginAndSuccesLibelle(login, libelle);
		if (su.isPresent()) {
			succesUtilisateurRepos.delete(su.get());
			return true;
		} else {
			return false;
		}
	}

}
