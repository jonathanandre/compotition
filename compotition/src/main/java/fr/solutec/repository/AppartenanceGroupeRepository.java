package fr.solutec.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.AppartenanceGroupe;

public interface AppartenanceGroupeRepository extends CrudRepository<AppartenanceGroupe, Long> {

	public List<AppartenanceGroupe> findByInvitationGroupeAccepteTrueAndUtilisateurLogin(String login);

	public List<AppartenanceGroupe> findByInvitationGroupeAccepteTrueAndGroupeId(Long id);

	public Optional<AppartenanceGroupe> findByGroupeIdAndUtilisateurLogin(Long id, String login);

	public void deleteByGroupeIdAndUtilisateurLogin(Long id, String login);

	public List<AppartenanceGroupe> findByInvitationGroupeAccepteFalseAndUtilisateurLoginAndDateInvitationReponseIsNull(
			String login);

	public List<AppartenanceGroupe> findByInvitationGroupeAccepteFalseAndUtilisateurLoginAndDateInvitationReponseIsNotNull(
			String login);

	public List<AppartenanceGroupe> findByInvitationGroupeAccepteTrueAndGroupeIdOrderByPointsParUtilisateurDansGroupeDesc(
			Long id);

}
