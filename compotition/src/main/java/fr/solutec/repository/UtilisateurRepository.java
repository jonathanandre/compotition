package fr.solutec.repository;

import org.springframework.data.repository.CrudRepository;

import fr.solutec.entities.Utilisateur;

public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

}
