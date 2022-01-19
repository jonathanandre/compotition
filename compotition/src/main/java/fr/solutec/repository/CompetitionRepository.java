package fr.solutec.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Competition;
import fr.solutec.entities.Groupe;

public interface CompetitionRepository extends CrudRepository<Competition, Long> {

	public List<Competition> findByGroupeId(Long id);

	public List<Competition> findByOrganisateurLogin(String login);

	public List<Competition> findByPariAndGroupe(boolean pari, Groupe groupe);

	public List<Competition> findByGroupeIdAndDateDebutBeforeAndDateFinIsNullOrDateDebutBeforeAndDateFinAfter(Long id,
			Date d, Date d2, Date d3);

	public List<Competition> findByGroupeIdAndDateFinBefore(Long id, Date d);

	public List<Competition> findByGroupeIdAndDateDebutAfter(Long id, Date d);
}
