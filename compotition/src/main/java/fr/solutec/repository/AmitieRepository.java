package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Amitie;
import fr.solutec.entities.Utilisateur;

public interface AmitieRepository extends CrudRepository<Amitie, Long> {
	@Query(value = "SELECT m FROM Amitie m WHERE m.accepted= true AND (m.receveur=?1 OR m.envoyeur=?1)")
	public List<Amitie> findMyAmitie(Optional<Utilisateur> u);

	@Query(value = "SELECT m FROM Amitie m WHERE m.accepted= false AND (m.envoyeur=?1)")
	public List<Amitie> findMyInvitationsAsEnvoyeur(Optional<Utilisateur> u);

	@Query(value = "SELECT m FROM Amitie m WHERE m.accepted= false AND (m.receveur=?1)")
	public List<Amitie> findMyInvitationsAsReceveur(Optional<Utilisateur> u);

	@Query(value = "SELECT m FROM Amitie m WHERE  m.envoyeur=?1 AND m.receveur=?2")
	public List<Amitie> findEnvoyeurAndReceveur(Optional<Utilisateur> u1, Optional<Utilisateur> u2);

}
