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
@IdClass(VotePariConstraint.class)
public class VotePari {
	@Id
	@ManyToOne
	private Competition competition;
	@Id
	@ManyToOne
	private Utilisateur predicteur;
	@ManyToOne
	private Utilisateur favori;
	private int remuneration;

}
