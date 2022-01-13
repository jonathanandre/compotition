package fr.solutec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import fr.solutec.repository.UtilisateurRepository;

@RestController
@CrossOrigin("*")
public class UtilisateurRest {
	@Autowired
	private UtilisateurRepository utilisateurRepo;

}
