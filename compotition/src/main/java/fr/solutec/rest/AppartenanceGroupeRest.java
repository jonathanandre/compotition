package fr.solutec.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.entities.AppartenanceGroupe;
import fr.solutec.repository.AppartenanceGroupeRepository;

@RestController
@CrossOrigin("*")
public class AppartenanceGroupeRest {
	@Autowired
	private AppartenanceGroupeRepository appartenanceGroupeRepos;

	@GetMapping("groupes/mes-groupes/{id}")
	public List<AppartenanceGroupe> getGroupesByIdUtilisateur(@PathVariable Long id) {
		return appartenanceGroupeRepos.findByUtilisateurId(id);
	}

	@GetMapping("groupes/classement/{id}")
	public List<AppartenanceGroupe> getClassementByIdGroupe(@PathVariable Long id) {
		return appartenanceGroupeRepos.findByGroupeId(id);

	}
}
