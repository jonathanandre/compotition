package fr.solutec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Duel;

public interface DuelRepository extends CrudRepository<Duel, Long> {

	public List<Duel> findByAdversaire1LoginOrAdversaire2Login(String login, String login2);

	public List<Duel> findByCompetitionId(Long id);

	public Duel findByCompetitionIdAndAdversaire1LoginAndAdversaire2Login(Long id, String login, String login2);

	public List<Duel> findByCompetitionIdAndAdversaire1LoginOrAdversaire2Login(Long id, String login, String login2);
}
