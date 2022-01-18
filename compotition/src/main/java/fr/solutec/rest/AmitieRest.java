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

import fr.solutec.entities.Amitie;
import fr.solutec.entities.Utilisateur;
import fr.solutec.repository.AmitieRepository;
import fr.solutec.repository.UtilisateurRepository;

@RestController
@CrossOrigin("*")
public class AmitieRest {
	@Autowired
	private AmitieRepository amitieRepo;

	@Autowired
	private UtilisateurRepository utilisateurrepo;

	@GetMapping("amitie")
	public Iterable<Amitie> getAllAmities() {
		return amitieRepo.findAll();
	}

	@GetMapping("amitie/{id}")
	public Iterable<Amitie> getMyAmities(@PathVariable Long id) {
		Optional<Utilisateur> u = utilisateurrepo.findById(id);
		return amitieRepo.findMyAmitie(u);
	}

	@GetMapping("amitie/envoi/{id}")
	public Iterable<Amitie> getMyInvitationsEnvoyees(@PathVariable Long id) {
		Optional<Utilisateur> u = utilisateurrepo.findById(id);
		return amitieRepo.findMyInvitationsAsEnvoyeur(u);
	}

	@GetMapping("amitie/reception/{id}")
	public Iterable<Amitie> getMyInvitationsRecues(@PathVariable Long id) {
		Optional<Utilisateur> u = utilisateurrepo.findById(id);
		return amitieRepo.findMyInvitationsAsReceveur(u);
	}

	@DeleteMapping("amitie/{id}")
	public boolean deleteAmi(@PathVariable Long id) {
		Optional<Amitie> a = amitieRepo.findById(id);
		if (a.isPresent()) {
			amitieRepo.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

	@PostMapping("amitie")
	public Amitie ajouterAmi(@RequestBody Amitie m) {
		return amitieRepo.save(m);
	}

	@PutMapping("amitie")
	public Amitie AccepterAmitie(@RequestBody Amitie a) {
		a.setAccepted(true);
		return amitieRepo.save(a);
	}

	@GetMapping("amitie/reception/{id1}/{id2}")
	public Iterable<Amitie> getPaire(@PathVariable Long id1, @PathVariable Long id2) {
		Optional<Utilisateur> u1 = utilisateurrepo.findById(id1);
		Optional<Utilisateur> u2 = utilisateurrepo.findById(id2);
		return amitieRepo.findEnvoyeurAndReceveur(u1, u2);
	}

}
