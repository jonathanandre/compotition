package fr.solutec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Amitie;
import fr.solutec.entities.Message;
import fr.solutec.entities.Utilisateur;

public interface MessageRepository extends CrudRepository<Message, Long> {
	public List<Message> findByAmitie(Amitie a);

	public List<Message> findByEnvoyeur(Utilisateur u);

}
