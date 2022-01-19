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

import fr.solutec.entities.Competition;
import fr.solutec.entities.Utilisateur;
import fr.solutec.entities.VotePari;
import fr.solutec.repository.CompetitionRepository;
import fr.solutec.repository.UtilisateurRepository;
import fr.solutec.repository.VotePariRepository;

@RestController
@CrossOrigin("*")

public class VotePariRest {
	@Autowired
	private VotePariRepository votepariRepos;
	@Autowired
	private CompetitionRepository competitionRepos;
	@Autowired
	private UtilisateurRepository utilisateurRepos;

	// retourne tous les paris de la bdd
	@GetMapping("votepari")
	public Iterable<VotePari> getAllVotePari() {
		return votepariRepos.findAll();
	}

	// retourne les paris liés à une compétition
	@GetMapping("votepari/competition/{id}")
	public Iterable<VotePari> getVotePariOfCompetition(@PathVariable Long id) {
		Optional<Competition> c = competitionRepos.findById(id);
		if (c.isPresent()) {
			return votepariRepos.findByCompetition(c.get());
		} else {
			return null;
		}

	}

	// retourne les paris liés à un prédicteur
	@GetMapping("votepari/predicteur/{id}")
	public Iterable<VotePari> getVotePariOfPredicteur(@PathVariable Long id) {
		Optional<Utilisateur> u = utilisateurRepos.findById(id);
		if (u.isPresent()) {
			return votepariRepos.findByPredicteur(u.get());
		} else {
			return null;
		}

	}

	// retourne les paris liés à un favori
	@GetMapping("votepari/favori/{id}")
	public Iterable<VotePari> getVotePariOfFavori(@PathVariable Long id) {
		Optional<Utilisateur> u = utilisateurRepos.findById(id);
		if (u.isPresent()) {
			return votepariRepos.findByFavori(u.get());
		} else {
			return null;
		}

	}

	// ajouter un pari
	@PostMapping("votepari")
	public VotePari ajouterCreationPari(@RequestBody VotePari v) {
		return votepariRepos.save(v);
	}

	// enlever pari
	@DeleteMapping("votepari/{id1}/{id2}")
	public boolean enleverPari(@PathVariable Long id1, @PathVariable Long id2) {
		Optional<VotePari> v = votepariRepos.findByCompetitionIdAndPredicteurId(id1, id2);
		if (v.isPresent()) {
			votepariRepos.delete(v.get());
			return true;
		} else {
			return false;
		}
	}

}
