package fr.solutec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Amitie;
import fr.solutec.entities.AppartenanceGroupe;
import fr.solutec.entities.Conversation;
import fr.solutec.entities.Groupe;
import fr.solutec.entities.Message;
import fr.solutec.entities.Utilisateur;
import fr.solutec.repository.AmitieRepository;
import fr.solutec.repository.AppartenanceGroupeRepository;
import fr.solutec.repository.ConversationRepository;
import fr.solutec.repository.GroupeRepository;
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
	@Autowired
	private GroupeRepository groupeRepos;
	@Autowired
	private AppartenanceGroupeRepository appartenanceGroupeRepos;
	@Autowired
	private ConversationRepository conversationRepos;

	public static void main(String[] args) {
		SpringApplication.run(CompotitionApplication.class, args);
		System.out.println("Compotition : lancement terminé");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Compotition : lancement des instructions perso");

		DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat d2 = new SimpleDateFormat("dd MMMM yyyy 'à' hh:mm:ss");

		Utilisateur u1 = new Utilisateur(null, "login", "mdp", "Nom", "Prénom", "prenom.nom@mail.com",
				d.parse("11/11/1997"), false, null, null);
		Utilisateur u2 = new Utilisateur(null, "login2", "mdp2", "Nom2", "Prénom2", "prenom2.nom2@mail.com",
				d.parse("01/01/2000"), false, null, null);
		Utilisateur u3 = new Utilisateur(null, "login3", "mdp3", "Nom3", "Prénom3", "prenom3.nom3@mail.com",
				d.parse("11/11/1997"), false, null, null);
		Utilisateur u4 = new Utilisateur(null, "login4", "mdp4", "Nom4", "Prénom4", "prenom4.nom4@mail.com",
				d.parse("01/01/2000"), false, null, null);
		Utilisateur u5 = new Utilisateur(null, "login5", "mdp5", "Nom5", "Prénom5", "prenom5.nom5@mail.com",
				d.parse("01/01/2000"), false, null, null);

		utilisateurRepos.save(u1);
		utilisateurRepos.save(u2);
		utilisateurRepos.save(u3);
		utilisateurRepos.save(u4);
		utilisateurRepos.save(u5);

		Amitie a1 = new Amitie(null, u1, u2, false);
		amitieRepos.save(a1);

		Message m1 = new Message(null, "Hello world", u1, a1);
		Message m2 = new Message(null, "How do you do", u2, a1);

		messageRepos.save(m1);
		messageRepos.save(m2);

		Groupe g1 = new Groupe(null, "Ce soir c'est MATCH", "Groupe de 2?");
		Groupe g2 = new Groupe(null, "Dev7", "Compotition");
		groupeRepos.save(g1);
		groupeRepos.save(g2);

		AppartenanceGroupe ag1 = new AppartenanceGroupe(u1, g1, 3);
		AppartenanceGroupe ag2 = new AppartenanceGroupe(u2, g1, 4);
		AppartenanceGroupe ag3 = new AppartenanceGroupe(u1, g2, 105);
		AppartenanceGroupe ag4 = new AppartenanceGroupe(u2, g2, 610);
		AppartenanceGroupe ag5 = new AppartenanceGroupe(u3, g2, 53);
		AppartenanceGroupe ag6 = new AppartenanceGroupe(u4, g2, 12);
		AppartenanceGroupe ag7 = new AppartenanceGroupe(u5, g2, 900);
		appartenanceGroupeRepos.save(ag1);
		appartenanceGroupeRepos.save(ag2);
		appartenanceGroupeRepos.save(ag3);
		appartenanceGroupeRepos.save(ag4);
		appartenanceGroupeRepos.save(ag5);
		appartenanceGroupeRepos.save(ag6);
		appartenanceGroupeRepos.save(ag7);

		Conversation c1 = new Conversation(null, "On se retrouve à quelle heure", u1, g1);
		Conversation c2 = new Conversation(null, "à 10 h", u1, g1);
		Conversation c3 = new Conversation(null,
				"Attend jpeux pas j'ai un test demain, à 8 h c'est mieux c'est moins tard", u2, g1);
		Conversation c4 = new Conversation(null, "va pour 8h pour moi", u1, g1);
		Conversation c5 = new Conversation(null, "il fait froid aujourd'hui", u2, g2);
		Conversation c6 = new Conversation(null, "oui", u1, g2);
		Conversation c7 = new Conversation(null, "non", u3, g2);
		Conversation c8 = new Conversation(null, "testing", u3, null);

		conversationRepos.save(c1);
		conversationRepos.save(c2);
		conversationRepos.save(c3);
		conversationRepos.save(c4);
		conversationRepos.save(c5);
		conversationRepos.save(c6);
		conversationRepos.save(c7);
		conversationRepos.save(c8);

		// Competition comp1 = new Competition("Billard", d2.parse("), null, null, null,
		// null, null, false, g2)

	}
}
