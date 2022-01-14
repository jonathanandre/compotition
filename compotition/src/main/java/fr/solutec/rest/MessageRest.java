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

import fr.solutec.entities.Amitie;
import fr.solutec.entities.Message;
import fr.solutec.entities.Utilisateur;
import fr.solutec.repository.AmitieRepository;
import fr.solutec.repository.MessageRepository;
import fr.solutec.repository.UtilisateurRepository;

@RestController
@CrossOrigin("*")
public class MessageRest {
	@Autowired
	private MessageRepository messageRepos;

	@Autowired
	private AmitieRepository amitieRepos;

	@Autowired
	private UtilisateurRepository utilisateurRepos;

	// retourne tous les messages de la bdd
	@GetMapping("message")
	public Iterable<Message> getAllMessages() {
		return messageRepos.findAll();
	}

	// retourne tous les messages d'une amitie
	@GetMapping("message/amitie/{id}")
	public Iterable<Message> getMessagesOfAmitie(@PathVariable Long id) {
		Optional<Amitie> a = amitieRepos.findById(id);
		if (a.isPresent()) {
			return messageRepos.findByAmitie(a.get());
		} else {
			return null;
		}

	}

	// retourne tous les messages envoyés par un utilisateur (messages entre amis,
	// pas ceux
	// des conv publiques)
	@GetMapping("message/utilisateur/{id}")
	public Iterable<Message> getMessagesOfUtilisateur(@PathVariable Long id) {
		Optional<Utilisateur> u = utilisateurRepos.findById(id);
		if (u.isPresent()) {
			return messageRepos.findByEnvoyeur(u.get());
		} else {
			return null;
		}

	}

	// ajouter un message (à l'intérieur d'une amitié)
	@PostMapping("message")
	public Message ajouterMessage(@RequestBody Message m) {
		return messageRepos.save(m);
	}

	// ajouter un message (à l'intérieur d'une amitié)
	@DeleteMapping("message/{id}")
	public boolean enleverMessage(@PathVariable Long id) {
		Optional<Message> m = messageRepos.findById(id);
		if (m.isPresent()) {
			messageRepos.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
