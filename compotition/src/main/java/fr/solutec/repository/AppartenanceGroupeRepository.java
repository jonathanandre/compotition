package fr.solutec.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.AppartenanceGroupe;
import fr.solutec.entities.Groupe;

public interface AppartenanceGroupeRepository extends CrudRepository<AppartenanceGroupe, Long> {

	public List<Groupe> findByUtilisateurId(Long id);

}
