package fr.solutec.entities;

import java.util.Date;

import javax.persistence.Column;
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
	@Column(nullable = false, unique = true) // contrainte d'unicité
	private String login;
	private String mdp;
	private String nom;
	private String prenom;
	@Column(unique = true)
	private String email;
	private Date dateNaissance;
	private boolean admin;
	private Long pointsGlobal;
	private Long pointsPari;
}
