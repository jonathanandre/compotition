package fr.solutec.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Duel;

public interface DuelRepository extends CrudRepository<Duel, Long> {

	public List<Duel> findByAdversaire1LoginOrAdversaire2Login(String login, String login2);

	public List<Duel> findByCompetitionId(Long id);

	public List<Duel> findByCompetitionIdAndAdversaire1LoginAndAdversaire2Login(Long id, String login, String login2);

	public List<Duel> findByCompetitionIdAndAdversaire1LoginOrAdversaire2Login(Long id, String login, String login2);

	@Query(value = "SELECT \r\n" + "    a1.login as adversaire1, a2.login as adversaire2\r\n" + "FROM\r\n"
			+ "    duel d\r\n" + "        INNER JOIN\r\n" + "    utilisateur a1 ON a1.id = d.adversaire2_id\r\n"
			+ "        INNER JOIN\r\n" + "    utilisateur a2 ON a2.id = d.adversaire1_id;", nativeQuery = true)
	public List<Object> retourDuel();
	
	@Query(value = "SELECT \r\n" + " score_adversaire1, score_adversaire2\r\n" + "FROM\r\n"
			+ "    duel d\r\n" + "        INNER JOIN\r\n" + "    utilisateur a1 ON a1.id = d.adversaire2_id\r\n"
			+ "        INNER JOIN\r\n" + "    utilisateur a2 ON a2.id = d.adversaire1_id;", nativeQuery = true)
	public List<Object> retourDuelScore();

}
