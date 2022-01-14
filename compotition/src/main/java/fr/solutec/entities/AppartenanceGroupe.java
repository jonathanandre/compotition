package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@IdClass(AppartenanceGroupeConstraint.class)
public class AppartenanceGroupe {
	@Id
	@ManyToOne
	private Utilisateur utilisateur;

	@Id
	@ManyToOne
	private Groupe groupe;

	private Long pointsParUtilisateurDansGroupe;

}
