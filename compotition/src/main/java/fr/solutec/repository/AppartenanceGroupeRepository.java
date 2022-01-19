package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.AppartenanceGroupe;

public interface AppartenanceGroupeRepository extends CrudRepository<AppartenanceGroupe, Long> {

	public List<AppartenanceGroupe> findByUtilisateurId(Long id);

	public List<AppartenanceGroupe> findByInvitationGroupeAccepteTrueAndGroupeId(Long id);

	public Optional<AppartenanceGroupe> findByGroupeIdAndUtilisateurLogin(Long id, String login);

	public void deleteByGroupeIdAndUtilisateurLogin(Long id, String login);

}
