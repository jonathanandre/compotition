package fr.solutec.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Utilisateur {
	@Id
	@GeneratedValue
	private Long id;
	private String login;
	private String mdp;
	private String nom;
	private String prenom;
	private String email;
	private Date dateNaissance;
	private boolean admin;
	private Long pointsGlobal;
	private Long pointsPari;
}
