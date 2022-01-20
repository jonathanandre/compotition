package fr.solutec.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Succes;

public interface SuccesRepository extends CrudRepository<Succes, Long> {

	public Optional<Succes> findByLibelle(String libelle);
}
