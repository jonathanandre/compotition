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

import fr.solutec.entities.Conversation;
import fr.solutec.entities.Groupe;
import fr.solutec.entities.Utilisateur;
import fr.solutec.repository.ConversationRepository;
import fr.solutec.repository.GroupeRepository;
import fr.solutec.repository.UtilisateurRepository;

@RestController
@CrossOrigin("*")

public class ConversationRest {
	@Autowired
	private ConversationRepository conversationRepos;

	@Autowired
	private GroupeRepository groupeRepos;

	@Autowired
	private UtilisateurRepository utilisateurRepos;

	// retourne tous les messages des conversations publique et privées
	@GetMapping("conversation")
	public Iterable<Conversation> getAllConvs() {
		return conversationRepos.findAll();
	}

	// retourne tous les messages de la conversation publique
	@GetMapping("conversation/publique")
	public Iterable<Conversation> getConversationPublique() {
		return conversationRepos.findByGroupe(null);

	}

	// retourne tous les messages de la conv d'un groupe
	@GetMapping("conversation/groupe/{id}")
	public Iterable<Conversation> getConversationOfGroupe(@PathVariable Long id) {
		Optional<Groupe> g = groupeRepos.findById(id);
		if (g.isPresent()) {
			return conversationRepos.findByGroupe(g.get());
		} else {
			return null;
		}

	}

	// retourne tous les messages conv publique ou privée envoyée par un utilisateur
	// donné
	@GetMapping("conversation/utilisateur/{id}")
	public Iterable<Conversation> getConversationMessagesOfGivenUser(@PathVariable Long id) {
		Optional<Utilisateur> u = utilisateurRepos.findById(id);
		if (u.isPresent()) {
			return conversationRepos.findByEnvoyeur(u.get());
		} else {
			return null;
		}

	}

	// ajouter un message dans une conv publique ou privée
	@PostMapping("conversation")
	public Conversation ajouterConversation(@RequestBody Conversation c) {
		return conversationRepos.save(c);
	}

	// enlever message
	@DeleteMapping("conversation/{id}")
	public boolean enleverConversation(@PathVariable Long id) {
		Optional<Conversation> c = conversationRepos.findById(id);
		if (c.isPresent()) {
			conversationRepos.deleteById(id);
			return true;
		} else {
			return false;
		}
	}

}
