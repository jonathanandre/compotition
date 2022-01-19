package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Participe;

public interface ParticipeRepository extends CrudRepository<Participe, Long> {

	public List<Participe> findByUtilisateurLogin(String login);

	public List<Participe> findByCompetitionId(Long id);

	public Optional<Participe> findByCompetitionIdAndUtilisateurLogin(Long id, String login);

}