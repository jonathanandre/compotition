package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.Conversation;
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

}
