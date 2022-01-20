package fr.solutec.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Competition competition;

}
