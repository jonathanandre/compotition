package fr.solutec;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.solutec.entities.Amitie;
import fr.solutec.entities.AppartenanceGroupe;
import fr.solutec.entities.Competition;
import fr.solutec.entities.Conversation;
import fr.solutec.entities.CreationPari;
import fr.solutec.entities.Duel;
import fr.solutec.entities.Groupe;
import fr.solutec.entities.Message;
import fr.solutec.entities.Participe;
import fr.solutec.entities.Utilisateur;
import fr.solutec.entities.VotePari;
import fr.solutec.repository.AmitieRepository;
import fr.solutec.repository.AppartenanceGroupeRepository;
import fr.solutec.repository.CompetitionRepository;
import fr.solutec.repository.ConversationRepository;
import fr.solutec.repository.CreationPariRepository;
import fr.solutec.repository.DuelRepository;
import fr.solutec.repository.GroupeRepository;
import fr.solutec.repository.MessageRepository;
import fr.solutec.repository.ParticipeRepository;
import fr.solutec.repository.UtilisateurRepository;
import fr.solutec.repository.VotePariRepository;

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
	@Autowired
	private CompetitionRepository competitionRepos;
	@Autowired
	private ParticipeRepository participeRepos;
	@Autowired
	private DuelRepository duelRepos;
	@Autowired
	private CreationPariRepository creationpariRepos;
	@Autowired
	private VotePariRepository votepariRepos;

	public static void main(String[] args) {
		SpringApplication.run(CompotitionApplication.class, args);
		System.out.println("Compotition : lancement terminé");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Compotition : lancement des instructions perso");

		DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat d2 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

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

		Amitie a1 = new Amitie(null, u1, u2, true);
		Amitie a2 = new Amitie(null, u1, u3, false);
		amitieRepos.save(a1);
		amitieRepos.save(a2);

		Message m1 = new Message(null, "Hello world", u1, a1);
		Message m2 = new Message(null, "How do you do", u2, a1);

		messageRepos.save(m1);
		messageRepos.save(m2);

		Groupe g1 = new Groupe(null, "Ce soir c'est MATCH", "Groupe de 2?");
		Groupe g2 = new Groupe(null, "Dev7", "Compotition");
		groupeRepos.save(g1);
		groupeRepos.save(g2);

		AppartenanceGroupe ag1 = new AppartenanceGroupe(u1, g1, 3, true, d2.parse("17/01/2022 18:30:00"),
				d2.parse("17/01/2022 18:31:00"));
		AppartenanceGroupe ag2 = new AppartenanceGroupe(u2, g1, 4, true, d2.parse("17/01/2022 18:30:00"),
				d2.parse("17/01/2022 18:31:00"));
		AppartenanceGroupe ag3 = new AppartenanceGroupe(u1, g2, 105, true, d2.parse("17/01/2022 18:30:00"),
				d2.parse("17/01/2022 18:31:00"));
		AppartenanceGroupe ag4 = new AppartenanceGroupe(u2, g2, 610, true, d2.parse("17/01/2022 18:30:00"),
				d2.parse("17/01/2022 18:31:00"));
		AppartenanceGroupe ag5 = new AppartenanceGroupe(u3, g2, 53, true, d2.parse("17/01/2022 18:30:00"),
				d2.parse("17/01/2022 18:31:00"));
		AppartenanceGroupe ag6 = new AppartenanceGroupe(u4, g2, 12, true, d2.parse("17/01/2022 18:30:00"),
				d2.parse("17/01/2022 18:31:00"));
		AppartenanceGroupe ag7 = new AppartenanceGroupe(u5, g2, 900, true, d2.parse("17/01/2022 18:30:00"),
				d2.parse("17/01/2022 18:31:00"));
		AppartenanceGroupe ag8 = new AppartenanceGroupe(u3, g1, 0, false, d2.parse("17/01/2022 18:30:00"), null);
		AppartenanceGroupe ag9 = new AppartenanceGroupe(u4, g2, 0, false, d2.parse("17/01/2022 18:30:00"),
				d2.parse("17/01/2022 18:31:00"));

		appartenanceGroupeRepos.save(ag1);
		appartenanceGroupeRepos.save(ag2);
		appartenanceGroupeRepos.save(ag3);
		appartenanceGroupeRepos.save(ag4);
		appartenanceGroupeRepos.save(ag5);
		appartenanceGroupeRepos.save(ag6);
		appartenanceGroupeRepos.save(ag7);
		appartenanceGroupeRepos.save(ag8);
		appartenanceGroupeRepos.save(ag9);

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

		Competition comp1 = new Competition(null, "Billard", d2.parse("17/01/2022 18:30:00"),
				d2.parse("17/02/2022 18:30:00"), "Club 108, Croissy-sur-Seine", d2.parse("16/01/2022 18:30:00"),
				"championnat", "Championnat de billard entre l'utilisateur1 et l'utilisateur2 pendant 1 mois", false,
				g1, u1);
		Competition comp2 = new Competition(null, "Bière-Pong", d2.parse("17/01/2022 18:30:00"), null,
				"Crémaillère de Gaël", d2.parse("17/01/2022 17:30:00"), "tournoi",
				"Bière-pong facon tournoi entre 4 utilisateurs", false, g2, u2);
		Competition comp3 = new Competition(null, "Fléchette", d2.parse("17/01/2022 21:30:00"), null,
				"Gite en normandie", null, "match", "Match de fléchettes entre utilisateur1 et utilisateur2", false, g1,
				u1);
		Competition comp4 = new Competition(null, "Max de tucs", null, null, null, null, "tournoi", "tournoi ouvert",
				false, null, u1);
		Competition comp5 = new Competition(null, "Test", d2.parse("10/02/2022 18:30:00"),
				d2.parse("17/02/2022 18:30:00"), null, null, "match", null, false, g1, u1);

		competitionRepos.save(comp1);
		competitionRepos.save(comp2);
		competitionRepos.save(comp3);
		competitionRepos.save(comp4);
		competitionRepos.save(comp5);

		Participe p1 = new Participe(u1, comp1);
		Participe p2 = new Participe(u2, comp1);

		Participe p3 = new Participe(u2, comp2);
		Participe p4 = new Participe(u3, comp2);
		Participe p5 = new Participe(u4, comp2);
		Participe p6 = new Participe(u5, comp2);

		Participe p7 = new Participe(u1, comp3);
		Participe p8 = new Participe(u2, comp3);

		Participe p9 = new Participe(u1, comp4);
		Participe p10 = new Participe(u3, comp4);
		Participe p11 = new Participe(u4, comp4);
		Participe p12 = new Participe(u2, comp4);
		Participe p13 = new Participe(u5, comp4);

		Participe p14 = new Participe(u1, comp5);
		Participe p15 = new Participe(u2, comp5);

		participeRepos.save(p1);
		participeRepos.save(p2);
		participeRepos.save(p3);
		participeRepos.save(p4);
		participeRepos.save(p5);
		participeRepos.save(p6);
		participeRepos.save(p7);
		participeRepos.save(p8);
		participeRepos.save(p9);
		participeRepos.save(p10);
		participeRepos.save(p11);
		participeRepos.save(p12);
		participeRepos.save(p13);
		participeRepos.save(p14);
		participeRepos.save(p15);

		Duel duel1 = new Duel(null, comp1, u1, u2, d2.parse("17/01/2022 19:30:00"), 10, 3);
		Duel duel2 = new Duel(null, comp1, u1, u2, d2.parse("20/01/2022 19:30:00"), 8, 6);
		Duel duel3 = new Duel(null, comp1, u1, u2, d2.parse("23/01/2022 19:30:00"), 1, 5);
		Duel duel4 = new Duel(null, comp1, u1, u2, d2.parse("26/01/2022 19:30:00"), 6, 6);
		Duel duel5 = new Duel(null, comp1, u1, u2, d2.parse("29/01/2022 19:30:00"), 4, 4);
		Duel duel6 = new Duel(null, comp1, u1, u2, d2.parse("01/02/2022 19:30:00"), 8, 7);
		Duel duel7 = new Duel(null, comp1, u1, u2, d2.parse("04/02/2022 19:30:00"), 4, 7);
		Duel duel8 = new Duel(null, comp1, u1, u2, d2.parse("07/02/2022 19:30:00"), 5, 6);
		Duel duel9 = new Duel(null, comp1, u1, u2, d2.parse("10/02/2022 19:30:00"), 10, 9);
		Duel duel10 = new Duel(null, comp1, u1, u2, d2.parse("12/02/2022 19:30:00"), 4, 5);
		Duel duel11 = new Duel(null, comp1, u1, u2, d2.parse("14/02/2022 19:30:00"), 4, 3);
		Duel duel12 = new Duel(null, comp1, u1, u2, d2.parse("16/02/2022 19:30:00"), 7, 8);

		Duel duel13 = new Duel(null, comp2, u2, u3, null, 1, 0);
		Duel duel14 = new Duel(null, comp2, u4, u5, null, 0, 1);
		Duel duel15 = new Duel(null, comp2, u2, u5, null, 0, 1);
		Duel duel16 = new Duel(null, comp2, u3, u4, null, 1, 0);

		Duel duel17 = new Duel(null, comp3, u1, u2, null, 150, 210);

		Duel duel18 = new Duel(null, comp2, u5, u3, null, 0, 1);
		Duel duel19 = new Duel(null, comp2, u1, u4, null, 1, 0);
		Duel duel20 = new Duel(null, comp2, u3, u2, null, 0, 1);
		Duel duel21 = new Duel(null, comp2, u1, u2, null, 1, 0);
		Duel duel22 = new Duel(null, comp3, u3, u4, null, 0, 1);

		duelRepos.save(duel1);
		duelRepos.save(duel2);
		duelRepos.save(duel3);
		duelRepos.save(duel4);
		duelRepos.save(duel5);
		duelRepos.save(duel6);
		duelRepos.save(duel7);
		duelRepos.save(duel8);
		duelRepos.save(duel9);

		duelRepos.save(duel10);
		duelRepos.save(duel11);
		duelRepos.save(duel12);
		duelRepos.save(duel13);
		duelRepos.save(duel14);
		duelRepos.save(duel15);
		duelRepos.save(duel16);
		duelRepos.save(duel17);
		duelRepos.save(duel18);
		duelRepos.save(duel19);
		duelRepos.save(duel20);
		duelRepos.save(duel21);
		duelRepos.save(duel22);

		CreationPari cp1 = new CreationPari(null, "Pari annuel", comp1);
		CreationPari cp2 = new CreationPari(null, "Ce pari fait office de championnat du monde des parieurs", comp1);
		CreationPari cp3 = new CreationPari(null, "....", comp2);

		creationpariRepos.save(cp1);
		creationpariRepos.save(cp2);
		creationpariRepos.save(cp3);

		VotePari vp1 = new VotePari(comp1, u1, u2, 0);
		VotePari vp2 = new VotePari(comp1, u2, u5, 10);
		VotePari vp3 = new VotePari(comp3, u2, u2, 20);

		votepariRepos.save(vp1);
		votepariRepos.save(vp2);
		votepariRepos.save(vp3);

	}
}
