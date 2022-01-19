package fr.solutec.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Competition;

public interface CompetitionRepository extends CrudRepository<Competition, Long> {

	public List<Competition> findByGroupeId(Long id);

	public List<Competition> findByOrganisateurLogin(String login);

	public List<Competition> findByGroupeIdAndDateDebutBeforeAndDateFinIsNullOrDateFinAfter(Long id, Date d, Date d2);
}
