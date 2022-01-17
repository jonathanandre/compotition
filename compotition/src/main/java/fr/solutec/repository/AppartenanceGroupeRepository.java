package fr.solutec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.AppartenanceGroupe;

public interface AppartenanceGroupeRepository extends CrudRepository<AppartenanceGroupe, Long> {

	public List<AppartenanceGroupe> findByUtilisateurId(Long id);

	public List<AppartenanceGroupe> findByGroupeId(Long id);

}
