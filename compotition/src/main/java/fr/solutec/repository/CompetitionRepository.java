package fr.solutec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Competition;

public interface CompetitionRepository extends CrudRepository<Competition, Long> {

	public List<Competition> findByGroupeId(Long id);
}
