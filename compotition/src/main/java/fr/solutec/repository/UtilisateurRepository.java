package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

	public Optional<Utilisateur> findByLoginAndMdp(String login, String mdp);

	public Optional<Utilisateur> findByLogin(String login);

	public Optional<Utilisateur> findByEmail(String email);

	public void deleteByLogin(String login);

	public List<Utilisateur> findAllByOrderByPointsGlobalDesc();

	public List<Utilisateur> findAllByOrderByPointsPariDesc();

}
