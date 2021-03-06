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
import fr.solutec.entities.Succes;
import fr.solutec.entities.SuccesUtilisateur;
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
import fr.solutec.repository.SuccesRepository;
import fr.solutec.repository.SuccesUtilisateurRepository;
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
	@Autowired
	private SuccesRepository succesRepos;
	@Autowired
	private SuccesUtilisateurRepository succesUtilisateurRepos;

	public static void main(String[] args) {
		SpringApplication.run(CompotitionApplication.class, args);
		System.out.println("Compotition : lancement termin??");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Compotition : lancement des instructions perso");

		DateFormat d = new SimpleDateFormat("dd/MM/yyyy");
		DateFormat d2 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");

		Utilisateur u1 = new Utilisateur(null, "Hunter", "hun", "Larson", "Nicky", "nicky.larson@mail.com",
				d.parse("11/11/1997"), false, 1, 10);
		Utilisateur u2 = new Utilisateur(null, "Superman", "sup", "Kent", "Clark", "clark.kent@mail.com",
				d.parse("16/05/1980"), false, 2, 20);
		Utilisateur u3 = new Utilisateur(null, "007", "jam", "Bond", "James", "james.bond@mail.com",
				d.parse("11/11/1997"), false, 0, 50);
		Utilisateur u4 = new Utilisateur(null, "Spiderman", "spi", "Parker", "Peter", "peter.parker@mail.com",
				d.parse("06/03/1998"), false, 4, 40);
		Utilisateur u5 = new Utilisateur(null, "Batman", "bat", "Wayne", "Bruce", "bruce.wayne@mail.com",
				d.parse("01/01/2000"), false, 5, 0);

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

		Groupe g1 = new Groupe(null, "Ce soir c'est MATCH", "Groupe pour FIFA");
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

		Conversation c1 = new Conversation(null, "On se retrouve ?? quelle heure", u1, g1);
		Conversation c2 = new Conversation(null, "?? 10 h", u1, g1);
		Conversation c3 = new Conversation(null,
				"Attend jpeux pas j'ai un test demain, ?? 8 h c'est mieux c'est moins tard", u2, g1);
		Conversation c4 = new Conversation(null, "va pour 8h pour moi", u1, g1);
		Conversation c5 = new Conversation(null, "il fait froid aujourd'hui", u2, g2);
		Conversation c6 = new Conversation(null, "oui", u1, g2);
		Conversation c7 = new Conversation(null, "non", u3, g2);
		Conversation c8 = new Conversation(null, "bof", u3, null);

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
				"championnat", "Championnat de billard pendant 1 mois", false, g1, u1, u1);
		Competition comp2 = new Competition(null, "Bi??re-Pong", d2.parse("17/01/2022 18:30:00"),
				d2.parse("17/01/2022 22:30:00"), "Cr??maill??re de Batman", d2.parse("17/01/2022 17:30:00"), "tournoi",
				"Bi??re-pong facon tournoi entre 4 utilisateurs", false, g2, u2, null);
		Competition comp3 = new Competition(null, "Fl??chette", d2.parse("17/01/2022 21:30:00"), null,
				"Gite en normandie", null, "match", "Match de fl??chettes", false, g1, u1, null);
		Competition comp4 = new Competition(null, "Max de trucs", d2.parse("17/01/2022 17:30:00"), null, null,
				d2.parse("17/01/2022 18:30:00"), "tournoi", "tournoi ouvert", false, null, u1, null);
		Competition comp5 = new Competition(null, "Competition de Smash Bros", d2.parse("10/02/2022 18:30:00"),
				d2.parse("17/02/2022 18:30:00"), null, null, "match", null, false, g1, u1, null);
		Competition comp6 = new Competition(null, "Match de VS Code", d2.parse("10/02/2022 18:30:00"),
				d2.parse("17/02/2022 18:30:00"), "Voisins-le-Bretonneux", null, "match", null, true, null, u1, null);
		Competition comp7 = new Competition(null, "tournoi r??gional de fus??es artisanales",
				d2.parse("10/02/2022 18:30:00"), d2.parse("17/02/2022 18:30:00"), "La Lune", null, "match", null, true,
				null, u1, null);
		Competition comp8 = new Competition(null, "tournoi r??gional de compotes", d2.parse("10/02/2022 18:30:00"),
				d2.parse("17/02/2022 18:30:00"), "Brest", null, "match", null, true, null, u1, null);
		Competition comp9 = new Competition(null, "Hunger Games", d2.parse("10/02/2022 18:30:00"),
				d2.parse("17/02/2022 18:30:00"), "Capitole", null, "match", null, true, null, u1, null);

		competitionRepos.save(comp1);
		competitionRepos.save(comp2);
		competitionRepos.save(comp3);
		competitionRepos.save(comp4);
		competitionRepos.save(comp5);
		competitionRepos.save(comp6);
		competitionRepos.save(comp7);
		competitionRepos.save(comp8);
		competitionRepos.save(comp9);

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

		Participe p16 = new Participe(u1, comp6);
		Participe p17 = new Participe(u2, comp6);

		Participe p18 = new Participe(u1, comp7);
		Participe p19 = new Participe(u2, comp7);

		Participe p20 = new Participe(u5, comp8);
		Participe p21 = new Participe(u2, comp8);

		Participe p22 = new Participe(u3, comp9);
		Participe p23 = new Participe(u2, comp9);

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
		participeRepos.save(p16);
		participeRepos.save(p17);
		participeRepos.save(p18);
		participeRepos.save(p19);
		participeRepos.save(p20);
		participeRepos.save(p21);
		participeRepos.save(p22);
		participeRepos.save(p23);

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
		/*duelRepos.save(duel5);
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
		duelRepos.save(duel22);*/

		CreationPari cp1 = new CreationPari(null, "Pari annuel", comp1);
		CreationPari cp2 = new CreationPari(null, "Ce pari fait office de championnat du monde des parieurs", comp1);
		CreationPari cp3 = new CreationPari(null, "Qui est le meilleur developpeur?", comp2);

		creationpariRepos.save(cp1);
		creationpariRepos.save(cp2);
		creationpariRepos.save(cp3);

		VotePari vp1 = new VotePari(comp1, u1, u1, 0);
		VotePari vp2 = new VotePari(comp1, u2, u5, 10);
		VotePari vp3 = new VotePari(comp3, u2, u2, 20);

		votepariRepos.save(vp1);
		votepariRepos.save(vp2);
		votepariRepos.save(vp3);

		Succes s1 = new Succes(null, "Num??ro 1 ?? un ??v??nement pari");
		Succes s2 = new Succes(null, "Cr??er une comp??tition");
		Succes s3 = new Succes(null, "Gagner un match");
		Succes s4 = new Succes(null, "Gagner une comp??tition");
		Succes s5 = new Succes(null, "Gagner 5 matchs");
		Succes s6 = new Succes(null, "Gagner un pari");
		Succes s7 = new Succes(null, "Num??ro 1 au classement g??n??ral");

		succesRepos.save(s1);
		succesRepos.save(s2);
		succesRepos.save(s3);
		succesRepos.save(s4);
		succesRepos.save(s5);
		succesRepos.save(s6);
		succesRepos.save(s7);

		SuccesUtilisateur su1 = new SuccesUtilisateur(null, s1, u1);
		SuccesUtilisateur su2 = new SuccesUtilisateur(null, s7, u5);
		SuccesUtilisateur su3 = new SuccesUtilisateur(null, s1, u3);
		SuccesUtilisateur su4 = new SuccesUtilisateur(null, s2, u1);
		SuccesUtilisateur su5 = new SuccesUtilisateur(null, s2, u2);
		SuccesUtilisateur su6 = new SuccesUtilisateur(null, s3, u1);
		SuccesUtilisateur su7 = new SuccesUtilisateur(null, s3, u2);
		SuccesUtilisateur su8 = new SuccesUtilisateur(null, s3, u3);
		SuccesUtilisateur su9 = new SuccesUtilisateur(null, s3, u4);
		SuccesUtilisateur su10 = new SuccesUtilisateur(null, s3, u5);
		SuccesUtilisateur su11 = new SuccesUtilisateur(null, s4, u1);
		SuccesUtilisateur su12 = new SuccesUtilisateur(null, s5, u1);
		SuccesUtilisateur su13 = new SuccesUtilisateur(null, s5, u2);

		succesUtilisateurRepos.save(su1);
		succesUtilisateurRepos.save(su2);
		succesUtilisateurRepos.save(su3);
		succesUtilisateurRepos.save(su4);
		succesUtilisateurRepos.save(su5);
		succesUtilisateurRepos.save(su6);
		succesUtilisateurRepos.save(su7);
		succesUtilisateurRepos.save(su8);
		succesUtilisateurRepos.save(su9);
		succesUtilisateurRepos.save(su10);
		succesUtilisateurRepos.save(su11);
		succesUtilisateurRepos.save(su12);
		succesUtilisateurRepos.save(su13);
	}
}
