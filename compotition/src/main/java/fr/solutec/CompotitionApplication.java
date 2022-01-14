package fr.solutec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Amitie;
import fr.solutec.entities.Message;
import fr.solutec.entities.Utilisateur;
import fr.solutec.repository.AmitieRepository;
import fr.solutec.repository.MessageRepository;
import fr.solutec.repository.UtilisateurRepository;

@SpringBootApplication
public class CompotitionApplication implements CommandLineRunner {
	@Autowired
	private UtilisateurRepository utilisateurRepos;

	@Autowired
	private AmitieRepository amitieRepos;

	@Autowired
	private MessageRepository messageRepos;

	public static void main(String[] args) {
		SpringApplication.run(CompotitionApplication.class, args);
		System.out.println("Compotition : lancement terminé");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Compotition : lancement des instructions perso");

		DateFormat d = new SimpleDateFormat("dd/MM/yyyy");

		Utilisateur u1 = new Utilisateur(null, "login", "mdp", "Nom", "Prénom", "prenom.nom@mail.com",
				d.parse("11/11/1997"), false, null, null);
		Utilisateur u2 = new Utilisateur(null, "login2", "mdp2", "Nom2", "Prénom2", "prenom2.nom2@mail.com",
				d.parse("01/01/2000"), false, null, null);

		utilisateurRepos.save(u1);
		utilisateurRepos.save(u2);

		Amitie a1 = new Amitie(null, u1, u2, false);
		amitieRepos.save(a1);

		Message m1 = new Message(null, "Hello world", u1, a1);
		messageRepos.save(m1);

		Message m2 = new Message(null, "How do you do", u2, a1);
		messageRepos.save(m2);

	}
}
