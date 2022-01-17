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
@IdClass(ParticipeConstraint.class)
public class Participe {

	@Id
	@ManyToOne
	private Utilisateur utilisateur;

	@Id
	@ManyToOne
	private Competition competition;

}
