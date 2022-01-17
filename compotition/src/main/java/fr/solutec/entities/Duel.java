package fr.solutec.entities;

import java.util.Date;

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
@IdClass(DuelConstraint.class)
public class Duel {
	@Id
	@ManyToOne
	private Competition competition;

	@Id
	@ManyToOne
	private Utilisateur adversaire1;

	@Id
	@ManyToOne
	private Utilisateur adversaire2;

	private Date date;
	private int scoreAdversaire1;
	private int scoreAdversaire2;
}
