package fr.solutec.repository;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Participe;

public interface ParticipeRepository extends CrudRepository<Participe, Long> {

	public List<Participe> findByUtilisateurLogin(String login);

	public Optional<Participe> findByCompetitionIdAndUtilisateurLogin(Long id, String login);

	public List<Participe> findByCompetitionId(Long id);

	public List<Participe> findByUtilisateurLoginAndCompetitionDateDebutBeforeAndCompetitionDateFinIsNullOrCompetitionDateDebutBeforeAndCompetitionDateFinAfter(
			String login, Date d, Date d2, Date d3);

	public List<Participe> findByUtilisateurLoginAndCompetitionDateFinBefore(String login, Date d);

	public List<Participe> findByUtilisateurLoginAndCompetitionDateDebutAfter(String login, Date d);

}