package fr.solutec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Conversation;
import fr.solutec.entities.Groupe;
import fr.solutec.entities.Utilisateur;

public interface ConversationRepository extends CrudRepository<Conversation, Long> {
	public List<Conversation> findByGroupe(Groupe g);

	public List<Conversation> findByEnvoyeur(Utilisateur u);

}
