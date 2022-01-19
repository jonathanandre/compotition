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

import fr.solutec.entities.AppartenanceGroupe;
import fr.solutec.repository.AppartenanceGroupeRepository;

@RestController
@CrossOrigin("*")
public class AppartenanceGroupeRest {
	@Autowired
	private AppartenanceGroupeRepository appartenanceGroupeRepos;

	@GetMapping("groupes/mes-groupes/{id}")
	public List<AppartenanceGroupe> getGroupesByIdUtilisateur(@PathVariable Long id) {
		return appartenanceGroupeRepos.findByUtilisateurId(id);
	}

	@GetMapping("groupes/classement/{id}")
	public List<AppartenanceGroupe> getClassementByIdGroupe(@PathVariable Long id) {
		return appartenanceGroupeRepos.findByGroupeId(id);

	}

	@PostMapping("groupes/ajout-personnes")
	public AppartenanceGroupe ajouterUtilisateursDansGroupe(@RequestBody AppartenanceGroupe ag) {
		return appartenanceGroupeRepos.save(ag);

	}

	// Obtenir les informations d'une "appartenance groupe" avec l'id du groupe et
	// le login utilisateur
	@GetMapping("groupes/{id}/{login}")
	public Optional<AppartenanceGroupe> getPointsUtilisateursDansGroupe(@PathVariable Long id,
			@PathVariable String login) {
		return appartenanceGroupeRepos.findByGroupeIdAndUtilisateurLogin(id, login);

	}

	@PutMapping("groupes/modification-personnes")
	public AppartenanceGroupe modifierUtilisateursDansGroupe(@RequestBody AppartenanceGroupe ag) {
		return appartenanceGroupeRepos.save(ag);

	}

	// Avec id_groupe et login utilisateur
	@DeleteMapping("groupes/supprimer-personnes/{id}/{login}")
	public boolean deleteUtilisateurDansGroupe(@PathVariable Long id, @PathVariable String login) {
		Optional<AppartenanceGroupe> ag = appartenanceGroupeRepos.findByGroupeIdAndUtilisateurLogin(id, login);
		if (ag.isPresent()) {
			appartenanceGroupeRepos.delete(ag.get());
			return true;
		} else {
			return false;
		}
	}

	@GetMapping("groupes/appartenance/all")
	public Iterable<AppartenanceGroupe> getAllAppartenanceGroupe() {
		return appartenanceGroupeRepos.findAll();
	}
}
