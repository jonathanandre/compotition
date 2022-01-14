package fr.solutec.repository;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Conversation;

public interface ConversationRepository extends CrudRepository<Conversation, Long> {

}
