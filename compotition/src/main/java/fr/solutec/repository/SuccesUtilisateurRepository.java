package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.SuccesUtilisateur;

public interface SuccesUtilisateurRepository extends CrudRepository<SuccesUtilisateur, Long> {

	public List<SuccesUtilisateur> findByUtilisateurLogin(String login);

	public List<SuccesUtilisateur> findBySuccesLibelle(String libelle);

	public Optional<SuccesUtilisateur> findByUtilisateurLoginAndSuccesLibelle(String login, String libelle);

}
