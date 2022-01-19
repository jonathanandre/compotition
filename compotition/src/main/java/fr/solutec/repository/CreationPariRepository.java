package fr.solutec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Competition;
import fr.solutec.entities.CreationPari;

public interface CreationPariRepository extends CrudRepository<CreationPari, Long> {

	public List<CreationPari> findByCompetition(Competition c);
}
