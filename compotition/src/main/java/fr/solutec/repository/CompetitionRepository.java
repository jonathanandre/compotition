package fr.solutec.repository;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Competition;


public interface CompetitionRepository extends CrudRepository<Competition, Long> {

}
