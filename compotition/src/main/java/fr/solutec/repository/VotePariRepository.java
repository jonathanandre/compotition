package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Competition;
import fr.solutec.entities.Utilisateur;
import fr.solutec.entities.VotePari;

public interface VotePariRepository extends CrudRepository<VotePari, Long> {
	public Optional<VotePari> findByCompetitionIdAndPredicteurId(Long id1, Long id2);

	public Iterable<VotePari> findByCompetition(Competition c);

	public Iterable<VotePari> findByPredicteur(Utilisateur u);

	public Iterable<VotePari> findByFavori(Utilisateur u);

}
